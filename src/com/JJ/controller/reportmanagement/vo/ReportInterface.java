package com.JJ.controller.reportmanagement.vo;

import java.util.Date;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;

public interface ReportInterface {
	public Sheet exportReport(Date dateAsOf, Map<String, Object> additionalMap);
}
