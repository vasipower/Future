package Strings;

import java.util.Arrays;

public class Anagram {

	
	public static void main(String[] args) {
		
		String str="vasista";
		String str1="istavas";
		
		
		char[]s1=str.toCharArray();
		char[] s2=str1.toCharArray();
		
		System.out.println(s1);
		System.out.println(s2);
		
		Arrays.sort(s1);
		Arrays.sort(s2);
		
		System.out.println(s1);
		System.out.println(s2);
		
		
      System.out.println(Arrays.equals(s1, s2));
		
      
      
		
	}
}
