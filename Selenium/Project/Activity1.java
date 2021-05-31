package Activities;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v88.browser.Browser;

public class Activity1 {
public static void main (String args[]) {
	
	   System.setProperty("webdriver.chrome.driver", "C:/Users/IBMADMIN/Documents/Automation/Drivers/chromedriver.exe"); 
	    WebDriver driver=new ChromeDriver();  
	    //driver.navigate().to("http://www.google.com/");  
		driver.get("https://alchemy.hguy.co/lms");

		String maintitle = driver.getTitle();
				if (maintitle.equals("Alchemy LMS – An LMS Application"))
				{
					System.out.println("Main Title matched");
				}
				else { 
					System.out.println("Main Title not matched");
				}
				
		driver.close();		
		Browser.close();
	}
}
