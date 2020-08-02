package common;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.tools.javac.util.Assert;

import common.Constants.Timeouts;

public class Utilities {

	private final WebDriver driver;
	
	public Utilities(WebDriver driver) {
		this.driver=driver;
	}
	
	public void sendKeys(final WebElement element, final Keys keys) throws Exception {
		if(!isClickable(element)) {
			throw new Exception("element not enabled");
		}
		element.sendKeys(keys);
	}
	
	public boolean isClickable(final WebElement element) {
		try {
			if(element == null) {
				return false;
			}
			driver.manage().timeouts().implicitlyWait(Constants.Timeouts.LOW, TimeUnit.SECONDS);
			final WebElement we = new WebDriverWait(driver, Timeouts.HIGH).until(ExpectedConditions.elementToBeClickable(element));
			return we!=null;
		} catch(Exception e) {
			return false;
		}
	}
	
	public boolean webDriverWait(final ExpectedCondition<?> exp, final long wait) {
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			new WebDriverWait(driver, wait).until(exp);
		} catch(Exception e) {
			return false;
		}
		return true;
		}
	
	public static void sync(final float secondsToWait) {
		try {
			Thread.sleep(Math.round(secondsToWait*1000));
		} catch(final InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
	
	public static Properties getProperties(final String file) {
		final Properties props = new Properties();
		try {
			props.load(new FileReader(file));
		}catch(Exception e) {
			Assert.error();
		}
		return props;
	}
}
