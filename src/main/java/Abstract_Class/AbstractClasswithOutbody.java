package Abstract_Class;


// An abstract class without any abstract method

abstract class PSPK11{
	
	void m1(){
		
		System.out.println("pora");
	}
	
}

class PK45 extends PSPK11{}

public class AbstractClasswithOutbody {
	
	public static void main(String[] args) {
		PK45 PP=new PK45();
		PP.m1();
		
	}
}
