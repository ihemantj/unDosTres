package tests;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import common.Utilities;
import pages.HomePage;
import pages.PaymentPage;

public class HomePageTests extends BaseTest{


	@Test(priority=1)
	public void verifyIfPageLoaded() {
		LOG.info("Checking if page has been loaded");
		boolean isPageLoaded = new HomePage(driver).isHomePageLoaded();
		Assert.assertEquals(true, isPageLoaded);
	}
	
	@Test(priority=2)
	public void mobileRecharge() {
	
	HomePage objHome;

	Properties props = Utilities.getProperties(System.getProperty("user.dir") + "\\src\\test\\resources\\data.properties");
	String strOperator = props.getProperty("strOperator");
	String strMobileNumber = props.getProperty("strMobileNumber");
	String strAmount = props.getProperty("strAmount");
	
	objHome = new HomePage(driver);

    //Enter recharge amount

	objHome.enterRechargeAmount(strOperator, strMobileNumber,strAmount);

    }
	
	@Test(priority=3)
	public void cardDetails() throws InterruptedException {
		PaymentPage objPayment;

		Properties props = Utilities.getProperties(System.getProperty("user.dir") + "\\src\\test\\resources\\data.properties");
		String strCardName = props.getProperty("strCardName");
		String strCardNumber = props.getProperty("strCardNumber");
		String strexpiryMon = props.getProperty("strexpiryMon");
		String strexpiryYear = props.getProperty("strexpiryYear");
		String strCvv = props.getProperty("strCvv");
		String strEmail = props.getProperty("strEmail");
		String strusrName = props.getProperty("strusrName");
		String strpwd = props.getProperty("strpwd");
		
		objPayment = new PaymentPage(driver);

	    //Enter recharge amount

		objPayment.enterCardDetails(strCardName, strCardNumber, strexpiryMon, strexpiryYear, strCvv, strEmail, strusrName, strpwd);
	}
	@Test(priority=4)
	public void verifyIfRechargeSuccessfull() {
		LOG.info("Checking if recharge has been successfull");
		boolean isrechargeSuccessfull = new PaymentPage(driver).isrechargeSuccessfull();
		Assert.assertEquals(true, isrechargeSuccessfull);
	}
}