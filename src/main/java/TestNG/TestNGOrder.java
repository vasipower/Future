package TestNG;

import org.testng.annotations.*;

public class TestNGOrder {

	@Test
	// Test Method
	public void firstTest() {
		System.out.println("Hi, I am under Test");
	}

	@BeforeMethod
	// Before each Test
	public void beforeMethod() {
		System.out.println("@BeforeMethod - Before Each and Every Test");
	}

	@AfterMethod
	// After each Test
	public void afterMethod() {
		System.out.println("@AfterMethod - After each and every Test");
	}

	@BeforeClass
	// Execute before start the execution of class
	public void beforeClass() {
		System.out.println("@BeforeClass - Eexcute first in Class");
	}

	@AfterClass
	// After all methods
	public void afterClass() {
		System.out.println("@AfterClass - Execute last in Class");
	}

	@BeforeTest
	// Before all Tests
	public void beforeTest() {
		System.out.println("@BeforeTest - Execute before all Test methods");
	}

	@AfterTest
	// After all Tests
	public void afterTest() {
		System.out.println("@AfterTest - Execute after all Test Methods");
	}

	@BeforeSuite
	// Before Suite
	public void beforeSuite() {
		System.out.println("@BeforeSuite - Execute First in Suite");
	}

	@AfterSuite
	// After entire suite
	public void afterSuite() {
		System.out.println("@AfterSuite - Execute Last in Suite");
	}
}

// STCM 

/*
 * Before test- will excecute only once before running test methods - Before
 * method -will execute before running each test
 */

/*
 * @BeforeClass Annotates methods that will be run before the first method on
 * the current test class is run.
 * 
 * @AfterClass Annotates methods that will be run after the last test method on
 * the current class is run.
 * 
 * @BeforeTest Annotates methods that will be run before any method in a given
 * is run.
 * 
 * @AfterTest Annotates methods that will be run after all the test methods in a
 * given have been buy provigil with prescription run.
 * 
 * @BeforeGroups Annotates methods that will be run before the first method in
 * any of the specified groups is run.
 * 
 * @AfterGroups Annotates methods that will be run after the last test method
 * belonging to the groups specified in its value attribute has been run. The
 * annotated method is automatically put into these specified groups.
 */
