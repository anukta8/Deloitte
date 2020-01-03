package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class User_dao {

	Connection con = null;
	List <Users> list = new ArrayList<Users> ();  
	
	public void listUsers()
	{
		DBConnector connector = new DBConnector("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");
		con=connector.getConnection();
		
		String sql="select u.first_name,u.email, u.username, u.pwd, r.role_name from user_details u inner join role_table r on u.role_id = r.role_id";

		try {
			PreparedStatement pst = con.prepareStatement(sql);
			
			ResultSet rs  = pst.executeQuery();
			
			while(rs.next())
			{
				System.out.println(rs.getString(1)+" : "+rs.getString(2)+" : "+rs.getString(3)+" : "+rs.getString(4)+" : "+rs.getString(5));
			}
			
		}catch(SQLException e)
		{
			System.out.println(e);
		}
	}
	
	public void addUser()
	{
		Iterator iter = list.iterator();
	}
	
	public void roleOfUser(String first_name)
	{
		DBConnector connector = new DBConnector("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");
		con=connector.getConnection();
		
		String sql="select u.first_name, r.role_name from user_details u inner join role_table r on u.role_id = r.role_id where u.first_name  < ?";

		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, first_name);					//BECAUSE USED ? IN LINE 21
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
		
		User_dao usr = new User_dao();
		
		usr.listUsers();
		usr.roleOfUser("vikash");
		

	}

}
