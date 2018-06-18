package Arrays;

import java.util.Arrays;

public class SeperateOncesANDZeros {
//static int count =0;

public static void main(String[] args) {
	int count =0;
	int arr[]={1,0,1,0,0,0,1,0};
	
	for (int i = 0; i < arr.length; i++) {
		
		if (arr[i]==0){
			count++;
		}
	}
	int onecount=arr.length-count;
	
	for (int j = 0; j <count; j++) {
		System.out.print(0+" ");
	}
	for (int k = 0; k < onecount; k++) {
		System.out.print(1+" ");
	}
}


// One more way to sort

/*int[] A = {0,1,1,0,1,0,1,1,0};
Arrays.sort(A);
System.out.println(Arrays.toString(A));
*/


}
