package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;

	public static void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	public static void windowMaximize() {
		driver.manage().window().maximize();

	}

	public static void launchUrl(String url) {
		driver.get(url);

	}

	public static void pageTitle() {
		String title = driver.getTitle();
		System.out.println(title);
	}

	public static void pageUrl() {
		String url = driver.getCurrentUrl();
		System.out.println(url);
	}

	public static void passText(String txt, WebElement ele) {
		ele.sendKeys(txt);

	}

	public static void closeEntireBrowswe() {
		driver.quit();

	}
	public static void clickbtn(WebElement ele) {
		ele.click();
		
	}
	public static void screenShot(String imgname)throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File image = ts.getScreenshotAs(OutputType.FILE);
		File f=new File("location+ imgname.png");
		FileUtils.copyFile(image, f);
		
	}
	public static Actions a;
	
	public static void moveTheCursor(WebElement targetWebElement) {
		a=new Actions(driver);
		a.moveToElement(targetWebElement).perform();
		
	}
	public static void dragDrop(WebElement dragWebElement,WebElement dropElement) {
		a=new Actions(driver);
		a.dragAndDrop(dragWebElement, dropElement).perform();
		
	}
	public static JavascriptExecutor js;
		
	
	public static void scrollThePage(WebElement tarwebEle) {
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", tarwebEle);
	}
	public static void scroll(WebElement element) {
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(false)", element);
		
	}
	public static void excelRead(String sheetName,int rowNum,int cellNum) throws IOException {
		File f=new File("location.xlsx");
		FileInputStream fis=new FileInputStream(f);
		Workbook wb=new XSSFWorkbook(fis);
		 Sheet mysheet = wb.getSheet("Sheet1");
		 Row r = mysheet.getRow(rowNum);
		 Cell c = r.getCell(cellNum);
		 int cellType=c.getCellType();
		 
		 String value=" ";
		 if (cellType==1) {
			 String cellValue = c.getStringCellValue();
		
	} else if (DateUtil.isCellDateFormatted(c)) {
		 Date dd = c.getDateCellValue();
		 SimpleDateFormat s=new  SimpleDateFormat(value);
		 String format = s.format(dd);
	}
	else {
		 double d = c.getNumericCellValue();
		 long l=(long)d;
		 String valueOf = String.valueOf(l);
	}
	}
		 public static void createNewExcelFile(int rowNum,int cellNum,String writeData) throws IOException {
			 File f=new File("C:\\Users\\user\\eclipse-workspace\\FrameWork-Challenges\\MavenProject\\Excel\\data.xlsx");
				Workbook wb=new XSSFWorkbook();
				Sheet newSheet = wb.createSheet("Datas");
				Row createRow = newSheet.createRow(rowNum);
				Cell createCell = createRow.createCell(cellNum);
				createCell.setCellValue(writeData);
				FileOutputStream fos=new FileOutputStream(f);
				wb.write(fos);
}
		 public static void createCell(int getRow,int crecell,String newdata) throws IOException {
				File f=new File("C:\\Users\\user\\eclipse-workspace\\FrameWork-Challenges\\MavenProject\\Excel\\data.xlsx");
				FileInputStream fis=new FileInputStream(f);
				Workbook wb=new XSSFWorkbook(fis);
				 Sheet s = wb.getSheet("datas");
				 Row r= s.getRow(getRow);
				 Cell c = r.createCell(crecell);
				 c.setCellValue(newdata);
				 FileOutputStream fos=new FileOutputStream(f);
					wb.write(fos);
		 }
		 public static void createRow(int creRow,int crecell,String newdata) throws IOException {
				File f=new File("C:\\Users\\user\\eclipse-workspace\\FrameWork-Challenges\\MavenProject\\Excel\\data.xlsx");
				FileInputStream fis=new FileInputStream(f);
				Workbook wb=new XSSFWorkbook(fis);
				 Sheet s = wb.getSheet("datas");
				 Row r= s.createRow(creRow);
				 Cell c = r.createCell(crecell);
				 c.setCellValue(newdata);
				 FileOutputStream fos=new FileOutputStream(f);
					wb.write(fos);
		 }
		 public static void updateDataToParticularCell(int getTheRow,int getThecell,String writenewdata,String exisitingdata) throws IOException {
				File f=new File("Excellocation.xlsx");
				FileInputStream fis=new FileInputStream(f);
				Workbook wb=new XSSFWorkbook(fis);
				 Sheet s = wb.getSheet("datas");
				 Row r= s.getRow(getTheRow);
				 Cell c = r.getCell(getThecell);
				 String str=c.getStringCellValue();
				 if(str.equals(exisitingdata)) {
				 c.setCellValue(writenewdata);
				 }
				 FileOutputStream fos=new FileOutputStream(f);
					wb.write(fos);
		 }
}