package Demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayToArrayList {
	
	public static void main(String[] args) {
		
		int a[]= {34,87,65,76};
		
		List<Integer>list=Arrays.stream(a).boxed().collect(Collectors.toList());
		
		list.forEach(System.out::println);
	}

}
