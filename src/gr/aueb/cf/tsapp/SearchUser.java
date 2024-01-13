package gr.aueb.cf.tsapp;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class SearchUser extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsername;
	private String inputUsername;

	/**
	 * Create the frame.
	 */
	public SearchUser() {
		setTitle("Εισαγωγή / Αναζήτηση Χρήστη");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 420);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setForeground(new Color(153, 0, 0));
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUsername.setBounds(258, 56, 173, 41);
		contentPane.add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(221, 93, 245, 41);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		JButton btnSearch = new JButton("Αναζήτηση");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				inputUsername = txtUsername.getText().trim();
				Main.getSearchUser().setEnabled(false);
				Main.getUpdateDeleteUser().setVisible(true);	
			}
		});
		btnSearch.setForeground(new Color(0, 0, 204));
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSearch.setBounds(281, 144, 137, 50);
		contentPane.add(btnSearch);
		
		JButton btnInsert = new JButton("Εισαγωγή");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getSearchUser().setEnabled(false);
				Main.getInsertUser().setVisible(true);
			}
		});
		btnInsert.setForeground(new Color(0, 0, 204));
		btnInsert.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnInsert.setBounds(281, 241, 137, 50);
		contentPane.add(btnInsert);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnClose.setForeground(new Color(0, 0, 204));
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnClose.setBounds(453, 332, 121, 41);
		contentPane.add(btnClose);
		
		JPanel panel = new JPanel();
		panel.setBounds(96, 56, 508, 154);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(96, 226, 508, 83);
		contentPane.add(panel_1);
	}

	

	public String getInputPassword() {
		return inputUsername;
	}
	
	

	
}
