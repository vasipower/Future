package Arrays;

import java.util.Arrays;

public class SecondLargest {
	
	
	//	public static void main(String args[]){  
		/*int a[]={1,44,55,43,99,77,76};  
	
		 Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		int aaaa= a[a.length-2];
		System.out.println(aaaa);*/
	
	public static void main(String[] args) {
		 
		int arr[] = { 14, 46, 47, -99,86, 92, 52, 48, 36, 66, 85 ,-1};
		int largest = arr[0];
		int secondLargest = arr[0];
		int smallest =arr[0];
	
		
		for (int i = 0; i < arr.length; i++) {
 
			if (arr[i] > largest) {
				secondLargest = largest;
				largest = arr[i];
 
			} else if (arr[i] > secondLargest) {
				secondLargest = arr[i];
 
			}
			
			else if (arr[i] < smallest) {
				smallest = arr[i];
			}
		}
		Arrays.sort(arr);
		System.out.println("\n");
	//	System.out.println(Arrays.toString(arr));
		System.out.println("largest number is:" + largest);
		System.out.println("Second largest number is:" + secondLargest);
		System.out.println("smallest number is:" + smallest);
		
 
	}
}	
			
		

