package WebApp.Salesarchitect.Pages;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import WebApp.Salesarchitect.BaseClass.WebBase;
import WebApp.Salesarchitect.Common.CommonMethods;

public class HomePage extends WebBase {

	
	

	@FindBy(xpath="(//ul[@class='header-nav']/li)[6]")
	public WebElement userNameLabel;

	@FindBy(xpath="//button[contains(@class,'btn-small')]") 
	public WebElement apikey;
	
	@FindBy(xpath="//div[contains(@class,'modal-body')])[3]")
	public WebElement apiKeyValue;
	
	@FindBy(xpath="//a[text()='New Home Navigator']")
	public WebElement newHomeNavigatorLink;
	
	@FindBy(xpath="//a[text()='Manage Users']")
	public WebElement manageUsersLink;
	
	@FindBy(xpath="//a[text()='Partner Configuration']")
	public WebElement partnerConfigLink;
	
	@FindBy(xpath="//div[contains(@class,'modal-body')])[3]")
	public WebElement managePartnerusersLink;
	
	@FindBy(xpath="//a[text()='Log off']")
	public WebElement logOffLink;
	
	@FindBy(xpath="//button[text()='Manage Prospects']")
	public WebElement manageProspectsbutton;

	@FindBy(xpath="//button[text()='Manage Apps']")
	public WebElement manageAppsButton;
	
	@FindBy(xpath="//button[text()='Navigator Reports']")
	public WebElement navigatorReportsButton;
	
	@FindBy(id="searchBox")
	public WebElement communitySearchBox;
	
	@FindBy(id="searchButton")
	public WebElement communitySearchBoxBtn;
	
	@FindBy(id="clear-search")
	public WebElement clearSearchLink;
	
	@FindBy(id="next_pager")
	public WebElement nextPagerIcon;
	
	@FindBy(xpath="//td[text()='Homestead at Sterling Ranch']")
	public WebElement HomesteadCommunity;
	
	@FindBy(xpath ="//a[text()='SVG Site Overview']")
	public WebElement siteOverviewLink;
	
	
	@FindBy(xpath ="//a[text()='SVG Site Plan' and @id='siteMapPreview']")
	public WebElement SitePlanPreviewLink;
	
	@FindBy(xpath ="//a[text()='GeoSpatial Site Plan' and @id='googleMapsPreview']")
	public WebElement GeoSpatialSitePlanLink;
	
	@FindBy(xpath ="//a[text()='SVG Plugin' and @id='ispPluginPreview']")
	public WebElement plugin2Link;
	
	@FindBy(xpath ="//a[text()='Geospatial Plugin' and @id='geospatialPluginPreview']")
	public WebElement geoSpatialPlugin3Link;
	
	
	
	public Actions action;
	CommonMethods common;
	public WebDriverWait wait;
	
	
	// initializing Page objects/WebElements
	public HomePage() throws IOException {
		PageFactory.initElements(driver,this); 
		
		wait =new WebDriverWait (driver, 90);
	}
	
	
	
	//Actions of this class OR Page Library :-
	
   public String verifyHomePageTitle(){
       return driver.getTitle();   
   }
   
   
   public boolean verifyUserName(){
		return userNameLabel.isDisplayed();
		 
	}
	
   
	public NewHomeNavigatorPage clickNewHomeNavigatorLink() throws IOException {    // return type of this method is NewHomeNavigatorPage since its returning NewHomenavigator class object
	    newHomeNavigatorLink.click();
	    return new NewHomeNavigatorPage();    // we write like this coz  next landing page for this method is NewHomeNavigator	
	}
	
	
	
	
	public ManageUsersPage manageUsersLink() throws IOException{
		manageUsersLink.click();
		return new ManageUsersPage();
	}
	
	
    public PartnerConfigurationPage partnerConfiguratonLink(){	
		partnerConfigLink.click();
		return new PartnerConfigurationPage();
	}
	
    public boolean logOffLink() throws InterruptedException{
    	Thread.sleep(2000);
    	logOffLink.click();
    	
    	//boolean isSubmitBtnDisplayed = driver.findElement(By.xpath("//button[@type='submit']")).isDisplayed();
    	boolean isPleaseSignInTextDisplayed = driver.findElement(By.xpath("//*[text()='Please sign in:']")).isDisplayed();
    	
    	return isPleaseSignInTextDisplayed;
    }
    
