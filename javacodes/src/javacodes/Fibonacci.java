package javacodes;

public class Fibonacci {
	//Print first N Fibonacci numbers.(Each number is the sum of the previous two numbers.eg:0,1,1,2,3,5,8,13,21,...)
	
	public static void main(String args[]) {	
	
	
	int N =8;
	int a=0, b=1;
	System.out.print(a + " " + b + " ");
	
	for(int i=2; i<N;i++) {
		 
		int c= a+b;
		System.out.print(c + " ");
		
		a=b;
		b=c;
		
		
		
	}
	
	
	
	
}}
