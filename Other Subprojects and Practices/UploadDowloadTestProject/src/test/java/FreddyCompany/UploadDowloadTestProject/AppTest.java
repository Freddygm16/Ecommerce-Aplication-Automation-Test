package FreddyCompany.UploadDowloadTestProject;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest {
	
	By modalMessage = By.cssSelector("div.Toastify__toast-body>div:nth-child(2)");


	@Test
	public void UploadDownloadTest() throws IOException {
		
		//Variables
		String fileLocation =System.getProperty("user.home") + "\\Downloads\\download.xlsx";
		int valueUpdate = 158;

		
		//Initialize diver
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/upload-download-test/");

		//Wait elements appear and updated file xlsx
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fileinput")));
		
		driver.findElement(By.id("downloadButton")).click();
		
		int column = getNumberColumn(fileLocation, "Price");
		
		int row = getNumberRow(fileLocation, "Apple");
		
		UpdatedCell(fileLocation, column, row, valueUpdate);

		
		//Upload file
		WebElement upload = driver.findElement(By.id("fileinput"));

		upload.sendKeys(fileLocation);

		
		//Validate the file upload correctly
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(modalMessage));
		
		String message = driver.findElement(modalMessage).getText();
		
		System.out.println(message);
		
		Assert.assertEquals(message, "Updated Excel Data Successfully.");
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(modalMessage));
		
		//Get the price of a apple fruit
		
		List<WebElement> rowsTable = driver.findElements(By.xpath("//div[contains(@class,\"rdt_TableRow\")]"));
		
		double price = 0;
		
		for (WebElement webElement : rowsTable) {
			String fruitName = webElement.findElement(By.cssSelector("#cell-2-undefined > div")).getText();
			
			if (fruitName.equalsIgnoreCase("Apple")) {
				price = Double.parseDouble(webElement.findElement(By.cssSelector("#cell-4-undefined > div")).getText());
			}
		}
		
		System.out.println(price);
	
	    String fruitName = "Apple";
	    
		String numberPrice = driver.findElement(By.xpath("//div[text()=\"Price\"]")).getAttribute("data-column-id");
		
		String priceChar = driver.findElement(By.xpath("//div[text()=\"Apple\"]/parent::div/parent::div/div//div[text()='"+fruitName+"']/parent::div/parent::div/div[@id='cell-"+numberPrice+"-undefined']/div")).getText();
		
		System.out.println(priceChar);
		
		driver.quit();
	}


	private void UpdatedCell(String fileLocation, int columnNum, int rowNum, int valueUpdate) throws IOException {
		FileInputStream streamInput = new FileInputStream(fileLocation);
		XSSFWorkbook woorkBook = new XSSFWorkbook(streamInput);
		Row row = woorkBook.getSheetAt(0).getRow(rowNum);
		Cell cell = row.getCell(columnNum);
		cell.setCellValue(valueUpdate);
		FileOutputStream streaOutput= new FileOutputStream(fileLocation);
		woorkBook.write(streaOutput);
		streamInput.close();
		streaOutput.close();
		woorkBook.close();
	}


	private int getNumberRow(String fileLocation, String string) throws IOException {
		
		XSSFWorkbook woorkBook = new XSSFWorkbook(fileLocation);
		XSSFSheet sheet = woorkBook.getSheetAt(0);
		Iterator<Row> rows= sheet.rowIterator();
		
		while (rows.hasNext()) {
			Row rowHeader = rows.next();			
			Iterator<Cell> cellsHaedar = rowHeader.cellIterator();
			
			while (cellsHaedar.hasNext()) {
				Cell cell = cellsHaedar.next();		
				
				if (cell.getCellType() == CellType.NUMERIC) {
					continue;
				}
				
				if (cell.getStringCellValue().equalsIgnoreCase(string)) {
					return cell.getRowIndex();
				}
			}
		}
		
		
		return 999;
	}


	private int getNumberColumn(String fileLocation, String string) throws IOException {
		XSSFWorkbook woorkBook = new XSSFWorkbook(fileLocation);
		XSSFSheet sheet = woorkBook.getSheetAt(0);
		Iterator<Row> rows= sheet.rowIterator();
		
		while (rows.hasNext()) {
			Row rowHeader = rows.next();			
			Iterator<Cell> cellsHaedar = rowHeader.cellIterator();
			
			while (cellsHaedar.hasNext()) {
				Cell cell = cellsHaedar.next();		
				
				if (cell.getCellType() == CellType.NUMERIC) {
					continue;
				}
				
				if (cell.getStringCellValue().equalsIgnoreCase(string)) {
					return cell.getColumnIndex();
				}
			}
		}
		
		
		return 999;
	}
}

