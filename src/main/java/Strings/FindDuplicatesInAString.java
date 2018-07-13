package Strings;

public class FindDuplicatesInAString {

	
	public static void main(String[] args) {
		
		String str="abcda";
		
		char[] c=str.toCharArray();
		
		for(int i=0;i<c.length;i++){
			int count =0;
			for  (int j = i+1; j < c.length; j++) {
				if(c[i]==c[j]){
					
					System.out.print(c[i] );
//					/count++;
				}
				//System.out.print(c[i]);
			}
		
		
	}
	}}
