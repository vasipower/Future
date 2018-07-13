package Strings;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class OccurenceOfWordFromFile {

	public static void main(String[] args) throws IOException {

		BufferedReader br = null;
		FileReader fr = null;

		String FILENAME = "C:\\Users\\vastvn\\Desktop\\Maven\\one.txt";

		fr = new FileReader(FILENAME);
		br = new BufferedReader(fr);
		String st;
		while ((st = br.readLine()) != null) {
			String arr1 = st.toLowerCase();
			String[] a = arr1.split(" ");

			System.out.println("pppppppp   " + st);
			
			Map<String, Integer> words = new HashMap<String, Integer>();
			for (String str : a) {
				if (words.containsKey(str)) {
					words.put(str, 1 + words.get(str));
				} else {
					words.put(str, 1);
				}
			}
			System.out.println(words);
		}
	}
}