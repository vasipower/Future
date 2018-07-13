package Strings;

public class SwapTwoStringVariablesWithoutUsingThirdVariable {

	
	public static void main(String[] args) {
		
		String s1="Power";
		String s2="star";
		
		//System.out.println("comapring refrences "+s1==s2);
		
		s1=s1+s2;
		
		s2=s1.substring(0, s1.length()-s2.length());
		s1=s1.substring(s2.length());
		
		System.out.println(s1);
		System.out.println(s2);
		
		
	}
}


//
/*Let s1 = “JAVA” and s2 = “J2EE”

//Swapping starts

s1 = s1 + s2

–>   s1 = “power” + “star”

–>   s1 = “powerstar”

s2 = s1.substring(0, s1.length()-s2.length())

–>   s2 = s1.substring(0, 8-4)

–>   s2 = s1.substring(0, 4)        //This copies first 4 chars of s1 to s2

–>   s2 = “power”

s1 = s1.substring(s2.length())

–>   s1 = s1.substring(4)           //This copies chars starting from index 4 to end of s1 to s1 itself

–>   s1 = “star”*/