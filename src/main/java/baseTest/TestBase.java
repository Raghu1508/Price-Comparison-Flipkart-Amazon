package baseTest;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import Library.SmallCommon;
import Utility.LoggerWrapper;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static LoggerWrapper log = null;
	public static SmallCommon objSmallCommon;
	
	 public TestBase() {
		// TODO Auto-generated constructor stub
		
	}
	
	
	@BeforeSuite(alwaysRun = true)
	public void initializeVar() {	
	WebDriverManager.chromedriver().setup();
	 driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 log = new LoggerWrapper(TestBase.class);
	 objSmallCommon = new SmallCommon();
	}
	
	
	@AfterSuite
	public void closeBrowser()
	{
		driver.manage().deleteAllCookies();
		driver.quit();
	}
	
	
	
	
}
