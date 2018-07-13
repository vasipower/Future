package main_Method;

public class MainMethod1 {
	
	  public static  void main(String[] args) {
		System.out.println("Execution starts from this method");
		
	//	return 0  ;
	}

	void main(int args) {
		System.out.println("Another main method");
	}

	double main(int i, double d) {
		System.out.println("Another main method");

		return i;
	}
	
	void main(long  aqq) {
		
		System.out.println("plpdlp");
	}
}


//  --> Can We Overload main() method?

// Only 2 possible ways to write main method 
// -->  public static void main(String[] args)
// -->> static public void main(String[] args)

//if i change the return type other then void ,it will through runtime exception 

// argument  must be string[] only ,other wise ,it will through runtime exception 
// -->  why  "Execution starts from this method" only this one executing ????????????? 
//