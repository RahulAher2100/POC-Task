package Demo;

import java.util.Scanner;

public class ReverseString {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
				System.out.println("Enter name");
		String str=sc.next();
		
//		StringBuilder sb=new StringBuilder(str);
//		
//		System.out.println(sb.reverse());
		
		char ch[]=str.toCharArray();
		
		String rev="";
		
		for(int i=ch.length-1; i>=0; i--) {
			
			rev+=ch[i];
		}
		
		System.out.println(rev);
	}

}
