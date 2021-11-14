package WebApp.Salesarchitect.Common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import WebApp.Salesarchitect.BaseClass.WebBase;

public class CommonMethods extends WebBase{
	
	
	

	public CommonMethods() throws IOException {
		super();
		
	}
	
	public static JavascriptExecutor js;
	
	
	
	
	
	// METHOD >> To Scroll to a Particular Web element via Java ScriptExecutor
	public static void scrollToElement(WebElement webElementXpath) throws InterruptedException{
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
	
	// Method >> To use DataProvider
	
	static String filePath = "E:\\SandeepJavaWorkspace\\Salesarchitect\\TestData\\SeleniumLotData.xlsx";

	private static String TEST_DATA_SHEET = filePath;
	private static Workbook book;
	private static Sheet sheet;

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
	}
	
	
	
	
}
