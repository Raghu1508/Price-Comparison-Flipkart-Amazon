package baseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample {
static WebDriver driver;
	
	@Test
	public void test1()
	{
		System.out.println("Hello World");
		
	}
	
	@Test
	public void first()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='_32LSmx']/../../div/button")));
		driver.findElement(By.xpath("//div[@class='_32LSmx']/../../div/button"));
		
		
		
		
		
	}
}
