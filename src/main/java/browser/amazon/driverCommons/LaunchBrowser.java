package browser.amazon.driverCommons;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import browser.amazon.parser.jsonParser;
import browser.utils.OSFinder;

public class LaunchBrowser extends jsonParser {
	
	
	private static final Logger LOGGER = Logger.getLogger(LaunchBrowser.class.getName());
	private String currentDirectory = System.getProperty("user.dir");
	
	public WebDriver launchBrowser() throws InterruptedException {
		WebDriver driver = null;
		//Method to load config file
		parseJsonFile();
		String browserName = getBrowserName().trim();
		
		// Method to check the framework supported browser
		checkSupportedBrowser(browserName);
		
		// Method to set the driver property
		setDriverPath(browserName);
		
		if(BrowserName.CHROME.toString().equalsIgnoreCase(browserName)) {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("UNHANDLED_PROMPT_BEHAVIOUR", "accept");
			ChromeOptions options = new ChromeOptions();
			options.merge(capabilities);
			driver = new ChromeDriver(options);
	       
		}else if (BrowserName.FIREFOX.toString().equalsIgnoreCase(browserName)) {
			FirefoxOptions options = new FirefoxOptions();
			options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.IGNORE);
			options.setAcceptInsecureCerts(true);
			driver = new FirefoxDriver(options);
			
		}else if (BrowserName.HEADLESS.toString().equalsIgnoreCase(browserName)) {
			
			ChromeOptions options = new ChromeOptions();
            options.addArguments("headless");
            driver = new ChromeDriver(options);
			
		}
		
		
		
		driver.get(getAppUrl());
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
		
	}
	
	
	
	/**
	 * Method to check the given browser name is available in the supported browser list
	 * 
	 * @param browserName 
	 * 
	 */
	public void checkSupportedBrowser(String browserName) {
		try {
			BrowserName.valueOf(browserName);
		} catch (IllegalArgumentException e) {
			
			LOGGER.info( "  Actual browser name is "+ browserName + "\n	Expected browserName is one of the following  "+Arrays.toString(BrowserName.values()));
			
			throw e;
		}
	}
	
	/**
	 *  Method to set the driver property based on the operating system and browser;
	 *  
	 * @param browserName
	 * 
	 * @return driver path
	 */
	public String setDriverPath(String browserName) {
		String driverPath =null;
		if(BrowserName.CHROME.toString().equalsIgnoreCase(browserName) || BrowserName.HEADLESS.toString().equalsIgnoreCase(browserName) ) {
			if(OSFinder.isWindows()) {
				driverPath = currentDirectory + "/src/main/resources/browserDriver/chromedriver.exe";
				
			}else if (OSFinder.isMac()) {
				driverPath = currentDirectory + "/src/main/resources/browserDriver/chromedriver";
			}
			
			System.setProperty("webdriver.chrome.driver",driverPath );
	         
		}else if (BrowserName.FIREFOX.toString().equalsIgnoreCase(browserName)) {
			
			if(OSFinder.isWindows()) {
				driverPath = currentDirectory + "/src/main/resources/browserDriver/geckodriver.exe";
				
			}else if (OSFinder.isMac()) {
				driverPath = currentDirectory + "/src/main/resources/browserDriver/geckodriver";
			}
			
			System.setProperty("webdriver.gecko.driver",driverPath );
		}
		
		return driverPath;
	}
	
	public static void main(String[] args)   {
		LaunchBrowser bd = new LaunchBrowser();
		try {
			bd.launchBrowser();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
