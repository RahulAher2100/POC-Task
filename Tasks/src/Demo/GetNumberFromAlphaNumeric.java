package Demo;

import java.util.Scanner;

public class GetNumberFromAlphaNumeric {

	
	public static void main(String[] args) {
		 
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter String");
		String str=sc.next();
		
		for(int i=0; i<str.length(); i++) {
			
			if(Character.isDigit(str.charAt(i))) {
				
				System.out.print(str.charAt(i));
				
				if(i<str.length()-1 && Character.isDigit(str.charAt(i+1))) {
					
					System.out.print("");
				}
			}
		}
		
		
	}
}
