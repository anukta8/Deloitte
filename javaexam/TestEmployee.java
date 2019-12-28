package javaexam;


public class TestEmployee {
	static Employee[] emps= new Employee[4];
	static Department[] depts=new Department[3];
	static Role[] roles=new Role[3];
	
	static int countEmp=0;
	static int countDept=0;
	static int countRole=0;
	
	
	public static void main(String[] args) {
		Department d1= new Department("hr","Delhi");
		Department d2= new Department("developer","mumbai");
		Department d3= new Department("test","bbsr");
		
		depts[0]=d1;
		depts[1]=d2;
		depts[2]=d3;
		
		Role r1= new Role("manager");
		Role r2= new Role("developer");
		Role r3=new Role("tester");
		roles[0]=r1;
		roles[1]=r2;
		roles[2]=r3;
		
		Employee em1= new Employee("Anukta",111,35000,r1,d3,null);
		addEmployee(em1);
		
		Employee em2= new Employee("Arpita",222,34000,r1,d1,null);
		addEmployee(em2);
		
		Employee em3= new Employee("Sobhna",336,89000,r3,d3,em1);
		addEmployee(em3);
		
		Employee em4= new Employee("Ankita",4423,12000,r2,d1,em2);
		addEmployee(em4);
		
		listEmployees();
		printEmployeesDept("hr");
		printEmployeesRole("manager");
		IncrementSalary("manager",10);
		System.out.println("salary incremented employees");
		employeeIncrementSalary();
		
		printEmployeesManager("Ankita");
	}
	
	public static void listEmployees() {
		for(Employee e:emps) {
			System.out.println(e);
		}
	}
	public static void printEmployeesDept(String dept)
	{
		System.out.println("employees of department: "+ dept);
		
		
		for(Employee e:emps)
		{
			String d= e.getDepartment().getName();
			
			if(d.equals(dept))
			{
				System.out.println(e.getName());
			}
			
		}
		
	}
	public static void printEmployeesRole(String role)
	{
		System.out.println("employees of role: "+ role);
		
		
		for(Employee e:emps)
		{
			String d= e.getRole().getName();
			
			if(d.equals(role))
			{
				System.out.println(e.getName());
			}
			
		}
		
	}
	public static void IncrementSalary(String r, int x) {
		for(Employee e: emps) {
			String role=e.getRole().getName();
			
			if(role.equalsIgnoreCase(r)) {
				
				e.setSalary(e.getSalary()+(e.getSalary()*x/100));
				//System.out.println(e.getName()+": "+e.getSalary());
				e.setSalaryInc(true);
			}
			
		}
	}
	public static void printEmployeesManager(String n)
	{
		System.out.println("employees under manager: "+ n);
		
		
		for(Employee e:emps)
		{
			if(e.getManager()!=null) {
			String manger=e.getManager().getName();
			
				if(manger.equalsIgnoreCase(n)) {
					System.out.println(e.getName());
				}
			}
		}
		
	}
	
	public static void employeeIncrementSalary()
	{
		
		for(Employee e:emps)
		{
			if(e.getSalaryInc())
				System.out.println(e);
			
		}
	}
	
	public static void addEmployee(Employee e) {
		if(countEmp<4) {
			emps[countEmp++]=e;
		}
	}
	
	
}
