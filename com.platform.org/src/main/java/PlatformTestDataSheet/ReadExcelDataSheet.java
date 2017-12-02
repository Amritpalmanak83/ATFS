package PlatformTestDataSheet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelDataSheet 
{
	XSSFWorkbook wb;
	
	XSSFSheet sheet1;
	
	
	public ReadExcelDataSheet(String ExcelPath)
	{
		try {
				File src=  new File(ExcelPath);
	
				FileInputStream fsi = new FileInputStream(src); // read the file from source
				
				wb = new XSSFWorkbook(fsi);
				
				//sheet1 = wb.getSheetAt(0);
				
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}
	public String [] getUserData(int sheetnum , int row )
	{
			sheet1 = wb.getSheetAt(sheetnum);
			String Userdata = sheet1.getRow(row).getCell(0).getStringCellValue();
			String Passdata = sheet1.getRow(row).getCell(1).getStringCellValue();
			try {
				wb.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return new String[] {Userdata , Passdata};
	}

	public String [] getUserInfo(int sheetnum , int row )
	{
			sheet1 = wb.getSheetAt(sheetnum);
			String User_name_data = sheet1.getRow(row).getCell(0).getStringCellValue();
			String Pass_word_data = sheet1.getRow(row).getCell(1).getStringCellValue();
			String Pass_conf_data = sheet1.getRow(row).getCell(1).getStringCellValue();
			String User_display_data = sheet1.getRow(row).getCell(3).getStringCellValue();			
			String User_email_data = sheet1.getRow(row).getCell(1).getStringCellValue();	
			try {
				wb.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return new String[] {User_name_data , Pass_word_data,Pass_conf_data,User_display_data,User_email_data};
	}
}
