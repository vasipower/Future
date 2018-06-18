package Arrays;

public class FindDuplicateElements {

	
	public static void main(String[] args) {
		
		String [] str={"vasi","pk","pspk","vasista","vasi","pspk","ind","pk"};
		
		for (int i = 0; i < str.length; i++) {
			
			for (int j = i+1; j < str.length; j++) {
				
				if (str[i].equals(str[j])){
					
					System.out.println(str[i]);
				}
			}
			
		}
	}
}
