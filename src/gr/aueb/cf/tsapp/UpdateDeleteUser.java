package gr.aueb.cf.tsapp;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gr.aueb.cf.tsapp.util.DBUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateDeleteUser extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTextField txtID;
	private Connection conn;
	private PreparedStatement p;
	private ResultSet rs;

	/**
	 * Create the frame.
	 */
	public UpdateDeleteUser() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				String sql = "SELECT ID, USERNAME, PASSWORD FROM USERS WHERE USERNAME LIKE ?";
				
			   try { 
					conn = DBUtil.getConnection();
					p = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
					
					p.setString(1, Main.getSearchUser().getInputPassword() + '%');
					rs = p.executeQuery(); 
					
					if (rs.next()) {
						txtID.setText(Integer.toString(rs.getInt("ID")));
						txtPassword.setText(rs.getString("PASSWORD"));
						txtUsername.setText(rs.getString("USERNAME"));
					} else {
						txtID.setText("");
						txtPassword.setText("");
						txtUsername.setText("");
					}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			@Override
			public void windowClosed(WindowEvent e) {
				try {
					if (rs != null) rs.close();
					if (p != null) p.close();
					if (conn != null) conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		setTitle("Ενημέρωση / Διαγραφή Χρήστη");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnFirst_Record = new JButton("");
		btnFirst_Record.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (rs.first()) {
						txtID.setText(rs.getString("ID"));
						txtUsername.setText(rs.getString("USERNAME"));
						txtPassword.setText(rs.getString("PASSWORD"));
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}				
			}
		});
		btnFirst_Record.setIcon(new ImageIcon(UpdateDeleteUser.class.getResource("/resources/First record.png")));
		btnFirst_Record.setBounds(29, 217, 66, 40);
		contentPane.add(btnFirst_Record);
		
		JButton btnPrevious_Record = new JButton("");
		btnPrevious_Record.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (rs.previous()) {
						txtID.setText(rs.getString("ID"));
						txtUsername.setText(rs.getString("USERNAME"));
						txtPassword.setText(rs.getString("PASSWORD"));
					} else {
						rs.first();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}			
			}
		});
		btnPrevious_Record.setIcon(new ImageIcon(UpdateDeleteUser.class.getResource("/resources/Previous_record.png")));
		btnPrevious_Record.setBounds(105, 217, 66, 40);
		contentPane.add(btnPrevious_Record);
		
		JButton btnNext_Record = new JButton("");
		btnNext_Record.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (rs.next()) {
						txtID.setText(rs.getString("ID"));
						txtUsername.setText(rs.getString("USERNAME"));
						txtPassword.setText(rs.getString("PASSWORD"));
					} else {
						rs.last();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}			
			}
		});
		btnNext_Record.setIcon(new ImageIcon(UpdateDeleteUser.class.getResource("/resources/Next_track.png")));
		btnNext_Record.setBounds(181, 217, 66, 40);
		contentPane.add(btnNext_Record);
		
		JButton btnLast_Record = new JButton("");
		btnLast_Record.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (rs.last()) {
						txtID.setText(rs.getString("ID"));
						txtUsername.setText(rs.getString("USERNAME"));
						txtPassword.setText(rs.getString("PASSWORD"));
					} 
				} catch (SQLException e1) {
					e1.printStackTrace();
				}			
			}
		});
		btnLast_Record.setIcon(new ImageIcon(UpdateDeleteUser.class.getResource("/resources/Last_Record.png")));
		btnLast_Record.setBounds(257, 217, 66, 40);
		contentPane.add(btnLast_Record);
		
		JLabel lblLastname = new JLabel("Username");
		lblLastname.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLastname.setBounds(15, 75, 85, 32);
		contentPane.add(lblLastname);
		
		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		txtUsername.setBounds(130, 72, 255, 35);
		contentPane.add(txtUsername);
		
		JLabel lblFirstname = new JLabel("Password");
		lblFirstname.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFirstname.setBounds(15, 120, 85, 32);
		contentPane.add(lblFirstname);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(130, 117, 255, 35);
		contentPane.add(txtPassword);
		
		JLabel lblID = new JLabel("Κωδικός");
		lblID.setForeground(new Color(204, 0, 51));
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblID.setBounds(15, 29, 73, 32);
		contentPane.add(lblID);
		
		txtID = new JTextField();
		txtID.setBackground(new Color(255, 255, 204));
		txtID.setEditable(false);
		txtID.setColumns(10);
		txtID.setBounds(130, 26, 117, 35);
		contentPane.add(txtID);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(15, 199, 589, 2);
		contentPane.add(separator);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "DELETE FROM USERS WHERE USERNAME = ?";
				int response;
				int numberOfRowsAffected;
				
				if(txtUsername.getText().equals("")) return;
				
			   try {
					conn = DBUtil.getConnection();
					p = conn.prepareStatement(sql);
					
					p.setString(1, txtUsername.getText().trim());
					
					response = JOptionPane.showConfirmDialog(null, "Είστε σίγουρος;", "Delete",
							JOptionPane.YES_NO_OPTION);
					
					if (response == JOptionPane.YES_OPTION) {
						numberOfRowsAffected = p.executeUpdate();
						JOptionPane.showMessageDialog(null, numberOfRowsAffected + " rows deleted",
								"Delete", JOptionPane.INFORMATION_MESSAGE);
					}
							
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDelete.setBounds(29, 326, 116, 49);
		contentPane.add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {
				String sql = "UPDATE USERS SET USERNAME = ?,PASSWORD = ? WHERE ID = ?";
				String inputUsername;
				String inputPassword;
				String inputId;
				int n;
				
				try {
					conn = DBUtil.getConnection();
					PreparedStatement p = conn.prepareStatement(sql); 
					
					
					inputUsername = txtUsername.getText().trim();
					inputPassword = txtPassword.getText().trim();
					inputId = txtID.getText();
					
					if (inputUsername.equals("") || (inputPassword.equals(""))) {
						return;
					}
					
					p.setString(1, inputUsername);
					p.setString(2, inputPassword);
					p.setInt(3, Integer.parseInt(inputId));
					
					n = p.executeUpdate();
					JOptionPane.showMessageDialog(null, n + " records updated", 
							"UPDATE", JOptionPane.PLAIN_MESSAGE);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			
			}	
			
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnUpdate.setBounds(155, 326, 116, 49);
		contentPane.add(btnUpdate);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getSearchUser().setEnabled(true);
				Main.getUpdateDeleteUser().setVisible(false);
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnClose.setBounds(281, 326, 116, 49);
		contentPane.add(btnClose);
	}

}
