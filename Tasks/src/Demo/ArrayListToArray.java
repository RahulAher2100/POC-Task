package Demo;

import java.util.ArrayList;
import java.util.List;

public class ArrayListToArray {
	
	public static void main(String[] args) {
		
		List<Integer>list=new ArrayList<>();
		list.add(12);
		list.add(22);
		list.add(32);
		list.add(42);
		list.add(52);
		
		
		Integer a[]=new Integer[list.size()];
		
		list.toArray(a);
		
		for(int b:a) {
			System.out.println(b);
		}
			
		
		
		
	}

}
