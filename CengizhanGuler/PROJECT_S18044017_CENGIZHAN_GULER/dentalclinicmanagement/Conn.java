import java.sql.*;

public class Conn {

	Connection c = null;
	Statement stmt = null;
	
	Conn()
	{}
	public Connection connDb()
	{
		try{
			 this.c = DriverManager.getConnection("jdbc:mariadb://localhost:3306/clinic?user=root&password=123456");
			 return c;
		}
		catch (Exception e) {
			System.err.println(e);
		}
		return c;
	}
}
