package CRMUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase {
	
	public static Properties prop;
	public static  WebDriver driver;

	public TestBase() {
		// Get Properties file path
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/CRMConfig/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void initializBrowser(String browser_name) throws InterruptedException  {
   // System.out.println("Browser Initiliaze");
		browser_name=prop.getProperty("Browser");
		//System.out.println(browser_name);
		Logger log = TestBase.getLogger(TestBase.class);		
		System.out.println("Launched browser successfully");
		Thread.sleep(1000);
		
		// Launch Url On Internet Explorer Browser
		if (browser_name.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");			
			Thread.sleep(1000);
			driver = new InternetExplorerDriver();
			Thread.sleep(4000);
			log.info("IE browser launched successfully");			
			postSteps();		
			
		}
		
		// Launch Url On  Chrome Browser
		else if (browser_name.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriverV81.exe");
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			driver = new ChromeDriver();
			log.info("Chrome browser launched successfully");
			//System.out.println("Chrome browser launched successfully");
			postSteps();
						
		}
		// Launch Url On Firefox Browser
		else if (browser_name.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			log.info("Firefox browser launched successfully");							
			postSteps();				
									
		}
		}

	public static void postSteps() throws InterruptedException {
		
		Logger log = TestBase.getLogger(TestBase.class);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		//driver.get(prop.getProperty("BASE_URL"));
		driver.navigate().to(prop.getProperty("BASE_URL"));
		String url = prop.getProperty("BASE_URL");
		Thread.sleep(2000);
		log.info("URL "+url+" entered successfully");
		

	}

	// used to set current date and time for logs
	static {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		System.setProperty("current.date.time", dateFormat.format(new Date()));
	}

	private static boolean root = false;
	
	@SuppressWarnings("rawtypes")
	public static Logger getLogger(Class cls) {

		if (root) {
			return Logger.getLogger(cls);
		}
		PropertyConfigurator.configure("src\\main\\java\\CRMConfig\\log4j.properties");
		root = true;
		return Logger.getLogger(cls);
	}

}
