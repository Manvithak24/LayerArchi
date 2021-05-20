package connection.jdbc;
import java.sql.*;
public class Transaction {
	
	public static void main(String[] args)
	{
		Connection connection = null;
		try {
			Class.forName("Oracle.jdbc.driver.OracleDriver");
			
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XEPDB1","Manvitha", "Manvitha123");
			connection.setAutoCommit(false);
			
			int fromAccount = 1;
			int toAccount = 5;
			int amount = 200;
			
			withdrawAmount(connection, fromAccount, amount);
			depositAmount(connection, toAccount, amount);
			connection.commit();
		}
		catch( ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
			if(connection !=null)
			{
				try {
					connection.rollback();
					System.out.println("Rolling back");
					
				}
				catch (SQLException e1)
				{
					e1.printStackTrace();
				}
			}
			
	

			
		}
	}

	private static void depositAmount(Connection connection, int accountNum, int amount) throws SQLException{
		// TODO Auto-generated method stub
		String sql = "UPDATE BANKACNT SET balance = balance +? WHERE acnt_num = ?";
		
		java.sql.PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, amount);
			stmt.setInt(2, accountNum);
			int count = stmt.executeUpdate();
			if(count == 0) {
				throw new SQLException("Account num not fount "+accountNum);
			}
		}
		finally {
			if(stmt != null) {
				stmt.close();
			}
		}
	}

	private static void withdrawAmount(Connection connection, int accountNum, int amount)throws SQLException {
		// TODO Auto-generated method stub
		String sql = "UPDATE BANKACNT SET balance = balance -? WHERE acnt_num =?";
		java.sql.PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1,amount);
			stmt.setInt(2,accountNum);
			int count = stmt.executeUpdate();
			if(count ==0) {
				throw new SQLException("Account num not fount "+ accountNum);
		}
		
	}
	finally {
		if(stmt != null) {
			stmt.close();
		}
			
		}
	}
	

}
