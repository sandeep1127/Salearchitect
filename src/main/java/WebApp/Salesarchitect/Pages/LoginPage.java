package WebApp.Salesarchitect.Pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import WebApp.Salesarchitect.BaseClass.WebBase;

public class LoginPage extends WebBase  {
// Object Repository
	@FindBy(id="UserName")             // we call it object repository and its the work of PAGE FACTORY to initialize them.
	public WebElement username;
	
	@FindBy(id="Password")
	public WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	public WebElement submitButton;
	
	@FindBy(id="logOff")
	public WebElement logoff;
	
	@FindBy(xpath="//div[contains(@class,'alert-error')]")
	public WebElement invalidlogintext;
	
	
	
	
	
	public LoginPage() throws IOException{               // constructor of Class where we are initializing Page objects	
		//this.driver=driver;
		PageFactory.initElements(driver, this);        // 'this' means initializing current class objects i.e @FindBy ones
	}
	
	// Methods for LoginPage OR Actions :-
	
public HomePage superAdminValidLogin(String un, String pwd) throws IOException{
		
	    username.sendKeys(un);         // this value will be coming from properties file
		password.sendKeys(pwd);
		submitButton.click();
		return new HomePage();      // It is returning HomePage class object because landing page of Login Page is Homepage.
	}
		
public void partnerSuperAdminvalidLogin(){

		username.sendKeys("sa");
		password.sendKeys("ex2qa");
		submitButton.click();
		 
		
}

public void communityAdminValidLogin(){
	
	username.sendKeys("ca");
	password.sendKeys("ex2qa");
	submitButton.click();
	
}

public void salesRepValidLogin(){
	
	username.sendKeys("sr");
	password.sendKeys("ex2qa");
	submitButton.click();
	
}


public void salesEditorValidLogin(){
	
	username.sendKeys("se");
	password.sendKeys("ex2qa");
	submitButton.click();
	
}


public void verifyLogin(){
	Assert.assertTrue(logoff.isDisplayed());
		
	}
	
public void invalidLogin(){
			
			username.sendKeys("Sandy_bhi");
			password.sendKeys("ex2qa5");
			submitButton.click();
			
			Boolean isinvalidlogintextfound = invalidlogintext.isDisplayed();
			
			
				Assert.assertTrue(isinvalidlogintextfound);                                 // If JVM comes to this block, it will PASS the test case

		
			
		}
			
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}



