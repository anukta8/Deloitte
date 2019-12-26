package objects;

public class Account {
	String accholder;
	int accpin;
	double accbalance;
	public static final double minbalance=1000;


	public Account(String accholder, int accpin, double accbalance) {
		super();
		this.accholder = accholder;
		this.accpin = accpin;
		this.accbalance = accbalance;
		
	}

	public String getAccholder() {
		return accholder;
	}

	public void setAccholder(String accholder) {
		this.accholder = accholder;
	}

	public int getAccpin() {
		return accpin;
	}

	public void setAccpin(int accpin) {
		this.accpin = accpin;
	}

	public double getAccbalance() {
		return accbalance;
	}

	public void setAccbalance(double accbalance) {
		this.accbalance = accbalance;
	}


	@Override
	public String toString() {
		return "Account [accholder=" + accholder + ", accpin=" + accpin + ", accbalance=" + accbalance + "]";
	}

	public static void main(String[] args)
	{
	
		Account acc = new Account("man",3232,14000);
		System.out.println(acc);
		
		
	}

}
