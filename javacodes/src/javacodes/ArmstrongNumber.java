package javacodes;

public class ArmstrongNumber {
	
	
	//Check Armstrong Number

	public static void main(String args[]) {	
		
		int num=153,temp=num,sum=0;
		while(temp !=0) {
			int digit=temp % 10;
			sum+=digit*digit*digit;
			temp /=10;
		}
		System.out.println(sum == num ? "Armstrong" : "Not Armstrong");
}}
//Iteration	temp (before)	temp % 10 (digit)	digit³	sum (after)	temp / 10 (new temp)
//1	153	3	27	27	15
//2	15	5	125	152	1
//3	1	1	1	153	0
//4	0	—	—	stop	loop ends