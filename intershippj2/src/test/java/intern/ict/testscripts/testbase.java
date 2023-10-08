package intern.ict.testscripts;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


	
public class testbase {
	WebDriver driver;
	@BeforeMethod
		public void setUp() {
		   driver = new ChromeDriver();
		    driver.get("https://learnertracker.netlify.app/");	           
		 driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}
	@AfterMethod
	public void close()
	{
		driver.close();
	}
}