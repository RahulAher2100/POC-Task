package com.neosoft.collection.failfastIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailFast {
	
	
	public static void main(String[] args) {
		
		
		List<String>list=new ArrayList<>();  //will throw ConcurrentModificationException (FailFast Iterator)
		
		//List<String>list=new CopyOnWriteArrayList<>();  // will not throw ConcurrentModificationException (FailSafe Iterator)
		
		list.add("Rahul");
		list.add("Kiran");
		list.add("Suraj");
		
		
		Iterator<String>itr=list.iterator();
		while(itr.hasNext())
		{
			String name=itr.next();
			
			System.out.println(name);
			
			list.add("Pratik"); // it will throw ConcurrentModificationException....(while iterating over collection Object)
			
		}
		
		
	}

}
