package inherit;

public class Savings extends Acccount {
	
	private static final double MINIMUM = 1000; 

	public Savings(String name, double balance, int number) {
		super(name, balance, number);
		// TODO Auto-generated constructor stub
	
	}

	@Override
	public void print(String s)
	{
		//System.out.println("printing account infoo  "+s);
		super.print(s);
	}
	@Override
	public void withdraw(double amount)
	{
		if(balance-amount>=MINIMUM)
		{
			balance -= amount;
			
	}
	}
	
}

