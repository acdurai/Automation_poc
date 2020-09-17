package com.amazon;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import browser.SearchAndBuyProduct;
import browser.amazon.driverCommons.LaunchBrowser;




public class ShoppingCartTest extends LaunchBrowser
{
    public WebDriver driver = null;
    public SearchAndBuyProduct search;
    
    @BeforeTest
    public void setUp() {
    	try {
			driver = launchBrowser();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	search = new SearchAndBuyProduct();
    	
    }
	
	@Test
    public void shoppingCart() throws InterruptedException {
        search.searchProduct(driver);
    
    Assert.assertEquals(search.productDetails, search.cartScreen_roductDetails);
    Assert.assertEquals(search.priceDetails, search.cartScreen_priceDetails);

    
 
        
    }
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
