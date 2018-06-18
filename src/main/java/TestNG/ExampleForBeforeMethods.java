package TestNG;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.*;

public class ExampleForBeforeMethods {

      @BeforeMethod
      public void verifyHomepageTitle() {
          System.out.println("Before Method"); 

      }
        
       
      @AfterMethod
      public void goBackToHomepage11q ( ) {
          System.out.println("After Method"); 

      }
      @BeforeTest
      public void goBackToHomepage11 ( ) {
          System.out.println("before Test"); 

      }
      
      @AfterTest
      public void goBackToHomepage11qs ( ) {
          System.out.println("After Test"); 

      }
       
      @Test()
      public void terminateBrowser(){
          System.out.println("launching firefox browser-1"); 

      }
      
      @Test()
      public void terminateBrowser11(){
          System.out.println("launching firefox browser-2"); 

      }
}
