package Demo;

import java.util.Scanner;

public class ArmStrongNumber {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Number");
		int n=sc.nextInt();
		
		int sum=0;
		int rem=0;
		int num=n;
		
		while(n>0) {
			
			rem=n%10;
			sum=sum+(rem*rem*rem);
			n=n/10;
		}
		if(sum==num) {
			System.out.println("ArmStrong Number");
		}
		else {
			System.out.println("Not Armstrong Number");
		}
	}

}
