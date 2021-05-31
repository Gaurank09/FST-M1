package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v88.browser.Browser;

public class Activity5 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/Users/IBMADMIN/Documents/Automation/Drivers/chromedriver.exe"); 
		WebDriver driver=new ChromeDriver();  
		driver.get("https://alchemy.hguy.co/lms");
		
		WebElement MyAccount = driver.findElement(By.xpath("//*[@id=\"menu-item-1507\"]"));
		MyAccount.click();
		
		System.out.println("Current Page Title = " + driver.getTitle());
		
		driver.close();
		Browser.close();

	}

}
