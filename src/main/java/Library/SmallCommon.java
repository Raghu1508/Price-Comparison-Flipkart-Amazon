package Library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseTest.TestBase;

public class SmallCommon extends TestBase{


	   private WebDriverWait wait;

	    protected void waitForElementToAppear(By locator, int seconds) {
	    	 wait = new WebDriverWait(driver,seconds);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	        
	    }
	    
	    public void navigateAndTakeControlToNewTab(int tabNumber)
	    {
	    	ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
		    driver.switchTo().window(tabs1.get(tabNumber+1));
	    }
	    
	    public float trimSpaceAndRsSymbol(String price)
	    {
	    	 price = price.replaceAll("[₹,]","");
			 float cartFloatPrice = Float.parseFloat(price);
			 log.info("Fetching the Product price from the product description page ");
			 return cartFloatPrice;
	    	
	    }
	    
	    public void waitforElement(By locator,long seconds)
		{
			 wait = new WebDriverWait(driver,seconds);
		        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		}
	    
	    public void comparePrices(float flipPrice,float amazePrice)
	    {
	    	if(flipPrice > amazePrice)
	    	{
	    		System.out.println("Product is cheaper on Amazon");
	    	}
	    	else if(amazePrice > flipPrice)
	    	{
	    		System.out.println("Product is cheaper on Flipkart");
	    	}
	    	else
	    	{
	    		System.out.println("Product has same price on both the application");
	    	}
	    }
	    
	    
}
