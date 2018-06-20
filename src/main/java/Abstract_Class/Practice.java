package Abstract_Class;

class A{
	
	
	 int addition(int a,int b){
		
		return a+b;		
	}
	
	int add(int a,int b){
		
		return a+b;
			
	}
	
}

public class Practice {

	public static void main(String[] args) {
		
		A a1=new A();
		
		int z=a1.addition(1, 2);
		System.out.println(z);
		
		int y=a1.add(z,10);
		System.out.println(y);
		
}
}