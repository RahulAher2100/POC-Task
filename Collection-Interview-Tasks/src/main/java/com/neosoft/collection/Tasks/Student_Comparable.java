package com.neosoft.collection.Tasks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student_Comparable implements Comparable<Student_Comparable> {

	private int id;
	private String name;
	private String address;
	
	@Override
	public int compareTo(Student_Comparable s) {
		
		
		if(id==s.id)
		{
			return 0;
			
		}
		else if(id>s.id)
		{
			return 1;
		}
		else {
			return -1;
		}
		
	}
	
	
	public static void main(String[] args) {
		
		
		List<Student_Comparable>list=new ArrayList<>();
		
		Student_Comparable s1=new Student_Comparable(109,"Rahul","Pune");
		Student_Comparable s2=new Student_Comparable(101,"Suraj","Mumbai");
		Student_Comparable s3=new Student_Comparable(188,"Karan","Delhi");
		Student_Comparable s4=new Student_Comparable(106,"Pavan","Surat");
		
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);
		
		Collections.sort(list);
		
		
		for(Student_Comparable st:list)
		{
			System.out.println(st);
		}
		
		
		
	}




	
}
