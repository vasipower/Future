package TestNG_Test;

import org.testng.annotations.Test;

public class TestNgSkip {

	//Skip Test cases
	
	@Test(enabled=true)
	void m1(){
		
		System.out.println("True");
	}
	
	@Test(enabled=false)
	void m2(){
		System.out.println("False");
	}
	
	
	@Test
	void m3(){
		System.out.println("True123");
	}
	
	
}
