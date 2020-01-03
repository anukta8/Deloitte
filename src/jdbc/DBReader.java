package jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class DBReader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//1.load driver
		Connection con=null;
		
		try {
			Class.forName("Oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e)
		{
			System.out.println("Driver not found"+e.getMessage());
		}
		
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String username = "hr";
		String password = "hr";
		
		//2.get connection
		try {
			con = DriverManager.getConnection(url, username, password);
		}catch(SQLException e)
		{
			System.out.println("connection failed"+e.getMessage());
		}
		
		//database metadata
		
		try {
			DatabaseMetaData dbmeta = con.getMetaData();    //connection object
			System.out.println(dbmeta.toString());
			System.out.println(dbmeta.getDatabaseMajorVersion());
			System.out.println(dbmeta.getDatabaseProductName());


			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		//3.create a statement object
		String sql = "select first_name, last_name, employee_id from employees where last_name = 'King'";
		
		try {
			Statement st = con.createStatement();
			//4. pass sql query string and execute statement
			ResultSet rs = st.executeQuery(sql);
			
			ResultSetMetaData rsmd = rs.getMetaData();
			int colCount = rsmd.getColumnCount();
			System.out.println(colCount);
			
			int type=rsmd.getColumnType(3);
	
			if(type == Types.INTEGER)
			{
				System.out.println("col 1 has integer type.");
			}else if(type==Types.VARCHAR) {
				System.out.println("col 1 is a string(varchar)");
			}else if(type==Types.NUMERIC)
			{
				System.out.println("col is of type numeric");
			}
			
			System.out.println(rsmd.getColumnTypeName(3));
			
			while(rs.next())
			{
				int id = rs.getInt(3);
				String fname = rs.getString("first_name");
				String lname = rs.getString("last_name");
				System.out.println(id+":"+fname+":"+lname);
				
			}
			rs.close();
			st.close();
			con.close();
			
		}catch(SQLException sqle)
		{
			System.out.println(sqle.getMessage());
		}
		
		
	}

}
