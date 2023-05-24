package Demo;

import java.util.Scanner;

public class IsAlphaNumeric {

	
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
			
			System.out.println("Given String is Not AlphaNumeric");
		}
		
		
	}
}
