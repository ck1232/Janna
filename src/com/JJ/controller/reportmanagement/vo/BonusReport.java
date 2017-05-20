package com.JJ.controller.reportmanagement.vo;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class BonusReport implements ReportInterface {

	@Override
	public Workbook exportReport(Workbook workbook, Date dateAsOf, Date endDate,
			Map<String, Object> additionalMap) {
		Sheet sheet = workbook.createSheet("Bonus");
		//get year
		Integer year = getYearFromParam(dateAsOf, endDate);
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue("testing");
		return workbook;
	}

	private Integer getYearFromParam(Date dateAsOf, Date endDate) {
		if(dateAsOf == null && endDate == null) {
			Calendar now = Calendar.getInstance();
			Integer year = now.get(Calendar.YEAR);
			return year;
		}
		return null;
	}

}
