package activities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity1 {
	
	WebDriver driver;
	
	
	@Test
  public void Test1() {
		
		String title = driver.getTitle();
        
		System.out.println("Page title is: " + title);
            
        Assert.assertEquals("Training Support", title);
                    
        driver.findElement(By.id("about-link")).click();
                    
        System.out.println("New page title is: " + driver.getTitle());
        
        Assert.assertEquals(driver.getTitle(), "About Training Support");
    }
		
  @BeforeMethod
  public void beforeMethod() {
	  
	  System.setProperty("webdriver.chrome.driver", "C:/Users/IBMADMIN/Documents/Automation/Drivers/chromedriver.exe");  
	  driver = new ChromeDriver();
      
      driver.get("https://www.training-support.net");
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
