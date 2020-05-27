package CRMPages;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import CRMUtil.TestBase;
import CRMUtil.TestUtil;

public class CRMLoginPage extends TestBase{	
	Logger log = TestBase.getLogger(TestBase.class);
		@FindBy(xpath = "//input[@id='inputEmail']")
		WebElement txtEmail;		
		@FindBy(xpath = "//input[@id='inputPassword']")
		WebElement txtPWD;		
		@FindBy(xpath = "//button[@class='btn btn-info showproSignInBtn']")
		WebElement btnSignIn;
		@FindBy(xpath = "//span[@class='thumb-small avatar inline']")
		WebElement icnLogout;
		@FindBy(xpath = "//a[contains(text(),'Logout')]")
		WebElement lblLogout;
		
		
		public CRMLoginPage() {			
			PageFactory.initElements(driver, this);
		}
		public void testLogin(String Uname,String PWD) throws InterruptedException {
		Thread.sleep(1000);
		txtEmail.sendKeys(Uname);
		txtPWD.sendKeys(PWD);
		btnSignIn.click();
		Thread.sleep(4000);
		/*String actualURL = driver.getCurrentUrl();
		String expectedURL = "http://stage-showpro.herokuapp.com/dashboard";
		Assert.assertEquals(expectedURL, actualURL);
		log.info("Test Pass-Login Sucessful");*/
		}
		
		public void testLogout() throws InterruptedException
		{
		Thread.sleep(2000);
		icnLogout.click();
		lblLogout.click();
		}		
}
