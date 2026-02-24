package TestsDataDriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDrivenTest {

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
				   
				   if(cells.next().getStringCellValue().equalsIgnoreCase(TestCaseName)) {
					  column = k; 
					  break;
				   }
				   
				   k++;
			   }
			   
			   
			   while(rows.hasNext()) {
				   
				   Row r = rows.next();
				   
				   if(r.getCell(column).getStringCellValue().equalsIgnoreCase("Purchase")) {
					   
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
		
		for (String nombres : getData("TestCases")) {
			System.out.println(nombres);
		}
		
	}

}
