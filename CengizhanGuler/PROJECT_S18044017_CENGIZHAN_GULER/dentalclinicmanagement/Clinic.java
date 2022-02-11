import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Clinic {
	public int id;
	public String name, adress, phone;
	Conn conn = new Conn();

	public Clinic(int id, String name, String adress, String phone) {
		this.id = id;
		this.name = name;
		this.adress = adress;
		this.phone = phone;
	}

	public Clinic() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public ArrayList<Clinic> getList() throws SQLException {

		ArrayList<Clinic> clinic = new ArrayList<Clinic>();
		Connection con = conn.connDb();
		Statement st = null;
		ResultSet rs = null;
		Clinic d;
		//Selects all rows in the "clinics" table includes the followings.
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM clinics");
			while (rs.next()) {
				d = new Clinic(rs.getInt("id"), rs.getString("name"), rs.getString("adress"), rs.getString("phone"));
				clinic.add(d);
			}

		} catch (SQLException ex) {
		} finally {
			st.close();
			rs.close();
			con.close();
		}
		return clinic;
	}

	
	

}
