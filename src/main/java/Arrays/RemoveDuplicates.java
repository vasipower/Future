package Arrays;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

       //Need to learn

public class RemoveDuplicates {

	public static void main(String[] args) {

		
		int[] myList = { 1, 2, 2, 3, 4, 4, 5, 6, 7, 7, 8, 9, 10, 10 };
		myList = removeDuplicates(myList);
		System.out.println(Arrays.toString(myList));
	}

	static int[] removeDuplicates(int[] list) {
		for (int i = 0; i < list.length; i++) {
			for (int j = i + 1; j < list.length; j++) {
				if (list[i] == list[j]) {
					list[i] = 0;
				}
			}
		}
		int count = 0;
		for (int i = 0; i < list.length; i++) {
			if (list[i] != 0) {
				count++;
			}
		}
		int[] newList = new int[count];
		int index = 0;
		for (int i = 0; i < list.length; i++) {
			if (list[i] != 0) {
				newList[index++] = list[i];
			}
		}
		return newList;
	}
}