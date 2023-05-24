package Demo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CommonElement {

	
	public static void main(String[] args) {
		
		Integer a[]= {12,67,98,65,9,5,4};
		
		Integer b[]= {89,2,9,5,4};
		
//		Set<Integer>set1=new HashSet<>(Arrays.asList(a));
//		Set<Integer>set2=new HashSet<>(Arrays.asList(b));
//		
//		set1.retainAll(set2);
//		
//		System.out.println(set1);
		
		
		
		//OR
		
		Set<Integer>set=new HashSet<>();
		
		for(int i=0; i<a.length; i++) {
			
			for(int j=0; j<b.length; j++) {
				
				if(a[i].equals(b[j])) {
					
					set.add(a[i]);
				}
			}
		}
		
		System.out.println(set);
	}
}
