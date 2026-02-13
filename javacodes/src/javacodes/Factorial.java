package javacodes;

public class Factorial {
	//Print factorial using loop.
	
	public static void main(String args[]) {
		
		int num=5;
		int fact =1;//Initialized to 1 because multiplying by 0 will always give 0
		
		for(int i=1; i<=num;i++) {//i++ =i+1
			fact=fact*i;
		}
		
		System.out.println("Factorial: " + fact);
	}
	
	
	
	
}
