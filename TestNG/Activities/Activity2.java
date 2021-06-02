package activities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;

public class Activity2 {

	WebDriver driver;
	
  @Test
  public void Test1() {
	  String Title1 = driver.getTitle();
	  
	  Assert.assertEquals("Target Practice", Title1);
	  
  }
  @Test
  public void Test2() {
	  
	  WebElement Button = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[3]/button[3]"));
	  Assert.assertTrue(Button.isDisplayed());
	  System.out.println("Button Color: " + Button.getText());
	  Assert.assertEquals(Button.getText(), "Blue");	  
  }
  
  @Test (enabled = false)
  public void Test3() {
	  
	  WebElement Header = driver.findElement(By.id("third-header"));
	  Assert.assertTrue(Header.isDisplayed());
	  System.out.println("Header: " + Header.getText());
	  Assert.assertEquals(Header.getText(), "Third header");
  }
  
  @Test
  public void Test4() {
	  throw new SkipException("Skipping test case 4");      
  } 
  
  @BeforeClass
  public void beforeClass() {  
	  System.setProperty("webdriver.chrome.driver", "C:/Users/IBMADMIN/Documents/Automation/Drivers/chromedriver.exe");  
	  driver = new ChromeDriver();	 
	  driver.get("https://www.training-support.net/selenium/target-practice");
  }

  @AfterClass
  public void afterClass() {
	  
	  driver.close();
  }
}
