package TestActivities;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TestActivity5 {
	
	AppiumDriver<MobileElement> driver = null;
    WebDriverWait wait;
    
    @BeforeClass
    public void beforeClass() throws MalformedURLException {
    	DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel_4_Emulator");
        caps.setCapability("platformName", "Android");
    	caps.setCapability("appPackage", "com.google.android.apps.messaging");
    	caps.setCapability("appActivity", ".ui.ConversationListActivity");
    	caps.setCapability("unicodeKeyboard", "true");                                     
    	caps.setCapability("resetKeyboard", "true");
    	caps.setCapability("noReset", true);

    	// Instantiate Appium Driver
    	URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
    	driver = new AndroidDriver<MobileElement>(appServer, caps);
    	
    	
    }
    
@Test
  public void SMS() {
	  driver.findElementByAccessibilityId("Start new conversation").click();   
	  
	  wait = new WebDriverWait(driver, 5);
	  
	  //driver.findElementById("recipient_text_view").sendKeys("7838381350");
	  String Phonenumber = 	 "resourceId(\"com.google.android.apps.messaging:id/recipient_text_view\")";	  
	  driver.findElement(MobileBy.AndroidUIAutomator(Phonenumber)).sendKeys("7838381350");
	  
	  String messageBoxLocator = "resourceId(\"com.google.android.apps.messaging:id/contact_list_container\")";
      driver.findElement(MobileBy.AndroidUIAutomator(messageBoxLocator)).click();

	  
	  //driver.findElement(MobileBy.AndroidUIAutomator("text(\"Start group conversation\")")).click();

	  //Wait for Converstaion screen to appear
	  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("compose_message_text")));
	  
      MobileElement SendText = driver.findElementById("send_message_button_icon");
      Assert.assertTrue(SendText.isDisplayed());
      
      driver.findElementById("compose_message_text").sendKeys("This is SMS Test");
      driver.findElementById("send_message_button_icon").click();
      
      wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("message_text_and_info")));
      MobileElement SentMessage = driver.findElementById("message_text_and_info");
      Assert.assertTrue(SentMessage.isDisplayed());
      
      String SentTxt = driver.findElementById("message_text").getText();
      Assert.assertEquals(SentTxt, "This is SMS Test");
      
      //message_text
      
	  
  }
  
	
  @AfterClass
  public void afterClass() {
      driver.quit();
  }
}
