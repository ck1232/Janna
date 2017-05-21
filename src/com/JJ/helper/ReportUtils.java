package com.JJ.helper;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.JJ.helper.vo.ExcelColumn;
import com.JJ.helper.vo.ReportMapping;

public class ReportUtils {
	public static <T>void writeData(Sheet sheet, List<T> list, ReportMapping reportMapping){
		if(list != null && list.size() > 0 && sheet != null 
				&& reportMapping != null && reportMapping.size() > 0){
			int rowNum = sheet.getPhysicalNumberOfRows();
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
					case Money:
						{
							Number num = (Number)value;
							NumberFormat mf = new DecimalFormat("'$'#.##");
							cell.setCellValue(mf.format(num));
						}
						break;
					case Decimal:
						{
							Number num = (Number)value;
							NumberFormat mf = new DecimalFormat("#.##");
							cell.setCellValue(mf.format(num));
						}
						break;
					case Number:
						{
							Number num = (Number)value;
							NumberFormat mf = new DecimalFormat("#");
							cell.setCellValue(mf.format(num));
						}
						break;
					case Percentage:
						{
							Number num = (Number)value;
							NumberFormat mf = new DecimalFormat("#.##'%'");
							cell.setCellValue(mf.format(num));
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
}
