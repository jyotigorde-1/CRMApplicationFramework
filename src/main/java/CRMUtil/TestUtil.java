package CRMUtil;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TestUtil extends TestBase {
	public static int PAGE_LOAD_TIMEOUT=25;
	public static int IMPLICIT_WAIT=30;
	
	 public static void takeScreenShot(String TestcaseName, WebDriver driver) {
    	 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         //The below method will save the screen shot  with test method name 
            try {
				FileUtils.copyFile(scrFile, new File("Screenshot//" +TestcaseName+".png"));
				System.out.println("the Screenshot is taken");
			} catch (IOException e) {
				e.printStackTrace();
			}
    }
	
	public static String getTime() {
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MMM-yyyy-hh-mm-ss");
		String time = dateFormat1.format(new Date());
		return time;
	}
}