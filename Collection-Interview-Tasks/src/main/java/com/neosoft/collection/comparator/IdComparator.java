package com.neosoft.collection.comparator;

import java.util.Comparator;

public class IdComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee e1, Employee e2) {
		
	if(e1.getId()==e2.getId())
	{
		return 0;
		
	}
	else if(e1.getId()>e2.getId())
	{
		return 1;
	}
	else {
		return -1;
	}
	
	}

	

}
