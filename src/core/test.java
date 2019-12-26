package core;

import java.util.Scanner;

public class test {

	private static int target = ((int)( Math.random() * 100))+1; 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	Scanner sc = new Scanner(System.in);
		System.out.println(target);
		play();
		
		
	}

	private static int getInput() {
		Scanner sc=new Scanner(System.in);
		
		return sc.nextInt();
	}
	
	private static void play()
	{
		int chance=1;
		for(chance=1;chance<=5;chance++)
		{
			int input = getInput();
		
			if(input == target)
			{
				System.out.println("Correct");
				System.exit(0);
			}
			else
				System.out.println("Try again");
		}
	}

}
