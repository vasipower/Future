package Strings;

public class Stringpermutations {

	public static void main(String[] args) {
		

	    permutations(0,"1234");
	}

	public static  void permutations(int start,String s) {
	    char[] chr=s.toCharArray();
	    if(start==s.length())
	        System.out.println(s);
	    for(int i=start;i<s.length();i++) {
	        char c=chr[i];
	        chr[i]=chr[start];
	        chr[start]=c;
	      permutations(start+1,new String(chr));
	    }   
	}}

