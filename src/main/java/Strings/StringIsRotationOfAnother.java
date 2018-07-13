package Strings;

public class StringIsRotationOfAnother {

	public static void main(String[] args) {
		String s1 = "AACD";

		String s2 = "ACDA";

		if (s1.length() != s2.length()) {
			System.out.println("string2 is not rotated version of string1");
		} else {

			String s3 = s1 +s1;
			System.out.println("pioraaa -->>  "+s3);

			if (s3.contains(s2)) {
				System.out.println("string2 is a rotated version of string1");
			} else {
				System.out.println("string2 is not rotated version of string1");
			}
		}
	}
}
