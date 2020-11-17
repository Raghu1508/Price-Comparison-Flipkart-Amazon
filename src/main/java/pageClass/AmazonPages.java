package pageClass;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseTest.TestBase;

public class AmazonPages extends TestBase {
	public AmazonPages()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "twotabsearchtextbox")
	private WebElement searchboxElement;
	
	@FindBy(id = "nav-search-submit-text")
	private WebElement clickOnSearchIconElement;
	
	@FindBy(xpath = "//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']/a")
	private List<WebElement> fetchAllProducts;

	@FindBy(xpath = "//span[@id='priceblock_ourprice']")
	private WebElement getProductPriceElement;
	
	@FindBy(id = "add-to-cart-button")
	private WebElement addToCartButtonElement;
	
	@FindBy(id = "hlb-view-cart-announce")
	private WebElement cartPageElement;
	
	@FindBy(id= "sc-subtotal-amount-activecart")
	private WebElement getAmazonFinalPriceElement;
	
	public void enterProductOnSearchBox(String prodName)
	{
		searchboxElement.sendKeys(prodName);
		log.info("Entering the Product Name");
	}
	
	public void clickOnSearchIcon()
	{
		clickOnSearchIconElement.click();
	}
	
	public void getAllProduct(String flipKartprodName)
	{
		selectProd(flipKartprodName);
		
//		for(WebElement wbElement : fetchAllProducts)
//		{
//			System.out.println(wbElement.getText());
//			
//			if(flipKartprodName.contains(wbElement.getText().substring(0, 10))) {
//			
//			
//				wbElement.click();
//				break;
//			}
//		}
	}
	
	public void selectProd(String flipKartprodName)
    {
    	String[] arr = flipKartprodName.split(" ");
    	int[] productCount = new int[fetchAllProducts.size()];
//    	HashMap<String, List<Integer>> map= new HashMap<String, List<Integer>>();
    	
    	for(int i=0;i<arr.length;i++)
    	{
//    		System.out.println("iin");
    		int count =0;
    		for(WebElement wbElement : fetchAllProducts)
    		{
    			if(wbElement.getText().contains(arr[i])) {
    				if (i <= 7) {    					
    					productCount[count] += (arr.length - i)*2; 
    				} else {
    					productCount[count]++;
    				}
//    				switch (i) {
//    				case 0 : productCount[count] += 20;
//    				break;
//    				case 1 : productCount[count] += 15;
//    				break;
//    				case 2 : productCount[count] += 10;
//    				break;
//    				case 3 : productCount[count] += 5;
//    				break;
//    				default : productCount[count] += 1;
//    				break;
//    				}
    			
//    			System.out.println(productCount[count] +" " + productCount.toString());
    				//wbElement.click();
//    				break;
    			}
    			count++;
    		}	
    	}
    	System.out.println(productCount.toString());
    	int max = productCount[0];
    	int maxIndex = 0;
    	for(int j=0;j<productCount.length;j++)
    	{
    		if(max<productCount[j])
    		{
    			max = productCount[j];
    			maxIndex = j;
    		}
    	}
    	WebElement wb = fetchAllProducts.get(maxIndex);
    	wb.click();
    }
	
	public String fetchProductPrice()
	{
		return getProductPriceElement.getText();
//		prodPrice = prodPrice.replaceAll("[₹,]","");
//		 float cartFloatPrice = Float.parseFloat(prodPrice);
//		 log.info("Fetching the Product price from the product description page ");
//		 return cartFloatPrice;
	 }
	
	public void clickOnAddToCartAmazon()
	{
		addToCartButtonElement.click();
	}
	
	public void navigateToCartPage()
	{
		cartPageElement.click();
	}
	
	public float getProductPriceAmazon()
	{
		String prodFinalPrice = getAmazonFinalPriceElement.getText();
		prodFinalPrice = prodFinalPrice.replaceAll("[₹,]","");
		float finalAmazonPrice = Float.parseFloat(prodFinalPrice);
		log.info("Fetching the Product price from the Cart page ");
		return finalAmazonPrice;
	}
	
	
	
	
	
}
