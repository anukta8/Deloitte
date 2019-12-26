package objects;

public class Atm {
	
	private double totalAmount;
	private double withdrawlLimit;
	//private int pin=123;
	private static Account acc;
	
	

	public Account getAcc() {
		return acc;
	}

	public void setAcc(Account acc) {
		this.acc = acc;
	}

	public Atm() 
	{
		totalAmount = 150000;
		withdrawlLimit = 5000;
		
	}
	
	public boolean validatePin(int pin)
	{
		return acc.getAccpin() == pin;					//changes
	}
	
	public double withdraw(double amt, int pin)
	{
		if (validatePin(pin))				//changes				
		{
			if(amt <= withdrawlLimit)
			{
				if(amt < acc.getAccbalance()- Account.minbalance)
				{
				totalAmount -= amt;
				acc.setAccbalance(acc.getAccbalance()-amt);
				return amt;
				}
			}
			else 
			{
					System.out.println("amount exceded withdrawl limit");
			}
		}
		return 0.0;
	}
	
	public double deposit(double amt, int pin)
	{
		if(validatePin(pin))
		{
			totalAmount += amt;
		}
		else
		{
			System.out.println("Wrong PIN");
		}
		return amt;
	}
	
	public String toString()
	{
		return "total amount = "+totalAmount;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Atm atm =new Atm();
		
		Account act = new Account("man",3232,2100);
		atm.setAcc(act);
	
		atm.withdraw(700,3232);
		atm.deposit(150,3232);
		System.out.println(atm);
		
		System.out.println(atm.getAcc());
		
		
	}

}
