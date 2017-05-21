package com.JJ.helper.vo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExcelColumn {
	private String variableName;
	private ColumnType columnType;
	private List<ColumnStyle> columnStyleList;
	
	public ExcelColumn(String variableName, ColumnType columnType) {
		this.variableName = variableName;
		this.columnType = columnType;
		this.columnStyleList = new ArrayList<ColumnStyle>();
	}
	
	public ExcelColumn(String variableName, ColumnType columnType, List<ColumnStyle> styleList) {
		this.variableName = variableName;
		this.columnType = columnType;
		this.columnStyleList = styleList;
	}
	
	public ExcelColumn(String variableName, ColumnType columnType, ColumnStyle styleList) {
		this.variableName = variableName;
		this.columnType = columnType;
		this.columnStyleList = Arrays.asList(styleList);
	}

	public enum ColumnType{
		Text, Money, Date, Percentage, Decimal, Number;
	}
	
	public enum ColumnStyle{
		Header, Bold, Underline, Italic, Bg_blue, ;
	}


	public String getVariableName() {
		return variableName;
	}


	public void setVariableName(String variableName) {
		this.variableName = variableName;
	}


	public ColumnType getColumnType() {
		return columnType;
	}


	public void setColumnType(ColumnType columnType) {
		this.columnType = columnType;
	}


	public List<ColumnStyle> getColumnStyleList() {
		return columnStyleList;
	}


	public void setColumnStyleList(List<ColumnStyle> columnStyleList) {
		this.columnStyleList = columnStyleList;
	}
}


