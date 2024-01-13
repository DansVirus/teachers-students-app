package gr.aueb.cf.tsapp;

import java.awt.EventQueue;

public class Main {
	
	private static Menu menu;
	private static SearchFormTeachers searchFormTeachers;
	private static SearchFormStudents searchFormStudents;
	private static InsertFormTeachers insertFormTeachers;
	private static InsertFormStudents insertFormStudents;
	private static UpdateDeleteFormTeachers updateDeleteFormTeachers;
	private static UpdateDeleteFormStudents updateDeleteFormStudents;
	
	private static LoginPage loginPage;
	private static InsertUser insertUser;
	private static SearchUser searchUser;
	private static UpdateDeleteUser updateDeleteUser;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu = new Menu();
					menu.setLocationRelativeTo(null);
					menu.setVisible(false);
					
					searchFormTeachers = new SearchFormTeachers();
					searchFormTeachers.setLocationRelativeTo(null);
					searchFormTeachers.setVisible(false);
					
					insertFormTeachers = new InsertFormTeachers();
					insertFormTeachers.setLocationRelativeTo(null);
					insertFormTeachers.setVisible(false);
					
					updateDeleteFormTeachers = new UpdateDeleteFormTeachers();
					updateDeleteFormTeachers.setLocationRelativeTo(null);
					updateDeleteFormTeachers.setVisible(false);
					
					searchFormStudents = new SearchFormStudents();
					searchFormStudents.setLocationRelativeTo(null);
					searchFormStudents.setVisible(false);
					
					insertFormStudents = new InsertFormStudents();
					insertFormStudents.setLocationRelativeTo(null);
					insertFormStudents.setVisible(false);
					
					updateDeleteFormStudents = new UpdateDeleteFormStudents();
					updateDeleteFormStudents.setLocationRelativeTo(null);
					updateDeleteFormStudents.setVisible(false);
					
					loginPage = new LoginPage();
					loginPage.setLocationRelativeTo(null);
					loginPage.setVisible(true);
					
					insertUser = new InsertUser();
					insertUser.setLocationRelativeTo(null);
					insertUser.setVisible(false);
					
					searchUser = new SearchUser();
					searchUser.setLocationRelativeTo(null);
					searchUser.setVisible(false);
					
					updateDeleteUser = new UpdateDeleteUser();
					updateDeleteUser.setLocationRelativeTo(null);
					updateDeleteUser.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static Menu getMenu() {
		return menu;
	}

	public static SearchFormTeachers getSearchFormTeachers() {
		return searchFormTeachers;
	}

	public static InsertFormTeachers getInsertFormTeachers() {
		return insertFormTeachers;
	}

	public static UpdateDeleteFormTeachers getUpdateDeleteFormTeachers() {
		return updateDeleteFormTeachers;
	}

	public static LoginPage getLoginPage() {
		return loginPage;
	}

	public static InsertUser getInsertUser() {
		return insertUser;
	}

	public static SearchUser getSearchUser() {
		return searchUser;
	}

	public static UpdateDeleteUser getUpdateDeleteUser() {
		return updateDeleteUser;
	}

	public static SearchFormStudents getSearchFormStudents() {
		return searchFormStudents;
	}

	public static InsertFormStudents getInsertFormStudents() {
		return insertFormStudents;
	}

	public static UpdateDeleteFormStudents getUpdateDeleteFormStudents() {
		return updateDeleteFormStudents;
	}
	
	

}
