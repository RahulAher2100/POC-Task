package demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MainClass {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		Employee emp=new Employee(1, "Rahul");
		
		//Serialization
		
		FileOutputStream fileOutputStream=new FileOutputStream("C:\\Users\\Neosoft\\Desktop\\Interview Workspace\\DeserializationExample\\employee.ser");
		
		ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
		
		objectOutputStream.writeObject(emp);
		
		objectOutputStream.close();
		
		fileOutputStream.close();
		
		//Deserialization
		
		FileInputStream fileInputStream=new FileInputStream("C:\\Users\\Neosoft\\Desktop\\Interview Workspace\\DeserializationExample\\employee.ser");
		
		ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
		
		Employee employee=(Employee) objectInputStream.readObject();
		
		System.out.println("Employee Name is : "+ employee.getName());
		
		objectInputStream.close();
		fileInputStream.close();
	}

}
