package WebApp.Salesarchitect.BaseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import WebApp.Salesarchitect.Utility.Xls_Reader;

public class WebBase {

	// Things we will be needing in BaseCla ss: driver,logger,excel AND then Properties file initialization AND the browser+ url open
	
	
	
	
	
	public static WebDriver driver;          // use static for all the global variables
	public static Properties config;
	
	public static Xls_Reader excel;
	public static Logger log;
	
	public WebBase() throws IOException{ // initialize properties file in the Constructor of BASE CLASS
		config = new Properties();   
		File file = new File("E:\\SandeepJavaWorkspace\\Salesarchitect\\Config\\env.properties");               // Storing our 'properties' file into File object.
		FileInputStream fis = new FileInputStream(file);                                                        // Converting 'properties' file into File Stream
		config.load(fis);	
		
	}
	 
	
	public static void init() {               //Creating static method  for launching browser.
		  log = Logger.getLogger("devpinoyLogger");
		        
				
				
				if(config.getProperty("browser").equalsIgnoreCase("chrome")) {                                           // opening of desired browser from config env.properties file .
					System.setProperty("webdriver.chrome.driver", "E:\\SandeepJavaWorkspace\\Salesarchitect\\Drivers\\chromedriver.exe");
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
	
	@AfterMethod                                    // He wrote it in each PAGE class
	
	public void tearDown(){
		
	driver.quit();	
	}
	
	
	
	
	
	
	// He made all variable as Static in Base Class
	// He initialized Config 'properties' file inside the contsructor of Base class
	// He made the init() method of Base class as 'static'.(By this he was able to call method of another Pacakge's class by its class name)
	// He made All Pages java classes as child of Base class ie used Extends
	// He didn't pass 'WebDriver driver' as args in PageFactpry method
	
	// IMP: In LoginPage class> method of Login> he made the login method to return HomePage object ie 'return new HomePage(); [Infact he always gave some return type for all the methods]He always made the method return the object of next landing page.
	
	// He created Consructor of LoginTestCases java file and in the cons called super();  which means it will call constructor of parent class first. ( He had written properties file code in Base class const , thats why he is doing this)
	// He created @BeforeMethod in Pages Java file only and called init() method of base class in it.
	// he created object of PAGES class inside @BeforeMethod which he created in LOGIN TEST class. (He defined Variable of Login Page at class level)
	// He wrote assertions in the PAGETEST Java file methods
	   // IMPORTANT > Whenever any link/button is taking u to next page, then its method created in PAGE java class should always return the object of next page its directing to.
	   // IMPORTANT > Importance of defining @BeforeMethod in each PAGE class : if we are at 5th window , so we can call all the must methods in @BeforeMethods which are needed to reach till 5th window.
	
	// HE edited testNG deplendency in Pom.xml and in place of 'text' wrote' complile' in   <scope>test</scope>
	// He deleted testNG.xml file and created a source folder at project level 
	// he did not mention "Groups=regression" in test cases. Instead he created 2 testNG.xml files in a folder named source with names testNg_regression and tesNG_Sanity and added classes in them jo bh chahye as per need.
	
// He used '@DataProvider' in TEST class package
	
	// NEW TOPIC : @CacheLookUp annotation (its available in Page Factory) > It creates a cache memory &  stores the for WebElements in cache memory to make performance of Framework better.
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
