package WebApp.Salesarchitect.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import WebApp.Salesarchitect.BaseClass.WebBase;
import WebApp.Salesarchitect.Pages.HomePage;
import WebApp.Salesarchitect.Pages.LoginPage;

public class LoginPageTestCases extends WebBase {
	
	
	LoginPage loginPage;
	HomePage homePage;
	 
	
	// constructor of this Class which calls Constructor of its Parent class to initialize 'properties' file
	public LoginPageTestCases() throws IOException {
		super();                                                   // STEP 1 : Call Constructor of BASE class to initialize Properties file. Otherwise it will give null point exception
		
	}

	 
	 
	 
	 @BeforeMethod
	 public void setUp() throws IOException{
		 init();                                                 // STEP 2 : Call init() method of BaseClass to open browser+URL
		 loginPage = new LoginPage(); 							 // STEP 3 : Creating Object of LOGINPAGE class to use its methods.
		 }
	 
	 
	 
	// Step 4 : Creating Test Cases
	
	@Test (groups="Regression" , priority =1)
	public void SuperAdminValidLoginTest() throws InterruptedException, IOException{
		
		homePage=loginPage.superAdminValidLogin(config.getProperty("username"), config.getProperty("password"));
		
		loginPage.verifyLogin();
		log.info("SuperAdmin login test case passed");
	}
	
	
	@Test (groups="Regression" , priority =2)
	public void PartnerSuperAdminValidLoginTest(){
		
	     
		loginPage.partnerSuperAdminvalidLogin();
		loginPage.verifyLogin();
		log.info("Partner SuperAdmin login test case passed");
		}
	
	
	@Test (groups="Regression", priority =3)
	public void testCommunityAdminValidLogin(){
		
		loginPage.communityAdminValidLogin();
		loginPage.verifyLogin();	
		log.info("Community Admin login test case passed");
		}

	
	@Test (groups="Regression", priority =4)
	public void SalesRepAdminValidLoginTest(){
		
		
		loginPage.salesRepValidLogin();
		loginPage.verifyLogin();
		log.info("Sales Representative test case passed");
		}
	
	
	@Test (groups="Regression", priority =5)
	public void SalesEditorAdminValidLoginTest(){
		
	
		loginPage.salesEditorValidLogin();
		loginPage.verifyLogin();
		
		log.info("Sales Editor login test case passed");
		
		}
	
	
	
	@Test (groups="Regression" , priority =6)
      public void InValidLoginTest(){
		
		
		loginPage.invalidLogin();
		log.info("InValid login test case passed");
		
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
