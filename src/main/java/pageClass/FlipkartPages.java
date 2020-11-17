package pageClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseTest.TestBase;

public class FlipkartPages extends TestBase{
	
	
	 public FlipkartPages()
	{
		
		 PageFactory.initElements(driver, this);
		
	}
	 
	 @FindBy(xpath = "//button[@class='_2KpZ6l _2doB4z']")
	 private WebElement closeLoginModule;

	 @FindBy(xpath = "//input[@title='Search for products, brands and more']")
	 private WebElement searchBar;
	 
	 @FindBy(xpath = "//button[@type='submit']")
	 private WebElement searchButtonOnSearchBar;
	 
	 @FindBy(xpath = "((//a[@class='_1fQZEK'])[1]/div[2])/div[1]/div[1]")
	 private WebElement clickOnFirstProduct;
	 
	 @FindBy(xpath =  "//span[@class='B_NuCI']")
	 private WebElement verifyProductNameElement;
	 
	 @FindBy(xpath = "//div[@class='_30jeq3 _16Jk6d']")
	 private WebElement getPriceOfProductElement;
	 
	 @FindBy(xpath = "//button[normalize-space()='ADD TO CART']")
	 private WebElement clickOnAddToCartButtonElement;
	 
	 @FindBy(xpath = "//button[normalize-space()='+']")
	 private WebElement addingOneMoreElementtoQuantityElement;
	 
	 @FindBy(xpath = "//div[normalize-space()='Total Amount']/../../div/span/div/div/span")
	 private WebElement cartPrice;
	 
	 
	 public void closingLoginModule()
	 {
		// waitforElement((By) closeLoginModule,10);
		 objSmallCommon.waitforElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"), 30);
		 closeLoginModule.click();
	 }
	 
	 
	 public void clickingonSearchBar(String ProductName)
	 {
		 searchBar.sendKeys(ProductName);
		 log.info("Entering the Product Name");
	 }
	 
	 public void clickOnSearchButton()
	 {
		 searchButtonOnSearchBar.click();
	 }
	 
	 public void ClickingOnFirstProduct()
	 {
		 objSmallCommon.waitforElement((By.xpath("((//a[@class='_1fQZEK'])[1]/div[2])/div[1]/div[1]")) ,10);
		 clickOnFirstProduct.click();
	 }
	 
	 
	 
	 public String fetchProductNameElement()
	 {
			 
		 objSmallCommon.waitforElement((By.xpath("//span[@class='B_NuCI']")) , 10);
		 
		 return verifyProductNameElement.getText();
	 }
	 
	 public String getProductPrice()
	 {
		 return getPriceOfProductElement.getText();

	 }
	 
	 public void clickingOnAddToCartButton()
	 {
		 clickOnAddToCartButtonElement.click();
	 }
	 
	 public void increasingQuantity()
	 {
		 objSmallCommon.waitforElement((By.xpath("//button[normalize-space()='+']")) , 10);
		 addingOneMoreElementtoQuantityElement.click();
	 }
	 
	 public String getCartPrice()
	 {
	 return cartPrice.getText();
	 }
	 
	
	 
	 
}
