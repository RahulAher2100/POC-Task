package demo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class MainClass {

	public static void main(String[] args) throws IOException {
		
		Employee emp=new Employee(1, "Rahul");
		
		FileOutputStream fileOutputStream=new FileOutputStream("C:\\Users\\Neosoft\\Desktop\\Interview Workspace\\SerilizationExample\\employee.ser");
	
		 ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
		
		objectOutputStream.writeObject(emp);
		
		objectOutputStream.close();
		
		fileOutputStream.close();

	}

}
