package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileCopier {

	private static String sourceFile="";
	private static String destinationFile="";

	public static void main(String[] args) {
		
		FileReader fr = null;
		FileWriter fw = null;
		
		try {
			fr = new FileReader(sourceFile);
		}catch(FileNotFoundException e)
		{
			System.out.println("file does not exist");
			e.printStackTrace();
		}
		
		try {
			fw = new FileWriter(destinationFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String line = "";
		/*  try {
				 line=fw.write(line);
				 
				 
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
		*/
		
		PrintWriter out = null;
		out.write(line);
		out.flush();
		
	}

}
