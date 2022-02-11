import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Appointment {
	public int id,dentist_id,patient_id;
	String date,dentist_name,patient_name;
	Conn conn = new Conn();
	public Appointment(int id, int dentist_id, int patient_id, String date , String dentist_name) {
		this.id = id;
		this.dentist_id = dentist_id;
		this.patient_id = patient_id;
		this.date = date;
		this.dentist_name = dentist_name;
	}
	
	public Appointment() {}

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

	public int getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public ArrayList<Appointment> getListPatient(int patient_id) throws SQLException {

		ArrayList<Appointment> app = new ArrayList<Appointment>();
		Connection con = conn.connDb();
		Statement st = null;
		ResultSet rs = null;
		Appointment d;
		//It renames the appointment table to "a" in order not to disturb the overall structure of the table, 
		//and also renames the user table to "u". Using the LEFT JOIN command, it performs a match operation to retrieve the first table. 
		//Select places where "a.patient_id" equals patient_id.
		try {
			st = con.createStatement();
			rs = st.executeQuery("select * from appointment a LEFT JOIN user u ON a.dentist_id = u.id WHERE a.patient_id =" + patient_id);

			while (rs.next()) {
				d = new Appointment(rs.getInt("id"), rs.getInt("dentist_id"),rs.getInt("patient_id"),rs.getString("date"),rs.getString("name"));
				app.add(d);
			}

		} catch (SQLException ex) {
		} finally {
			st.close();
			rs.close();
			con.close();
		}
		return app;
	}

	public ArrayList<Appointment> getListDentist(int dentist_id) throws SQLException {

		ArrayList<Appointment> app = new ArrayList<Appointment>();
		Connection con = conn.connDb();
		Statement st = null;
		ResultSet rs = null;
		Appointment d;
		//Again using the LEFT JOIN command, it performs the match operation to get the first table. 
		//Select places where "a.dentist_id" equals dentist_id.
		try {
			st = con.createStatement();
			rs = st.executeQuery("select * from appointment a LEFT JOIN user u ON a.patient_id = u.id WHERE a.dentist_id =" + dentist_id);

			while (rs.next()) {
				d = new Appointment(rs.getInt("id"), rs.getInt("dentist_id"),rs.getInt("patient_id"),rs.getString("date"),rs.getString("name"));
				app.add(d);
			}

		} catch (SQLException ex) {
		} finally {
			st.close();
			rs.close();
			con.close();
		}
		return app;
	}

	public String getDentist_name() {
		return dentist_name;
	}

	public void setDentist_name(String dentist_name) {
		this.dentist_name = dentist_name;
	}
	
}
