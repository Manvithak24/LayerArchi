package connection.jdbc;
import java.sql.*;
import java.time.LocalDate;
import java.time.Month;

import oracle.jdbc.driver.OracleDriver;
public class PreparedStatement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		insertEmpData(7,"Sam","Sales",2,LocalDate.of(2019, Month.JANUARY, 11),1200,12,1);

	}
	private static void insertEmpData(int empId,String empName,String job,int mgrid,LocalDate hireDate, double salary, double comm, int deptCode)
	{
		Connection conn = null;
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XEPDB1", "Manvitha", "Manvitha123");
			final String QUERY="SELECT empid,empName,job,mgrid,hiredate,salary,comm,deptcode";
			String sql = "insert into employee values(?,?,?,?,?,?,?,?)";
			CallableStatement pstmt=conn.prepareCall(sql);
			pstmt.setInt(1,empId);
			pstmt.setString(2,empName);
			pstmt.setString(3,job);
			pstmt.setInt(4,mgrid);
			pstmt.setDate(5, Date.valueOf(hireDate));
			pstmt.setDouble(6,salary);
			pstmt.setDouble(7, comm);
			pstmt.setInt(8,deptCode);
			
			int count = pstmt.executeUpdate();
			
			System.out.println("Record is inserted successfully ");
			
			
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		finally {
			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
//	public void setDouble(int i, double balance) {
//		// TODO Auto-generated method stub
//		
//	}

}
