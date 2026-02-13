package javacodes;

public class CountVowels {
//Count Vowels in String
	
	public static void main(String[] args) {
		
String str="automation";
int count=0;
for(char c:str.toLowerCase().toCharArray()) {
	if("aieou".indexOf(c)!=-1) count++ ;
		
	}
System.out.println("Vowels: " + count);
}
	
}
