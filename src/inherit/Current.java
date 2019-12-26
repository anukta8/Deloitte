package inherit;

public class Current extends Acccount {
	
	

	public Current(String name, double balance, int number) {
		super(name, balance, number);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void withdraw(double amount)
	{
		if(amount<=balance)
			balance-=amount;
	}
	
	

}
