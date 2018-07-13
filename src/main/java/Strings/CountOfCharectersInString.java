package Strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountOfCharectersInString {

	public static void main(String[] args) {
		
		String str = "Java J2EE Java JSP J2EE";
		String SS=str.replaceAll(" ", "");
		System.out.println("poo   "+SS);
		
		//If only string no need above 
		String str1 = "Vasista";
		
		char[] arr = SS.toCharArray();

		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for (char c : arr) {

			if (map.containsKey(c)) {

				map.put(c, 1 + map.get(c));

			} else {

				map.put(c, 1);
			}

		}
		System.out.println(map);

	}
}

// https://blog.ajduke.in/2013/04/28/setting-up-new-java-compiler-and-runtime-in-eclipse-ide/



			/*same logic for bellow programs also
			
			OccurenceOfWordFromFile
			OccurenceOfStringInASentence*/