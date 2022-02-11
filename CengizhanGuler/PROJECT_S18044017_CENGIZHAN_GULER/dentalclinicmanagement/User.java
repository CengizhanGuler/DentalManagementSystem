import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
	Conn conn = new Conn();
	public String userName, name, password, type;
	public int id;

	public User() {

	}

	public User(int id, String userName, String name, String password, String type) {

		this.name = name;
		this.password = password;
		this.type = type;
		this.id = id;
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
