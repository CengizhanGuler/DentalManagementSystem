import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class DentistDate {
	public int id, dentist_id;
	public String date, status;
	Conn conn = new Conn();

	public DentistDate(int id, int dentist_id, String date, String status) {
		this.id = id;
		this.dentist_id = dentist_id;
		this.date = date;
		this.status = status;
	}

	public DentistDate() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDentist_id() {
		return dentist_id;
	}

	public void setDentist_id(int dentist_id) {
		this.dentist_id = dentist_id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ArrayList<DentistDate> getList(int dentist_id) throws SQLException {

		ArrayList<DentistDate> date = new ArrayList<DentistDate>();
		Connection con = conn.connDb();
		Statement st = null;
		ResultSet rs = null;
		DentistDate d;
		//In the Available Date table, all tuples are selected where the entered Dentist ID is equal to the current dentist ID and
		//the status is active.
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM availabledate WHERE dentist_id = " + dentist_id  + " AND status='active' ");
			while (rs.next()) {
				d = new DentistDate(rs.getInt("id"), rs.getInt("dentist_id"), rs.getString("date"),
						rs.getString("status"));
				date.add(d);
			}

		} catch (SQLException ex) {
		} finally {
			st.close();
			rs.close();
			con.close();
		}
		return date;
	}

	public boolean deleteDate(int id) {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String deleteSQL = "DELETE FROM availabledate WHERE id = ?";
		//Available date is deleted from the "availabledate" table where it is equal to the id entered.
		try {
			dbConnection = conn.connDb();
			preparedStatement = dbConnection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {

			System.out.println(e.getMessage());
			return false;

		} finally {

			try {
				dbConnection.close();
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
