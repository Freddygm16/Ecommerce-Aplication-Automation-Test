package TestsDataDriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataDrivenImplementation {
	DataFormatter formatter = new DataFormatter();
	
	@Test(dataProvider = "driverTest")
	public void ExcelDataDrivenTest(String data1, String data2, String number, String testData) {
		System.out.println(data1);
		System.out.println(data2);
		System.out.println(number);
		System.out.println(testData);
	}
	
	
	@DataProvider(name = "driverTest")
	public Object[][] ExcelData() throws IOException{
		FileInputStream fls = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/Book.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(fls);
		
		XSSFSheet sheets = workBook.getSheetAt(0);
		int numberRows = sheets.getPhysicalNumberOfRows();
		XSSFRow row = sheets.getRow(0);
		int numberColumns = row.getPhysicalNumberOfCells();
		
		Object data[][] = new Object[numberRows-1][numberColumns - 1];
		
		for (int i = 0; i < numberRows - 1; i++) {
			XSSFRow rowData = sheets.getRow(i+1);
			
			for (int j=0; j < numberColumns - 1; j++) {
				XSSFCell cellData = rowData.getCell(j+1);
				data[i][j] = formatter.formatCellValue(cellData);
			}
		}
		
		return data;
		
	}
	
	
//	public Object[][] getData(String testCaseName, XSSFSheet sheet) {
//		int iteration = 0; //Number of execution that do testcase with data.
//		int countParameters = 0;
//		Object data[][] = new Object[1][4];
//		
//		FileInputStream fls = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/Book.xlsx");
//		XSSFWorkbook workBook = new XSSFWorkbook(fls);
//		
//		int sheets = workBook.getNumberOfSheets();
//		
//		for (int i = 0; i < sheets; i++) {
//			
//			if(workBook.getSheetAt(i).getSheetName().equalsIgnoreCase("Hoja1")) {
//				
//				XSSFSheet sheet =  workBook.getSheetAt(i);
//				
//				Iterator<Row> rows = sheet.iterator();
//				
//				Iterator<Cell> cells = rows.next().cellIterator();
//
//				int columnCases = 0;
//				int k = 0;
//				
//				while(cells.hasNext()) {
//					
//					if(cells.next().getStringCellValue().equalsIgnoreCase("TestCases")) {
//						columnCases = k;
//						break;
//					}
//					
//					k++;
//				}
//				
//				while (rows.hasNext()) {
//					
//					Row datarow = rows.next();
//					
//					if(datarow.getCell(columnCases).getStringCellValue().equalsIgnoreCase("purchase")) {
//						
//						Iterator<Cell> dataCells = datarow.cellIterator();
//						
//						while (dataCells.hasNext()) {
//							Cell cellData = dataCells.next();
//							
//							if(cellData.getColumnIndex() == columnCases) {
//								continue;
//							}
//							
//							if(cellData.getCellType() == CellType.NUMERIC) {
//								data[iteration][countParameters] = NumberToTextConverter.toText(cellData.getNumericCellValue());
//								countParameters ++;
//							}else {
//								data[iteration][countParameters] = cellData.getStringCellValue();
//								countParameters ++;
//							}
//					
//						}
//						iteration ++;
//					}
//				}
//				
//			}
//		}
//		
//		
//		return data;
//		
//	}

}