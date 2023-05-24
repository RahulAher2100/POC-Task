package Demo;

public class MainClass {
	

		public static void voterAge(int age) throws AgeNotFoundException
		{
			
			if(age<18) {
				
				throw new AgeNotFoundException("Voter is Below Age line");
			}
			else
			{
				System.out.println("Welcome Voter");
			}
		}
	

public static void main(String[] args) {
	
	try {
		
		voterAge(12);
	}
	
	catch(AgeNotFoundException ex) {
		
		System.out.println("Custom Exception :" +ex.getMessage());
	}
	

}
}
