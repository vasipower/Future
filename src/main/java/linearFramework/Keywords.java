package linearFramework;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.sun.jmx.snmp.Timestamp;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.proxy.CaptureType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.screentaker.ViewportPastingStrategy;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Keywords {

    static WebDriver driver;
    static BrowserMobProxy proxy = new BrowserMobProxyServer();
    int globalTimeOut = 15;
    boolean screenshotFlag = false;
    String harFilePath = new File("target/har/har.txt").getAbsolutePath();

    /**
     * method to invoke browser
     *
     * @param browserName
     */
    public boolean invokeBrowser(String browserName) {

        boolean result;
        try {
            if (browserName.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver",
                        (new File("seleniumdrivers\\chromedriver.exe").getAbsolutePath()));
                ChromeOptions options = new ChromeOptions();
                //to enable headless browser
                //options.setHeadless(true);
                options.addArguments("start-maximized");
                driver = new ChromeDriver(options);

            } else if (browserName.equalsIgnoreCase("headless")) {
                System.setProperty("webdriver.chrome.driver",
                        (new File("seleniumdrivers\\chromedriver.exe").getAbsolutePath()));
                ChromeOptions options = new ChromeOptions();
                //to enable headless browser
                options.setHeadless(true);
                options.addArguments("window-size=1920,1080");
               /* if(screenshotFlag) {
                    options.addArguments("screenshot");
                }
                options.addArguments("start-maximized");
                options.addArguments("--headless");
                options.addArguments("--disable-gpu");
                options.addArguments("--no-sandbox");
                options.addArguments("--allow-insecure-localhost");*/
                driver = new ChromeDriver(options);

            } else if (browserName.equalsIgnoreCase("ie")) {
                System.setProperty("webdriver.ie.driver",
                        (new File("seleniumdrivers\\IEDriverServer.exe").getAbsolutePath()));
                InternetExplorerOptions options = new InternetExplorerOptions();
                options.ignoreZoomSettings();
                options.enablePersistentHovering();
                options.introduceFlakinessByIgnoringSecurityDomains();
                driver = new InternetExplorerDriver(options);

            } else if (browserName.equalsIgnoreCase("ff")) {
                System.setProperty("webdriver.firefox.profile", "AUTO_PRO");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                driver = new FirefoxDriver(firefoxOptions);

            } else if (browserName.equalsIgnoreCase("proxychrome")) {
                proxy.setTrustAllServers(true);
                proxy.start();
                System.setProperty("webdriver.chrome.driver",
                        (new File("seleniumdrivers\\chromedriver.exe").getAbsolutePath()));
                ChromeOptions options = new ChromeOptions();
                options.addArguments("start-maximized");
                Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
                options.setCapability(CapabilityType.PROXY, seleniumProxy);
                driver = new ChromeDriver(options);
                startBMob();
            } else if (browserName.equalsIgnoreCase("htmlunit")) {
                driver = new HtmlUnitDriver(BrowserVersion.CHROME);

            }
            result = true;
        } catch (WebDriverException e) {
            takeScreenShotForFailed();
            throw new AssertionError("Invoking browser failure", e);
        }
        return result;
    }

    /**
     * method to start the browser mob proxy
     *
     * @return
     */
    public boolean startBMob() {

        boolean result = false;
        try {
            proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
            result = true;
        } catch (ExceptionInInitializerError err) {
            System.err.format(err + " Failed to initialize browser mob proxy");
            result = false;
        }
        return result;
    }

    /**
     * method to stop the browser mob proxy
     *
     * @return
     */
    public boolean stopBMob() {

        boolean result ;
        try {
            proxy.stop();
            result = true;
        } catch (ExceptionInInitializerError err) {
            System.err.format(err + " Failed to terminate browser mob proxy");
            result = false;
        }
        return result;
    }

    /**
     * method to get the har requests and write to a file
     *
     * @return
     */
    public boolean getHarRequests() {

        boolean result ;
        try {
            Har har = proxy.getHar();
            File fos = new File(harFilePath);
            fos.createNewFile();
            har.writeTo(fos);
            result = true;
        } catch (Exception err) {
            System.err.format(err + " Failed to capture the har requests into a file");
            result = false;
        }
        return result;
    }

    /**
     * method to close open browser
     */
    public boolean closeBrowser() {

        boolean result;
        try {
            driver.quit();
            result = true;
        } catch (NoSuchSessionException e) {
            takeScreenShotForFailed();
            throw new AssertionError("No such session exception" + e);
        }
        return result;
    }

    /**
     * method to launch url
     *
     * @param URL
     */
    public boolean openURL(String URL) {

        boolean result;
        try {
            driver.navigate().to(URL);
            result = true;
        } catch (NotFoundException e) {
            takeScreenShotForFailed();
            throw new AssertionError("Unable to open url " + e);
        }
        return result;
    }

    /**
     * method to enter text in a web element
     *
     * @param locatorType
     * @param value
     * @param text
     */
    public boolean enterText(String locatorType, String value, String text) {

        boolean result = false;
        try {
            By locator;
            locator = locatorValue(locatorType, value);
            WebDriverWait wait = new WebDriverWait(driver, globalTimeOut);
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            element.clear();
            element.sendKeys(text);
            String dispText = element.getText();
            if (dispText.equalsIgnoreCase(text)) {
                System.out.println("Entered text: " + text);
                result = takeScreenShot();
                result &= true;
            } else {
                takeScreenShotForFailed();
                System.err.format("Entered text was displayed as: " + dispText);
            }
        } catch (NoSuchElementException e) {
            takeScreenShotForFailed();
            throw new AssertionError("No Element Found to enter text", e);

        } catch (ElementNotVisibleException e) {
            takeScreenShotForFailed();
            throw new AssertionError("Element " + e + " was not visible");

        } catch (StaleElementReferenceException e) {
            takeScreenShotForFailed();
            throw new AssertionError("Element " + e + " was no longer displayed in DOM");
        }
        return result;
    }

    /**
     * method to take screenshot based on boolean status and save it target folder
     *
     * @return
     */
    public boolean takeScreenShot() {
        boolean result = false;
        if (screenshotFlag) {
            try {
                File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                FileUtils.copyFile(screenshotFile, new File("target/screenshots/" + timestamp.getDateTime() + ".png"));
                if (screenshotFile.exists()) {
                    result = true;
                }
            } catch (IOException e) {
                throw new AssertionError("IO Exception", e);
            }
        } else {
            result = true;
        }
        return result;
    }

    public boolean takeAFullPageScreenShot() {
        boolean result = false;
        if (screenshotFlag) {
            try {
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                Screenshot screenshot = new AShot().shootingStrategy
                        (new ViewportPastingStrategy(1000)).takeScreenshot(driver);
                ImageIO.write(screenshot.getImage(),
                        "PNG", new File("target/screenshots/" + timestamp.getDateTime() + ".png"));
            } catch (IOException e) {
                throw new AssertionError("IO Exception", e);
            }
        } else {
            result = true;
        }
        return result;
    }

    /**
     * method to take screenshot based on boolean status and save it target folder
     *
     * @return
     */
    public boolean takeScreenShotForFailed() {
        boolean result = false;
        try {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            FileUtils.copyFile(screenshotFile, new File("target/screenshots/" + timestamp.getDateTime() + ".png"));
            if (screenshotFile.exists()) {
                result = true;
            }
        } catch (IOException e) {
            throw new AssertionError("IO Exception", e);
        }
        return result;
    }

    /**
     * method to enter text in a web element
     *
     * @param locatorType
     * @param value
     * @param text
     */
    public boolean enterTextAndReturn(String locatorType, String value, String text) {

        boolean result = false;
        try {
            By locator;
            locator = locatorValue(locatorType, value);
            WebDriverWait wait = new WebDriverWait(driver, globalTimeOut);
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            element.clear();
            element.sendKeys(text);
            String dispText = element.getAttribute("value");
            if (dispText.equalsIgnoreCase(text)) {
                System.out.println("Entered text: " + text);
                result = takeScreenShot();
                result &= true;
            } else {
                takeScreenShotForFailed();
                System.err.format("Entered text displayed as : " + dispText);
            }
            element.sendKeys(Keys.RETURN);
        } catch (NoSuchElementException e) {
            takeScreenShotForFailed();
            throw new AssertionError("No Element Found to enter text", e);

        } catch (ElementNotVisibleException e) {
            takeScreenShotForFailed();
            throw new AssertionError("Element " + e + " was not visible");

        } catch (StaleElementReferenceException e) {
            takeScreenShotForFailed();
            throw new AssertionError("Element " + e + " was no longer displayed in DOM");
        }
        return result;
    }

    /**
     * method to click a web element
     *
     * @param locatorType
     * @param value
     */
    public boolean clickElement(String locatorType, String value) {

        boolean result = false;
        try {
            By locator;
            locator = locatorValue(locatorType, value);
            WebDriverWait wait = new WebDriverWait(driver, globalTimeOut);
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
          ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
           // ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
         
            element.click();
          
            if (wait.until(ExpectedConditions.invisibilityOfElementLocated(locator)) == true) {
                System.out.println("Clicked element: " + element.toString());
                result = takeScreenShot();
                result &= true;
            } else {
                takeScreenShotForFailed();
                System.err.format("Click failed on element: " + element.toString());
            }
        } catch (NoSuchElementException e) {
            takeScreenShotForFailed();
            throw new AssertionError("No Element Found to click", e);

        } catch (ElementNotVisibleException e) {
            takeScreenShotForFailed();
            throw new AssertionError("Element " + e + " was not visible");

        } catch (StaleElementReferenceException e) {
            takeScreenShotForFailed();
            throw new AssertionError("Element " + e + " was no longer displayed in DOM");
        }
        return result;
    }

    /**
     * method to select a web element by value
     *
     * @param locatorType
     * @param value
     */
    public boolean selectByValue(String locatorType, String value) {

        boolean result ;
        try {
            By locator;
            locator = locatorValue(locatorType, value);
            WebDriverWait wait = new WebDriverWait(driver, globalTimeOut);
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            Select foo = new Select(element);
            foo.selectByValue(value);
            result = takeScreenShot();
            result &= true;
        } catch (ElementNotSelectableException e) {
            takeScreenShotForFailed();
            throw new AssertionError("No Element Found to select", e);

        } catch (ElementNotVisibleException e) {
            takeScreenShotForFailed();
            throw new AssertionError("Element " + e + " was not visible");

        } catch (StaleElementReferenceException e) {
            takeScreenShotForFailed();
            throw new AssertionError("Element " + e + " was no longer displayed in DOM");
        }
        return result;
    }

    /**
     * method to select a web element by index
     *
     * @param locatorType
     * @param value
     * @param index
     */
    public boolean selectByIndex(String locatorType, String value, int index) {

        boolean result;
        try {
            By locator;
            locator = locatorValue(locatorType, value);
            WebDriverWait wait = new WebDriverWait(driver, globalTimeOut);
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            Select foo = new Select(element);
            foo.selectByIndex(index);
            result = takeScreenShot();
            result &= true;
        } catch (ElementNotSelectableException e) {
            takeScreenShotForFailed();
            throw new AssertionError("No Element Found to select", e);

        } catch (ElementNotVisibleException e) {
            takeScreenShotForFailed();
            throw new AssertionError("Element " + e + " was not visible");

        } catch (StaleElementReferenceException e) {
            takeScreenShotForFailed();
            throw new AssertionError("Element " + e + " was no longer displayed in DOM");
        }
        return result;
    }

    /**
     * method to wait by polling
     */
    public boolean waitByPolling() {

        boolean result;
        try {
            new FluentWait<WebDriver>(driver).ignoring(NoSuchElementException.class);
            result = takeScreenShot();
            result &= true;
        } catch (Exception e) {
            takeScreenShotForFailed();
            throw new AssertionError("Unable to wait" + e);
        }
        return result;
    }

    /**
     * method to mouse over on web element
     *
     * @param locatorType
     * @param value
     */
    public boolean mouseOverUsingJS(String locatorType, String value) {

        boolean result;
        try {
            String javaScript = "var evObj = document.createEvent('MouseEvents');" +
                    "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);" +
                    "arguments[0].dispatchEvent(evObj);";
            By locator;
            locator = locatorValue(locatorType, value);
            WebDriverWait wait = new WebDriverWait(driver, globalTimeOut);
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            ((JavascriptExecutor) driver).executeScript(javaScript, element);
            result = takeScreenShot();
            result &= true;
        } catch (NoSuchElementException e) {
            takeScreenShotForFailed();
            throw new AssertionError("No such element: " + e);

        } catch (ElementNotVisibleException e) {
            takeScreenShotForFailed();
            throw new AssertionError("Element " + e + " was not visible");

        } catch (StaleElementReferenceException e) {
            takeScreenShotForFailed();
            throw new AssertionError("Element " + e + " was no longer displayed in DOM");
        }
        return result;
    }

    /**
     * method to mouse over on web element
     *
     * @param locatorType
     * @param value
     */
    public boolean mouseOverUsingAction(String locatorType, String value) {

        boolean result;
        try {
            By locator;
            locator = locatorValue(locatorType, value);
            WebDriverWait wait = new WebDriverWait(driver, globalTimeOut);
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            Actions action = new Actions(driver);
            action.moveToElement(element).perform();
            result = takeScreenShot();
            result &= true;
        } catch (NoSuchElementException e) {
            takeScreenShotForFailed();
            throw new AssertionError("No such element: " + e);

        } catch (ElementNotVisibleException e) {
            takeScreenShotForFailed();
            throw new AssertionError("Element " + e + " was not visible");

        } catch (StaleElementReferenceException e) {
            takeScreenShotForFailed();
            throw new AssertionError("Element " + e + " was no longer displayed in DOM");
        }
        return result;
    }

    /**
     * method to verify if the web element is displayed
     *
     * @param locatorType
     * @param value
     */
    public boolean verifyElementIsDisplayed(String locatorType, String value) {

        boolean result ;
        try {
            By locator;
            locator = locatorValue(locatorType, value);
            WebDriverWait wait = new WebDriverWait(driver, globalTimeOut);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            if (!element.isDisplayed()) {
                takeScreenShotForFailed();
                System.err.format("Failed to verify element " + element.toString() + " display");
            }
            result = takeScreenShot();
        } catch (NoSuchElementException e) {
            takeScreenShotForFailed();
            throw new AssertionError("No such element : " + e + " to verify");

        } catch (ElementNotVisibleException e) {
            takeScreenShotForFailed();
            throw new AssertionError("Element " + e + " was not visible");

        } catch (StaleElementReferenceException e) {
            takeScreenShotForFailed();
            throw new AssertionError("Element " + e + " was no longer displayed in DOM");
        }
        return result;
    }


    /**
     * method to build locator type
     *
     * @param locatorType
     * @param value
     * @return
     */
    public By locatorValue(String locatorType, String value) {
        By by;
        if (locatorType.equals("id")) {
            by = By.id(value);

        } else if (locatorType.equals("name")) {
            by = By.name(value);

        } else if (locatorType.equals("css")) {
            by = By.cssSelector(value);

        } else if (locatorType.equals("linkText")) {
            by = By.linkText(value);

        } else if (locatorType.equals("partialLinkText")) {
            by = By.partialLinkText(value);

        } else if (locatorType.equals("xpath")) {
            by = By.xpath(value);

        } else {
            by = null;

        }
        return by;
    }
    
    
    public void click(String locatorType, String value) {

        //  boolean result = false;
      //    try {
              By locator;
              locator = locatorValue(locatorType, value);
             
      WebDriverWait wait = new WebDriverWait(driver, globalTimeOut);
      try
      {
              WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
              element.click();
              System.out.println("able to click");
      }
      catch
    	   (StaleElementReferenceException e) {
              takeScreenShotForFailed();
              throw new AssertionError("Element " + e + " was no longer displayed in DOM");
    	  
      }
      
           //   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
             // element.click();
            /*  if (wait.until(ExpectedConditions.invisibilityOfElementLocated(locator)) == true) {
                  System.out.println("Clicked element: " + element.toString());
                  result = takeScreenShot();
                  result &= true;
              } else {
                  takeScreenShotForFailed();
                  System.err.format("Click failed on element: " + element.toString());
              }*/
             // return result;
          }
      /*//catch (NoSuchElementException e) {
              takeScreenShotForFailed();
              throw new AssertionError("No Element Found to click", e);

          } catch (ElementNotVisibleException e) {
              takeScreenShotForFailed();
              throw new AssertionError("Element " + e + " was not visible");

          } catch (StaleElementReferenceException e) {
              takeScreenShotForFailed();
              throw new AssertionError("Element " + e + " was no longer displayed in DOM");
          }*/
       
    
    
    /*
     * To verify check is selected or not 
     * 
     */
    public boolean getcheckboxvalue(String locatorType, String value)
    {   
//    	 By locator;
//         locator = locatorValue(locatorType, value);
//         WebElement element =  if( ((WebDriver) locator).get(2).isSelected())
//        return webElement.isSelected();
    	  boolean result = false;
         By locator;
         locator = locatorValue(locatorType, value);
         WebDriverWait wait = new WebDriverWait(driver, globalTimeOut);
         WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
          element.isSelected();
          return result;
        
    }
 
    public String getText(String locatorType, String value){
    	
    
    	 By locator;
         locator = locatorValue(locatorType, value);
         WebDriverWait wait = new WebDriverWait(driver, globalTimeOut);
         WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        String str= element.getText();
         System.out.println("Printing "+element);
		return str;
    
    }
    
    
    public boolean entertext(String locatorType, String value, String text) {

        boolean result = false;
       
            By locator;
            locator = locatorValue(locatorType, value);
            WebDriverWait wait = new WebDriverWait(driver, globalTimeOut);
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        //    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            element.clear();
            element.sendKeys(text);
        return result;
        
       
}
    
  
    
    
}