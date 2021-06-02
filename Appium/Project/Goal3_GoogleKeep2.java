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

public class Goal3_GoogleKeep2 {
	
	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait;
  @Test
  public void GoogleKeep2() {
	  
	  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("new_note_button")));
	  driver.findElementById("new_note_button").click();
	  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("browse_text_note")));
	  
	  driver.findElementById("editable_title").sendKeys("New Note in Google Keep with Reminder");
	  driver.findElementById("edit_note_text").sendKeys("This is the Goal 3 Activity");
	  
	  driver.findElementById("menu_reminder").click();
	  
	  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("menu_text")));
	  driver.findElementById("menu_text").click();
	  
	  System.out.println(driver.findElementById("reminder_chip").getText());
	  
	  driver.findElementByAccessibilityId("Navigate up").click();
	  
	  
	  //Verification Begins
	  
	  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("new_note_button")));
	  
	  List<MobileElement> NoteList = driver.findElementsById("index_note_title");  
	  String LatestNote = NoteList.get(0).getText();
	  System.out.println("Current Note at Position 1 : " + LatestNote);
	  
	  Assert.assertEquals("New Note in Google Keep with Reminder", LatestNote);
	  
	  boolean Reminder = driver.findElementById("reminder_chip_text").isDisplayed();
	  System.out.println("Is the Reminder displayed : " + Reminder);
 
	  
  }
  @BeforeClass
  public void beforeClass() {
	  DesiredCapabilities caps = new DesiredCapabilities();
      caps.setCapability("deviceName", "Pixel_4_Emulator");
      caps.setCapability("platformName", "Android");
      caps.setCapability("appPackage", "com.google.android.keep");
      caps.setCapability("appActivity", "com.google.android.apps.keep.ui.activities.BrowseActivity");
      caps.setCapability("automationName", "UiAutomator2");
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
