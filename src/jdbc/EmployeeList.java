package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeList {
	
	
	Connection con = null;
	List<Employee> emps = new ArrayList();
	
	public EmployeeList() {
		
	}
	
	public void listEmployeeByDate(String date)
	{
		DBConnector connector = new DBConnector("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");
		con=connector.getConnection();
		String sql = "select employee_id, first_name, last_name, department_id, salary, to_char(hire_date, 'DD-MON-YYYY') from employees where hire_date < ?";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1,date);     //CAN ALSO USE getDate();
			ResultSet rs  = pst.executeQuery();
			
			while(rs.next())
			{
				//System.out.println(rs.getString(1)+";"+rs.getString(2)+";"+rs.getString(3)+":"+rs.getNString(4)+":"+rs.getString(5)+":"+rs.getString(6));
				int id=rs.getInt(1);
				String fname = rs.getString(2);
				String lname = rs.getString(3);
				int depId = rs.getInt(4);
				double sal = rs.getInt(5);
				String jdate = rs.getString(6);
				SimpleDateFormat sdf = new SimpleDateFormat("DD-MMM-YYYY");
				Date joinDate =null;
				
				try{
					joinDate = sdf.parse(jdate);
				}catch(ParseException e1)
				{
					e1.printStackTrace();
				}
				
				Employee e = new Employee(id,fname+" "+lname, depId,joinDate,sal);
				
				
				System.out.println(e);
				emps.add(e);
				
			}
		}catch(SQLException e)
		{
			System.out.println(e);
		}
	}
	
	
	public void listEmployeeByDept(int dept)
	{
		DBConnector connector = new DBConnector("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");
		con=connector.getConnection();
		
		//String sql = "select department_id from departments where department_name='Executive';\r\n" + 
		//		"\r\n" + 
		//		"select * from employees where department_id =(select department_id from departments where department_name='"+deptName+"')";
		
		//String sql="select * from employees where department_id = "+dept;
		
		String sql="select * from employees where department_id = ?";

		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1,dept);
			ResultSet rs  = pst.executeQuery();
			
			while(rs.next())
			{
				System.out.println(rs.getString(1)+";"+rs.getString(2)+";"+rs.getString(3));
			}
		}catch(SQLException e)
		{
			System.out.println(e);
		}
		
	}
	 
	
	//public void 
	
	public static void main(String[] args) {


		//new EmployeeList().listEmployeeByDept("Executive");
		EmployeeList list = new EmployeeList();
		list.listEmployeeByDept(90);
		list.listEmployeeByDate("01-JAN-2010");
		System.out.println(list.emps.size());
		
		//list.listEmployeeByDept("Executive");
		
		//DBInfo info = new DBInfo();
		//info.listEmployeeByDate("01-JUN-10");
		
	}

}
