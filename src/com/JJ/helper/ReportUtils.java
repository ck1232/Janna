package com.JJ.helper;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.JJ.helper.vo.ExcelColumn;
import com.JJ.helper.vo.ReportMapping;

public class ReportUtils {
	public static <T>void writeData(Sheet sheet, List<T> list, ReportMapping reportMapping){
		if(list != null && list.size() > 0 && sheet != null 
				&& reportMapping != null && reportMapping.size() > 0){
			int rowNum = sheet.getPhysicalNumberOfRows();
			reportMapping = setCellStyleForColumn(sheet.getWorkbook(), reportMapping);
			Row row = sheet.createRow(rowNum++);
			writeHeader(row, reportMapping);
			for(T obj : list){
				row = sheet.createRow(rowNum++);
				writeRow(row, obj, reportMapping);
			}
		}
	}
	
	private static void writeRow(Row row, Object object, ReportMapping reportMapping){
		int cellNum = 0;
		for(String header : reportMapping.getMapping().keySet()){
			ExcelColumn column = reportMapping.getMapping().get(header);
			Cell cell = row.createCell(cellNum++);
			cell.setCellStyle(column.getCellStyle());
			Object value = GeneralUtils.getObjectProprty(object, column.getVariableName());
			if(value == null){
				cell.setCellValue("");
			}else{
				switch(column.getColumnType()){
					case Text: cell.setCellValue((String)value);
						break;
					case Date: 
						{
							if(value instanceof Date){
								Date date = (Date)value;
								cell.setCellValue(GeneralUtils.convertDateToString(date, GeneralUtils.STANDARD_DATE_FORMAT));
							}else{
								cell.setCellValue("");
							}
						}
						break;
					case Percentage:
					case Number:
					case Decimal:
					case China_Money:
					case Money:
						{
							Number num = (Number)value;
							cell.setCellValue(num.doubleValue());
						}
						break;
					default:cell.setCellValue(value.toString());break;
				}
			}
		}
	}
	
	private static void writeHeader(Row row, ReportMapping reportMapping){
		int cellNum = 0;
		for(String header : reportMapping.getMapping().keySet()){
			Cell cell = row.createCell(cellNum++);
			cell.setCellValue(header);
		}
	}
	
	private static ReportMapping setCellStyleForColumn(Workbook wb, ReportMapping reportMapping){
		ExcelUtils excelUtils = new ExcelUtils(wb);
		for(String header : reportMapping.getMapping().keySet()){
			ExcelColumn column = reportMapping.getMapping().get(header);
			CellStyle cs = excelUtils.generateCellStyle(column.getColumnType(), column.getColumnStyleList());
			column.setCellStyle(cs);
		}
		return reportMapping;
	}
}
