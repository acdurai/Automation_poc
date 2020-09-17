package browser;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import browser.amazon.driverCommons.SeleniumCommons;
import browser.amazon.parser.ExcelParser;
import browser.locators.SearchProductLocators;

public class SearchAndBuyProduct extends SeleniumCommons {
	public String searchKeyWord ;
	public String productDetails;
	public String priceDetails;
	public String cartScreen_roductDetails;
	public String cartScreen_priceDetails;
	public String loginSceen_label;
	
	public void getsearchData(){
		ExcelParser ep = new ExcelParser();
		ep.parseXLS("TestData.xlsx");
		searchKeyWord = ep.getCellData("Search_Product", "Search_keyword", "TVBrand1");
		System.out.println();
	}
	public void searchProduct(WebDriver driver) throws InterruptedException {
		getsearchData();
		
		waitForElementPresent(driver, By.xpath(SearchProductLocators.homeScreen_label));
		setValueByXpath(driver, SearchProductLocators.search_textfield, searchKeyWord);
		clickElementByXpath(driver, SearchProductLocators.search_button);
		
		
		waitForElementPresent(driver, By.xpath(SearchProductLocators.select_product));
		clickElementByXpath(driver, SearchProductLocators.select_product);
		
		//window handels
		ArrayList tabs = new ArrayList (driver.getWindowHandles());
		
		//Use the list of window handles to switch between windows
		driver.switchTo().window(tabs.get(1).toString());
		productDetails = findElementByXpath(driver, SearchProductLocators.getProduct_deatils).getText();
		priceDetails = findElementByXpath(driver, SearchProductLocators.getPriceDeatils).getText().replaceAll("₹", "").trim();
		
		clickElementByXpath(driver, SearchProductLocators.addToCart_button);
		try {
			clickElementByXpath(driver, SearchProductLocators.cart_button);
		} catch (WebDriverException e) {
			clickElementByXpath(driver,SearchProductLocators.cart_button1);
		}
		
		cartScreen_roductDetails = findElementByXpath(driver, SearchProductLocators.cartScreen_productDetails).getText();
		cartScreen_priceDetails = findElementByXpath(driver, SearchProductLocators.cartScreen_priceDetails).getText().trim();
		
	}
	

}
