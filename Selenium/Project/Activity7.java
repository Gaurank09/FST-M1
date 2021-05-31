package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v88.browser.Browser;

public class Activity7 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/Users/IBMADMIN/Documents/Automation/Drivers/chromedriver.exe"); 
		WebDriver driver = new ChromeDriver();  
		driver.get("https://alchemy.hguy.co/lms");
		
		driver.findElement(By.id("menu-item-1508")).click();
		
		
		String text1 = driver.findElement(By.xpath("//*[@id=\\\"post-69\\\"]/div[2]/h3")).getText();
		System.out.println("Course 1: " + text1);
	
		String text2 = driver.findElement(By.xpath("//*[@id=\"post-71\"]/div[2]/h3")).getText();
		System.out.println("Course 1: " + text2);
		
		String text3 = driver.findElement(By.xpath("//*[@id=\"post-24042\"]/div[2]/h3")).getText();
		System.out.println("Course 1: " + text3);
		
		driver.close();
		Browser.close();
	}

}
