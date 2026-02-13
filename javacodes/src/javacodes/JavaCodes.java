package javacodes;

public class JavaCodes {
// reverse a string without using built-in reverse methods.
public static void main(String args[]) {	
	
	String input="QuestGlobal";
	String reversed="";
	for(int i=input.length() -1; i >=0; i --) {
		reversed +=input.charAt(i);
		
	}
	System.out.println("Reversed: " + reversed);
	
}}


