package Abstract_Class;



abstract class pspkkk{
	
	abstract void  add ();
	
	void m1(){
		
		System.out.println("one");
		
		 add();
		
	}
	
}
abstract class ppp extends pspkkk{

		 void add() {
			
			System.out.println("three");
			m22();
		}
		
		abstract void m22();
		
	}

class jfjj extends ppp{

	@Override
	void m22() {
System.out.println("two");		
	}
	
	
}

public class Abstract_Practice_1 {

	
	public static void main(String[] args) {
		
		jfjj pp=new jfjj();
		pp.add();
		pp.m1();
		pp.m22();
	
	}
}


/*three
two
one
three
two
two*/
