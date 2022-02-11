import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DentistWork {
	public int id,dentist_id;
	public String clinic_name;
	Conn conn = new Conn();
	public DentistWork(int id, int dentist_id, String clinic_name) {
		super();
		this.id = id;
		this.dentist_id = dentist_id;
		this.clinic_name = clinic_name;
	}
	public DentistWork() {
		
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
	public String getClinic_name() {
		return clinic_name;
	}
	public void setClinic_name(String clinic_name) {
		this.clinic_name = clinic_name;
	}
	
	public ArrayList<DentistWork> getList(int dentist_id) throws SQLException {

		ArrayList<DentistWork> work = new ArrayList<DentistWork>();
		Connection con = conn.connDb();
		Statement st = null;
		ResultSet rs = null;
		DentistWork d;
		//The "employee" and "clinics" table makes LEFT JOIN where "e.clinic_id" and "h.id" are equal and selects all tuples where "e.dentist_id" equals "dentist_id".
		try {
			st = con.createStatement();
			rs = st.executeQuery("Select * from employee e LEFT JOIN clinics h ON e.clinic_id = h.id where e.dentist_id = " + dentist_id);

			while (rs.next()) {
				d = new DentistWork(rs.getInt("id"), rs.getInt("dentist_id"), rs.getString("name"));
				work.add(d);
			}

		} catch (SQLException ex) {
		} finally {
			st.close();
			rs.close();
			con.close();
		}
		return work;
	}
	

	public boolean deleteWork(int id) {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		//Employee is deleted from the "employee" table where it is equal to the id entered.
		String deleteSQL = "DELETE FROM employee WHERE id = ?";

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
