package WebApp.Salesarchitect.testcases;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import WebApp.Salesarchitect.BaseClass.WebBase;
import WebApp.Salesarchitect.Common.CommonMethods;
import WebApp.Salesarchitect.Pages.HomePage;
import WebApp.Salesarchitect.Pages.LoginPage;
import WebApp.Salesarchitect.Pages.ManageAppsPage;
import WebApp.Salesarchitect.Pages.ManageProspectsPage;
import WebApp.Salesarchitect.Pages.ManageUsersPage;
import WebApp.Salesarchitect.Pages.NavigatorReportsPage;
import WebApp.Salesarchitect.Pages.NewHomeNavigatorPage;
import WebApp.Salesarchitect.Pages.PartnerConfigurationPage;
@Listeners(CustomListener.class)

public class HomePageTestCases extends WebBase{

	LoginPage loginPage;
	HomePage homepage;
	ManageUsersPage manageUsers;
	NewHomeNavigatorPage newHomeNavigator;
	PartnerConfigurationPage partnerConfig;
	ManageProspectsPage manageProspectspage;
	ManageAppsPage manageAppsPage;
	NavigatorReportsPage navigatorReportsPage;
	
	String sheetName="LotData";
	
	
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
		 
		 
		 homepage =loginPage.superAdminValidLogin(config.getProperty("username"), config.getProperty("password")); // Step 4 : I have to login each time to go to HOMEPAGE screen So , i'm including this in my Before Method.
		 
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
	
	
//	@Test (groups="Regression" , priority =6 , enabled=false)
//	public void logOffLinkTest() throws InterruptedException{
//	homepage.logOffLink();
//	Assert.assertTrue(homepage.logOffLink());
//	}
	
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
		
	Assert.assertTrue(homepage.communitySearchBoxByBuilderName());;
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
	
	//	String pageTitle=	homepage.siteOverviewLink();	
	//Assert.assertEquals(pageTitle, "Brandon Park", "The Title of the window doesn't match");
	
		Assert.assertTrue(homepage.siteOverviewLink(), "The Plan Detail button not displaying");
		
	   driver.close();
		
	}
	
	
	@Test
	public void sitePreviewLinkTest() throws InterruptedException, IOException{
		
		Assert.assertTrue(homepage.sitePreviewLink());
		driver.close();
	}
	
	
	@Test
	public void geoSpatialSitePlanJsonLinkTest() throws InterruptedException, IOException{
		
		Assert.assertTrue(homepage.geoSpatialSitePlanJsonLink());
		driver.close();
		
	}
	
	@Test
	public void geoSpatialSitePlanSvgGeoLinkTest() throws InterruptedException, IOException{
		
		Assert.assertTrue(homepage.geoSpatialSitePlanSvgGeoLink());
		driver.close();
		
	}
	
	
	
	 
	/*@Test           // Manually passing data for lot in Manage Lots
	 public void manualManageLotsFillDataTest() throws InterruptedException{
		 
		homepage.manageLotsFillData("Market", "1111", "900SqFeet", "90000", "900B", "900P", "High", "left900", "selenium description", "h no -900/TT, Lawrence lane", "https://www.google.com", "seleniumUrl");
	 }*/
	
	
	
	
	@DataProvider
	public Object[][] getManageLotData(){
   Object data[][]= CommonMethods.getTestData(sheetName);
	return data;	
	} 
	
	//String LotStatus,String DisplayName,String LotSize,String LotPremiumPrice ,String Block,String Phase ,String Elevation ,String Swing ,String Description ,String Address,String ContactURL,String ContactButtonText
	@Test (dataProvider="getManageLotData")
	  public void manageLotsFillDataTestExcel(String LotStatus,String DisplayName,String LotSize,String LotPremiumPrice ,String Block,String Phase ,String Elevation ,String Swing ,String Description ,String Address,String ContactURL,String ContactButtonText) throws InterruptedException{
	 
	//homepage.manageLotsFillData("Market", "1111", "900SqFeet", "90000", "900B", "900P", "High", "left900", "Selenium Description", "h no -900/TT, Lawrence lane", "https://www.google.com", "seleniumUrl");
 homepage.ManageLotsFillDataExcel(LotStatus, DisplayName, LotSize, LotPremiumPrice, Block, Phase, Elevation, Swing, Description, Address, ContactURL, ContactButtonText);
	}

	
	
	@Test(priority=11)
	public void deleteAllLotsInfoLinkTest() throws InterruptedException, IOException{
		
	
		Assert.assertEquals(homepage.deleteAllLotsInfoLink(), true);
		Assert.assertEquals(homepage.siteOverviewLink.isDisplayed(), false);
		
	}
	
	
	@Test(priority=10)
	public void uploadSVGTest() throws InterruptedException, AWTException{
		
		Assert.assertTrue(homepage.uploadSVG());;
		Assert.assertTrue(homepage.LotId.isDisplayed());
		
		
		
	}
	
	
	@Test
	public void uploadSVGMasterPlanTest() throws InterruptedException, AWTException{
		homepage.uploadSVGMasterPlan();
		
		
	}
	
	@Test
	public void associateSVGMasterPlanTest() throws InterruptedException, AWTException{
		homepage.associateSVGMasterPlan();
		if (homepage.eagleView.getText().equals("Eagle View")){
			Assert.assertTrue(homepage.eagleView.getText().equals("Eagle View"), "OOPS Test case of associate master plan has Failed");  // Here  Im checking of 
			System.out.println("The name of the community for which Masert plan associated is : " + homepage.eagleView.getText());
		}
		
		
	}
	
	
	@Test
	public void previewSVGMasterPlanLinkTest() throws InterruptedException{
		Assert.assertTrue(homepage.previewSVGMasterPlanLink());
		
		driver.close();
		
	}
	
	
	
	
	
	
}
