package PlatformTestDataSheet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelDataSheet 
{
	XSSFWorkbook wb;
	
	XSSFSheet sheet1;
	
	
	public WriteExcelDataSheet(String ExcelPath)
	{
		try {
				File src=  new File(ExcelPath);
	
				FileOutputStream fout = new FileOutputStream(src); // read the file from source
				
				wb.write(fout);
				
				//sheet1 = wb.getSheetAt(0);
				
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}
	public void outputResultUserInfo(int sheetnum , int row , int col, String value )
	{
			sheet1 = wb.getSheetAt(sheetnum);
			sheet1.getRow(row).createCell(col).setCellValue(value);
			try {
				wb.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}	
}
