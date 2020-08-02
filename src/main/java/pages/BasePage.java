package pages;

import org.openqa.selenium.WebDriver;

import common.Utilities;

public class BasePage {
	
	protected WebDriver driver;
	protected Utilities utils;
	
	public BasePage switchToThisWindow() {
		final String handle = driver.getWindowHandle();
		driver.switchTo().window(handle);
		return this;
	}

}