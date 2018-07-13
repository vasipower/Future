package Strings;

import java.util.HashSet;
import java.util.Set;

public class Sample {

	public static void main(String[] args) {

		String str = "pawan";
		char[] c = str.toCharArray();

		for (int i = c.length - 1; i >= 0; i--) {

			System.out.print(c[i]);

		}
	}
}