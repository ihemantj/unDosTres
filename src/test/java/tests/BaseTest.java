package tests;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.testng.annotations.*;
import org.testng.log4testng.Logger;

import common.Browsers;
import common.Utilities;
import common.WebDriverSetup;

public class BaseTest {
	
	protected WebDriver driver;
	protected Utilities utils;
	static Logger LOG = Logger.getLogger(BaseTest.class);

	@BeforeSuite
	public void suiteSetup() {
		initWebDriver();
	}
	
	private void initWebDriver() {
		try {
			driver = new WebDriverSetup().createDriverInstance(Browsers.CHROME);
		}catch(Exception e){
			
		}
		utils = new Utilities(driver);
	}
	
	@BeforeClass
	public void classSetup() {
		
		launchApp();
	}
	
	private void launchApp() {
		Properties props = Utilities.getProperties(System.getProperty("user.dir") + "\\src\\test\\resources\\data2.properties");
		driver.get(props.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	@AfterSuite
	public void  tearDown() {
		driver.quit();
	}
}
