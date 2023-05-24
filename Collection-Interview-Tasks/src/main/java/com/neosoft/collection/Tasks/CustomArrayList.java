package com.neosoft.collection.Tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CustomArrayList extends ArrayList{
	
	
	
	//Create Custom ArrayList not to allow duplicates....
	
	
	@Override
	public boolean add(Object e) {
		// TODO Auto-generated method stub
		
		if(this.contains(e))
		{
			return true;
		}
		else
		{
			return super.add(e);
		}
		
	}
	

	public static void main(String[] args) {
		
	
	
	 CustomArrayList list=new CustomArrayList();
	
	list.add("Rahul");
	list.add("Suraj");
	list.add("Deepak");
	list.add("Karan");
	list.add("Rahul");
	
	System.out.println(list);
	
	
	}
}
