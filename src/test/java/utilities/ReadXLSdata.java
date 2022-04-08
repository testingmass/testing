package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.io.FileNotFoundException;


import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ReadXLSdata{

// @DataProvider(name="ecelfile")
public static void main(String[] args) throws EncryptedDocumentException, IOException
{
		
	ReadXLSdata red = new ReadXLSdata();
red.getData("login");

}
		public String[][] getData(String excelSheetName) throws EncryptedDocumentException, IOException
		{
	
	
	//String excelSheetName =string.getName();
	
		System.out.println("the path is:" +System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\testdata.xlsx");
	
		
		
		
		File f = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\testdata.xlsx");
				FileInputStream fis = new FileInputStream(f);
				   Workbook wb  = WorkbookFactory.create(fis);
		Sheet sheetName = wb.getSheet(excelSheetName);
		
		
		
		
		int totalRows = sheetName.getLastRowNum();
		System.out.println(totalRows);
		Row rowCells = sheetName.getRow(0);
		int totalCols = rowCells.getLastCellNum();
		System.out.println(totalCols);
		
		
		
		
		DataFormatter format = new DataFormatter();
		
		String testData[][] = new String[totalRows][totalCols];
		for(int i=1; i<=totalRows;i++) {
			for (int j = 0; j < totalCols; j++) {
				testData[i-1][j] =format.formatCellValue(sheetName.getRow(i).getCell(j));
				System.out.println(testData[i-1][j]);
				
			}
		}
		
		
	return testData;
		
		}
		
	}



