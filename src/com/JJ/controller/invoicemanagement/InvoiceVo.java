package com.JJ.controller.invoicemanagement;

import java.io.Serializable;
import java.util.LinkedList;
import com.JJ.model.FileMeta;

public class InvoiceVo implements Serializable {
	private static final long serialVersionUID = 1L;
	private LinkedList<FileMeta> invoiceList;
	
	public LinkedList<FileMeta> getInvoiceList() {
		return invoiceList;
	}
	public void setInvoiceList(LinkedList<FileMeta> invoiceList) {
		this.invoiceList = invoiceList;
	}

	
}
