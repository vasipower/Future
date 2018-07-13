package Selenium;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ComparePrice {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Vasi\\Softwares\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://Amazon.in");
		Thread.sleep(2000);

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("BlackBerry Passport");
		driver.findElement(By.xpath("//input[@value='Go']")).click();

		/*driver.findElement(By
				.xpath("//li[@id='result_0']//span[@class='a-size-base a-color-price s-price a-text-bold']"))
				.click();*/

		Thread.sleep(2000);
//Getting the price of first mobile
		String Price = driver.findElement(By.xpath("//li[@id='result_0']//span[@class='a-size-base a-color-price s-price a-text-bold']")).getText();
		System.out.println(Price);
		
		//clicking the first mobile
		
		
	//	//html//li[@id='result_0']/div[@class='s-item-container']
		String  psps= driver.findElement(By.xpath("//li[@id='result_0']")).getText();

		System.out.println("papapap"+psps);
		
	/*	WebElement WebElement = driver.findElement(By.xpath("//li[@id='result_0']"));
		li.get(1).click();*/
		
		List<WebElement> li = driver.findElements(By.xpath("//li[@id='result_0']"));
		System.out.println("vasista      "+li.get(1));
		li.get(1).click();

		//WebElement table = driver.findElement(By.xpath("your path"));
		/*List<WebElement> rows = psps.findElements(By.xpath("//*[contains(text(),'BlackBerry Passport']"));
		java.util.Iterator<WebElement> i = rows.iterator();
		while(i.hasNext()) {
		    WebElement row = i.next();
		    row.click();*/
		    
		    
/*		List<WebElement> allLinks = driver.findElements(By.xpath("//div[@class='datepicker']/div/table/tbody/tr/td/table/tbody[2]/tr/td[@class='' or @class='datepickerSaturday' or @class='datepickerSunday']/a/span"));

		Iterator<WebElement> itr = allLinks.iterator();
		while(itr.hasNext()) {
		    System.out.println(itr.next().getAttribute("src"));

		}*/
		
	/*	List<WebElement> li = driver.findElements(By.linkText("Services"));;
		li.get(1).click();*/
		}
	}
//}


