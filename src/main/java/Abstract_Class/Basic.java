package Abstract_Class;


/*abstract class pspsk{
	
	
	abstract  void m1();
}


class pk extends pspsk{

	void m1() {
		
		System.out.println("Basic");
	}
	
	
	
}

public abstract class Basic {
	public static void main(String[] args) {

		pspsk p1=new pk();
		
			p1.m1();
		
	}
}
*/


abstract class pspsk{
	
	
	 abstract    void m1();
	abstract  void m3();

}


abstract class pk1 extends pspsk{

	void m1() {
		
		System.out.println("Basic");
	}
		}

 class pk extends pspsk{

	void m1() {
		
		System.out.println("Basic");
	}

	void m3() {
		System.out.println("Basic-1");
		
	}
}


public abstract class Basic {
	public static void main(String[] args) {

		pspsk p1=new pk();
		
			p1.m1();
			p1.m3();

		
	}
}
