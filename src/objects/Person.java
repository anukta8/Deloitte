package objects;

public class Person {

	private String name;
	private long ph_number;
	
	private static int instances = 0;
	
	//setter or mutator
	public void setName(String name)
	{
		this.name= name;
	}
	
	//getter or accesser
	public String getName()
	{
		return name;
	}
	
	public void setPh_number(long num)
	{
		ph_number=num;
	}
	
	public long getPh_number()
	{
		return ph_number;
	}
	
	@Override
	public String toString() {				//superclass method
		return name+":"+ph_number;
		
	}
	
	//default no-arg constructor(used to create instances)
	public Person() {
		
		++instances;
	}
	
	//2-arg constructor, OVERLOADED CONSTRUCTOR
	public Person(String name, long number)
	{
		this();    //calls the above constructor;refers to the constructor of this class
		this.name=name;
		ph_number=number;
	}
	
	//1-arg constructor
	public Person(String name)
	{
		this(name,0L);
		
		/*this();
	 	this.name=name;
		 */
	}
	
	
	/*public int getInstances()
	{
		return instances;
	}
	*/
	public static void main(String[] args) 
	{
	
		Person anu=new Person();  //use new keyword to create an instance
		anu.setName("Anukta");
		anu.setPh_number(11223366);
		
		System.out.println(anu.getName());
		System.out.println(anu.getPh_number());
		
		
		
		Person xyz = new Person();
		xyz.setName("Monica");
		xyz.setPh_number(336699);
		
		
		Person abc = new Person("alice", 123456);
		System.out.println(abc);
		
		Person one= new Person("A N S");
		System.out.println(one);
		
		System.out.println("number of instances:"+instances);
	/*	System.out.println(xyz.getName()+":"+xyz.getPh_number());
		System.out.println(anu);
		
	*/
		
		//String[] Person = {anu,xyz,abc,one};
		
	}

}
