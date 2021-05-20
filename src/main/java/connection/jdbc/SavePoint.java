package connection.jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;

import com.sun.corba.se.pept.transport.Connection;

public class SavePoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection  =null;
		Savepoint sp = null;
		try {
			Class.forName("Oracle.jdbc.driver.OracleDriver");
			connection = (Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XEPDB1","Manvitha", "Manvitha123");
			SavePoint sd = new SavePoint();
			((java.sql.Connection) connection).setAutoCommit(false);
			
			((SavePoint) sd).insertAccount(connection, 3,"Alex", 3000);
			((SavePoint) sd).insertAccount(connection,4,"Ajay",3500);
			
			sd = (SavePoint) ((java.sql.Connection) connection).setSavepoint("My save Point");
			sd.insertAccount(connection,5,"Lara",10000);
			
			((java.sql.Connection) connection).commit();
			
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			if(connection !=null)
			{
				try {
					if(sp == null) {
						System.out.println("RollingBack the transaction");
						((java.sql.Connection) connection).rollback();
						
					}
					else {
						System.out.println("Rolling back to savepoint");
						((java.sql.Connection) connection).rollback(sp);
						
						((java.sql.Connection) connection).commit();
						
						
					}
				}catch(SQLException e1)
				{
					e1.printStackTrace();
				}
			}
		}finally {
			if(connection != null)
			{
				try {
					connection.close();
					
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			
		}
	}

	private void insertAccount(Connection connection, int acntNum, String name, double balance) throws SQLException{
		// TODO Auto-generated method stub
		String insertSQL = "INSERT INTO BANKACNT (ACNT_NUM,NAME,BALANCE) values(?,?,?)";
		PreparedStatement prepStmt = null;
		try {
			prepStmt = connection.prepareStatement(insertSQL);
			((Object) prepStmt).setInt(1,acntNum);
			prepStmt.setString(2,name);
			prepStmt.setDouble(3,balance);
			int count = ((Object) prepStmt).executeUpdate();
			System.out.println("Num of records inserted - "+count);
			
			
		}finally {
			if(prepStmt != null) {
				((Connection) prepStmt).close();
			}
		}
		
	}

}
