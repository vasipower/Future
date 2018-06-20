package Abstract_Class;


 abstract class pspk{
	
	abstract void m1();
	
	void m2(){
		
		int a=10;
}
	
	pspk(){
		
		System.out.println("pawan kalyan");
	}
}
 
 class pkk extends pspk{

	
	void m1() {

		System.out.println("PSPK");
	}
	pkk(){
		
		System.out.println("PKK");

	}
	 
 }
public class AbstractConstructor {

	public static void main(String[] args) {
		
		pkk P1=new pkk();
		P1.m1();
	}
}
