package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.Utilities;
import common.Constants;
import common.Constants.Timeouts;

public class PaymentPage extends BasePage {

		protected final By summaryText = By.xpath("//span[@class='summary-message messageShowTop']");
		protected final By cardTypeElement = By.xpath("//a[@class='list-group-item text-center select-card active']//p[contains(text(),'Tarjeta')]");
		protected final By cardNameField = By.xpath("//div[@class='field form-group']//input[@name='cardname']");
		protected final By cardNumField = By.xpath("//input[@id='cardnumberunique']");
		protected final By expMonField = By.xpath("//form[@id='payment-form']//input[@name='expmonth']");
		protected final By expYearField = By.xpath("//form[@id='payment-form']//input[@name='expyear']");
		protected final By cvvField = By.xpath("//form[@id='payment-form']//input[@name='cvvno']");
		protected final By emailField = By.xpath("//form[@id='payment-form']//input[@name='txtEmail']");
		protected final By submitButton = By.xpath("//button[@name='formsubmit']");
		protected final By userName = By.xpath("//input[@id='usrname']");
		protected final By pwdField = By.xpath("//input[@id='psw']");
		protected final By iframeCaptcha = By.xpath("//iframe[contains(@name,'a-')]");
		protected final By captchaButton = By.xpath("//label[@id='recaptcha-anchor-label']");
		protected final By loginButton = By.id("loginBtn");
		protected final By rechargeSuccess = By.xpath("//div[@class='col-sm-7']");
		
		
		public PaymentPage(final WebDriver driver) {
			this.driver=driver;
			utils = new Utilities(driver);
		}
		
		public boolean isPaymentPageLoaded() 
		{
			if(driver.findElement(summaryText)!=null)
			{
				
				String strSummary = driver.findElement(summaryText).getText();
				if (strSummary.compareTo("Recarga   Recarga Saldo  de Telcel  al número 5523261151  de   $10 pesos")==0)
					return true;
				else
					return false;
			}
			else return false;
		}
		
		public void enterCardDetails(String strCardName,String strCardNumber, String strexpiryMon, String strexpiryYear, String strCvv, String strEmail, String strusrName, String strpwd) throws InterruptedException {
			
			
			utils.sync(Timeouts.LOW);
			
			driver.findElement(cardNameField).sendKeys(strCardName);
			driver.findElement(cardNumField).sendKeys(strCardNumber);
			driver.findElement(expMonField).sendKeys(strexpiryMon);
			driver.findElement(expYearField).sendKeys(strexpiryYear);
			driver.findElement(cvvField).sendKeys(strCvv);
			driver.findElement(emailField).sendKeys(strEmail);
			driver.findElement(submitButton).click();
			driver.findElement(userName).sendKeys(strusrName);
			driver.findElement(pwdField).sendKeys(strpwd);
			WebElement iframeSwitch = driver.findElement(iframeCaptcha);
			driver.switchTo().frame(iframeSwitch);
			driver.findElement(captchaButton).click();
			driver.switchTo().defaultContent();
			driver.findElement(loginButton).click();
			
		}
		public boolean isrechargeSuccessfull()
			{
				if(driver.findElement(rechargeSuccess)!=null)
				{
					String strRcSuccess = driver.findElement(rechargeSuccess).getText();
					if (strRcSuccess.compareTo("Recarga Saldo de Telcel al número 5523261151")==0)
						return true;
					else
					return false;
				}
				else return false;
			}	
			
		}