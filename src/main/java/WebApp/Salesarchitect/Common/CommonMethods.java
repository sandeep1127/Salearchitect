package WebApp.Salesarchitect.Common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import WebApp.Salesarchitect.BaseClass.WebBase;

public class CommonMethods extends WebBase{
	
	
	

	public CommonMethods() throws IOException {
		super();
		
	}
	
	public static JavascriptExecutor js;
	public static String TESTDATA_SHEET_PATH ="E:\\SandeepJavaWorkspace\\Salesarchitect\\TestData\\SeleniumLotData.xlsx";
	static Workbook book;
	public static org.apache.poi.ss.usermodel.Sheet sheet;

	
	
	
	
	// METHOD >> To Scroll to a Particular Web element and click it via Java Script Executor
	public static void scrollToElementClick(WebElement webElementXpath) throws InterruptedException{
		js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].scrollIntoView(true)", webElementXpath); 
		Thread.sleep(500); 
		webElementXpath.click();
		
		
	}
	
	
	//METHOD >> To Explicitly Wait for any Web Element for SEND KEYS
	
	
	public static void sendkeys(WebDriver driver , WebElement element, int timeout, String value){
		new WebDriverWait(driver,timeout).until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}
	
	//METHOD >> To Explicitly Wait for any Web Element for CLICKING
	
	public static void clickOn(WebDriver driver , WebElement element, int timeout){
		new WebDriverWait(driver,timeout).until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		
	}
	
	
	// METHOD >> This method has been used in WebEventListner class to take screenshot only when some exception OR error occurs.
	
	public  static void takeScreenshotAtEndOfTest() throws IOException {
		//File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		
	//	String currentDir = System.getProperty("user.dir");
	
		
		
	//FileUtils.copyFile(scrFile, new File(currentDir + "/ErrorScreenshots/" + System.currentTimeMillis() + ".png"));    //FILEUTILS here is giving error at present so i used the FileHandler class in below line but it doesnt work
	//	FileHandler.copy(scrFile, new File("E:\\SandeepJavaWorkspace\\Salesarchitect\\FailedScreenShots" + System.currentTimeMillis() + ".png"));
	}
	
	
	
	
	
	
	
	
	// Method >> To use DataProvider to fetch data from Excel:-
	
	/*static String filePath = "E:\\SandeepJavaWorkspace\\Salesarchitect\\TestData\\SeleniumLotData.xlsx";

	private static String TEST_DATA_SHEET = filePath;
	private static Workbook book;
	private static org.apache.poi.ss.usermodel.Sheet sheet;

	public static Object[][] getTestData(String sheetName) {

		Object data[][] = null;

		try {
			FileInputStream ip = new FileInputStream(TEST_DATA_SHEET);
			book = WorkbookFactory.create(ip);
			sheet = book.getSheet(sheetName);

			data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

			for (int i = 0; i < sheet.getLastRowNum(); i++) {
				for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
					data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return data;
	} */
	
	
	// Method >> To use DataProvider to fetch data from Excel:- ( NAVEEN's CODE)
	
 public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet= book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	
	
 }
 

}
