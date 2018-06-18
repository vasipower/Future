package TestNG_Test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import TestNG.TestNGOrder;

/*
 * Here mentioned examples for Groups,Parameter,Priority 
 */
public class TestNG_Groups extends TestNGOrder {

	// Groups example
	@Test(groups = { "Sanity", "Smoke" })
	void m1() {
		System.out.println("Sample1");

	}

	@Test(groups = "Smoke")
	void m2() {
		System.out.println("Sample2");
	}

	//Parameter example
	
	@Parameters({ "username", "password" })
	@Test(groups = { "ABCD", "Sanity" })

	void m3(String username, String password) {
		System.out.println("Parameter for User Name passed as :- " + username);
		System.out.println("Parameter for Password passed as :- " + password);
	}

	@Test(priority=0)
	
	void m4(){
		
		System.out.println("Test with priority-1");
	}
	@Test(priority=1)

	void m5() {

		System.out.println("Test with priority-2");
	}
}
