package TestActivities;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TestActivity4 {
	
	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait;
  @Test
  public void NewContact() {
	  
      driver.findElementByAccessibilityId("Create new contact").click();      
     
      driver.findElement(MobileBy.AndroidUIAutomator("text(\"First name\")")).sendKeys("Test");
      driver.findElement(MobileBy.AndroidUIAutomator("text(\"Last name\")")).sendKeys("Varma");
      driver.findElement(MobileBy.AndroidUIAutomator("text(\"Phone\")")).sendKeys("9991284781");
     
      // Save the contact
      driver.findElementById("editor_menu_save_button").click();
      
      // Wait for contact card to appear
      wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("toolbar_parent")));

      // Assertion
      MobileElement mobileCard = driver.findElementById("toolbar_parent");
      Assert.assertTrue(mobileCard.isDisplayed());
      
      String contactName = driver.findElementById("large_title").getText();
      System.out.println("Contact Name: "+ contactName);
      Assert.assertEquals(contactName, "Test Varma");
  }
  
  
  @BeforeClass
  public void beforeClass() {
	  
	  DesiredCapabilities caps = new DesiredCapabilities();
      caps.setCapability("deviceName", "Pixel_4_Emulator");
      caps.setCapability("platformName", "Android");
      caps.setCapability("appPackage", "com.android.contacts");
      caps.setCapability("appActivity", ".activities.PeopleActivity");
      caps.setCapability("noReset", true);

      try {
    	  URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
    	  driver = new AndroidDriver<MobileElement>(appServer, caps);
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
