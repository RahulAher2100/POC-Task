package Demo;

import java.util.Scanner;

public class PalindromNumber {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Number");
		int n=sc.nextInt();
		
		int rem=0;
		int rev=0;
		int num=n;
		
		while(n>0) {
			
			rem=n%10;
			rev=rev*10+(rem);
			n=n/10;
		}
		if(rev==num) {
			System.out.println("Palindrome Number");
		}
		else {
			System.out.println("Not Palindrome Number");
		}
			
			
	}
	

}
