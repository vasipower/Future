package Abstract_Class;


abstract class P1{
	
	abstract void m1();
}


class P2 extends P1{

	
	void m1() {
System.out.println("P2");		
	}
	
	
}

class P3 extends P1{

	void m1() {
System.out.println("P3");		
	}
	
	
}
public class AbstractMultipleuseofSameMethod {

	public static void main(String[] args) {
		
		P1 po=new P2();
		po.m1();
		P1 wwww=new P3();
		wwww.m1();
	}
}
