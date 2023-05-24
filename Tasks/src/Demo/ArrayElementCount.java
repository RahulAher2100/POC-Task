package Demo;

import java.util.HashMap;
import java.util.Map;

public class ArrayElementCount {
	
	public static void main(String[] args) {
		
		int a[]= {12,34,54,76,9,3,76,34,8,32,8,2,3,4,5,67};
		
		
		Map<Integer,Integer>map=new HashMap<>();
		
		for(int i:a) {
			if(map.containsKey(i)) {
				
				map.put(i, map.get(i)+1);
			}
			else {
				map.put(i,1);
			}
		}
		System.out.println(map);
	}

}
