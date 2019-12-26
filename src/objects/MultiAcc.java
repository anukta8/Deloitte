package objects;

public class MultiAcc {

	private double totalAmount;
	private double withdrawlLimit;
	private Account[] accts;
	Account currentAccountHolder;
	
	int counter =0;
	int limit = 3;
	
	public MultiAcc(double totalAmount, double withdrawlLimit, Account[] accts) {
		super();
		this.totalAmount = totalAmount;
		this.withdrawlLimit = withdraw(0, 0);
		accts = new Account[limit];
	}
	
	public void addAccount(Account acct)
	{
		if(counter<limit)
		{
			accts[counter++]=acct;
		}
	}
	
	public boolean validatePin(int pin) {
		for(Account act : accts)
		{
			if(act.getAccpin()==pin)
			{
				currentAccountHolder=act;
				return true;
			}
		}
		return false;
	}
	
	
	public double withdraw(double amt, int pin)
	{
		if (validatePin(pin))				//changes				
		{
			if(amt <= withdrawlLimit)
			{
				if(amt < currentAccountHolder.getAccbalance()- Account.minbalance)
				{
				totalAmount -= amt;
				currentAccountHolder.setAccbalance(currentAccountHolder.getAccbalance()-amt);
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
			currentAccountHolder.setAccbalance(currentAccountHolder.getAccbalance()+amt);
		}
		else
		{
			System.out.println("Wrong PIN");
		}
		return amt;
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	//	MultiAcc multiacc = new MultiAcc(500);
	//	Account a1 = new Account

	}




	}


