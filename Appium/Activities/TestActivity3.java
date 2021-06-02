package TestActivities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TestActivity3 {
	AppiumDriver<MobileElement> driver = null;
	
	
	  @Test (priority = 1)
	  public void calcAdd() throws InterruptedException, IOException {
	      driver.findElementById("digit_5").click();
	      	      
	      driver.findElementById("op_add").click();
	      
	      driver.findElementById("digit_9").click();
	      
	      driver.findElementById("eq").click();
	      
	      String ActualAddResult = driver.findElementById("result").getText();
	      System.out.println("Addition Result: " + ActualAddResult);
	      Assert.assertEquals(ActualAddResult, "14");
	  }
	  
	  @Test (priority = 2)
	  public void calcSubtract() throws InterruptedException, IOException {
	      driver.findElementById("digit_1").click();
	      driver.findElementById("digit_0").click();
	      	      
	      driver.findElementById("op_sub").click();
	      
	      driver.findElementById("digit_5").click();
	      
	      driver.findElementById("eq").click();
	      
	      String SubResult = driver.findElementById("result").getText();
	      System.out.println("Addition Result: " + SubResult);
	      Assert.assertEquals(SubResult, "5");
	  }
	  
	  @Test (priority = 3)
	  public void calcMultiply() throws InterruptedException, IOException {

		  driver.findElementById("digit_5").click();
		  driver.findElementById("op_mul").click();
		  driver.findElementById("digit_1").click();
		  driver.findElementById("digit_0").click();
		  driver.findElementById("digit_0").click();
		  
		  driver.findElementById("eq").click();
		  
		  
		  String MultiplyResult = driver.findElementById("result").getText();
		  System.out.println("Multiply Result: " + MultiplyResult);
		  
		  Assert.assertEquals(MultiplyResult, "500");

	  }  
	  @Test (priority = 4)
	  public void calcDiv() throws InterruptedException, IOException {

		  driver.findElementById("digit_5").click();
		  driver.findElementById("digit_0").click();
		  driver.findElementById("op_div").click();
		  driver.findElementById("digit_2").click();
		  
		  driver.findElementById("eq").click();		  
		  
		  String DivResult = driver.findElementById("result").getText();
		  System.out.println("Multiply Result: " + DivResult);
		  
		  Assert.assertEquals(DivResult, "25");

	  } 
	  
	  @BeforeClass
	  public void beforeClass() {
		  
		  DesiredCapabilities caps = new DesiredCapabilities();
	      caps.setCapability("deviceName", "Pixel_4_Emulator");
	      caps.setCapability("platformName", "Android");
	      caps.setCapability("appPackage", "com.android.calculator2");
	      caps.setCapability("appActivity", "com.android.calculator2.Calculator");
	      caps.setCapability("automationName", "UiAutomator2");
	      caps.setCapability("noReset", true);

	      try {
	    	  URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
	    	  driver = new AndroidDriver<MobileElement>(appServer, caps);
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}       
	  }

	  @AfterClass
	  public void afterClass() {
		  
		  driver.quit();
	  }
}
