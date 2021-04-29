package MvnPack2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Repo_Demo {
	
	ExtentReports exRepo;
	 ExtentTest exTest;
	
	@Test
	public void testOmayo()
	{
		 exRepo = ExtentFileDemo.getInstance();
	     exTest =	exRepo.startTest("Start Test");
		System.setProperty("webdriver.chrome.driver", "Drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		exTest.log(LogStatus.INFO, "chrome browser launched");
		driver.manage().window().maximize();
		exTest.log(LogStatus.INFO, "Browser got maximized");
		driver.get("http://www.omayo.blogspot.com");
		exTest.log(LogStatus.INFO, "url launched");
		String ExpectedText = "PracticeAutomationHere";
		String ActualText = driver.findElement(By.id("pah")).getText();
		if (ActualText.equals(ExpectedText))
		{
		System.out.println("Match Done");
		exTest.log(LogStatus.PASS, "condition passed");
		}
		else {
			System.out.println("No Match Happened");
			exTest.log(LogStatus.FAIL, "condition failed");
		}
	}
  
	  @AfterMethod
	  public void testClosure()
	  {
		  exRepo.endTest(exTest);
		  exRepo.flush();
	  }
}
