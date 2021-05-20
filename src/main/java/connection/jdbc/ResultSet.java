package connection.jdbc;
import java.sql.*;

public class ResultSet {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XEPDB1", "Manvitha", "Manvitha123");
		
		Statement stmt = conn.createStatement();
		ResultSet rs = (ResultSet) stmt.executeQuery("select * from Employees");
		System.out.println("Contents of the Result Set");
	      while(((java.sql.ResultSet) rs).next()) {
	         System.out.print("ID: " + ((java.sql.ResultSet) rs).getInt("id"));
	         System.out.print(", Salary: " + ((java.sql.ResultSet) rs).getInt("Salary"));
	         System.out.print(", Name: " + ((java.sql.ResultSet) rs).getString("Name"));
	         System.out.println(", Location: " + ((java.sql.ResultSet) rs).getString("Location"));
	      }
	      
	      System.out.println();
	      ((java.sql.ResultSet) rs).moveToInsertRow();
	      ((java.sql.ResultSet) rs).updateInt(1, 7);
	      ((java.sql.ResultSet) rs).updateString(2, "Santosh");
	      ((java.sql.ResultSet) rs).updateInt(3, 96000);
	      ((java.sql.ResultSet) rs).updateString(4, "Mumbai");
	      ((java.sql.ResultSet) rs).insertRow();
	      
	      System.out.println("Contents of the ResultSet after inserting another row in to it");
	      ((java.sql.ResultSet) rs).beforeFirst();
	      while(((java.sql.ResultSet) rs).next()) {
	         System.out.print("ID: " + ((java.sql.ResultSet) rs).getInt("id"));
	         System.out.print(", Salary: " + ((java.sql.ResultSet) rs).getInt("Salary"));
	         System.out.print(", Name: " + ((java.sql.ResultSet) rs).getString("Name"));
	         System.out.println(", Location: " + ((java.sql.ResultSet) rs).getString("Location"));


	      }
	}

}
