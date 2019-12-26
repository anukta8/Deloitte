package objects;

public class People {

	private Person[] persons;
	int pers = 5;
	int counter = 0;
	
	public People()
	{
		persons=new Person[pers];
	}
	
	public void addPerson(Person p) {
		if(counter<pers) {
		persons[counter++]=p;
	}
	}
	public void displayPersons() {
		for(Person p : persons) {        //for(type_of_element variable:array)
			System.out.println(p);
		}
	}
	
	public static void main(String[] args) {
		
		People ppl = new People();
		Person amit = new Person("amit", 123456);
		Person anuj = new Person("anuj", 123456456456L);
		Person bibas = new Person("bibas", 456123456);
		Person ghjf = new Person("gfh", 45123456);
		
		ppl.addPerson(amit);
		ppl.addPerson(anuj);
		ppl.displayPersons();
	}

}
