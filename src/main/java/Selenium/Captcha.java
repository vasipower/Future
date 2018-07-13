package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Captcha {


	public static void main(String[] args) throws InterruptedException {
		
	
	 System.setProperty("webdriver.chrome.driver", "C:\\Vasi\\Softwares\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://customer.onlinelic.in/ForgotPwd.htm");
		Thread.sleep(2000);
      String srr= driver.findElement(By.xpath("//img[@src='/LICEPS/Captcha.jpeg']")).getText(); //this will read the captcha
        System.out.println(srr);

		
		 /* Use below code If you want to read image location from your hard disk   
		  *   
		   BufferedImage image = ImageIO.read(new File("Image location"));   
		   String imageText = new OCR().recognizeCharacters((RenderedImage) image);  
		   System.out.println("Text From Image : \n"+ imageText);  
		   System.out.println("Length of total text : \n"+ imageText.length());   
		      
		   */ 
		}

		}
