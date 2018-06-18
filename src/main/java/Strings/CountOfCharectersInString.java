package Strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountOfCharectersInString {

	
	
	    public static void main(String[] args)
	    {
	        String str="abcda";
	        char[]arr=str.toCharArray();
	       
	        Map <Character,String> occurence =new HashMap<Character,String>();
	        for (int i = 0; i < arr.length; i++) {
	        	 int count=0;
				for (int j = 0; j < arr.length; j++) {
					if (arr[i]==arr[j]) {
						count++;
						
					}
					
				}
				occurence.put(arr[i],count+ "");
			}
	        System.out.println(occurence);
	    }
	}