package WebApp.Salesarchitect.Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
	
	@FindBy(xpath="//td[text()='Brandon Park']")
	public WebElement BrandonPark;
	

	@FindBy(xpath="//td[text()='Creek Ridge']")
	public WebElement creekRidge;
	
	@FindBy(xpath="//td[text()='Quailhill']")
	public WebElement Quailhill;
	
	@FindBy(xpath="//td[text()='Lakefront at Vineyard Town Center']")
	public WebElement LakefrontatVineyardTownCenter;
	
	@FindBy(xpath="//tr[@id=3865]//td[@aria-describedby='Communities_cell.LotsCount'and text()=0]")
	public WebElement LakefrontatVineyardTownCenterMissing;
	
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


	
	@FindBy(xpath="//input[contains(@data-bind,'checked: isAmenity')]")
	public WebElement isAnAmenityCheckBox;
	
	@FindBy(xpath="//input[@id='displayName' and @name='displayName']")
	public WebElement displayNametextBox;
	
	@FindBy(xpath="//input[@id='lotSize' and @name='lotSize']")
	public WebElement lotSizeTextBox;
	
	@FindBy(xpath="//input[@id='lotPremiumPrice' and @name='premiumPrice']")
	public WebElement lotPremiumPriceTextBox;
	
	@FindBy(xpath="//input[@id='lotBlock' and @name='block']")
	public WebElement blockTextBox;
	
	@FindBy(xpath="//input[@id='lotPhase' and @name='phase']")
	public WebElement phaseTextBox;
	
	@FindBy(xpath="//input[@id='lotElevation' and @name='elevation']")
	public WebElement elevationTextBox;
	
	@FindBy(xpath="//input[@id='lotSwing' and @name='swing']")
	public WebElement swingTextBox;
	
	@FindBy(xpath="//textarea[@id='lotDescription' and @name='description']")
	public WebElement descriptionTextBox;
	
	@FindBy(xpath="//textarea[@id='lotAddress' and @name='address']")
	public WebElement addressTextBox;
	
	@FindBy(xpath="//input[@id='contact' and @name='contact']")
	public WebElement contactUrlTextBox;
	
	@FindBy(xpath="//input[@id='buttonText' and @name='buttonText']")
	public WebElement contactButtonTextBox;
	
	
	@FindBy(xpath="//button[@onclick ='saveLotInfo()']")
	public WebElement saveChangesButton;
	
	@FindBy(xpath="//span[@class='isp-icon icon-cycle']")
	public WebElement resetButton;
	
	
	@FindBy(xpath="//a[text()='SVG Site Overview']")
	public WebElement overviewLink;
	
	@FindBy(xpath="//a[text()='SVG Site Plan' and @id='siteMapPreview']")
	public WebElement previewLink;
	
	@FindBy(xpath="//a[text()='GeoSpatial Site Plan' and @id='googleMapsPreview']")
	public WebElement ispJsonLink;
	
	@FindBy(xpath="//a[text()='GeoSpatial Site Plan' and @id='googleMapsPreview']")
	public WebElement ispSvgGeoLink;
	
	@FindBy(xpath="//*[name()='svg']//*[local-name()='polygon' and @id='Lot_81']")
	public WebElement SvgGeolotId;
	

	@FindBy(xpath="//span[text()=' Delete All Lots Info']")
	public WebElement deleteAllLotsInfo;
	
	

	@FindBy(xpath="//button[@class='btn btn-success btn-confirm']")
	public WebElement deleteSvgConfirmBtn;
	
	
	@FindBy(xpath="//a[text()='SVG Site Plan' and contains(@href,'javascript:showModalWindow')]")
	public WebElement uploadSvgLink;
	
	@FindBy(xpath="//input[@id='choose-LoadMapfile' and @value='Choose File']")
	public WebElement chooseFileToUploadButton;
	
	@FindBy(xpath="//input[@id='file-upload' and @value='Upload']")
	public WebElement uploadButton;
	
	@FindBy(xpath="//span[text()=2 and @data-bind='text: ExternalReference']")
	public WebElement LotId;
	
	@FindBy(xpath="//span[text()='2A-1'and @data-bind='text: ExternalReference']")
	public WebElement LotId2A1;
	
	
	
	
	
	
	public Actions action;
	CommonMethods common;
	public WebDriverWait wait;
	
	
	// initializing Page objects/WebElements
	public HomePage() throws IOException {
		PageFactory.initElements(driver,this); 
		
		wait =new WebDriverWait (driver, 60);    // using explicit wait
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
	
	   wait.until(ExpectedConditions.elementToBeClickable(navigatorReportsButton)).click();
	return new NavigatorReportsPage();
}
	
	
	public boolean communitySearchBoxByCommunityName() throws InterruptedException{
		communitySearchBox.sendKeys("Creek Ridge");
		Thread.sleep(2000);
	    action = new Actions(driver);                    // OR use communitySearchBoxBtn.click();
	    action.sendKeys(Keys.ENTER).build().perform();
	    Thread.sleep(2000);
		
		
		//boolean IsCommSearchResultDisplayed= driver.findElement(By.xpath("//div[text()='View 1 - 1 of 1']")).isDisplayed();
		boolean IsCommSearchResultDisplayed= driver.findElement(By.xpath("//td[text()='Creek Ridge']")).isDisplayed();
		Thread.sleep(2000);
		return IsCommSearchResultDisplayed;
	}
	
	public boolean communitySearchBoxByBuilderName() throws InterruptedException{
		
		communitySearchBox.clear();
		communitySearchBox.sendKeys("EDGEhomes");
		Thread.sleep(4000);
		 action = new Actions(driver);
			action.sendKeys(Keys.ENTER).build().perform();      // OR use communitySearchBoxBtn.click();
			Thread.sleep(2000);
	
		boolean IsBuilderSearchResultDisplayed= creekRidge.isDisplayed();
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
			boolean IsBuilderSearchResultDisplayed1= driver.findElement(By.xpath("//td[text()='Graystone']")).isDisplayed();
			return IsBuilderSearchResultDisplayed1;
	}
	
	
	public boolean verifyNextPagerIcon() throws InterruptedException{
		Thread.sleep(4000);              // I should use 'explicitly' wait here       // It was giving ElementClickIntercepted expection by this code , so used JS executer.
		//wait.until(ExpectedConditions.elementToBeClickable(nextPagerIcon));
		//nextPagerIcon.click();
		
		CommonMethods.scrollToElementClick(nextPagerIcon);
		Thread.sleep(4000);
		boolean IsNextPagerShowinResult= driver.findElement(By.xpath("//td[contains(text(),'The Ridge')]")).isDisplayed();
		return IsNextPagerShowinResult;
	}
	
	
	
  public Boolean siteOverviewLink() throws InterruptedException, IOException{
		         
		wait.until(ExpectedConditions.elementToBeClickable(BrandonPark));
		BrandonPark.click();
		log.info("community name in the community table is clicked");
		
        CommonMethods.scrollToElementClick(driver.findElement(By.xpath("//a[text()='SVG Site Overview']")));    // using JAVASCRIPT EXCECUTER method to click the element
        log.info("Site overview link is clicked");
		
	
       // System.out.println(driver.getTitle());	
	//	String parentWindowId = driver.getWindowHandle();
	//	System.out.println("Parent window id is " +parentWindowId);
		
		Set<String> allWindowsIds= driver.getWindowHandles();
		System.out.println("All other ids are" +allWindowsIds);
		
	/*	for (String x : allWindowsIds){                 // THIS WAY IS NOT WORKING. NOT SURE WHY
			if(!parentWindowId.equalsIgnoreCase(x)){
				driver.switchTo().window(x);
				driver.manage().window().maximize();
				//String xyz = driver.getTitle();
				//System.out.println(xyz);
				
			break;
		          }
	     } */
		
	// USING ITERATOR() to switch to different window
		
		Iterator<String> it=allWindowsIds.iterator();
		String Parentid= it.next();             // By this it will always move to the Parent Window
		String childid = it.next();            // Now it will move to next child window which was opened in Parent window.
		
		driver.switchTo().window(childid);
		
		//return driver.getTitle(); 
	
	   	Boolean isPlanDetailsBtnDisplayed = driver.findElement(By.id("filter-btn")).isDisplayed();
		System.out.println(isPlanDetailsBtnDisplayed);
		return isPlanDetailsBtnDisplayed;
	}
	
  
  //OTHER METHOD To change tabs/windows by converting SET into ARRAYLIST :-   (Mukesh otwani)
    // Set<String> allWindows =driver.getWindowHandles();
    // ArrayLisst<String> tabs + new ArrayList<>(allWindows);      //Here we converted the sets into Array so that we can switch to diff tabs
    //   driver.switchTo().window(tabs.get(0));   // this will take the driver to PARENT Window
    //   driver.switchTo().window(tabs.get(1)); // this is take driver to the 1st opened tab and so on you can give index no.
  
  
	
  
  
  
  
  
  
	//Manually filling data for Manage lots
	/*
	 public void manageLotsFillData(String status, String displayName ,String size , String lpp, String block,String phase ,String elevation , String swing, String description , String address, String hotspotUrl , String hotspotText) throws InterruptedException{
	 
		
		//driver.findElement(By.xpath("//td[text()='Banning Lewis Ranch']")).click();
		BrandonPark.click();
		Thread.sleep(2000);
		
		// here write code to >delete SVG > upload SVG> upload Json 
		
	    //driver.findElement(By.xpath("//tr[@id='524085']//td")).click();
		
		CommonMethods.scrollToElementClick(driver.findElement(By.xpath("//tr[@id='531533']//td")));
		Thread.sleep(2000);
		Select select = new Select(driver.findElement(By.id("statusList")));
		select.selectByVisibleText(status);
		
		isAnAmenityCheckBox.click();
		
		displayNametextBox.clear();
		displayNametextBox.sendKeys(displayName);
		
		lotSizeTextBox.clear();
		lotSizeTextBox.sendKeys(size);
		
		lotPremiumPriceTextBox.clear();
		lotPremiumPriceTextBox.sendKeys(lpp);
		
		blockTextBox.clear();
		blockTextBox.sendKeys(block);
		
		phaseTextBox.clear();
		phaseTextBox.sendKeys(phase);
		
		elevationTextBox.clear();
		elevationTextBox.sendKeys(elevation	);
		
		swingTextBox.clear();
		swingTextBox.sendKeys(swing);
		
		descriptionTextBox.clear();
		descriptionTextBox.sendKeys(description);
		
		addressTextBox.clear();
		addressTextBox.sendKeys(address);
		
		contactUrlTextBox.clear();
		contactUrlTextBox.sendKeys(hotspotUrl);
		
		contactButtonTextBox.clear();
		contactButtonTextBox.sendKeys(hotspotText);
		
		saveChangesButton.click();	
	} 
	*/
		
	// Filling data for Lot via EXCEL
		public void ManageLotsFillDataExcel(String status, String displayName ,String size , String lpp, String block,String phase ,String elevation , String swing, String description , String address, String hotspotUrl , String hotspotText) throws InterruptedException{
			
			//driver.findElement(By.xpath("//td[text()='Banning Lewis Ranch']")).click();
			BrandonPark.click();
			Thread.sleep(2000);
			
			// here write code to >delete SVG > upload SVG> upload Json 
			
		    //driver.findElement(By.xpath("//tr[@id='524085']//td")).click();
			
			CommonMethods.scrollToElementClick(LotId2A1);
			Thread.sleep(2000);
			Select select = new Select(driver.findElement(By.id("statusList")));
			select.selectByVisibleText(status);
			
			isAnAmenityCheckBox.click();
			
			displayNametextBox.clear();
			displayNametextBox.sendKeys(displayName);
			
			lotSizeTextBox.clear();
			lotSizeTextBox.sendKeys(size);
			
			lotPremiumPriceTextBox.clear();
			lotPremiumPriceTextBox.sendKeys(lpp);
			
			blockTextBox.clear();
			blockTextBox.sendKeys(block);
			
			phaseTextBox.clear();
			phaseTextBox.sendKeys(phase);
			
			elevationTextBox.clear();
			elevationTextBox.sendKeys(elevation	);
			
			swingTextBox.clear();
			swingTextBox.sendKeys(swing);
			
			descriptionTextBox.clear();
			descriptionTextBox.sendKeys(description);
			
			addressTextBox.clear();
			addressTextBox.sendKeys(address);
			
			contactUrlTextBox.clear();
			contactUrlTextBox.sendKeys(hotspotUrl);
			
			contactButtonTextBox.clear();
			contactButtonTextBox.sendKeys(hotspotText);
			
			saveChangesButton.click();	
	}
	
	
	
	
		public Boolean sitePreviewLink() throws InterruptedException, IOException{
	         
			wait.until(ExpectedConditions.elementToBeClickable(BrandonPark));
			BrandonPark.click();
			log.info("community name in the community table is clicked");
			
	          
	        CommonMethods.scrollToElementClick(previewLink);  //// using JAVASCRIPT EXCECUTER method to click the element
	        log.info("Site Preview link is clicked");
			
			
			Set<String> allWindowsIds= driver.getWindowHandles();
			System.out.println("All other ids are" +allWindowsIds);
			
		
			
		// USING ITERATOR() to switch to different window
			
			Iterator<String> it=allWindowsIds.iterator();
			String Parentid= it.next();             // By this it will always move to the Parent Window
			String childid = it.next();            // Now it will move to next child window which was opened in Parent window.
			
			driver.switchTo().window(childid);
			driver.manage().window().maximize();
			
			
		
		   	Boolean isResetBtnDisplayed = resetButton.isDisplayed();
			System.out.println(isResetBtnDisplayed);
			return isResetBtnDisplayed;
		}
		
	
		public Boolean geoSpatialSitePlanJsonLink() throws InterruptedException, IOException{
	         
			wait.until(ExpectedConditions.elementToBeClickable(BrandonPark));
			BrandonPark.click();
			log.info("community name in the community table is clicked");
			
	          
	        CommonMethods.scrollToElementClick(ispJsonLink);  //// using JAVASCRIPT EXCECUTER method to click the element
	        log.info("ISP 3.0 JSON link is clicked");
			
			
			Set<String> allWindowsIds= driver.getWindowHandles();
			System.out.println("All other ids are" +allWindowsIds);
			
		
			
		// USING ITERATOR() to switch to different window
			
			Iterator<String> it=allWindowsIds.iterator();
			String Parentid= it.next();             // By this it will always move to the Parent Window
			String childid = it.next();            // Now it will move to next child window which was opened in Parent window.
			
			driver.switchTo().window(childid);
			driver.manage().window().maximize();
			
			
			Boolean isPlanDetailsBtnDisplayed = driver.findElement(By.id("filter-btn")).isDisplayed();
		   	
			
			return isPlanDetailsBtnDisplayed;
		}
		
		
		
	
		public Boolean geoSpatialSitePlanSvgGeoLink() throws InterruptedException, IOException{
	         
			wait.until(ExpectedConditions.elementToBeClickable(creekRidge));
			creekRidge.click();
			log.info("community name in the community table is clicked");
			
	          
	        CommonMethods.scrollToElementClick(ispSvgGeoLink);  //// using JAVASCRIPT EXCECUTER method to click the element
	        log.info("ISP 3.0 SVG GEO link is clicked");
			
			
			Set<String> allWindowsIds= driver.getWindowHandles();
			System.out.println("All other ids are" +allWindowsIds);
			
		
			
		// USING ITERATOR() to switch to different window
			
			Iterator<String> it=allWindowsIds.iterator();
			String Parentid= it.next();             // By this it will always move to the Parent Window
			String childid = it.next();            // Now it will move to next child window which was opened in Parent window.
			
			driver.switchTo().window(childid);
			
			Boolean isSvgGeolotIdDisplayed = SvgGeolotId.isDisplayed();
			log.info("Lot number 81 is found");
			
			return isSvgGeolotIdDisplayed;
		}
		
	
		public boolean deleteAllLotsInfoLink() throws InterruptedException{
			
//			wait.until(ExpectedConditions.elementToBeClickable(Quailhill));    IT IS NOT CLICKING the community when code is run on laptop screen, but works on bigger screen
//			Quailhill.click();
		  //Thread.sleep(4000);
			
			CommonMethods.scrollToElementClick(LakefrontatVineyardTownCenter);
			CommonMethods.scrollToElementClick(LakefrontatVineyardTownCenter);
			CommonMethods.scrollToElementClick(LakefrontatVineyardTownCenter);
			CommonMethods.scrollToElementClick(deleteAllLotsInfo);
			
			Thread.sleep(1000);
			wait.until(ExpectedConditions.elementToBeClickable(deleteSvgConfirmBtn));
			deleteSvgConfirmBtn.click();
			Thread.sleep(4000);
			
			return LakefrontatVineyardTownCenterMissing.isDisplayed();
		}
		
	
	public boolean uploadSVG() throws InterruptedException, AWTException{
		
		CommonMethods.scrollToElementClick(LakefrontatVineyardTownCenter);
		CommonMethods.scrollToElementClick(LakefrontatVineyardTownCenter);
		CommonMethods.scrollToElementClick(LakefrontatVineyardTownCenter);
		Thread.sleep(1000);
		
		uploadSvgLink.click();
		Thread.sleep(2000);
		//chooseFileToUploadButton.sendKeys("E:\\SandeepJavaWorkspace\\Salesarchitect\\TestData\\Child1.svg");     // IT IS NOT UPLOADING THE FILE BECAUSE '@Type =File' attribute is not there in DOM for this element. Also ask how to apply assert here that this element if is visible then dont click n'upload' button
		CommonMethods.scrollToElementClick(chooseFileToUploadButton);
		Thread.sleep(2000);
		Robot robot= new Robot();  // We are using 'ROBOT' class and creating its object here to upload the File coz SendKeys method not working here. 
	   robot.setAutoDelay(1000); // Its equivalent to Thread.Sleep which is provided by ROBOT class
		StringSelection filepath = new StringSelection("E:\\SandeepJavaWorkspace\\Salesarchitect\\TestData\\Child1.svg");   // We use 'StringSelection' Class to copy the file path into the clipboard which needs to be uploaded.
		
		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath,null);  // Here we are pasting the filepath into clipboard by using ToolKit class.
		
		robot.keyPress(KeyEvent.VK_CONTROL);   // We are pressing Ctrl here  and then will press 'v' to paste the file into the 'file name' field of upload file modal window.
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_V);  // we pressed CTRL+V till now
		Thread.sleep(1000);
		
		robot.keyRelease(KeyEvent.VK_V);  // we're releasing the key v here
		robot.keyRelease(KeyEvent.VK_CONTROL); //we're releasing the key CTRL here
	
		
		robot.keyPress(KeyEvent.VK_ENTER);  // We hit ENTER key to upload the file 
		robot.keyRelease(KeyEvent.VK_ENTER);  // we released the ENTER key
		Thread.sleep(1000);
		
		wait.until(ExpectedConditions.elementToBeClickable(uploadButton));
		uploadButton.click();
		Thread.sleep(2000);
		CommonMethods.scrollToElementClick(LakefrontatVineyardTownCenter);
		CommonMethods.scrollToElementClick(LakefrontatVineyardTownCenter);
		LakefrontatVineyardTownCenter.click();
	
		return siteOverviewLink.isDisplayed();
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
