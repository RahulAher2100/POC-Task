package com.neosoft.stream.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

public class Stream_Filter {
	
	public static void main(String[] args) {
		
		List<Student>list=new ArrayList<>();
		
		list.add(new Student(11,"Rahul",96.05));
		list.add(new Student(42,"Sagar",76.05));
		list.add(new Student(73,"Dinesh",56.05));
		list.add(new Student(18,"Kunal",36.05));
		list.add(new Student(85,"Shekhar",66.05));
		list.add(new Student(76,"Harshal",46.05));
		list.add(new Student(11,"Rahul",86.05));
		
		System.out.println("--------------Name Start with S--------------");
		list.stream().filter(s->s.getName().startsWith("S")).collect(Collectors.toList()).forEach(System.out::println);
		
		System.out.println("----------------");
		
		System.out.println("---------------Students with marks > 50-----------------");
		list.stream().filter(s->s.getMarks()>50).collect(Collectors.toList()).forEach(System.out::println);
		
		System.out.println("-----------------");
		
	   
		System.out.println("------------Students with name Rahul,Sagar,Harshal---------------");
		
		list.stream().filter(s->s.getName().equals("Rahul")||s.getName().equals("Sagar")||s.getName().equals("Harshal")).collect(Collectors.toList()).forEach(System.out::println);

 
		System.out.println("----------------------------");
		
		System.out.println("Ignore Name which contains Character h");
		
		list.stream().filter(s->!s.getName().toLowerCase().contains("h")).collect(Collectors.toList()).forEach(System.out::println);
		
		System.out.println("----------------");
		
		System.out.println("Replace s with *");
		
		list.stream().map((x)->{x.setName(x.getName().toLowerCase().replace('s','*'));return x;}).collect(Collectors.toList()).forEach(System.out::println);
	}

}





class Student
{
	private int id;
	private String name;
	private double marks;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
	public Student(int id, String name, double marks) {
		super();
		this.id = id;
		this.name = name;
		this.marks = marks;
	}
	
	
	
}