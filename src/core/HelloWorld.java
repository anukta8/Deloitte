package core;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String hello = "Helllooo, Java World";
		System.out.println(hello);
		int len = hello.length();
		System.out.println("No. of charecter in the text = "+len);
		
		System.out.println("is this true? "+ (len == 20));
		
		
		if(len == 18) {
			System.out.println("Correct");
		}
		else
			System.out.println("Wrong! Try again.");
		
		System.out.println((len == 10)?"correct":"incorrect");
		
		int m= 34, n= 45;
		System.out.println(m+n);
		
		if(m<n)
			System.out.println(n-m);
		else
			System.out.println(m-n);
		
		for(int i=0;i<len;i++)
		{
			System.out.print(i + " ");
		}
		
		
		int num =(int) 22.5;
		System.out.println();
		
		char ch = 'A';
		for(int i=(int) ch; i<=(int)(ch+26);i++)
		{
			
			System.out.println(i);
		}
		
		char c = 'a';
		for(int i=(int) c;i<=(int)(c+26); i++) {
			
			System.out.println(i);
		}
		
	rangeSum(1,10);
	calculate(4,0,"/");
		
	}
		
	
	public static void rangeSum(int x, int y) {
		if(x>y)
			{
			swap(y,x);
			}
		else {
			
		
			int sum=0;
			System.out.println("Enter value of x nad y: ");
			for(int i=x;i<=y;i++)
			{
				sum=sum+i;
			}
			System.out.println("sum of "+x+"and "+y+"is "+sum);
			
			
	}
	
	}
	private static void swap(int a,int b)
	{
		int sum=0;
		System.out.println("Enter value of x nad y: ");
		for(int i=a;i<=b;i++)
		{
			sum=sum+i;
		}
		System.out.println("sum of "+a+"and "+b+"is "+sum);
	}
	
	public static int add(int k, int m)
	{
		return k+m;
	}
	
	public static void calculate(double a, double b, String op)
	{
		double res=0.0;
		
		switch(op)
		{
		case "+": res=a+b; 
		break;
		
		case "-": res=a-b;
		break;
		
		case "*": res=a*b;
		break;
		
		case "/":
			{
				if(b==0)
					System.out.println("invalid");
				else
					res=a/b;
			}
		break;
		
		default:
			System.out.println("invalid");
		
		}
		
		System.out.println(res);
		
	}
	
	
}
