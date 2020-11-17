package uiScripts;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.w3c.dom.Text;

import baseTest.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;

public class FirstTestCase extends TestBase {
	
//	WebDriver driver;
	String prodName ;
	JSONObject jsFlipKart = new JSONObject();
	JSONObject jsAmazon = new JSONObject();
	
	@Test (priority = 0)
	public float flipkartTest()
	{
    
       
		
//		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		
		driver.manage().window().maximize();
		
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='_32LSmx']/../../div/button")));
		
		driver.findElement(By.xpath("//div[@class='_32LSmx']/../../div/button")).click();;
		
		driver.findElement(By.xpath("//input[@title='Search for products, brands and more']")).sendKeys("samsung galaxy tab");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("((//div[@class='_1HmYoV _35HD7C'])[2]//div[@class='_1UoZlX'])[1]//a")));
		
		driver.findElement(By.xpath("((//div[@class='_1HmYoV _35HD7C'])[2]//div[@class='_1UoZlX'])[1]//a")).click();
		
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
		
	    wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[@class='_35KyD6']")));
	    
	    prodName = driver.findElement(By.xpath("//span[@class='_35KyD6']")).getText();
		
	    
	    
		String price  = driver.findElement(By.xpath("//div[@class='_1vC4OE _3qQ9m1']")).getText();
		
		price= price.replaceAll("[₹,]","");
		System.out.println(price);
		
		
		driver.findElement(By.xpath("//button[normalize-space()='ADD TO CART']")).click();
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//button[normalize-space()='+']")));
		
		driver.findElement(By.xpath("//button[normalize-space()='+']")).click();
		
		String CartPrice = driver.findElement(By.xpath("//div[normalize-space()='Total Amount']/../../div/span/div/div/span")).getText();
		
		CartPrice= CartPrice.replaceAll("[₹,]","");
		System.out.println(CartPrice);
	
		System.out.println(prodName);
	
		jsFlipKart.put("Product Price",price);
		jsFlipKart.put("ProductName",prodName);
		jsFlipKart.toString();
		
		//driver.quit();
		float flipPrice = Float.parseFloat(price);
		
		return flipPrice;
	}
	
	@Test (priority = 1)
	public float amazonTest() {

		float flipkartAmount = flipkartTest();
		
		driver.get("https://www.amazon.in/");
		
		
		
		driver.manage().window().maximize();
		String prod1 = (String) jsFlipKart.get("ProductName");
		
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("samsung galaxy tab");
		
		driver.findElement(By.id("nav-search-submit-text")).click();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		List<WebElement> listOfProducts = driver.findElements(By.xpath("//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']/a"));
		
		for(WebElement wbElement : listOfProducts)
		{
			System.out.println(wbElement.getText());
			
			if(wbElement.getText().contains(prod1))
			{
				wbElement.click();
				break;
			}
		}
		
		//driver.findElement(By.xpath("(//a[@class='a-link-normal a-text-normal'])[1]")).click();
		
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
		String amazonPrice = driver.findElement(By.xpath("//td[@id='priceblock_dealprice_lbl']/../td[2]/span[@id='priceblock_dealprice']")).getText();
		amazonPrice = amazonPrice.replaceAll("[₹,?]", "").trim();
		
		
		System.out.println("Price from the product page "+amazonPrice);
		
		driver.findElement(By.id("add-to-cart-button")).click();
		driver.findElement(By.id("add-to-cart-button")).click();
		
		driver.findElement(By.id("hlb-view-cart-announce")).click();
		
		String cartPrice = driver.findElement(By.id("sc-subtotal-amount-activecart")).getText();
		
		
		System.out.println("Price from the cart price " +cartPrice );	
		
		
		jsAmazon.put("Product Price", amazonPrice);
		
		float amazePrice = Float.parseFloat(amazonPrice);
		int cartPr = Integer.parseInt(cartPrice);
		return amazePrice;
		
	}
	
//	@Test
//	public void comparePrices()
//	{
//		float flipKartPrice = firstTestCase();
//		float amazonPrice = amazonTest();
//		
//		if(flipKartPrice>amazonPrice)
//		{
//			System.out.println("Flipkart is cheaper");
//		}
//		else if(flipKartPrice<amazonPrice)
//		{
//			System.out.println("Amazon is cheaper");
//		}
//		else {
//			System.out.println("Both have same price ");
//		}
//		
//	}
//	
	
}
