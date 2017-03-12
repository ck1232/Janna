package com.JJ.controller.common;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelFileHelper {
	private static final Logger logger = Logger.getLogger(ExcelFileHelper.class);
	
	public ExcelFileHelper() {}
		
	//if merged, return last cell column index
	
	public static HSSFWorkbook writeToFile(ResultSet resultSet){
		try {
			int rowNum = 0;
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet("EXPORT");
			
			ResultSetMetaData metaData = resultSet.getMetaData();
			int columnCount = metaData.getColumnCount();
			HSSFRow header = sheet.createRow(rowNum++);
			for (int i = 1; i <= columnCount; i++){
				header.createCell(i).setCellValue(metaData.getColumnName(i));
			}
			
			while (resultSet.next()){
				HSSFRow row = sheet.createRow(rowNum++);
				for (int i = 1; i <= columnCount; i++){
					row.createCell(i).setCellValue(resultSet.getString(i));
				}
			}
	            
            
			return workbook;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
