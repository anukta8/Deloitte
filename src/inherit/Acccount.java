package inherit;

public abstract class Acccount implements Printer{
	protected String name;
	protected double balance;
	protected int number;
	
	

	public Acccount(String name, double balance, int number) {
		super();
		this.name = name;
		this.balance = balance;
		this.number = number;
	}
	
	public void print(String s)
	{
		System.out.println("printing acc info...."+s);
	}

	//withdraw
	public abstract void withdraw(double amount); 	//no implementaion--- ABSTRACT METHOD
	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}

	
	

	@Override
	public String toString() {
		return "Acccount [name=" + name + ", balance=" + balance + ", number=" + number + "]";
	}


	

}
