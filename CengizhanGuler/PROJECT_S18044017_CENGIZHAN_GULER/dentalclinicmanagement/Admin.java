import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Admin extends User {
	public Admin(int id, String name, String userName, String password, String type) {
		super(id, userName, name, password, type);

	}

	public Admin() {
	}

	public boolean addDentist(String name, String userName, String password) throws SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		Statement st = null;
		ResultSet rs = null;
		int key = 0;
		
		// When adding new dentist by admin, username, name and password are assigned by admin, type is automatically assigned dentist 
		//and is added to the database with the SQL code in this section.
		String query = "INSERT INTO user" + "(username,name,password,type) VALUES" + "(?,?,?,?)";
		try {
			dbConnection = conn.connDb();
			st = dbConnection.createStatement();
			preparedStatement = dbConnection.prepareStatement(query);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, password);
			preparedStatement.setString(4, "dentist");
			preparedStatement.executeUpdate();
			key = 1;

		} catch (Exception e) {
			// TODO: handle exception
		}
		if (key == 1)
			return true;
		else
			return false;
	}
	public boolean addUser(String name, String userName, String password,String type) throws SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		Statement st = null;
		ResultSet rs = null;
		int key = 0;
		
		//When the user becomes a member in the Register panel,
		//user enters the username, name, password and type information and performs the registration process and 
		//is registered to the database with the SQL code in this section.
		String query = "INSERT INTO user" + "(username,name,password,type) VALUES" + "(?,?,?,?)";
		try {
			dbConnection = conn.connDb();
			st = dbConnection.createStatement();
			preparedStatement = dbConnection.prepareStatement(query);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, password);
			preparedStatement.setString(4, type);
			preparedStatement.executeUpdate();
			key = 1;

		} catch (Exception e) {
			// TODO: handle exception
		}
		if (key == 1)
			return true;
		else
			return false;
	}
	
	public boolean deleteDentist(int id) throws SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		Statement st = null;
		ResultSet rs = null;
		int key = 0;
        //When the admin wants to remove a dentist from the dentist list in Admin Panel, admin removes it by typing the dentist's id.
		//and is removed to the database with the SQL code in this section.
		String query = "DELETE FROM USER WHERE id = ?";
		try {
			dbConnection = conn.connDb();
			preparedStatement = dbConnection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

			key = 1;

		} catch (Exception e) {
			// TODO: handle exception
		}
		if (key == 1)
			return true;
		else
			return false;
	}
	
	public boolean deleteWork(int clinic_id , int dentist_id) {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		//When the admin wants to remove a dentist from any hospital on the clinic list, he or she writes and removes the dentist id.
		String deleteSQL = "DELETE FROM employee WHERE clinic_id = ? AND dentist_id = ? ";
		int key = 0;

		try {
			dbConnection = conn.connDb();
			preparedStatement = dbConnection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, clinic_id);
			preparedStatement.setInt(2, dentist_id);
			preparedStatement.executeUpdate();
			 key = 1;
		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			try {
				dbConnection.close();
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		if(key==1)
			return true;
		else
			return false;

	}
	
	public boolean deleteApp(int id) {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		//When an administrator wants to remove an appointment in the appointment list, he or she writes and removes the appointment id.
		String deleteSQL = "DELETE FROM appointment WHERE id = ?";
		int key = 0;

		try {
			dbConnection = conn.connDb();
			preparedStatement = dbConnection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			 key = 1;
		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			try {
				dbConnection.close();
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		if(key==1)
			return true;
		else
			return false;

	}
	
	
}