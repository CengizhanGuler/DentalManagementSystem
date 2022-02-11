import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class Dentist extends User {

	public Dentist(int id, String name, String userName, String password, String type) {
		super(id, userName, name, password, type);

	}

	public Dentist() {
	}

	public boolean addAvaibleDate(int dentist_id, String date) throws SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		//The dentist determines the available dates in days, months and years.
		String query = "INSERT INTO availabledate" + "(dentist_id,date) VALUES" + "(?,?)";
		int key = 0;
		try {
			dbConnection = conn.connDb();
			preparedStatement = dbConnection.prepareStatement(query);
			preparedStatement.setInt(1, dentist_id);
			preparedStatement.setString(2, date);
			preparedStatement.executeUpdate();
			key = 1;

		} catch (SQLException e) {

			System.out.println(e.getMessage());
			key = 2;

		} finally {
			dbConnection.close();
			preparedStatement.close();

		}
		if (key == 1)
			return true;
		else
			return false;
	}

	public boolean addClinic(int dentist_id, int clinic_id) throws SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		Statement st = null;
		ResultSet rs = null;
		int count = 0;
		int key = 0;
		//The Clinic ID and Dentist ID values are entered in the Employee table.
		String query = "INSERT INTO employee" + "(clinic_id,dentist_id) VALUES" + "(?,?)";
		try {
			dbConnection = conn.connDb();
			st = dbConnection.createStatement();
			rs = st.executeQuery(
		//All tuple are selected where the entered clinic ID is equal to the current clinic ID and 
		//the entered dentist ID is equal to the current dentist ID in Employee Table.
					"SELECT * FROM employee WHERE clinic_id = " + clinic_id + " AND  dentist_id =" + dentist_id);
			while (rs.next()) {
				count++;
			}
			if (count == 0) {
				preparedStatement = dbConnection.prepareStatement(query);
				preparedStatement.setInt(1, clinic_id);
				preparedStatement.setInt(2, dentist_id);
				preparedStatement.executeUpdate();
				key = 1;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		if (key == 1)
			return true;
		else
			return false;
	}

	public ArrayList<Dentist> getList() throws SQLException {

		ArrayList<Dentist> dentist = new ArrayList<Dentist>();
		Connection con = conn.connDb();
		Statement st = null;
		ResultSet rs = null;
		Dentist d;
		//Select tuples in the User table whose type is equal to the dentist.
		try {
			st = con.createStatement();
			rs = st.executeQuery("Select * from user where type = 'dentist' ");

			while (rs.next()) {
				d = new Dentist(rs.getInt("id"), rs.getString("name"), rs.getString("username"),
						rs.getString("password"), rs.getString("type"));
				dentist.add(d);
			}

		} catch (SQLException ex) {
		} finally {
			st.close();
			rs.close();
			con.close();
		}
		return dentist;
	}

	public ArrayList<Dentist> getDentistList(int clinic_id) throws SQLException {
		ArrayList<Dentist> dentist = new ArrayList<Dentist>();
		Connection con = conn.connDb();
		Statement st = null;
		ResultSet rs = null;
		Dentist d;
		try {
			st = con.createStatement();
			rs = st.executeQuery(
					"select u.id , u.name , u.username , u.password  from clinics h LEFT JOIN employee e  ON h.id = e.clinic_id  LEFT JOIN user u  ON e.dentist_id = u.id WHERE h.id="
							+ clinic_id);

			while (rs.next()) {
				d = new Dentist(rs.getInt("u.id"), rs.getString("u.name"), rs.getString("u.username"),
						rs.getString("u.password"), "dentist");
				dentist.add(d);
			}

		} catch (SQLException ex) {
		} finally {
			st.close();
			rs.close();
			con.close();
		}
		return dentist;
	}
	
	public boolean updateDentist(int id, String name, String username, String password) throws SQLException
	{
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		int key = 0;
		String query = "update user set name = ?, username = ? , password = ?  where id = ?";
		try {
			dbConnection = conn.connDb();
			preparedStatement = dbConnection.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, username);
			preparedStatement.setString(3, password);
			preparedStatement.setInt(4, id);
			preparedStatement.executeUpdate();
			key = 1;

		} catch (SQLException e) {

			System.out.println(e.getMessage());
			key = 2;

		} finally {
			dbConnection.close();
			preparedStatement.close();

		}
		if (key == 1)
			return true;
		else
			return false;
		
	}

}
