package com.JJ.service.invoicemanagement;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellRangeAddress;

import com.JJ.model.Invoice;

public class ExcelFileHelper {
	private static final Logger logger = Logger.getLogger(ExcelFileHelper.class);
	
	public ExcelFileHelper() {}
	
	public Invoice readFromFile(byte[] file) {
		Invoice invoice = new Invoice();
		InputStream is = null;
		
		try {
            is = new ByteArrayInputStream(file);
            Workbook workbook = WorkbookFactory.create(is);
            Sheet sheet = workbook.getSheet("Sheet1");

            
            /* Getting Messenger */
            int[] messengerIndex = findIndex(sheet, "Messrs");
            int messengerContent = getLastCell(sheet, messengerIndex);
            Cell messenger = sheet.getRow(messengerIndex[0]).getCell(messengerContent+1);
            String cellvalue = messenger.getRichStringCellValue().getString();
            messenger = sheet.getRow(messengerIndex[0]+2).getCell(messengerContent+1);
            cellvalue += messenger.getRichStringCellValue().getString();
            
            logger.info(messengerIndex[0]+ ", " +  messengerIndex[1] + ", " + messengerContent);
            logger.info(cellvalue);
            invoice.setMessenger(cellvalue);
            
            /* Getting Invoice Id */
            int[] invoiceIndex = findIndexWithPattern(sheet, "INVOICE");
            Cell invoiceId = sheet.getRow(invoiceIndex[0]).getCell(invoiceIndex[1]);
            cellvalue = invoiceId.getRichStringCellValue().getString();
            int i = 0;
            while (i < cellvalue.length() && !Character.isDigit(cellvalue.charAt(i))) i++;
            logger.info("index: " + i);
            if(i < cellvalue.length()) {
            	logger.info(cellvalue.substring(i, cellvalue.length()));
            	invoice.setInvoiceid(Integer.valueOf(cellvalue.substring(i, cellvalue.length())));
            }
            
            /* Getting Invoice Date */
            int[] dateIndex = findIndex(sheet, "Date:");
            Cell invoiceDate = sheet.getRow(dateIndex[0]).getCell(dateIndex[1]+1);
            try{
            	Date celldatevalue = invoiceDate.getDateCellValue();
            	logger.info(celldatevalue);
                invoice.setInvoicedate(celldatevalue);
            }catch(Exception e) {
            	logger.info("Error getting date");
//            	e.printStackTrace();
            	try{
	            	cellvalue = invoiceDate.getRichStringCellValue().getString();
	            	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
	            	invoice.setInvoicedate(formatter.parse(cellvalue));
            	}catch(Exception ex){
            		logger.info("Error getting date again");
            	}
            }
            
            
            /* Getting Invoice Total Price */
            int[] totalPriceIndex = findIndex(sheet, "TOTAL");
            Cell invoiceTotalPrice = sheet.getRow(totalPriceIndex[0]).getCell(totalPriceIndex[1]+1);
            Double cellnumvalue = invoiceTotalPrice.getNumericCellValue();
            
            logger.info(messengerIndex[0]+ ", " +  messengerIndex[1] + ", " + messengerContent);
            logger.info(cellnumvalue);
            invoice.setTotalprice(BigDecimal.valueOf(cellnumvalue));
            return invoice;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try{
                if(is != null) is.close();
            } catch (Exception ex){
                 
            }
        }
		return null;
	}
	
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
	
	
}
