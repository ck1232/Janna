package com.JJ.controller.reportmanagement.vo;

import java.util.Date;
import java.util.Map;

import org.apache.poi.ss.usermodel.Workbook;

public interface ReportInterface {
	public void exportReport(Workbook workbook, Date dateAsOf,Date endDate, Map<String, Object> additionalMap);
}
