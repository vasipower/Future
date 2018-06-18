package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class RemoveDuplicates11 {
	public static void main(String[] args) {

		int[] arr = { 1, 2, 2, 3, 4, 5, 6, 3, 2, 1 };

		System.out.println(Arrays.toString(arr));
		for (int i = 0; i < arr.length; i++) {

			for (int j = i + 1; j < arr.length; j++) {

				if (arr[i] == arr[j]) {

					arr[i] = 0;
				}
			}
			System.out.print(+arr[i] + "");
			
			/*while (arr[i]==0) {
				
			
			}*/
			
/*
			List li = new ArrayList(Arrays.asList(arr));
			System.out.println(li);

			for (int k = 0; k < li.size(); k++) {

				if (arr[k] == arr[k + 1]) {

					li.remove(arr[k]);
				}
				Iterator it = li.iterator();

				while (it.hasNext()) {

					System.out.println(it.next());
				}
			}*/
		}

		/*
		 * int count =0; for (int k = 0; k < arr.length; k++) {
		 * 
		 * 
		 * }
		 */
	}
}

//Another way

/*Integer[] numbers = { 7, 7, 8, 9, 10, 8, 8, 9, 6, 5, 4 };
System.out.println(" Input String " + Arrays.toString(numbers));

Set<Integer> set = new HashSet<Integer>(Arrays.asList(numbers));

System.out.println(set);*/