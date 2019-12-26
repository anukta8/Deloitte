package inherit;

public class AccontTest {
	
	public static void showBalance(Acccount ac)   //doubt
	{
		System.out.println(ac.getBalance());
	}
	
	public static void printAccount(Acccount ac, Printer p)
	{
		ac.print("from accounts...");
		p.print("from printer class....");
	}
	
	
	public static void main(String[] args) {
	
		Savings s = new Savings("Anukta",10000,123);
		System.out.println(s);
		
		s.withdraw(6500);
		System.out.println(s);
		
		
		Current c = new Current("Anu",10000,456);
		System.out.println(c);
		
		c.withdraw(1200);
		System.out.println("----"+c);
		
		Acccount ac = new Savings("aaa",10000,645);
		System.out.println(ac);
		
		ac.withdraw(500);
		System.out.println(ac);
		
		showBalance(ac);
		
		ac.print("print mee....");
		s.print("from savings....");
		ac.print("print mee....");
		
		printAccount(ac,new ConsolePrinter());
		printAccount(ac,new FilePrinter());


		
	}

}
