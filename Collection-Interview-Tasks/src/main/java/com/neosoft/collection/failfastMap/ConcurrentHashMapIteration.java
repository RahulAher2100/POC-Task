package com.neosoft.collection.failfastMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapIteration {
	
	
	public static void main(String[] args) {
		
		// Map<Integer, String>map=new HashMap<>();// will throw ConcurrentModificationException while Iterating
		
		Map<Integer, String>map=new ConcurrentHashMap<>(); // will not throw ConCurrentModificationException while Iterating
		
		map.put(1, "rahul");
		map.put(2, "rohit");
		
		
		Set<Integer> key=map.keySet();
		
		Iterator<Integer>itr=key.iterator();
		while(itr.hasNext())
		{
			Integer n=itr.next();
			
			System.out.println(n +" : "+map.get(n));
			
			map.put(3, "kiran");
			
		}
		
	}

}
