package Strings;

public class StringImmutable {

	public static void main(String[] args) {
		
		String str1="pawan";
		String str2="pawan";
		
		str2=str2+"pk";
		
		System.out.println(str1==str2);
	}
}
