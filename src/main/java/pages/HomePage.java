package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import common.Utilities;

public class HomePage extends BasePage {

	protected final By homePageIcon = By.cssSelector("img[id='undostres_logo']");
	protected final By operatorField = By.cssSelector("input[suggest='mobile-operator']");
	protected final By mobileNumField = By.xpath("//input[@type='tel'][@oninput='checkMob(this)']");
	protected final By amountField = By.xpath("//input[@suggest='mobile-operator_amount']");
	protected final By proceedButton = By.xpath("//div[@class='box menuitem '][@to-do='mobile']//button[@perform='payment']");
	
	public HomePage(final WebDriver driver) {
		this.driver=driver;
		utils = new Utilities(driver);
	}
	
	public boolean isHomePageLoaded() {
		if(driver.findElement(homePageIcon)!=null)
		{
			return true;
		}
		else return false;
	}
	
	
	public void setOperator(String strOperator) {
		 driver.findElement(operatorField).click();
		 By operatorList = By.xpath("//li[@data-show='" + strOperator + "']");
	     driver.findElement(operatorList).click();
	}
	
	public void setMobileNumber(String strMobileNumber) {
		driver.findElement(mobileNumField).sendKeys(strMobileNumber);
	}
	
	public void setAmount(String strAmount) {
		driver.findElement(amountField).click();
		 By amountList = By.xpath("//li[@data-show='$" + strAmount + " (Recarga Saldo)']");
	     driver.findElement(amountList).click();
	}
	
	public void clickProceed() {
		driver.findElement(proceedButton).click();
	}
	
	public void enterRechargeAmount(String strOperator,String strMobileNumber,String strAmount){

        //Fill Operator
		this.setOperator(strOperator);

        //Fill Mobile Number
        this.setMobileNumber(strMobileNumber);
        
        //Fill Amount
        this.setAmount(strAmount);

        //Click Proceed button
        this.clickProceed();        
    }

}
