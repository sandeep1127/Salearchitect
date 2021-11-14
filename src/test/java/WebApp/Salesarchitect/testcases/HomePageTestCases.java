package WebApp.Salesarchitect.testcases;

import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import WebApp.Salesarchitect.BaseClass.WebBase;
import WebApp.Salesarchitect.Pages.HomePage;
import WebApp.Salesarchitect.Pages.LoginPage;
import WebApp.Salesarchitect.Pages.ManageAppsPage;
import WebApp.Salesarchitect.Pages.ManageProspectsPage;
import WebApp.Salesarchitect.Pages.ManageUsersPage;
import WebApp.Salesarchitect.Pages.NavigatorReportsPage;
import WebApp.Salesarchitect.Pages.NewHomeNavigatorPage;
import WebApp.Salesarchitect.Pages.PartnerConfigurationPage;

public class HomePageTestCases extends WebBase{

	LoginPage loginPage;
	HomePage homepage;
	ManageUsersPage manageUsers;
	NewHomeNavigatorPage newHomeNavigator;
	PartnerConfigurationPage partnerConfig;
	ManageProspectsPage manageProspectspage;
	ManageAppsPage manageAppsPage;
	NavigatorReportsPage navigatorReportsPage;
	
	
	public HomePageTestCases() throws IOException  {               // STEP 1 : Call Constructor of BASE class to initialize Properties file. Otherwise it will give null point exception
	super();
	}

	 @BeforeMethod
	 public void setUp() throws IOException{
		 init();                                                 // STEP 2 : Call init() method of BaseClass to open browser + URL
		 loginPage = new LoginPage(); 							 // STEP 3 : Creating Object of LOGINPAGE class to use its methods.
		 manageUsers = new ManageUsersPage();
		 newHomeNavigator = new NewHomeNavigatorPage(); 
		 partnerConfig = new PartnerConfigurationPage();
		 manageProspectspage = new ManageProspectsPage();
		 manageAppsPage = new ManageAppsPage();
		 navigatorReportsPage = new NavigatorReportsPage();
		 
		 
		 homepage =loginPage.superAdminValidLogin(config.getProperty("username"), config.getProperty("password")); // Step 4 : I have to login each time to go to HOMEPAGE screen.
		 
	 } 
	
	 
	 
	 
	 // Creating Test suite:-
	
	 @Test(groups="Regression" , priority =1)
	 public void verifyHomePageTitleTest(){
		 String homePageTitle =homepage.verifyHomePageTitle();
		 Assert.assertEquals(homePageTitle,"Communities - salesArchitect","HomePage Title not matched");    // we can add another 3rd argument which will be shown only if test case fails	 
		 log.info("HomePage title test Case passed");
	 }
	
	@Test(groups="Regression" , priority =2)
	public void verifyUserNameTest(){
		homepage.verifyUserName();
		Assert.assertTrue(homepage.verifyUserName());
		log.info("Correct user name test case passed");
		
	}
	
	@Test(groups="Regression" , priority =3)
	public void clickNewHomeNavigatorLinkTest() throws IOException{
		newHomeNavigator = homepage.clickNewHomeNavigatorLink();
		
	}
	
	
	@Test(groups="Regression" , priority =4)
	public void manageUsersLinkTest() throws IOException{
		manageUsers= homepage.manageUsersLink();
	}
	
	@Test(groups="Regression" , priority =5)
	public void partnerConfigurationLinkTest() throws IOException{
		partnerConfig= homepage.partnerConfiguratonLink();
	}
	
	
	@Test (groups="Regression" , priority =6 , enabled=false)
	public void logOffLinkTest() throws InterruptedException{
	homepage.logOffLink();
	Assert.assertTrue(homepage.logOffLink());
	}
	
	@Test
	public void logOffTest(){
		homepage.logfOff();
		
	}
		
	
	
	@Test (groups="Regression" , priority =7)
	public void manageProspectsButtonTest() throws IOException{
		
		manageProspectspage= homepage.manageProspectsButton();
	}
	
	
	
	@Test (groups="Regression" , priority =8)
	public void manageAppsTest() throws IOException{
		
		manageAppsPage = homepage.manageApps();
	}
	
	@Test (groups="Regression" , priority =9)
	public void navigatorReportsButtonTest() throws IOException{
		navigatorReportsPage=homepage.navigatorReportsButton();
	}
	
	
	
	@Test
	public void communitySearchBoxByCommunityNameTest() throws InterruptedException{
		
	Assert.assertTrue(homepage.communitySearchBoxByCommunityName());;
	}
	
	@Test
	public void communitySearchBoxByBuilderNameTest() throws InterruptedException{
		System.out.println(homepage.communitySearchBoxByBuilderName());
	//Assert.assertTrue(homepage.communitySearchBoxByBuilderName());;
	}
	
	@Test
	public void clearSearchLinkTest() throws InterruptedException{
		
		Assert.assertTrue(homepage.clearSearchLink());
	}
	
	
	@Test

	public void verifyNextPagerIconTest() throws InterruptedException{
		
		Assert.assertTrue(homepage.verifyNextPagerIcon());;
	}
	
	
	
	@Test
	public void isApikeyValueTest() throws InterruptedException{
		
		Assert.assertTrue(homepage.apiKey());
	}
	
	
	@Test
	public void siteOverviewLinkTest() throws InterruptedException, IOException{
	
		homepage.siteOverviewLink();
		Thread.sleep(2000);
		
		String pageTitle = homepage.siteOverviewLink();
		System.out.println("Title is" +pageTitle);
		
	Assert.assertEquals(pageTitle, "Homestead at Sterling Ranch@", "The Title of the window doesn't match");
		
	//	Assert.assertTrue(homepage.siteOverviewLink());
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
