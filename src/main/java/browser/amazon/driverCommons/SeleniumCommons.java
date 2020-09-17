package browser.amazon.driverCommons;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumCommons {
	
	/**
	 *  Method to wait to given amount time to check the condition satisfies
	 *  
	 * @param driver - webdriver object
	 * 
	 * @param by - element locator type
	 */
	public void  waitForElementPresent(WebDriver driver,By by) {
		try {
	        WebDriverWait wait = new WebDriverWait(driver, 30);

	        ExpectedCondition<Boolean> expectation;   
	        expectation = new ExpectedCondition<Boolean>() {

	            public Boolean apply(WebDriver driverjs) {

	                JavascriptExecutor js = (JavascriptExecutor) driverjs;
	                return js.executeScript("return((window.jQuery != null) && (jQuery.active === 0))").equals("true");
	            }
	        };
	        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	    }       
	    catch (WebDriverException e) {

	       throw new WebDriverException("Given element "+ by + " is not visible in 30 seconds ");
	    }
	}
	
	/**
	 *  Method to return the web element(object) for the given xpath
	 *  
	 * @param driver - webdriver object
	 * 
	 * @param path - element locator type
	 */
	public WebElement findElementByXpath(WebDriver driver,String path) {
		
		waitForElementPresent(driver, By.xpath(path));
		WebElement ele = driver.findElement(By.xpath(path));
		return ele;
		
	}
	
	/**
	 * 
	 * Method to return the list of web element(object) for the given xpath
	 * 
	 @param driver - webdriver object
	 * 
	 * @param path - element locator type
	 * 
	 * @return
	 */
	public List<WebElement> findElementsByXpath(WebDriver driver,String path) {
		
		waitForElementPresent(driver, By.xpath(path));
		List<WebElement> ele = driver.findElements(By.xpath(path));
		return ele;
		
	}
	
	/**
	 * 
	 * Method to return the web element(object) for the given id
	 * 
	 @param driver - webdriver object
	 * 
	 * @param path - element locator type
	 * 
	 * @return
	 */
	public WebElement findElementByID(WebDriver driver,String path) {
			
			waitForElementPresent(driver, By.id(path));
			WebElement ele = driver.findElement(By.id(path));
			return ele;
			
		}
	
	/**
	 * 
	 * Method to return the list of web element(object) for the given id
	 * 
	 @param driver - webdriver object
	 * 
	 * @param path - element locator type
	 * 
	 * @return
	 */
	public List<WebElement> findElementsByID(WebDriver driver,String path) {
			
			waitForElementPresent(driver, By.id(path));
			List<WebElement> ele = driver.findElements(By.id(path));
			return ele;
			
		}
	
	/**
	 * 
	 * Method to return the  web element(object) for the given name
	 * 
	 @param driver - webdriver object
	 * 
	 * @param path - element locator type
	 * 
	 * @return
	 */
	public WebElement findElementByName(WebDriver driver,String path) {
			
			waitForElementPresent(driver, By.name(path));
			WebElement ele = driver.findElement(By.name(path));
			return ele;
			
	}
	/**
	 * 
	 * Method to return the list of web element (object) for the given name
	 * 
	 @param driver - webdriver object
	 * 
	 * @param path - element locator type
	 * 
	 * @return
	 */
	public List<WebElement> findElementsByName(WebDriver driver,String path) {
		
		waitForElementPresent(driver, By.name(path));
		List<WebElement> ele = driver.findElements(By.name(path));
		return ele;
		
	}
	
	/**
	 * Method to click the element with given element locator
	 * 
	 * @param driver - webdriver object
	 * 
	 * @param path - element locator type
	 */
	public void clickElementByXpath(WebDriver driver, String path) {
		findElementByXpath(driver, path).click();
	}
	
	/**
	 * Method to click the element with given element locator
	 * 
	 * @param driver - webdriver object
	 * 
	 * @param path - element locator type
	 */
	public void clickElementByID(WebDriver driver, String path) {
		findElementByID(driver, path).click();
	}
	
	/**
	 * Method to click the element with given element locator
	 * 
	 * @param driver - webdriver object
	 * 
	 * @param path - element locator type
	 */
	public void clickElementByName(WebDriver driver, String path) {
		findElementByName(driver, path).click();
	}
	
	/**
	 * Method to the enter the value in the text field using xpath
	 * 
	 * @param driver - webdriver object
	 * 
	 * @param path - element locator type
	 * 
	 * @param text - values to enter in the textfield
	 */
	public void setValueByXpath(WebDriver driver, String path, String text) {
		findElementByXpath(driver, path).sendKeys(text);
	}
	
	/**
	 * Method to the enter the value in the text field using ID
	 * 
	 * @param driver - webdriver object
	 * 
	 * @param path - element locator type
	 * 
	 * @param text - values to enter in the textfield
	 */
	public void setValueByID(WebDriver driver, String path, String text) {
		findElementByID(driver, path).sendKeys(text);
	}
	
	/**
	 * Method to the enter the value in the text field using name
	 * 
	 * @param driver - webdriver object
	 * 
	 * @param path - element locator type
	 * 
	 * @param text - values to enter in the textfield
	 */
	public void setValueByName(WebDriver driver, String path, String text) {
		findElementByName(driver, path).sendKeys(text);
	}

}
