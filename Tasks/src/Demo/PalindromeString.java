package Demo;

import java.util.Scanner;

public class PalindromeString {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter String");
		String str=sc.next();
		
		String rev="";
		
		for(int i=str.length()-1; i>=0; i--) {
			
			rev=rev+str.charAt(i);
		}
		if(str.equals(rev)) {
			System.out.println("Palindrome String");
		}
		else {
			System.out.println("Not palindrome String");
		}
		
	}

}
