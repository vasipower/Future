package Arrays;

public class Fizbuz1 {

	
	public static void main(String[] args) {
		
		
		int ar[] ={10,99,55};
		
		for (int i = 0; i < ar.length; i++) {
			
			if (ar[i]%2==0) {
				System.out.println("fizz");
				
			}
			
			else if (ar[i]%5==0) {
				System.out.println("Buzz");
				
			}
			else{
				System.out.println(ar[i]);
			}
			
		}
	}
}
