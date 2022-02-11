import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Patient extends User {
	public Patient(int id, String name, String userName, String password, String type) {
		super(id, userName, name, password, type);
	}

	public Patient() {
	}

	public boolean addAppointment(int dentist_id, int patient_id, String date) throws SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		int key = 0;
		//"dentist_id", "patient_id" and "date" are entered in the "appointment" table for adding appointment.
		String query = "INSERT INTO appointment" + "(dentist_id,patient_id,date) VALUES" + "(?,?,?)";
		try {
			dbConnection = conn.connDb();
			preparedStatement = dbConnection.prepareStatement(query);
			preparedStatement.setInt(1, dentist_id);
			preparedStatement.setInt(2, patient_id);
			preparedStatement.setString(3, date);
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
	public boolean updateDateStatus(int dentist_id, String date) throws SQLException
	{
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		int key = 0;
		//In the "availabledate" table, whether the status is active or passive is updated according to the appointment.
		String query = "update availabledate set status = ?  where dentist_id = ? AND date = ?";
		try {
			dbConnection = conn.connDb();
			preparedStatement = dbConnection.prepareStatement(query);
			preparedStatement.setString(1, "passive");
			preparedStatement.setInt(2, dentist_id);
			preparedStatement.setString(3, date);
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
