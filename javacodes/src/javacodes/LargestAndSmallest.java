package javacodes;

public class LargestAndSmallest {
//the largest and smallest element in an array.
	
	
	public static void main(String args[]) {	
		
	int [] arr= {10, 2, 33, 8, 17};
	int max=arr[0];
	//We take the first element as both max and min,ie:10
	int min=arr[0];
	
		for(int n:arr) {
			if(n>max) max=n;
			if(n<min)min=n;
		}
			
		
	System.out.println("Max: " + max + ", Min: " + min);	
		
		
		
		
}}
