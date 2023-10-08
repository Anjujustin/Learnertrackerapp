package intern.ict.testscripts;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.io.PrintStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.ictkerala.utilty.Excelutility;
import org.testng.Assert;
import org.testng.annotations.Test;

import intern.ict.constant.ExpectedConstants;
//import automate.Amazonpage;
//import expectedconstants.Expected;
import intern.ict.pages.Admin;
import intern.ict.pages.Placementofficer;
import intern.ict.pages.Trainer;
import intern.ict.utility.Excelutility;




@Test
public class testclass extends testbase{
	//private static final String value = null;
	Admin ad;
	Trainer tr;
	Placementofficer po;
@Test(priority=1)
	public void home()//url navigate to proper login page
	{
		ad=new Admin(driver);
		String title=driver.getTitle();
		System.out.println("The URL directs to the page having the title -"+title);
		Assert.assertEquals(title,ExpectedConstants.ExpectedTitle);
	}
	@Test(priority=2)
	public void wlogin() throws IOException, InterruptedException//wrong admin login
{
	ad=new Admin(driver);
	String Username = Excelutility.getData(0, 0);
	String Passwrd = Excelutility.getData(0, 1);
	//System.out.println(Passwrd);
	ad.setusername(Username);
	ad.login();
	Thread.sleep(500);
	ad.scroll();
	String alert=driver.findElement(By.xpath("//small[text()='Password is required.']")).getText();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
	

	System.out.println("It shows the error message for blank password as - "+alert);
	Assert.assertEquals(alert, ExpectedConstants.Expectedalert);
}
	@Test(priority=3)
	public void wlogin1() throws IOException, InterruptedException//wrong admin login
	{
		ad=new Admin(driver);
		String Username = Excelutility.getData(0, 6);
		String Passwrd = Excelutility.getData(0, 7);
		ad.setusername(Username);
		ad.setpassword(Passwrd);
		ad.login();
		Thread.sleep(500);
		ad.scroll();
		String alert=driver.findElement(By.xpath("//div[@class='fade alert alert-danger alert-dismissible show']")).getText();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		System.out.println("It shows the error message for wrong username and password as - "+alert);
		Assert.assertEquals(alert, ExpectedConstants.Expectedmsg);
	}
	@Test(priority=4)
	public void adlogin() throws IOException, InterruptedException//correct admin login navigate to admin page
{ad=new Admin(driver);
	String Username = Excelutility.getData(0, 0);
	String Passwrd = Excelutility.getData(0, 1);
	ad.setusername(Username);
	ad.setpassword(Passwrd);
	ad.login();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
	String Title=driver.findElement(By.xpath("(//*[@class='table-success']//th)[5]")).getText();
	System.out.println("For correct username and password it navigate to the page having the field -"+Title);
	Assert.assertEquals(Title, ExpectedConstants.Expectectedtitle);
	}
	@Test(priority=5)
public void adtrainer() throws IOException//admin navigate to trainer page
{
	ad=new Admin(driver);
	String Username = Excelutility.getData(0, 0);
	String Passwrd = Excelutility.getData(0, 1);
	ad.setusername(Username);
	ad.setpassword(Passwrd);
	ad.login();
	ad.learner();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
	String title=driver.findElement(By.xpath("//span[text()='Learners']")).getText();
	System.out.println("Admin login can  navigates to the trainerpage with title- "+title);
	Assert.assertEquals(title, ExpectedConstants.Expectectedtitle1);
}
	
	
	@Test(priority=6)
public void adplacement() throws IOException//admin navigate to placement page
{
	ad=new Admin(driver);
	String Username = Excelutility.getData(0, 0);
	String Passwrd = Excelutility.getData(0, 1);
	//String ParentWindow=driver.getWindowHandle();
	ad.setusername(Username);
	ad.setpassword(Passwrd);
	ad.login();
	ad.placement();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
	String title=driver.findElement(By.xpath("//span[text()='Placement']")).getText();
	System.out.println("Admin login can navigate to the placementpage with title- "+title);
	Assert.assertEquals(title, ExpectedConstants.Expectectedtitle2);
}
@Test(priority=7)
public void adminuser() throws IOException//To navigate to the add user form
{ad=new Admin(driver);
String Username = Excelutility.getData(0, 0);
String Passwrd = Excelutility.getData(0, 1);
//String ParentWindow=driver.getWindowHandle();
ad.setusername(Username);
ad.setpassword(Passwrd);
ad.login();
ad.adduser();
String Useraddtitle=driver.findElement(By.xpath("//*[@class='container w-50 mt-5 pt-5 bg-secondary-subtle rounded']//h3")).getText();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
System.out.println("The Useradd button navigate to the =" +Useraddtitle);
Assert.assertEquals(Useraddtitle, ExpectedConstants.Expecteduseraddtitle);
	
}
@Test(priority=8)
public void adminaddusr() throws IOException//To add a new user in admin
{
	ad=new Admin(driver);
	String Username = Excelutility.getData(0, 0);
	String Passwrd = Excelutility.getData(0, 1);
	//String ParentWindow=driver.getWindowHandle();
	ad.setusername(Username);
	ad.setpassword(Passwrd);
	ad.login();
	ad.adduser();
	String name = Excelutility.getData(0, 11);
	String email = Excelutility.getData(0, 12);
	String username = Excelutility.getData(0, 13);
	String password = Excelutility.getData(0, 14);
	
	ad.username(name);
	ad.Email(email);
	ad.usname(username);
	ad.paswd(password);
	ad.role();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
	ad.submit();
	String msg=driver.findElement(By.xpath("//div[@id='swal2-html-container']")).getText();
	System.out.println("Adding a user successfully shows the message- "+msg);
	driver.findElement(By.xpath("//button[text()='OK']")).click();
}

@Test(priority=9)//validating name field in add user form
public void wnameuseradd() throws IOException
{
	ad=new Admin(driver);
	String Username = Excelutility.getData(0, 0);
	String Passwrd = Excelutility.getData(0, 1);
	//String ParentWindow=driver.getWindowHandle();
	ad.setusername(Username);
	ad.setpassword(Passwrd);
	ad.login();
	ad.adduser();
	String name = Excelutility.getData(0,15);
	String email = Excelutility.getData(0, 12);
	String username = Excelutility.getData(0, 13);
	String password = Excelutility.getData(0, 14);
	
	ad.username(name);
	ad.Email(email);
	ad.usname(username);
	ad.paswd(password);
	ad.role();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
	ad.submit();
	String alert=driver.findElement(By.xpath("//p[@class='fw-light fst-italic text-start text-danger']")).getText();
	System.out.println(alert);
	Assert.assertEquals(alert, ExpectedConstants.Expectectederror);
}
@Test(priority =10 )//validating role field in add user form
public void blankroleadduser() throws IOException
{
	ad=new Admin(driver);
	String Username = Excelutility.getData(0, 0);
	String Passwrd = Excelutility.getData(0, 1);
	//String ParentWindow=driver.getWindowHandle();
	ad.setusername(Username);
	ad.setpassword(Passwrd);
	ad.login();
	ad.adduser();
	String name = Excelutility.getData(0,11);
	String email = Excelutility.getData(0, 12);
	String username = Excelutility.getData(0, 13);
	String password = Excelutility.getData(0, 14);
	
	ad.username(name);
	ad.Email(email);
	ad.usname(username);
	ad.paswd(password);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
	ad.submit();
	String alert=driver.findElement(By.xpath("//p[@class='fw-light fst-italic text-start text-danger']")).getText();
	System.out.println(alert);
	Assert.assertEquals(alert, ExpectedConstants.Expectectederror1);
}

@Test(priority=11)//updating a userdetails in admin login
public void aduserupdate() throws IOException//update user in admin page
{
	ad=new Admin(driver);
	String Username = Excelutility.getData(0, 0);
	String Passwrd = Excelutility.getData(0, 1);
	
	ad.setusername(Username);
	ad.setpassword(Passwrd);
	ad.login();
	ad.userupdate();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
	ad.usernameupdate();
	String name=driver.findElement(By.xpath("(//td)[22]")).getText();
	System.out.println(name);
	Assert.assertEquals(name,ExpectedConstants.Expectectedname);
	//System.out.println("Updating a User shows the message as- Updated Successfully");
}
@Test(priority=12)//deleting a user in admin login
public void aduserdelete() throws IOException
{ad=new Admin(driver);
String Username = Excelutility.getData(0, 0);
String Passwrd = Excelutility.getData(0, 1);
//String ParentWindow=driver.getWindowHandle();
ad.setusername(Username);
ad.setpassword(Passwrd);
ad.login();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
ad.userdelete();
System.out.println("The delete button in admin page shows the message -Deleted Successfully");	
}

@Test(priority=13)
public void wTrainerlogin() throws IOException, InterruptedException//wrong trainer login
{
	tr=new Trainer(driver);
	String Username = Excelutility.getData(0, 2);
	tr.setusername(Username);
	tr.login();
	Thread.sleep(500);
	tr.scroll();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
	String alert1=driver.findElement(By.xpath("//small[text()='Password is required.']")).getText();
     System.out.println("For blank password in trainer login shows the message -"+alert1);
	Assert.assertEquals(alert1, ExpectedConstants.Expectedalert);
}
@Test(priority=14)
public void wtrainerlogin1() throws IOException, InterruptedException//wrong trainer login
{
	tr=new Trainer(driver);
	String Username = Excelutility.getData(0, 6);
	String Passwrd = Excelutility.getData(0, 7);
	tr.setusername(Username);
	tr.setpassword(Passwrd);
	tr.login();
	
	Thread.sleep(500);
	tr.scroll();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
	String alert=driver.findElement(By.xpath("//div[@class='fade alert alert-danger alert-dismissible show']")).getText();
	System.out.println("The wrong username and password for trainer login shows the message -"+alert);
	Assert.assertEquals(alert, ExpectedConstants.Expectedmsg);
}
@Test(priority=15)
public void trainerlogin() throws IOException//correct trainer login navigate to trainer page
{tr=new Trainer(driver);
String Username = Excelutility.getData(0, 2);
String Passwrd = Excelutility.getData(0, 3);
tr.setusername(Username);
tr.setpassword(Passwrd);
tr.login();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
String title=driver.findElement(By.xpath("//span[text()='Learners']")).getText();
System.out.println("The correct trainer login credentials navigate to the page with title- "+ title);

Assert.assertEquals(title, ExpectedConstants.Expectedtrainertitle);
}
@Test(priority=16)
public void usrformtitle() throws IOException//user add button navigate to learner form
{tr=new Trainer(driver);
String Username = Excelutility.getData(0, 2);
String Passwrd = Excelutility.getData(0, 3);
tr.setusername(Username);
tr.setpassword(Passwrd);
tr.login();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
	tr.learner();
String title=	driver.findElement(By.xpath("(//*[@class='container w-50 mt-5 pt-5  bg-secondary-subtle rounded']//h3)")).getText();
System.out.println("The learneradd button of trainer page navigate to the page with title- "+title);
Assert.assertEquals(title, ExpectedConstants.Expectedusraddtitle);
}
@Test(priority=17)
public void wlearntrainer() throws IOException//validating learnerid field in learner form
{tr=new Trainer(driver);
String Username = Excelutility.getData(0, 2);
String Passwrd = Excelutility.getData(0, 3);
tr.setusername(Username);
tr.setpassword(Passwrd);
tr.login();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
	tr.learner();
	//String learnerid=Excelutility.getData(0, 6);
	String name = Excelutility.getData(0,9);
	//tr.setlearnerid(learnerid);
	tr.setname(name);
	tr.course();
	tr.batch();
	tr.project();
	tr.coursestatus();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
	tr.submit();
	String alert=driver.findElement(By.xpath("//p[@class='fw-light fst-italic text-start text-danger']")).getText();
	System.out.println("If the learnerid kept blank in learner form shows the message -"+alert);
	Assert.assertEquals(alert,ExpectedConstants.Expectedalert1);
	
}
@Test(priority=18)
public void wnametrainer() throws IOException//validating name in learner form
{tr=new Trainer(driver);
String Username = Excelutility.getData(0, 2);
String Passwrd = Excelutility.getData(0, 3);
tr.setusername(Username);
tr.setpassword(Passwrd);
tr.login();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
	tr.learner();
	String learnerid=Excelutility.getData(0, 8);
	String name = Excelutility.getData(0,10);
	tr.setlearnerid(learnerid);
	tr.setname(name);
	tr.course();
	tr.batch();
	tr.project();
	tr.coursestatus();
	tr.submit();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
	String alert=driver.findElement(By.xpath("//p[@class='fw-light fst-italic text-start text-danger']")).getText();
	System.out.println("If numbers given in name field of learners form ,it shows the message -"+alert);
	Assert.assertEquals(alert,ExpectedConstants.Expectedalert2);
	
	
}
@Test(priority=19)
public void trainercourse() throws IOException//getting course in dropdown menu
{tr=new Trainer(driver);
String Username = Excelutility.getData(0, 2);
String Passwrd = Excelutility.getData(0, 3);
tr.setusername(Username);
tr.setpassword(Passwrd);
tr.login();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
	tr.learner();
	String learnerid=Excelutility.getData(0, 8);
	String name = Excelutility.getData(0,9);
	tr.setlearnerid(learnerid);
	tr.setname(name);
	//tr.coursename();
	String coursename=tr.coursename();
     System.out.println("Selected course: in learnerform -" +tr.coursename() );
     Assert.assertEquals(coursename, ExpectedConstants.Expectedcoursename);
     
}
@Test(priority=20)
public void trainerproject() throws IOException//getting project in dropdown menu
{tr=new Trainer(driver);
String Username = Excelutility.getData(0, 2);
String Passwrd = Excelutility.getData(0, 3);
tr.setusername(Username);
tr.setpassword(Passwrd);
tr.login();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
	tr.learner();
	String learnerid=Excelutility.getData(0, 8);
	String name = Excelutility.getData(0,9);
	tr.setlearnerid(learnerid);
	tr.setname(name);
	
	String projectname=tr.projectname();
     System.out.println("Selected project: in learner form -" +tr.projectname() );
     Assert.assertEquals(projectname, ExpectedConstants.Expectedproject);
     
}
@Test(priority=21)
public void trainerbatch() throws IOException//getting batch in dropdown menu
{tr=new Trainer(driver);
String Username = Excelutility.getData(0, 2);
String Passwrd = Excelutility.getData(0, 3);
tr.setusername(Username);
tr.setpassword(Passwrd);
tr.login();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
	tr.learner();
	String learnerid=Excelutility.getData(0, 8);
	String name = Excelutility.getData(0,9);
	tr.setlearnerid(learnerid);
	tr.setname(name);
	
	String batch=tr.batchname();
     System.out.println("Selected batch: in learner form -" +tr.projectname() );
     Assert.assertEquals(batch, ExpectedConstants.Expectedbatch);
     
}
@Test(priority=22)
public void coursestatus() throws IOException//getting course status in dropdown menu
{tr=new Trainer(driver);
String Username = Excelutility.getData(0, 2);
String Passwrd = Excelutility.getData(0, 3);
tr.setusername(Username);
tr.setpassword(Passwrd);
tr.login();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
	tr.learner();
	String learnerid=Excelutility.getData(0, 8);
	String name = Excelutility.getData(0,9);
	tr.setlearnerid(learnerid);
	tr.setname(name);
	
	String cs=tr.coursestatusname();
     System.out.println("Selected coursestatus: in learner form -  " +tr.coursestatusname() );
     Assert.assertEquals(cs, ExpectedConstants.Expectedcs);
     
}
@Test(priority=23)
public void learneradd() throws IOException//adding a learner
{tr=new Trainer(driver);
String Username = Excelutility.getData(0, 2);
String Passwrd = Excelutility.getData(0, 3);
tr.setusername(Username);
tr.setpassword(Passwrd);
tr.login();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
	tr.learner();
	String learnerid=Excelutility.getData(0, 8);
	String name = Excelutility.getData(0,9);
	tr.setlearnerid(learnerid);
	tr.setname(name);
	tr.course();
	tr.batch();
	tr.project();
	tr.coursestatus();
	tr.submit();
	String alert=driver.findElement(By.xpath("//div[text()='Posted successfully']")).getText();
	System.out.println("Adding a learner shows the message -"+alert);
	Assert.assertEquals(alert,ExpectedConstants.Expectedalert3);
	driver.findElement(By.xpath("//button[text()='OK']")).click();
	}

@Test(priority=24)//adding bulkdata in trainer login
	public void trainerbulkdata() throws IOException
	{tr=new Trainer(driver);
	String Username = Excelutility.getData(0, 2);
	String Passwrd = Excelutility.getData(0, 3);
	tr.setusername(Username);
	tr.setpassword(Passwrd);
	tr.login();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
	tr.bulkdata();
	tr.bulkdataupload();
	String msg=driver.findElement(By.xpath("//h2[@id='swal2-title']")).getText();
	System.out.println(msg);
	Assert.assertEquals(msg, ExpectedConstants.Expectedmsg1);
	driver.findElement(By.xpath("//button[@class='swal2-confirm swal2-styled']")).click();
	driver.findElement(By.xpath("//button[@class='swal2-confirm swal2-styled']")).click();	
	}
@Test(priority=25)
public void trainerbulkdatacancel() throws IOException
{tr=new Trainer(driver);
String Username = Excelutility.getData(0, 2);
String Passwrd = Excelutility.getData(0, 3);
tr.setusername(Username);
tr.setpassword(Passwrd);
tr.login();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
tr.bulkdata();
tr.bulkdatacancel();
String title=driver.findElement(By.xpath("//span[text()='Learners']")).getText();
System.out.println(title);
Assert.assertEquals(title,ExpectedConstants.Expectectedtitle1 );
	
}
@Test(priority=26)
public void traineredit() throws IOException//Edit button navigate to the edit page
{tr=new Trainer(driver);
String Username = Excelutility.getData(0, 2);
String Passwrd = Excelutility.getData(0, 3);
tr.setusername(Username);
tr.setpassword(Passwrd);
tr.login();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
	tr.update();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
	String titleofedit=driver.findElement(By.xpath("(//*[@class='container w-50 mt-5 pt-5  bg-secondary-subtle rounded']//h3)")).getText();
	System.out.println("The edit button of  trainer dashboard navigate to the page with title -"+titleofedit);
	Assert.assertEquals(titleofedit, ExpectedConstants.Expectedtitleupdate);
}
@Test(priority=27)
public void trainerupdatelearner() throws IOException//trainer details can be updated
{tr=new Trainer(driver);
String name;
String Username = Excelutility.getData(0, 2);
String Passwrd = Excelutility.getData(0, 3);
tr.setusername(Username);
tr.setpassword(Passwrd);
tr.login();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
tr.update();
tr.learnerupdate();

tr.submit();
String learnerid=driver.findElement(By.xpath("(.//td)[1]")).getText();
System.out.println(learnerid);
Assert.assertEquals(learnerid,ExpectedConstants. Expectectedlearnerid);

//System.out.println("Successful updation of trainer shows the message as- Updated Successfully");
}
@Test(priority=28)
public void trainerdelete() throws IOException//to delele a learner from trainer dashboard
{
	tr=new Trainer(driver);
	String name;
	String Username = Excelutility.getData(0, 2);
	String Passwrd = Excelutility.getData(0, 3);
	tr.setusername(Username);
	tr.setpassword(Passwrd);
	tr.login();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
	tr.trainerdelete();
	String message="Deleted Successfully";
	System.out.println("Successful deletion of learner dashboard shows the message -" +message);
}
@Test(priority=29)
public void wpoofficerlogin() throws InterruptedException, IOException//wrong placement officer login
{
	po=new Placementofficer(driver);
	String Username = Excelutility.getData(0, 4);
	po.setusername(Username);
	po.login();
	Thread.sleep(100);
	po.scroll();
	String alert2=driver.findElement(By.xpath("//small[text()='Password is required.']")).getText();
	System.out.println("Placement officer with blank password shows the message -"+alert2);
	Assert.assertEquals(alert2, ExpectedConstants.Expectedalert);
}
@Test(priority=30)
public void wplacementlogin1() throws IOException, InterruptedException//wrong placement officer login
{
	po=new Placementofficer(driver);
	String Username = Excelutility.getData(0, 6);
	String Passwrd = Excelutility.getData(0, 7);
	po.setusername(Username);
	po.setpassword(Passwrd);
	po.login();
	Thread.sleep(500);
	po.scroll();
	String alert=driver.findElement(By.xpath("//div[@class='fade alert alert-danger alert-dismissible show']")).getText();
	System.out.println("Wrong username and password in placement officer login shows the message -"+alert);
	Assert.assertEquals(alert, ExpectedConstants.Expectedmsg);
}
@Test(priority=31)
public void pologin() throws IOException//correct placement officerlogin to placement dashboard
{po=new Placementofficer(driver);
String Username = Excelutility.getData(0, 4);
String Passwrd = Excelutility.getData(0, 5);
po.setusername(Username);
po.setpassword(Passwrd);
po.login();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
String title=driver.findElement(By.xpath("//span[text()='Placement']")).getText();
System.out.println("The correct poofficer login credentials navigate to the page with title - "+title);


Assert.assertEquals(title ,ExpectedConstants.Expectectedtitle2);
	
}
@Test(priority=32)
public void pologinup() throws IOException//placementofficer update navigate to learner page
{po=new Placementofficer(driver);
String Username = Excelutility.getData(0, 4);
String Passwrd = Excelutility.getData(0, 5);
po.setusername(Username);
po.setpassword(Passwrd);
po.login();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
po.update();
String title=driver.findElement(By.xpath("(//*[@class='container w-50 mt-5 pt-5 bg-secondary-subtle rounded']//h3)")).getText();
System.out.println("The Update button of poofficer dashboard navigate to the page with title -"+title);
Assert.assertEquals(title, ExpectedConstants.Expectedupform);
	
}
@Test(priority=33)
public void poupform() throws IOException//placement status update
{
	po=new Placementofficer(driver);
	String Username = Excelutility.getData(0, 4);
	String Passwrd = Excelutility.getData(0, 5);
	po.setusername(Username);
	po.setpassword(Passwrd);
	po.login();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
	po.lrnform();
	String text=driver.findElement(By.xpath("(.//td)[15]")).getText();
	//alert.getText();
	System.out.println("PlacementStatus Updated Successfully and status is -" + text);
	Assert.assertEquals(text, ExpectedConstants.Expectedstatus);
}
@Test(priority=34)
public void pobachtodashboard() throws IOException//back to dashboard in learner form navigate to placement dashboard
{po=new Placementofficer(driver);
String Username = Excelutility.getData(0, 4);
String Passwrd = Excelutility.getData(0, 5);
po.setusername(Username);
po.setpassword(Passwrd);
po.login();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
	String navpage=driver.findElement(By.xpath("//th[text()='Placement Status']")).getText();
	System.out.println("The backtodashboard button in learnerform navigate to placementpage with title - "+navpage);
	Assert.assertEquals(navpage,ExpectedConstants.Expectednavtitle );
}

	
}





