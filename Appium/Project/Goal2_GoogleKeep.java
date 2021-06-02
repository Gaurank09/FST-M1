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

public class Goal2_GoogleKeep {
	
	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait;
	
  @Test
  public void GoogleKeep1() {
	  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("new_note_button")));
	  driver.findElementById("new_note_button").click();
	  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("browse_text_note")));
	  
	  driver.findElementById("editable_title").sendKeys("New Note in Google Keep");
	  driver.findElementById("edit_note_text").sendKeys("This is the Goal 2 Activity");
	  	  
	  driver.findElementByAccessibilityId("Navigate up").click();
	  
	  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("new_note_button")));
	  
	  List<MobileElement> NoteList = driver.findElementsById("index_note_title");  
	  System.out.println("Total Notes in Google Keep: " + NoteList.size());
	  String LatestNote = NoteList.get(0).getText();
	  System.out.println("Note at Position 1 : " + LatestNote);
	  
	  Assert.assertEquals("New Note in Google Keep", LatestNote);
	  
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
