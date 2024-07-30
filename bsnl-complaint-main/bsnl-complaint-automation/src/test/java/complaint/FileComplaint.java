package complaint;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class FileComplaint {
	WebDriver driver;
	@BeforeSuite
	public void driverSetup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@AfterSuite
	public void quitDriver() {
		driver.close();
	}
	
	
	@Test(invocationCount = 5000)
	public void fileComplaint() throws InterruptedException {
		// TODO Auto-generated method stub
		
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		driver.get("https://pgrms.bsnl.co.in/Complaint/CustomerComplaint");
		Thread.sleep(2000);
		
		List<String> complaints=new ArrayList<String>();
		complaints.add("This is worst possible service and support that can be provided");
		complaints.add("My internet has been slow since I got the connection");
		complaints.add("No body takes resposibility of the issue");
		complaints.add("It is a known issue and no action is taken by anyone");
		complaints.add("The complaints have no use since they are resolved without any action");
		complaints.add("SDO of Dehra is non functional");
		complaints.add("SDO Dehra does not pick calls and takes no action either");
		complaints.add("I only get calls from Dharamshala saying that the are forwarding to SDO Dehra and complaint gets resolved without any action");
		complaints.add("I am being told to reduce my plan rather than solving the issue");
		complaints.add("Department has failed to take any ownership of the issue");
		Random random = new Random();
        int randomNumber = random.nextInt(10);
		
		WebElement serviceSelect = driver.findElement(By.xpath("//*[@id='filter-service']"));
		Select serviceOption = new Select(serviceSelect);
		serviceOption.selectByValue("Broad Band");
		
		Thread.sleep(2000);
		WebElement natureOfGrief = driver.findElement(By.xpath("//*[@id='filter-comp-nature']"));
		Select griefOption = new Select(natureOfGrief);
		griefOption.selectByValue("5");
		
		WebElement customerName = driver.findElement(By.xpath("//*[@id='cust_name']"));
		
		customerName.sendKeys("Shubham Jadhav");
		WebElement customerAddress = driver.findElement(By.xpath("//*[@id='cust_address1']"));
		customerAddress.sendKeys("B702, Orabelle Soc., Ravet");
		WebElement landMark = driver.findElement(By.xpath("//*[@id='cust_address2']"));
		landMark.sendKeys("Near SB Patil School");
		
		WebElement state = driver.findElement(By.xpath("//*[@id='filter-state']"));
		Select stateOption = new Select(state);
		stateOption.selectByValue("MH");
		
		WebElement district = driver.findElement(By.xpath("//*[@id='filter-ba']"));
		Thread.sleep(2000);
		Select districtOption = new Select(district);
		districtOption.selectByVisibleText("PUNE");
		
		WebElement zipCode = driver.findElement(By.xpath("//*[@id='cust_pin']"));
		zipCode.sendKeys("412101");
		
		WebElement mobileContact = driver.findElement(By.xpath("//*[@id='cust_contact_mob']"));
		mobileContact.sendKeys("8600229526");
		
		WebElement email = driver.findElement(By.xpath("//*[@id='cust_email']"));
		email.sendKeys("d.jadhavshubham1647@gmail.com");
		
		WebElement grievanceNo = driver.findElement(By.xpath("//*[@id='grivno']"));
		grievanceNo.sendKeys("01970299193");
		
		WebElement issueMessage = driver.findElement(By.xpath("//*[@id='TextArea1']"));
		issueMessage.sendKeys(complaints.get(randomNumber));
		
		WebElement submitBtn = driver.findElement(By.xpath("//button[text()='Submit']"));
		jsExecutor.executeScript("arguments[0].click();", submitBtn);
		
		WebElement complaintMessage = driver.findElement(By.xpath("/html/body/div[1]/section/div[2]/div[2]/div/h5"));
		System.out.println(complaintMessage.getText());
		
	}
	
	
}
