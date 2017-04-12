package com.JJ.service.reportmanagement.expensecontrol;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import com.JJ.controller.reportmanagement.ExpenseControlReportCriteria;
import com.JJ.controller.salarybonusmanagement.vo.SalaryBonusVO;

public class ExcelFileHelper {
	private static final Logger logger = Logger.getLogger(ExcelFileHelper.class);
	
	public ExcelFileHelper() {}
	
	
	
	@SuppressWarnings("deprecation")
	private static int[] findIndex(Sheet sheet, String cellContent) {
		int[] index = new int[2];
	    for (Row row : sheet) {
	        for (Cell cell : row) {
	            if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
	            	String cellvalue = cell.getRichStringCellValue().getString();
	                if (cellvalue.trim().equals(cellContent)) {
	                	index[0] = row.getRowNum();
	                	index[1] = cell.getColumnIndex();
	                    return index;  
	                }
	            }
	        }
	    }               
	    return index;
	}
	
	@SuppressWarnings("deprecation")
	private static int[] findIndexWithPattern(Sheet sheet, String pattern) {
		int[] index = new int[2];
	    for (Row row : sheet) {
	        for (Cell cell : row) {
	            if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
	            	String cellvalue = cell.getRichStringCellValue().getString();
	                if (cellvalue.trim().contains(pattern)) {
	                	index[0] = row.getRowNum();
	                	index[1] = cell.getColumnIndex();
	                    return index;  
	                }
	            }
	        }
	    }               
	    return index;
	}
	
	//if merged, return last cell column index
	private static int getLastCell(Sheet sheet, int[] cell) {
        for(int i = 0; i < sheet.getNumMergedRegions(); ++i)
        {
            CellRangeAddress range = sheet.getMergedRegion(i);
            if (range.getFirstRow() <= cell[0] && range.getLastRow() >= cell[0] 
            		&& range.getFirstColumn() == cell[1] && range.getLastColumn() != cell[1])
                return range.getLastColumn();
            if(range.getFirstRow() != cell[0]) {
            	break;
            }
        }
        return cell[1];
	}
	
	public HSSFWorkbook writeToFile(File inputfile, List<SalaryBonusVO> bonusList, ExpenseControlReportCriteria reportCriteria){
		try {
			FileInputStream file = new FileInputStream(inputfile);
			HSSFWorkbook workbook = new HSSFWorkbook(file);
//			HSSFSheet sheet = workbook.getSheet("Sheet1");
//			Cell cell = null;
//			cell = sheet.getRow(5).getCell(2);
//			cell.setCellValue("Company name");;
//			
//			/* Writing Messenger */
//			int[] messengerIndex = findIndex(sheet, "Messrs");
//            int messengerContent = getLastCell(sheet, messengerIndex);
//            cell = sheet.getRow(messengerIndex[0]).getCell(messengerContent+1);
//            cell.setCellValue(invoiceList.get(0).getMessenger());
//            
//            /* Writing Statement of Account As Of */
//            int[] statementDateIndex = findIndexWithPattern(sheet, "Statement of Account as of");
//            cell = sheet.getRow(statementDateIndex[0]).getCell(statementDateIndex[1]);
//            cell.setCellValue("Statement of Account as " + statementPeriod);
//            
//            /* Writing content */
//            int[] dateHeaderIndex = findIndex(sheet, "Date");
//            int[] invoiceNoHeaderIndex = findIndex(sheet, "Invoice");
//            int[] statusHeaderIndex = findIndex(sheet, "Status");
////            int[] chequeNoHeaderIndex = findIndex(sheet, "Cheque No.");
//            int[] amountHeaderIndex = findIndex(sheet, "($)    Amount");
//            SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM");
//            int row = dateHeaderIndex[0] + 1;
//            Double totalAmount = 0.0;
//            for(InvoiceVO invoice : invoiceList) {
//            	cell = sheet.getRow(row).getCell(dateHeaderIndex[1]);
//            	cell.setCellValue(formatter.format(invoice.getInvoiceDate()));
//            	
//            	cell = sheet.getRow(row).getCell(invoiceNoHeaderIndex[1]);
//            	cell.setCellValue(invoice.getInvoiceId());
//            	
//            	cell = sheet.getRow(row).getCell(statusHeaderIndex[1]);
//            	cell.setCellValue(invoice.getStatus());
//            	
//            	/*if(invoice.getChequeid() != null) {
//            		cell = sheet.getRow(row).getCell(chequeNoHeaderIndex[1]);
//            		cell.setCellValue(invoice.getChequeid());
//            	}*/
//            	
//            	cell = sheet.getRow(row).getCell(amountHeaderIndex[1]);
//            	cell.setCellValue(invoice.getTotalAmt().doubleValue());
//            	
//            	totalAmount += invoice.getTotalAmt().doubleValue();
//            	row++;
//            }
//            
//            /* Writing Invoice Total Price */
//            int[] totalPriceIndex = findIndex(sheet, "TOTAL");
//            cell = sheet.getRow(totalPriceIndex[0]).getCell(totalPriceIndex[1]+1);
//            cell.setCellValue(totalAmount);
            
			return workbook;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
