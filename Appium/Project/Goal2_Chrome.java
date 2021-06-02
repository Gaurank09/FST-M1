package AppiumProject;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class Goal2_Chrome {
	
	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait;
	
	@BeforeClass
	public void setUp() throws MalformedURLException {
	    DesiredCapabilities caps = new DesiredCapabilities();
	    caps.setCapability("deviceName", "Pixel_4_Emulator");
	    caps.setCapability("platformName", "android");
	    caps.setCapability("automationName", "UiAutomator2");
	    caps.setCapability("appPackage", "com.android.chrome");
        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        caps.setCapability("noReset", true);
        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver,20);
        
}
	
	@BeforeMethod
	public void openLogInURL() {
	        driver.get("https://www.training-support.net/selenium");
	        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View")));
			driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(new UiSelector().scrollable(true)).flingToEnd(5)"));
			driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(new UiSelector().scrollable(true)).scrollBackward()"));
			driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(new UiSelector().scrollable(true)).scrollBackward()"));
			driver.findElementByXPath("//android.view.View[contains(@text,'Login')]").click();
	           }
	
  @Test 
    public void chromeLoginSuccessful() throws InterruptedException {
      
      Thread.sleep(5000);
      wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.EditText[1]")));
      driver.findElementByXPath("//android.widget.EditText[1]").sendKeys("admin");
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
      
      driver.findElementByXPath("//android.widget.EditText[2]").sendKeys("password");
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
      
      driver.findElementByXPath("//android.widget.Button[@text='Log in']").click();
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
      
      wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View/android.view.View[4]")));
      String msg=driver.findElementByXPath("//android.view.View/android.view.View[4]").getText();
      System.out.println(msg);
      Assert.assertEquals("Welcome Back, admin", msg);
                    		       
  }
  
  @Test(priority=2)
  public void chromeLoginInvalidCredentials() throws InterruptedException {
  	              
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 

      wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.EditText[1]")));
      driver.findElementByXPath("//android.widget.EditText[1]").sendKeys("admin");
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 

      driver.findElementByXPath("//android.widget.EditText[2]").sendKeys("WrongPassword");
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 

      driver.findElementByXPath("//android.widget.Button[@text='Log in']").click();
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 

      wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View/android.view.View[4]")));
      String msg=driver.findElementByXPath("//android.view.View/android.view.View[4]").getText();
      System.out.println(msg);
      Assert.assertEquals("Invalid Credentials", msg);
                    		       
  }
  @AfterClass
  public void afterClass() {
	  
	  driver.quit();
  }

}
