package Arrays;

import java.util.Arrays;

public class equalsMethod {
	 public static void main(String[] args)


	
	{    
        int[] arrayOne = {2, 5, 1, 7, 4};
         
        int[] arrayTwo = {2, 5, 1, 7, 5};
         
        boolean equalOrNot = true;
         
        if(arrayOne.length == arrayTwo.length)
        {
            for (int i = 0; i < arrayOne.length; i++)
            {
                if(arrayOne[i] != arrayTwo[i])
                {
                    equalOrNot = false;
                }
            }
        }
        else
        {
            equalOrNot = false;
        }
         
        if (equalOrNot)
        {
            System.out.println("Two Arrays Are Equal");
        }
        else
        {
            System.out.println("Two Arrays Are Not equal");
        }
    }
}
	    
	 
	 /* public static void main(String[] args)
	    {    
	        int[] a1 = {21, 57, 11, 37, 24};
	          
	        int[] a2 = {21, 57, 11, 37, 24};
	          
	  Boolean compare=Arrays.equals(a1, a2);
	          System.out.println(compare);
	          
	          
	          
	     
	    }
	}*/