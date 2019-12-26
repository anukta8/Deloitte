package objects;

public class Student {

	private String name;
	private long rollnumber;
	
	public Student(String name, long roll) {
		this.name=name;
		rollnumber=roll;
	}
	
	
	public void setName(String name) {
		this.name=name;
	}
	
	public void setRoll(long roll)
	{
		rollnumber= roll;
	}
	
	public String getName() {
		return name;
	}
	
	public long getRoll() {
		return rollnumber;
	}
	
	public String toString() {				//superclass method
		return name+":"+rollnumber;
	}
	
	
	public static void main(String[] args) {
		
		Student anu=new Student("Anukta", 121); 
		System.out.println(anu);
		
	}

}
