package com.JJ.controller.reportmanagement.vo;

import java.util.Date;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExpenseReport implements ReportInterface {

	@Override
	public void exportReport(Workbook workbook, Date dateAsOf, Date endDate,
			Map<String, Object> additionalMap) {
		Sheet sheet = workbook.createSheet("Expense report");
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue("testing");
	}

}
