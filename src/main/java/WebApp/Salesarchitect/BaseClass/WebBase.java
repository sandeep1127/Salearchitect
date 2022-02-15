package WebApp.Salesarchitect.BaseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;

import WebApp.Salesarchitect.Utility.WebEventListener;
import WebApp.Salesarchitect.Utility.Xls_Reader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebBase {

	// Things we will be needing in BaseClass: driver,logger,excel AND then Properties file initialization AND the browser+ url open
	
	
	
	
	
	public static WebDriver driver;          // use static for all the global variables
	public static Properties config;
	
	//public static Xls_Reader excel;
	public static Logger log;
	public static EventFiringWebDriver e_driver;   // Creating variable to be used for WebFiringDriver for creating Logs
	public static WebEventListener eventListener;   // Creating variable to be used for WebEventListener for creating Logs
	
	
	public WebBase() throws IOException{ // initialize 'Properties' file in the Constructor of the BASE CLASS
		config = new Properties();   
		File file = new File("E:\\SandeepJavaWorkspace\\Salesarchitect\\Config\\env.properties");               // Storing our 'properties' file into File object.
		FileInputStream fis = new FileInputStream(file);                                                        // Converting 'properties' file into File Stream
		config.load(fis);	
		
	}
	
	
	public static void init() throws IOException {               //Creating static method  for launching the desired browser as per value  in properties files.
		  log = Logger.getLogger("devpinoyLogger");
		        
				
				
				if(config.getProperty("browser").equalsIgnoreCase("chrome")) {                                           // opening of desired browser from config env.properties file .
				System.setProperty("webdriver.chrome.driver", "E:\\SandeepJavaWorkspace\\Salesarchitect\\Drivers\\chromedriver.exe");
				//WebDriverManager.chromedriver().setup();            // Instead of above line where we need to always keep updating the driver manually, by using this class(after adding its dependency) we dont need to update driver now.
					
					driver = new ChromeDriver();
					log.info("Chrome browser opened");
					
				} 
					else if(config.getProperty("browser").equalsIgnoreCase("firefox"))  {
						System.setProperty("webdriver.gecko.driver", "E:\\SandeepJavaWorkspace\\Salesarchitect\\Drivers\\geckodriver.exe");
						driver = new FirefoxDriver();
						log.info("Firefox browser opened");
					}
				
					else if(config.getProperty("browser").equalsIgnoreCase("ie"))  {   
						System.setProperty("webdriver.ie.driver", "E:\\SandeepJavaWorkspace\\Salesarchitect\\Drivers\\IEDriverServer.exe");
						driver = new InternetExplorerDriver();
						log.info("IE browser opened");
					}
				
					else if(config.getProperty("browser").equalsIgnoreCase("edge"))  {   
						System.setProperty("webdriver.edge.driver", "E:\\SandeepJavaWorkspace\\Salesarchitect\\Drivers\\msedgedriver.exe");
						driver = new EdgeDriver();
						log.info("Edge browser opened");
					}
		 		
				// Below code is a part for generating logs which will be used by WebEventListner class available in Util Package
				e_driver = new EventFiringWebDriver(driver);
				// Now create object of EventListerHandler to register it with EventFiringWebDriver
				eventListener = new WebEventListener();
				e_driver.register(eventListener);
				driver = e_driver;
				
				
				
				
				
				
				driver.manage().window().maximize();
				log.info("browser is maximised");
				driver.manage().deleteAllCookies();
				log.info("cookies cleared");
				driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
				driver.get(config.getProperty("url"));
				log.info(config.getProperty("url") + " app opened");
				
				
			//	excel = new Xls_Reader("path of test data file");
	      		 
	}
	
	// Method which will TakeScreenshot and will be called only when any TestCase Fails(Its Listener is written in customListener class:-
	
   public void screenShotOfFailedCases(String testMethodName) throws IOException{
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		
		FileHandler.copy(src, new File("E:\\SandeepJavaWorkspace\\Salesarchitect\\FailedScreenShots\\"+testMethodName+".jpg"));
	
		
		
	}
	
	@AfterMethod                                    
	
	public void tearDown(){
		
	driver.quit();	
	}
	
	
	
	
	
	
	// He made all variable as Static in Base Class so thay they can be called simply by class name and no need of creating object.
	// He initialized Config 'properties' file inside the constructor of the Base class
	// He made the init() method of Base class as 'static'.(By this he was able to call method of another Pacakge's class by its class name)
	// He made All Pages java classes as child of Base class ie used Extends
	// He didn't pass 'WebDriver driver' as args in PageFactory method
	
	// IMP: In LoginPage class> method of Login> he made the login method to return HomePage object ie 'return new HomePage(); [Infact he always gave some return type for all the methods]He always made the method return the object of next landing page.
	
	// He created Consructor of LoginTestCases java file and in the cons called super();  which means it will call constructor of parent class first. ( He had written properties file code in Base class const , thats why he is doing this)
	// He created @BeforeMethod in Pages Java file only and called init() method of base class in it.
	// he created object of PAGES class inside @BeforeMethod which he created in LOGIN TEST class. (He defined Variable of Login Page at class level)
	// He wrote assertions in the PAGETEST Java file methods
	   // IMPORTANT > Whenever any link/button is taking u to next page, then its method created in PAGE java class should always return the object of next page its directing to.
	   // IMPORTANT > Importance of defining @BeforeMethod in each PAGE class : if we are at 5th window , so we can call all the must methods in @BeforeMethods which are needed to reach till 5th window.
	
	// HE edited testNG dependency in Pom.xml and in place of 'text' wrote' complile' in   <scope>test</scope>
	// He deleted testNG.xml file and created a source folder at project level 
	// he did not mention "Groups=regression" in test cases. Instead he created 2 testNG.xml files in a folder named source with names testNg_regression and tesNG_Sanity and added classes in them jo bh chahye as per need.
	
// He used '@DataProvider' in TEST class package
	
	// NEW TOPIC : @CacheLookUp annotation (its available in Page Factory) > It creates a cache memory &  stores the for WebElements in cache memory to make performance of Framework better.
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
