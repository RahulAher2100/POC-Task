package Demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class A {
	
	
	public static void main(String[] args) {
		
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter String");
		String str=sc.next();
		
		
		String regex="^[a-zA-Z0-9]+$";
		
		boolean result=str.matches(regex);
		
		if(result) {
			
			System.out.println("Given String is AlphaNumeric");
		}
		else {
			
			System.out.println("Given String is not AlphaNumeric");
		}
		
		
		
		
	}

}
