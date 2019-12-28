package io;

import java.io.RandomAccessFile;

public class RandomAccess {

	private static String fileName = "D://password.txt";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
			RandomAccessFile raf = new RandomAccessFile("D://password.txt","rw");
			raf.seek(0);		
		}catch{
			
		}
		


	}

}
