package com.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LibGlobal {
	WebDriver driver;

	public void navTo(String url) {
		driver.navigate().to(url);
	}

	public void navBack() {
		driver.navigate().back();
	}

	public void navForward() {
		driver.navigate().forward();
	}

	public void refresh() {
		driver.navigate().refresh();
	}

	public void loadUrl(String url) {
		driver.get(url);
	}

	public WebDriver getDriver() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Santhosh\\eclipse-workspace\\Selenium6_Robot\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}

	public WebElement findElementID(String s) {
		WebElement findElement = driver.findElement(By.id(s));
		return findElement;
	}

	public WebElement findElementName(String s) {
		WebElement findElement = driver.findElement(By.name(s));
		return findElement;
	}

	public WebElement findElementClassName(String s) {
		WebElement findElement = driver.findElement(By.className(s));
		return findElement;
	}

	public WebElement findElementXPath(String s) {
		WebElement findElement = driver.findElement(By.xpath(s));
		return findElement;
	}

	public void maximize() {
		driver.manage().window().maximize();
	}

	public String getTitle() {
		String text = driver.getTitle();
		return text;
	}

	public void printTitle() {
		String title = driver.getTitle();
		System.out.println(title);
	}

	public String getUrl() {
		String title = driver.getCurrentUrl();
		return title;

	}

	public void printUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
	}

	public void quit() {
		driver.quit();
	}

	public void close() {
		driver.close();
	}

	public void sendKeys(WebElement element, String str) {
		element.sendKeys(str);
	}

	public void click(WebElement element) {
		element.click();
	}

	public String getText(WebElement element) {
		String text = element.getText();
		return text;
	}

	public void printText(WebElement element) {
		String text = element.getText();
		System.out.println(text);
	}

	public String getAttribute(WebElement element, String str) {
		String s1 = element.getAttribute(str);
		return s1;

	}

	public void debug(long l) throws InterruptedException {
		Thread.sleep(l);
	}

	public void moveToElement(WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
		// new Actions(driver).moveToElement(element).perform();
	}

	public void dragAndDrop(WebElement source, WebElement destination) {
		Actions a = new Actions(driver);
		a.dragAndDrop(source, destination).perform();
	}

	public void rightClick(WebElement element) {
		Actions a = new Actions(driver);
		a.contextClick(element).perform();
	}

	public void doubleclick(WebElement element) {
		Actions a = new Actions(driver);
		a.doubleClick(element).perform();
	}

	public void down(int a) throws AWTException {
		Robot r = new Robot();
		for (int i = 0; i < a; i++) {
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
		}
	}

	public void up(int a) throws AWTException {
		Robot r = new Robot();
		for (int i = 0; i < a; i++) {
			r.keyPress(KeyEvent.VK_UP);
			r.keyRelease(KeyEvent.VK_UP);
		}
	}

	public void enter() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	public void tab(int a) throws AWTException {
		Robot r = new Robot();
		for (int i = 0; i < a; i++) {
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
		}
	}

	public void alertAccept() {
		Alert al = driver.switchTo().alert();
		al.accept();
	}

	public void alertDismiss() {
		Alert al = driver.switchTo().alert();
		al.dismiss();
	}

	public void promptAlert(String s) {
		Alert al = driver.switchTo().alert();
		al.sendKeys(s);
		al.accept();
	}

	public void screenShot(String filePath) throws IOException {
		TakesScreenshot screen = (TakesScreenshot) driver;
		File location = screen.getScreenshotAs(OutputType.FILE);
		File dest = new File(filePath);
		FileUtils.copyFile(location, dest);
	}

	public void scrollDown(WebElement element) {
		JavascriptExecutor execute = (JavascriptExecutor) driver;
		execute.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	public void scrollUp(WebElement element) {
		JavascriptExecutor execute = (JavascriptExecutor) driver;
		execute.executeScript("arguments[0].scrollIntoView(false)", element);
	}

	// public void javaSendKeys(WebElement element,String str) {
	// JavascriptExecutor execute=(JavascriptExecutor) driver;
	// execute.executeScript("arguments[0].setAttribute('value','str')", element);
	// }

	public void javaClick(WebElement element) {
		JavascriptExecutor execute = (JavascriptExecutor) driver;
		execute.executeScript("arguments[0].click()", element);
	}

	public void frameIndex(int a) {
		driver.switchTo().frame(a);
	}

	public void frameWebelement(WebElement element) {
		driver.switchTo().frame(element);
	}

	public void frameStringt(String str) {
		driver.switchTo().frame(str);
	}

	public void defaultContent() {
		driver.switchTo().defaultContent();
	}

	public void parentFrame(int a) {
		for (int i = 0; i < a; i++) {
			driver.switchTo().parentFrame();
		}
	}

	public void switchWindow(int a) {
		Set<String> allId = driver.getWindowHandles();

		int count = 0;
		for (String child : allId) {
			if (count == a) {
				driver.switchTo().window(child);
			}
			count++;
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String getDataFromExcel(String filePath, String sheetName, int rowNo, int cellNo) throws IOException {
		File f = new File(filePath);
		FileInputStream fi = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fi);
		Sheet s = w.getSheet(sheetName);
		Row r = s.getRow(rowNo);
		Cell c = r.getCell(cellNo);
		int type = c.getCellType();

		String value = null;
		if (type == 1) {
			value = c.getStringCellValue();
		} else if (DateUtil.isCellDateFormatted(c)) {
			Date dateCellValue = c.getDateCellValue();
			SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yy");
			value = sim.format(dateCellValue);
		} else {
			double d = c.getNumericCellValue();
			long l = (long) d;
			value = String.valueOf(l);
		}
		return value;
	}

	public void sendDataToExcel(String filePath, String sheetName, String cellData, int rowNo, int cellNo)
			throws IOException {
		File f = new File(filePath);
		FileInputStream fi = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fi);
		Sheet s = w.getSheet(sheetName);
		Row r = s.getRow(rowNo);
		Cell c = r.createCell(cellNo);
		c.setCellValue(cellData);
		FileOutputStream o = new FileOutputStream(f);
		w.write(o);
		System.out.println("done");
	}

}
