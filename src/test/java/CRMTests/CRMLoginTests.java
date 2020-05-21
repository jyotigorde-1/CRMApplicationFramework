package CRMTests;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import CRMPages.CRMLoginPage;

import CRMUtil.TestBase;
import CRMUtil.TestUtil;

public class CRMLoginTests extends TestBase {
	Logger log = TestBase.getLogger(TestBase.class);

	public static String browserName;	
	@BeforeSuite
	public void launchBrowser() throws InterruptedException {		
		TestBase.initializBrowser(browserName);
	}
	
	@Test(dataProvider = "dataToLogin",priority=0)
	public void loginFun(String username, String password) throws InterruptedException, IOException {
		log.info("CRM Login Test");
		CRMLoginPage CP = new CRMLoginPage();
		CP.testLogin(username,password);
		
	}

	@DataProvider(name = "dataToLogin")
	public Object[][] dp() throws IOException {
		return new Object[][] 
		    	{
		            { "rohan.patil@anyonehome.com", "@123" }
		           // { "snehal.godse@anyonehome.com", "@123" },
		           
		        };
	}
	
	
	
	@AfterMethod
	public void teardown() {
		//driver.close();

	}

}
