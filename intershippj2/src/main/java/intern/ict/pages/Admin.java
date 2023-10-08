package intern.ict.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;



	
public class Admin {
	WebDriver driver;
	private WebElement username;
	private WebElement passw;
	private WebElement name;
	private WebElement email;
	private WebElement username1;
	private WebElement passwd;

	public Admin(WebDriver driver)
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
	public void learner()
	{
		driver.findElement(By.xpath("//span[text()='Learners']")).click();
	}
	public void placement()
	{
		driver.findElement(By.xpath("//span[text()='Placement']")).click();
	}
	public void adduser()
	{
		driver.findElement(By.xpath("//button[@class='mb-3 btn btn-success']")).click();
	}
	public void username( String uname)
	{
		name = driver.findElement(By.id("name"));
		name.sendKeys(uname);
	}
	public void Email( String mailid)
	{
		email = driver.findElement(By.id("email"));
		email.sendKeys(mailid);
	}
	public void usname( String usrname)
	{
		username1 = driver.findElement(By.id("username"));
		username1.sendKeys(usrname);
	}
	public void paswd( String pswd)
	{
		passwd = driver.findElement(By.id("password"));
		passwd.sendKeys(pswd);
	}
	public void role()
	{WebElement role=driver.findElement(By.name("roleInputs"));
	Select select = new Select(role);
	select.selectByVisibleText("Placement Officer");	
	
}
	public void submit()
	{
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
	}
	public void userupdate()
	{
		driver.findElement(By.xpath("(//button[@class='btn btn-success btn btn-primary'])[4]")).click();
		
	}
	public void usernameupdate()
	{
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys("Anu");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
	}
	public void userdelete()
	{
		driver.findElement(By.xpath("(//button[@class='btn btn-danger btn btn-primary'])[4]")).click();
	}
	
	}
