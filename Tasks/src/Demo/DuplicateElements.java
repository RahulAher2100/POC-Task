package Demo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class DuplicateElements {
	
	public static void main(String[] args) {
		
		int a[]= {45,9,7,67,24,45,67};
		
		Set<Integer>set=new HashSet<>();
		
		Set<Integer>duplicate=Arrays.stream(a).filter(dup->!set.add(dup)).boxed().collect(Collectors.toSet());
		
		System.out.println(duplicate);
	}

}
