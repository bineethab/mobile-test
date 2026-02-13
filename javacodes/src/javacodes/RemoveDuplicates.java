package javacodes;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicates {
	public static void main(String[] args) {
	int[] arr = {1, 2, 2, 4, 1}; 
	Set<Integer> set = new LinkedHashSet<>(); 
	for (int n : arr) set.add(n); 
	System.out.println(set);
}}
