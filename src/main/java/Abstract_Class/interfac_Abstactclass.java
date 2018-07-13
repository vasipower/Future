package Abstract_Class;



interface ABC {
	
	void a();

	void b();

}

  abstract class BCD implements ABC {

	void c(){
		
		System.out.println("BCD-C");
	}
}

class CDE extends BCD{

	public void a() {
      System.out.println("CDE-A");		
	}

	public void b() {
		System.out.println("CDE-B");		
		
	}
	
	public void c(){
		System.out.println("ooo");
		
	}
	
}

public class interfac_Abstactclass {
	
	public static void main(String[] args) {
		
	ABC CC=new CDE();
	CC.a();
	CC.b();
	CC.c();
	

}}

/// Dought ???
//why method c not able to access by object ,
//Even though method c avalable in class CDE