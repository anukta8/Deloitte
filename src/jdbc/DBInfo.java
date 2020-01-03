package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBInfo {
		
		
		Connection con = null;
		
		
		
		public DBInfo (){
			
		}

		
		public void listEmployeeByDate(String date)
		{
			DBConnector connector = new DBConnector("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");
			con=connector.getConnection();
			
			String sql="select last_name, hire_date from employees where hire_date < ?";

			try {
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setString(1, date);					//BECAUSE USED ? IN LINE 21
				ResultSet rs  = pst.executeQuery();
				
				while(rs.next())
				{
					System.out.println(rs.getString(1)+":"+rs.getString(2));
				}
			}catch(SQLException e)
			{
				System.out.println(e);
			}
		}
		
	public static void main(String[] args) {
		
		
		DBInfo info = new DBInfo();
		info.listEmployeeByDate("01-JUN-10");
		
	}
}
