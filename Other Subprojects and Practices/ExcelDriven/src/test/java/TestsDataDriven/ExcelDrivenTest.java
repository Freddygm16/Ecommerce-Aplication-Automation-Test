package TestsDataDriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDrivenTest {
	static DataFormatter formatter = new DataFormatter();
	
	public static ArrayList<String> getData(String TestCaseName) throws IOException{
		ArrayList<String> data = new ArrayList<String>();
		
		FileInputStream fls = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/Book.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(fls); 
		
		int sheets = workBook.getNumberOfSheets();
		
		for (int i = 0; i < sheets; i++) {
			
			if(workBook.getSheetAt(i).getSheetName().equalsIgnoreCase("Hoja1")) {
			   XSSFSheet sheet =  workBook.getSheetAt(i);
			   
			   Iterator<Row> rows = sheet.iterator();
			   
			   Iterator<Cell> cells = rows.next().cellIterator();
			   
			   int k=0;
			   int column = 0;
			   
			   while(cells.hasNext()) {
				  
				   //Cell value = cells.next();
				   
				   if(cells.next().getStringCellValue().equalsIgnoreCase("TestCaseName")) {
					  column = k; 
					  break;
				   }
				   
				   k++;
			   }
			   
			   
			   while(rows.hasNext()) {
				   
				   Row r = rows.next();
				   
				   if(r.getCell(column).getStringCellValue().equalsIgnoreCase(TestCaseName)) {
					   
					   Iterator<Cell> cellsPurchase = r.iterator();
					
					   while(cellsPurchase.hasNext()) {
						   Cell cellData = cellsPurchase.next();
						   
					   	   if(cellData.getCellType() == CellType.NUMERIC) {
							   data.add(NumberToTextConverter.toText(cellData.getNumericCellValue())); 
					   	   }else {
							   data.add(cellData.getStringCellValue()); 
					   	   }

					   }
					   
				   }
				   
			   }
			   
			  return data;
			   
			} else {
				return null;
			}
			
		}
		
		return null;
	}
	
	public static void main(String[] args) throws IOException {
		
//		for (String nombres : getData("TestCases")) {
//			System.out.println(nombres);
//		}
		
		
		FileInputStream fls = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/Book.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(fls);
		
		XSSFSheet sheets = workBook.getSheetAt(0);
		int numberRows = sheets.getPhysicalNumberOfRows();
		XSSFRow row = sheets.getRow(0);
		int numberColumns = row.getPhysicalNumberOfCells();
		
		Object data[][] = new Object[numberRows-1][numberColumns];
		
		for (int i = 1; i < numberRows - 1; i++) {
			XSSFRow rowData = sheets.getRow(i);
			for (int j=0; j < numberColumns; j++) {
				XSSFCell cellData = rowData.getCell(j);
				data[i][j] = formatter.formatCellValue(cellData);
				System.out.println(data[i][j]);
			}
		}
		
		//return data;
		
		
	}

}
