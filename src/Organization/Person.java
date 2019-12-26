package Organization;

public class Person {

	protected static String name;
	protected String address;
	
	public Person(String name) {
		this.name=name;
	}
	
	public Person(String name, Address addr) {
		super();
		this.name = name;
		this.address = address;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", address=" + address + "]";
	}
	
	
	
}
