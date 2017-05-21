package com.JJ.helper.vo;

import java.util.LinkedHashMap;

import com.JJ.helper.vo.ExcelColumn.ColumnType;

public class ReportMapping {
	private LinkedHashMap<String, ExcelColumn> mapping;
	
	public ReportMapping(){
		mapping = new LinkedHashMap<String, ExcelColumn>();
	}

	public LinkedHashMap<String, ExcelColumn> getMapping() {
		return mapping;
	}

	public void clear(){
		mapping.clear();
	}
	
	public void addMapping(String header, ExcelColumn column){
		mapping.put(header, column);
	}
	
	public void addMapping(String header, String variableName, ColumnType type){
		mapping.put(header, new ExcelColumn(variableName, type));
	}
	
	public void addTextMapping(String header, String variableName){
		mapping.put(header, new ExcelColumn(variableName, ColumnType.Text));
	}
	
	public void addMoneyMapping(String header, String variableName){
		mapping.put(header, new ExcelColumn(variableName, ColumnType.Money));
	}
	
	public void addPercentageMapping(String header, String variableName){
		mapping.put(header, new ExcelColumn(variableName, ColumnType.Percentage));
	}
	
	public void addDateMapping(String header, String variableName){
		mapping.put(header, new ExcelColumn(variableName, ColumnType.Date));
	}
	
	public void addDecimalMapping(String header, String variableName){
		mapping.put(header, new ExcelColumn(variableName, ColumnType.Decimal));
	}
	
	public void addNumberMapping(String header, String variableName){
		mapping.put(header, new ExcelColumn(variableName, ColumnType.Number));
	}
	
	public int size(){
		return mapping.size();
	}
}
