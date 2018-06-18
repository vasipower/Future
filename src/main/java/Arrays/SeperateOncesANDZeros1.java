package Arrays;

public class SeperateOncesANDZeros1 {

 void seperate(int[] arr,int size){
	
	int left=0;
	int right =size-1;
	
	while(left<right){

	while(arr[left]==0&& left<right)
		left ++;
	while(arr[right]==1&& left<right)
		right --;
		
		if(left<right){
			arr[left]=0;
		   arr[right]=1;
		   left ++;
		   right --;
		}
	}
}


public static void main(String[] args) {
	
	int arr[]={1,0,1,1};
	int size=arr.length;
	SeperateOncesANDZeros1 aa=new SeperateOncesANDZeros1();
	aa.seperate(arr, size);
	
	for (int i = 0; i < arr.length; i++) {
		
		System.out.println(arr[i]);
	}
	
}	
	

}
