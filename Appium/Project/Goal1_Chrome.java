package AppiumProject;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class Goal1_Chrome {
	
	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait;
	
  @Test
  public void Chrome_1() throws InterruptedException {
	  
      String Goal1Tasks[] = {
			  "1. Add tasks to list",
			  "2. Get number of tasks",
			  "3. Clear the list"
	  };   
      
      Assert.assertTrue(driver.findElementByClassName("android.widget.EditText").isDisplayed());
       
	  for(String TaskToAdd: Goal1Tasks) {
		  	
		  driver.findElementByClassName("android.widget.EditText").sendKeys(TaskToAdd);
		  Thread.sleep(2000);		
		  driver.findElement(MobileBy.AndroidUIAutomator("text(\"Add Task\")")).click();
		  Thread.sleep(2000);		
		    
	  }
	  	  
	  String addedtask1=driver.findElementByXPath("//android.view.View[4]/android.view.View[2]/android.view.View[2]/android.view.View").getText();
      String addedtask2=driver.findElementByXPath("//android.view.View[4]/android.view.View[2]/android.view.View[3]/android.view.View").getText();
      String addedtask3=driver.findElementByXPath("//android.view.View[4]/android.view.View[2]/android.view.View[4]/android.view.View").getText();
      
      
      Assert.assertEquals("1. Add tasks to list", addedtask1);
      Assert.assertEquals("2. Get number of tasks", addedtask2);
      Assert.assertEquals("3. Clear the list", addedtask3);
	  
      
      List<MobileElement> List = driver.findElementsByXPath("//android.view.View[@resource-id='tasksList']/android.view.View");
      System.out.println("no. of tasks: " + List.size());
      Assert.assertEquals(List.size(), 4);
      
      
      driver.findElementByXPath("//android.view.View[4]/android.view.View[2]/android.view.View[2]/android.view.View").click();
      Thread.sleep(2000);
      driver.findElementByXPath("//android.view.View[4]/android.view.View[2]/android.view.View[3]/android.view.View").click();
      Thread.sleep(2000);
      driver.findElementByXPath("//android.view.View[4]/android.view.View[2]/android.view.View[4]/android.view.View").click();
      Thread.sleep(2000);
      driver.findElementByXPath("//android.view.View/android.view.View[4]/android.view.View[3]/android.view.View[2]").click();
      Thread.sleep(2000);
      
      
      List<MobileElement> UpdatedList = driver.findElementsByXPath("//android.view.View[@resource-id='tasksList']/android.view.View");
      System.out.println("no. of tasks: " + UpdatedList.size());
      Assert.assertEquals(UpdatedList.size(), 0);
      
	  /*	   
	  driver.findElement(MobileBy.AndroidUIAutomator("text(\"Add tasks to list\")")).click();
	  driver.findElement(MobileBy.AndroidUIAutomator("text(\"Get number of tasks\")")).click();		 
	  driver.findElement(MobileBy.AndroidUIAutomator("text(\"Clear the list\")")).click();

	  */
  }
  @BeforeClass
  public void beforeClass() {
	  DesiredCapabilities caps = new DesiredCapabilities();
      caps.setCapability("deviceName", "Pixel_4_Emulator");
      caps.setCapability("platformName", "Android");
      caps.setCapability("appPackage", "com.android.chrome");
      caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
      caps.setCapability("automationName", "UiAutomator2");
      caps.setCapability("noReset", true);

      
      try {
    	  URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
    	  driver = new AndroidDriver<MobileElement>(appServer, caps);
    	  wait = new WebDriverWait(driver, 10);
    	  
    	  
    	  driver.get("https://www.training-support.net/selenium/todo-list");
    	  wait = new WebDriverWait(driver, 10);
		
	} catch (MalformedURLException e) {
		e.printStackTrace();
	}         
  }

  @AfterClass
  public void afterClass() {
	  
	  driver.quit();
  }

}
