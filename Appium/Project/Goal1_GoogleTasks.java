package AppiumProject;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Goal1_GoogleTasks {
	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait;
	
	
  @Test
  public void CreateNewTask() {
	  
	  String Goal1Tasks[] = {
			  "Complete Activity with Google Tasks",
			  "Complete Activity with Google Keep",
			  "Complete the second Activity Google Keep"
	  };
	  
	  
	  for(String TaskToAdd: Goal1Tasks) {
		  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("tasks_fab")));
		  
		  driver.findElementByAccessibilityId("Create new task").click();
		  wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("add_task_title")));
		  
		  driver.findElementById("add_task_title").sendKeys(TaskToAdd);
		  driver.findElementById("add_task_done").click();
	  }	  
	  
	  wait.until(ExpectedConditions.numberOfElementsToBe(MobileBy.id("task_name"),3));
	  List<MobileElement> taskList = driver.findElementsById("task_name");  
	  
	  System.out.println("Total Tasks in Google Tasks: " + taskList.size());
	  
	  Assert.assertEquals(taskList.size(), 3);
	  
	  System.out.println("Task at Position 1 : " + taskList.get(0).getText());
	  System.out.println("Task at Position 2 : " + taskList.get(2).getText());
	  System.out.println("Task at Position 3: " + taskList.get(1).getText());
	  
	  Assert.assertEquals(taskList.get(0).getText(), "Complete the second Activity Google Keep");
	  Assert.assertEquals(taskList.get(1).getText(), "Complete Activity with Google Keep");
	  Assert.assertEquals(taskList.get(2).getText(), "Complete Activity with Google Tasks");
}

  @BeforeClass
  public void beforeClass() {
	  DesiredCapabilities caps = new DesiredCapabilities();
      caps.setCapability("deviceName", "Pixel_4_Emulator");
      caps.setCapability("platformName", "Android");
      caps.setCapability("appPackage", "com.google.android.apps.tasks");
      caps.setCapability("appActivity", ".ui.TaskListsActivity");
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
