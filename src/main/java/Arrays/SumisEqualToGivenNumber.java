package Arrays;




public class SumisEqualToGivenNumber {

	void sum (int[] arr,int sum){
		
		for(int i=0;i<=arr.length;i++){
			
			for (int j = i+1; j < arr.length; j++) {
				
				if(arr[i]+arr[j]==sum){
					
					{
	                    System.out.println(arr[i]+" + "+arr[j]+" = "+sum);
	                }
				}
			}
			
		}
		
	}
	
	
	public static void main(String[] args) {
		
		int arr[]={1,4,2,0,3,5};
		int totoal=5;
		
		SumisEqualToGivenNumber pair= new SumisEqualToGivenNumber();
		pair.sum(arr, totoal);
		
	}
    }
