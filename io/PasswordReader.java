package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PasswordReader {

	private static String fileName = "D://data.txt";
	
	public static void main(String[] args) {
		
		File file = new File(fileName);
		boolean fileExists = file.exists();
		
		if(fileExists)
		{
			System.out.println(file.getPath());
			FileReader reader = null;
			BufferedReader buffer = null;
			
			//read
			try 
			{
				reader = new FileReader(file);
			} catch (FileNotFoundException e) 
			{
				System.out.println("file doesnot exists");
				e.printStackTrace();
			}
			
			buffer = new BufferedReader(reader);
			 String line = "";
			 try {
					 line=buffer.readLine();
					 while(line != null)
					 {
						 String[] user = line.split(line, ':');
					
						 line = buffer.readLine();
						 
						 for(String s: user)
							{
								System.out.println(s);
							}
						 
						 
					 }
			 }catch(IOException e)
			 {
				System.out.println("error reading file: "+e.getMessage()); 
				
				
				System.out.println("");
			 }
			 
			 finally {
				// if(buffer != null)
			 }
		}

	}

}
