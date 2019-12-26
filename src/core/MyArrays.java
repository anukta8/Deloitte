package core;

import java.util.Arrays;

public class MyArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//declaration, memory allocation, initialization
		
		int[] nums = {12,21,23,43,44,54 };
		
		for(int i=0;i<nums.length;i++)
		{
			System.out.println(nums[i]*nums[i]);
		}
		
		String[] names= new String[3];
		names[1]="anand";
		names[2]="abcd";
		names[0]="pqe";
		//names
		
		int[] num= new int[3];
		num[0]=1;
		num[1]=2;
		num[2]=3;
		//System.out.println(names[0]);
		stringLength(args);
		//arrayMod(num);
		Arrays.sort(num);
		
		
		
		
	}

	public static void stringLength(String[] s)
	{
		for(int i=0;i<s.length;i++)
		{
			System.out.println(s[i].length());
			
		}

	}
	
	public static void arrayMod(int[] num)
	{
		num[0]=12;
		num[1]=12;
		num[2]=12;
		
		for(int i=0; i<3;i++)
		{
			System.out.println(num[i]);
		}
		
	}
	
	
	
	
}
