package Demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EvenOddUsingStream {
	
	
	public static void main(String[] args) {
		
		Integer a[]= {22,86,98,56,21,91,67};
		
		Stream<Integer>stream=Arrays.stream(a);
		
		
		System.out.println("Even Number are : ");
		stream.filter(e->e%2==0).forEach(System.out::println);
		
		
		
//		System.out.println("Odd Nuumber are :");
//		stream.filter(o-> o%2!=0).forEach(System.out::println);
//		
				
	}

}
