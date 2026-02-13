package javacodes;

public class Sum {
	//the sum of digits in an integer?
	
	public static void main(String args[]) {
		int num=12701, sum=0;
		while(num>0) {
			sum+=num%10;//%10 → get last digit


			num=num/10;// /10 → remove last digit
		}
		
		System.out.println("Sum of digits: " + sum);
		
		
		
		
		
	}
}
