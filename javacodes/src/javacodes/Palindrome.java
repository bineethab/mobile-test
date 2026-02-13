package javacodes;

public class Palindrome {
	
	//Check whether a string is palindrome.(when reversed remains unchanged)

	public static void main(String args[]) {
		
		String input="madam";
		String reversed="";
		for(int i =input.length() -1;i>=0; i--) {
			reversed+= input.charAt(i);
		}
		if(input.equals(reversed)) {
			System.out.println(input +"is palindrome");
		}else {
		
			System.out.println(input +"is not a palindrome");
		
}}}
