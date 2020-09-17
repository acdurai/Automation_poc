package browser.amazon.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import browser.amazon.driverCommons.LaunchBrowser;



public class ExcelParser {
	
	private  Logger log = Logger.getLogger(LaunchBrowser.class.getName());
	
	public XSSFWorkbook workbook = null;
    public XSSFSheet sheet = null;
    public XSSFRow row = null;
    public XSSFCell cell = null;
	
	public Workbook parseXLS(String fileName){
		
		try {
			
			String path = System.getProperty("user.dir");
			String filePath = path+"/src/main/resources/"+fileName;
        	log.info("Reading the following json file  " +filePath );
			
        	FileInputStream fis = new FileInputStream(new File(filePath));
			workbook = new XSSFWorkbook(fis);
			fis.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return workbook;
	}
	
	public String getCellData(String sheetName, String columnName, String rowName) {
		int col_Num =0;
		int row_Num = 1;
		
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(0);
		// get the column number for the given column name
		for(int i = 0; i < row.getLastCellNum();i++)
        {
			
            if(row.getCell(i).getStringCellValue().trim().equals(columnName.trim())) {
                col_Num = i;
            }
        }
		
		// get row number the given row name
		for(int i=1;i<sheet.getLastRowNum()+1; i++) {
			row = sheet.getRow(i);
			if(row.getCell(0).getStringCellValue().trim().equals(rowName.trim())) {
				
                row_Num = i;
			}
		}
		
		//get the cell value for the given column and row name
		row = sheet.getRow(row_Num);
		return row.getCell(col_Num).getStringCellValue().trim();
		
	}
	
	public static void main(String[] args) {
		ExcelParser ep = new ExcelParser();
		ep.parseXLS("TestData.xlsx");
		String searchKeyWord = ep.getCellData("Search_Product", "Search_keyword", "TVBrand");
		System.out.println(searchKeyWord);
	}
}
