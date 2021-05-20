package connection.jdbc;
import java.sql.*;
public class Insert {

	public static void main(String[] args) throws SQLException{
		// TODO Auto-generated method stub
		
		try
		{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XEPDB1", "Manvitha", "Manvitha123");
			
			Statement stmt = conn.createStatement();
			
			int count = stmt.executeUpdate("insert into employee values(7, 'Jack', 'mgr',1,'15-May-2021',10000,2000,2)");
			
			System.out.println("Record is inserted successfully "+count);
			
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		

	}

}
