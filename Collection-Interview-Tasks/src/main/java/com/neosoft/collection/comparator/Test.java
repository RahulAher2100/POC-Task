package com.neosoft.collection.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		
		List<Employee> list=new ArrayList<>();
		
		Employee e=new Employee(145,"Rahul", "Pune");
		Employee e1=new Employee(102,"Tejas", "Nagpur");
		Employee e2=new Employee(111,"Nitin", "Nashik");
		Employee e3=new Employee(188,"Kunal", "Mumbai");
		
		list.add(e);
		list.add(e1);
		list.add(e2);
		list.add(e3);
		
		
		//Collections.sort(list,new IdComparator());
		Collections.sort(list,new NameComparator());
		
		
		
		for(Employee emp:list)
		{
			
			
			System.out.println(emp);
		}
				
	}
}
