package CRMUtil;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class Listener extends TestBase implements ITestListener {	

	public void onFinish(ITestContext context) {		
		
	}

	public void onStart(ITestContext context) {
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onTestFailure(ITestResult result) {
		
		String TestcaseName=result.getName().toString().trim();	
	       //System.out.println(driver);
	      // System.out.println(TestcaseName); 		
	       TestUtil.takeScreenShot(TestcaseName,driver);
		
	}

	public void onTestSkipped(ITestResult result) {
		   String TestcaseName=result.getName().toString().trim();	
	       //System.out.println(driver);
	       //System.out.println(TestcaseName); 		
	       TestUtil.takeScreenShot(TestcaseName,driver);
			
	}

	public void onTestStart(ITestResult result) {
		
		
	}

	public void onTestSuccess(ITestResult result) {		
		
		String TestcaseName=result.getName().toString().trim();	
       //System.out.println(driver);
       //System.out.println(TestcaseName); 		
       TestUtil.takeScreenShot(TestcaseName,driver);
	}
	
}
