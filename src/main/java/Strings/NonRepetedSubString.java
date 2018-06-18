package Strings;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class NonRepetedSubString {

	public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Enter String");
	        String word = sc.next(), maxWord = "", newWord = "";
	        int l = word.length(), i, j, max = 0;
	        for (i = 0; i < l; i++) {
	            newWord = word.substring(i);
	            for (j = i + 1; j < l; j++)
	                if (newWord.indexOf(word.charAt(j)) + i != j)
	                    break;
	            if (j - i > max) {
	                max = j - i;
	                maxWord = word.substring(i, j);
	            }
	        }
	        System.out.println(maxWord);
	    }}
	  
	  //it works!
	
	
	
	/*public static int solution(String s) {
		Set set = new LinkedHashSet();
		for (char c : s.toCharArray()) {
		set.add(c);
		}
		return set.size();
		}
	
	
	 public static void main(String[] args) {
		 
		 String str="abcdfeag";
		 solution(str);
	 }
	 }*/