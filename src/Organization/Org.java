package Organization;

public class Org {

	public static void main(String[] args) {

		Department hr = new Department("hr","hyd");
		
		Department dev = new Department("dev","mum");
		
		Department test = new Department("test","blr");
		
		Address add1 = new Address("42","lane1","bbsr","odisha");
		Employee e1 = new Employee("anukta", add1, 123, hr);
		
		Address add2 = new Address("452","lane121","kgp","kol");
		Employee e2 = new Employee("anu", add2, 163, dev);
		

	}

}
