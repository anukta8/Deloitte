package Organization;

public class Employee extends Person {
	protected static int id;
	protected static Department dept;
	
	public Employee(String name, int id, Department dept) {
		super(name);
		this.id = id;
		dept = dept;
	}

	public Employee(String name, Address addr, int id, Department deprt)
	{
		super(name,addr);
		this.id=id;
		this.dept=deprt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", dept=" + dept + "]";
	}
	
	
	

}
