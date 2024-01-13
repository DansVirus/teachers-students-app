package gr.aueb.cf.tsapp;



import javax.swing.JFrame;
import javax.swing.JPanel;




import javax.swing.border.BevelBorder;

import org.mindrot.jbcrypt.BCrypt;

import gr.aueb.cf.tsapp.util.DBUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JPasswordField;

public class InsertUser extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;


	/**
	 * Create the frame.
	 */
	public InsertUser() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				txtUsername.setText("");
				txtPassword.setText("");
			}
		});
		setTitle("Εισαγωγή Χρήστη");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setForeground(new Color(153, 0, 51));
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsername.setBounds(65, 45, 85, 26);
		contentPane.add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(161, 46, 188, 24);
		contentPane.add(txtUsername);
		txtUsername.setColumns(50);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(new Color(153, 0, 51));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(65, 81, 85, 26);
		contentPane.add(lblPassword);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "INSERT INTO USERS (USERNAME, PASSWORD) VALUES (?, ?)";
				String inputUsername;
				String inputPassword;
				int n;
				
				try (Connection conn = DBUtil.getConnection(); 
						PreparedStatement p = conn.prepareStatement(sql)) { 
					
					inputUsername = txtUsername.getText().trim();
					inputPassword = String.valueOf(txtPassword.getPassword()).trim();
					
					if (inputUsername.equals("") || (inputPassword.equals(""))) {
						return;
					}
					//
					int workload = 12;
					String salt = BCrypt.gensalt(workload);
					String hashedPassword = BCrypt.hashpw(inputPassword, salt);
					
					p.setString(1, inputUsername);
					p.setString(2, hashedPassword);
					
					n = p.executeUpdate();
					JOptionPane.showMessageDialog(null, n + " records inserted", 
							"INSERT USER", JOptionPane.PLAIN_MESSAGE);
					//
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}	
			
		});
		btnInsert.setForeground(new Color(0, 0, 153));
		btnInsert.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnInsert.setBounds(201, 194, 85, 40);
		contentPane.add(btnInsert);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(21, 172, 389, 2);
		contentPane.add(separator);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getSearchUser().setEnabled(true);
				Main.getInsertUser().setVisible(false);
			}
		});
		btnClose.setForeground(new Color(0, 0, 153));
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnClose.setBounds(304, 194, 85, 40);
		contentPane.add(btnClose);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(45, 26, 327, 109);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(116, 59, 188, 24);
		panel.add(txtPassword);
	}
}
