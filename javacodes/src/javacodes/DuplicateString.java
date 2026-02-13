package javacodes;

import java.util.HashMap;

public class DuplicateString {
	//Print duplicate characters in a string.
	
	public static void main(String args[]) {	
		
String str="annotation"		;

HashMap<Character,Integer>map=new HashMap<>();
str.toCharArray();//converts annotation into each letter {"a","n","n","o"........}

for (char ch:str.toCharArray())		{
map.put(ch, map.getOrDefault(ch, 0)+1)	;
}
	for(char ch:map.keySet())	{
		if (map.get(ch)>1) {
			System.out.println(ch + "=" + map.get(ch));
		}
	}
	}
}
