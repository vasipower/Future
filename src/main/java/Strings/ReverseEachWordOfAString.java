package Strings;

public class ReverseEachWordOfAString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String ss = "vasista will learn mobile testing";

		String[] str = ss.split(" ");
		String sentence = "";

		for (int i = 0; i < str.length; i++) {

			String w1 = str[i];

			String word = "";

			for (int j = w1.length() - 1; j >= 0; j--) {

				word = word + w1.charAt(j);

			}

			sentence = sentence + word + " ";

		}
		System.out.print(sentence);
		
		
	}

}

// Input :- vasista will learn mobile testing
// OutPut:- atsisav lliw nrael elibom gnitset