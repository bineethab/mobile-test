package javacodes;

public class PrimeNumber {

	//Write Java to check if a number is prime.
	
	public static void main(String args[]) {
		int num=7;
		boolean flag=true;
		for(int i=2; i<=num/2;i++) {
			if(num%i==0) {
				flag = false; 
				break;
				
			}}
		 System.out.println(flag ? num + " is prime" : num + " is not prime");
		}}

