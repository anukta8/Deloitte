package io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import collection.Student;
public class ObjectCopier {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Student s = new Student("Akash", 123);
		try {
			FileOutputStream fout = new FileOutputStream("std.err");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(s);
			oos.flush();
			oos.close();
			System.out.println("object serialized");
		}catch(IOException ioe)
		{
			System.out.println("Object failed to serialize.."+ioe.getMessage());
		}
	}

}
