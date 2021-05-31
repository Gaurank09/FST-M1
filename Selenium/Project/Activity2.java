package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v88.browser.Browser;

public class Activity2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/Users/IBMADMIN/Documents/Automation/Drivers/chromedriver.exe"); 
		WebDriver driver=new ChromeDriver();  
		driver.get("https://alchemy.hguy.co/lms");

		WebElement element = driver.findElement(By.xpath("//*[@id=\"uagb-infobox-74cd79b6-b855-4e72-81bc-e70591de1896\"]/div/div/div/div[1]/h1"));
		
		
		System.out.println(element.getText());
		
		if (element.getText().equals("Learn from Industry Experts"))
		{
			System.out.println("Main Heading matched");
		}
		else { 
			System.out.println("Main Heading not matched");
		}
		
		//System.out.println(element.getText());

		driver.close();
		Browser.close();
		
	}

}
