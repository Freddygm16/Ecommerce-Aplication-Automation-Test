package TestsDataDriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataDrivenImplementation {
	
	@Test(dataProvider = "ExcelData")
	public void ExcelDataDrivenTest(String data1, String data2, String number, String testData) {
		System.out.println(data1);
		System.out.println(data2);
		System.out.println(number);
		System.out.println(testData);
	}
	
	
	@DataProvider
	public Object[][] ExcelData() throws IOException{
		int iteration = 0; //Number of execution that do testcase with data.
		int countParameters = 0;
		Object data[][] = new Object[1][4];
		
		FileInputStream fls = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/Book.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(fls);
		
		int sheets = workBook.getNumberOfSheets();
		
		for (int i = 0; i < sheets; i++) {
			
			if(workBook.getSheetAt(i).getSheetName().equalsIgnoreCase("Hoja1")) {
				
				XSSFSheet sheet =  workBook.getSheetAt(i);
				
				Iterator<Row> rows = sheet.iterator();
				
				Iterator<Cell> cells = rows.next().cellIterator();

				int columnCases = 0;
				int k = 0;
				
				while(cells.hasNext()) {
					
					if(cells.next().getStringCellValue().equalsIgnoreCase("TestCases")) {
						columnCases = k;
						break;
					}
					
					k++;
				}
				
				while (rows.hasNext()) {
					
					Row datarow = rows.next();
					
					if(datarow.getCell(columnCases).getStringCellValue().equalsIgnoreCase("purchase")) {
						
						Iterator<Cell> dataCells = datarow.cellIterator();
						
						while (dataCells.hasNext()) {
							Cell cellData = dataCells.next();
							
							if(cellData.getColumnIndex() == columnCases) {
								continue;
							}
							
							if(cellData.getCellType() == CellType.NUMERIC) {
								data[iteration][countParameters] = NumberToTextConverter.toText(cellData.getNumericCellValue());
								countParameters ++;
							}else {
								data[iteration][countParameters] = cellData.getStringCellValue();
								countParameters ++;
							}
					
						}
						iteration ++;
					}
				}
				
			}
		}
		
		
		return data;
	}

}