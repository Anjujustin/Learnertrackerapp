package intern.ict.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;



	

	
public class Trainer {
	WebDriver driver;
	private WebElement username;
	private WebElement passw;
	private WebElement choosefile;

	public Trainer(WebDriver driver)
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
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/main/div/a[1]/button")).click();
	}
	public void setlearnerid(String Learner) {
		username = driver.findElement(By.id("learnerid"));
		username.sendKeys(Learner);
	}

	public void setname(String name) {
		passw = driver.findElement(By.id("name"));
		passw.sendKeys(name);
		}
	public void course()
	{
		WebElement course=driver.findElement(By.name("course"));
		Select select = new Select(course);
		select.selectByVisibleText("ST");
		
		
	}
	public void project()
	{
		WebElement project=driver.findElement(By.name("project"));
		Select select = new Select(project);
		select.selectByVisibleText("ICTAK");	
		
	}
	public void batch()
	{
		WebElement batch=driver.findElement(By.name("batch"));
		Select select = new Select(batch);
		select.selectByVisibleText("Mar_23");	
		
	}
	public void coursestatus()
	{
		WebElement csstatus=driver.findElement(By.name("cstatus"));
		Select select = new Select(csstatus);
		select.selectByVisibleText("Qualified");	
		
	}
	public void submit()
	{
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
	}
	public  String coursename()
	{
		WebElement course=driver.findElement(By.name("course"));
		Select select = new Select(course);
		select.selectByVisibleText("ST");
		 WebElement o = select.getFirstSelectedOption();
	      String selectedoption = o.getText();
	      	      
		return selectedoption;
		
		
	}
	public String projectname()
	{
		WebElement project=driver.findElement(By.name("project"));
		Select select = new Select(project);
		select.selectByVisibleText("ICTAK");
		WebElement k= select.getFirstSelectedOption();
	      String selectedoption = k.getText();
		return selectedoption;	
		
	}
	public String batchname()
	{
		WebElement batch=driver.findElement(By.name("batch"));
		Select select = new Select(batch);
		select.selectByVisibleText("Mar_23");
		WebElement b = select.getFirstSelectedOption();
	      String selectedoption = b.getText();
		return selectedoption;	
		
	}
	public String coursestatusname()
	{
		WebElement csstatus=driver.findElement(By.name("cstatus"));
		Select select = new Select(csstatus);
		select.selectByVisibleText("Qualified");
		WebElement cs = select.getFirstSelectedOption();
	      String selectedoption = cs.getText();
		return selectedoption;	
		
	}
	public void update()
	{
	driver.findElement(By.xpath("(//button[@class='btn btn-success'])[1]"))	.click();
	}
	public void learnerupdate()
	{
	driver.findElement(By.id("learnerid")).clear();
	
		driver.findElement(By.id("learnerid")).sendKeys("115");
	
	}
	public void trainerdelete()
	{
		driver.findElement(By.xpath("(//button[@class='btn btn-danger'])[4]")).click();
	}
	public void bulkdata()
	{
		driver.findElement(By.xpath("//a[@href='/upload']")).click();	
	}
	public String bulkdataupload()
	{
			
		WebElement choosefile =driver.findElement(By.name("file"));
	
	choosefile.sendKeys("C:/folder/ass.csv");
	driver.findElement(By.xpath("//button[text()='Submit']")).click();
	return null;	
		
		
	}
	public void bulkdatacancel()
	{
		driver.findElement(By.xpath("//button[text()='Cancel']")).click();
	}
}