    public void logfOff(){
    	logOffLink.click();
    	boolean isSubmitBtnDisplayed = driver.findElement(By.xpath("//button[@type='submit']")).isDisplayed();
    	Assert.assertTrue(isSubmitBtnDisplayed);
    }
	
	
	 public boolean apiKey() throws InterruptedException{
		
		apikey.click();
		Thread.sleep(3000);
		boolean isApikeyValue = driver.findElement(By.xpath("(//div[@class='modal-body'])[3]")).isDisplayed();
		return isApikeyValue;
		//driver.switchTo().alert();
		//String a=driver.switchTo().alert().getText();
		
	} 
	
    public ManageProspectsPage manageProspectsButton() throws IOException{
    	manageProspectsbutton.click();
    		return new ManageProspectsPage();
    	}
    
    
	public ManageAppsPage manageApps() throws IOException{
		manageAppsButton.click();
		return new ManageAppsPage();
	}
	

	
   public NavigatorReportsPage navigatorReportsButton() throws IOException{
	
	navigatorReportsButton.click();
	return new NavigatorReportsPage();
}
	
	
	public boolean communitySearchBoxByCommunityName() throws InterruptedException{
		communitySearchBox.sendKeys("Bison");
		Thread.sleep(4000);
	 action = new Actions(driver);                    // OR use communitySearchBoxBtn.click();
	action.sendKeys(Keys.ENTER).build().perform();
	Thread.sleep(2000);
		
		
		//boolean IsCommSearchResultDisplayed= driver.findElement(By.xpath("//div[text()='View 1 - 1 of 1']")).isDisplayed();
		boolean IsCommSearchResultDisplayed= driver.findElement(By.xpath("//td[text()='Bison Ranch']")).isDisplayed();
		Thread.sleep(2000);
		return IsCommSearchResultDisplayed;
	}
	
	public boolean communitySearchBoxByBuilderName() throws InterruptedException{
		
		communitySearchBox.sendKeys("Classic");
		Thread.sleep(4000);
		 action = new Actions(driver);
			action.sendKeys(Keys.ENTER).build().perform();      // OR use communitySearchBoxBtn.click();
			Thread.sleep(2000);
	
		boolean IsBuilderSearchResultDisplayed= driver.findElement(By.xpath("//td[contains(text(),'Indigo Ranch')]")).isDisplayed();
		return IsBuilderSearchResultDisplayed;
	}
	
	public boolean clearSearchLink() throws InterruptedException{
		communitySearchBox.sendKeys("Classic");
		Thread.sleep(4000);
		 action = new Actions(driver);
			action.sendKeys(Keys.ENTER).build().perform();
			Thread.sleep(4000);
			
			clearSearchLink.click();
		//	Thread.sleep(4000);
			boolean IsBuilderSearchResultDisplayed1= driver.findElement(By.xpath("//td[text()='Forest Lakes']")).isDisplayed();
			return IsBuilderSearchResultDisplayed1;
	}
	
	
	public boolean verifyNextPagerIcon() throws InterruptedException{
		Thread.sleep(6000);              // I should use 'explicitly' wait here
		nextPagerIcon.click();
		Thread.sleep(4000);
		boolean IsNextPagerShowinResult= driver.findElement(By.xpath("//td[contains(text(),'Jackson Creek ')]")).isDisplayed();
		return IsNextPagerShowinResult;
	}
	
	
	
	public String siteOverviewLink() throws InterruptedException, IOException{
		         
		wait.until(ExpectedConditions.elementToBeClickable(HomesteadCommunity));
		HomesteadCommunity.click();
		
	//	common = new CommonMethods();    // created object of Common Class
		 CommonMethods.scrollToElement(driver.findElement(By.xpath("//a[text()='SVG Site Overview']")));    // using JAVASCRIPT EXCECUTER method to click the element
		
		
	
			
		String parentWindowId = driver.getWindowHandle();
		//System.out.println("main window is " +parentWindowId);
		
		Set<String> allOtherWindowsIds= driver.getWindowHandles();
		//System.out.println("All other ids are" +allOtherWindowsIds);
		
		for (String x : allOtherWindowsIds){
			
			if(!parentWindowId.equals(x)){
				driver.switchTo().window(x);
				driver.manage().window().maximize();
				//String xyz = driver.getTitle();
				//System.out.println(xyz);
				
			break;
		          }
	     }
		
	
	
		Thread.sleep(4000);
		return driver.getTitle();
	
	   //	Boolean isPlanDetailsBtnDisplayed = driver.findElement(By.id("filter-btn")).isDisplayed();
		//System.out.println(isPlanDetailsBtnDisplayed);
		//return isPlanDetailsBtnDisplayed;
	}
	
	
	public void manageLots(String LotId){
		
		driver.findElement(By.xpath("//td[text()='Banning Lewis Ranch']")).click();
		
		// here write code to >delete SVG > upload SVG> upload Json 
		
		driver.findElement(By.xpath("//span[text()='2A-1']")).click();
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
