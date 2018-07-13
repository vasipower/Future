package Strings;

import java.util.Scanner;

public class countOfWordsInASentence {

	public static void main(String[] args) {
		
		
		//String str="vasitsa is great humen being";
		
		 System.out.println("Enter the string");
		 
	        Scanner sc = new Scanner(System.in);
	 
	        String str=sc.nextLine();
		
		String[] words= str.split(" ");
		
		System.out.println(words.length);
		
	}
}


			/*String str="vasitsa is great humen being";
			
			String[] words= str.split(" ");
			
			System.out.println(words.length);*/



