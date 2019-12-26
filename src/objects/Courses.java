package objects;

public class Courses {

	
	private String sub1;
	private String sub2;
	private Student[] stu;
	private int counter = 0;
	private int limit = 3;
	private int numCourses=0;
	private Courses[] courses= new Courses[limit];
	
	public Courses()
	{
		stu = new Student[limit];
	}
	
	public Student[] getStudentArray() {
		return stu;
	}
	
	public void addStudent(Student st) {
		if(counter<limit) {
			stu[counter++]=st;
		}
		else
			System.out.println("course is fillled");
		
	}
	
	public void addCourses(Courses c)
	{
		courses[numCourses++]=c;
	}
	
	public void display() {
		for(Student s : stu) {
			System.out.println(s);
		}
	}
	
	
	public void printStudentNAme(String subject)
	{
		for(Courses c:courses)
		{
			if(c.getSub1().equalsIgnoreCase(subject) || (c.getSub2().equalsIgnoreCase(subject)))
			{
				Student[] students = c.getStudentArray();
				for(Student s : students)
				{
					System.out.println(s);
				}
			}	
		}
	}
	
	
	public String getSub1() {
		return sub1;
	}


	public void setSub1(String sub1) {
		this.sub1 = sub1;
	}


	public String getSub2() {
		return sub2;
	}


	public void setSub2(String sub2) {
		this.sub2 = sub2;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Courses phy= new Courses();
		phy.setSub1("mechanics");
		phy.setSub2("dynamics");
		
		phy.addStudent(new Student("a",121));
		phy.addStudent(new Student("b",122));
		phy.addStudent(new Student("c",123));
		phy.addStudent(new Student("d",124));
		
		phy.display();
	}


	
	}


