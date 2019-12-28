package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MyFileReader {

	private static String fileName = "D://data.txt";
	
	public static void main(String[] args) {
		File file = new File(fileName);
		boolean fileExists = file.exists();
		System.out.println("file available? "+file.exists());
		
		if(fileExists) {
		System.out.println(file.getPath());
		FileReader reader = null;
		BufferedReader buffer = null;
		
		
		//read file comtent
		try {
			 reader = new FileReader(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("file does not exist");
			e.printStackTrace();
		}
		
		
		 buffer = new BufferedReader(reader);
		 String line = "";
		 try {
				 line=buffer.readLine();
				 while(line != null)
				 {
					 System.out.println(line);
					 line = buffer.readLine();
				 }
		 }catch(IOException e)
		 {
			System.out.println("error reading file: "+e.getMessage()); 
		
		 }
		}

	}

}
