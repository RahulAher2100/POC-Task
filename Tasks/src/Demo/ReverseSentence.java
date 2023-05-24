package Demo;

import java.util.Scanner;

public class ReverseSentence {
	
	public static void main(String[] args) {
		

     String str="NeoSOFT is IT Company";
     
     String rev[]=str.split("\\s");
     
     String revSentence="";
     
     for(int i=rev.length-1; i>=0; i--) {
    	 
    	 revSentence=revSentence+rev[i]+" ";
     }
	
     System.out.println(revSentence);
     
}
}
