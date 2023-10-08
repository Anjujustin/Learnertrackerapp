package intern.ict.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;



	

	



public class Placementofficer {
	WebDriver driver;
	private WebElement username;
	private WebElement passw;

	public Placementofficer(WebDriver driver)
	{
		this.driver=driver;
	}
	public void setusername(String User) {
		username = driver.findElement(By.id("username"));
		username.sendKeys(User);
	}

	public void setpassword(String password) {
		passw = driver.findElement(By.id("password"));
		passw.sendKeys(password);
		}
	public void login()
	{
		driver.findElement(By.xpath("//button[@class='btn btn-success w-100']")).click();
	}
	public void scroll()
    {
    JavascriptExecutor js=(JavascriptExecutor) driver;
	 //  js.executeScript("window.scrollBy(0,document.body.scrollHeight");
    js.executeScript("window.scrollBy(10,300)"); 
    //System.out.println("sss");
    }
	public void update()
	{
		driver.findElement(By.xpath("(//button[@class='btn btn-success btn btn-primary'] )[4]")).click();
		
				}
	public void lrnform()
	{
		//driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/main/div/div[2]/ul/li[8]")).click();
		driver.findElement(By.xpath("(//button[@class='btn btn-success btn btn-primary'] )[2]")).click();
	WebElement status=	driver.findElement(By.name("pstatus"));
		Select select = new Select(status);
		select.selectByVisibleText("Job seeking");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		//driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/main/div/div[2]/ul/li[8]")).click();
		
	}
}
