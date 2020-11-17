package BusinessFunction;

import Library.SmallCommon;
import baseTest.TestBase;
import pageClass.AmazonPages;

public class AmazonFunction extends TestBase
{
		AmazonPages objAmazonPages;
		SmallCommon objSmallCommon;
		
		public AmazonFunction()
		{
			objAmazonPages = new AmazonPages();
			objSmallCommon = new SmallCommon();
		}
		
		public void navigateToAmazon()
		{
			driver.get("https://www.amazon.in/");
		}
		
		public void searchProduct(String ProdName)
		{
			objAmazonPages.enterProductOnSearchBox(ProdName);
			objAmazonPages.clickOnSearchIcon();
		}
		
		
		public void selectProd(String flipKartprodName)
		{
			objAmazonPages.getAllProduct(flipKartprodName);
		}
		
		public float FetchPrice()
		{
			objSmallCommon.navigateAndTakeControlToNewTab(1);
			String price = objAmazonPages.fetchProductPrice();
			
			  return objSmallCommon.trimSpaceAndRsSymbol(price);
			  
		}
		
		
		public void addToCart()
		{
			objAmazonPages.clickOnAddToCartAmazon();
			objAmazonPages.navigateToCartPage();
			objAmazonPages.getProductPriceAmazon();
		}
		
		
		
		
}
