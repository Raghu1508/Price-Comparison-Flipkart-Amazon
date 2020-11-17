package uiScripts;


import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BusinessFunction.AmazonFunction;
import BusinessFunction.FlipkartFunction;
import Library.SmallCommon;
import baseTest.TestBase;

public class TestScripts extends TestBase{
	FlipkartFunction objFlipkartFunction;
	AmazonFunction objAmazonFunction;
	SmallCommon objSmallCommon;
	
	@BeforeSuite(alwaysRun = true)
	public void beforeSuite()
	{
		objFlipkartFunction = new FlipkartFunction();
		objAmazonFunction = new AmazonFunction();
		objSmallCommon = new SmallCommon();
	}
	
	@Test(priority = 0 , description = "Validate Product Search and add to cart feature on flipkart") 
	public void firstTestCase()
	{
		objFlipkartFunction.navigateToFlipkart();
		objFlipkartFunction.searchProduct("Apple iPhone XR (Yellow, 64 GB)");
		String prodName = objFlipkartFunction.verifyProductSelection();
		System.out.println("Product Name"+ prodName);
		Float prodPrice = objFlipkartFunction.fetchProductPrice();
		System.out.println("Product Price"+prodPrice);
		objFlipkartFunction.addProductToCart();
	}
	
	@Test (priority = 1 , description = "Validate Product Search and add to cart feature on flipkart & Amazon")
	public void secondTestCase()
	{
		objFlipkartFunction.navigateToFlipkart();
		objFlipkartFunction.searchProduct("samsung galaxy tab");
		String flipKartProductName = objFlipkartFunction.verifyProductSelection();
		Float flipkartProdPrice = objFlipkartFunction.fetchProductPrice();
		System.out.println("Flipkrt prod price" +flipkartProdPrice);
		
		objAmazonFunction.navigateToAmazon();
		objAmazonFunction.searchProduct("samsung galaxy tab");
		objAmazonFunction.selectProd(flipKartProductName);
		Float amazonProdPrice = objAmazonFunction.FetchPrice();	
		System.out.println("Amzon Prod Price " +amazonProdPrice);
		
		objSmallCommon.comparePrices(flipkartProdPrice,amazonProdPrice);
	}
	

}
