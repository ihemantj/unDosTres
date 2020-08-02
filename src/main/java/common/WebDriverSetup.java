package common;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverSetup {

	WebDriver driver;
	
	public WebDriver createDriverInstance(final Browsers browserName) throws Exception {
		try {
			switch(browserName) {
			case FIREFOX:
				driver = getFireFoxDriver();
			break;
			case CHROME:
				driver = getChromeDriver();
			break;
			default:driver = null;
				break;
				} 
		} catch(Exception e) {
			throw e;
		}
		return driver;
	}
	
	private static WebDriver getFireFoxDriver() {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\geckodriver.exe");
		return new FirefoxDriver();
	}
	
	private static WebDriver getChromeDriver() {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\src\\test\\resources\\chromedriver_84.exe");
		return new ChromeDriver();
	}
}
