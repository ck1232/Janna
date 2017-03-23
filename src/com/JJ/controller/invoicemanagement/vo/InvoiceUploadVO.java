package com.JJ.controller.invoicemanagement.vo;

import java.io.Serializable;
import java.util.LinkedList;

import com.JJ.controller.common.vo.FileMetaVO;

public class InvoiceUploadVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private LinkedList<FileMetaVO> invoiceList;
	
	public LinkedList<FileMetaVO> getInvoiceList() {
		return invoiceList;
	}
	public void setInvoiceList(LinkedList<FileMetaVO> invoiceList) {
		this.invoiceList = invoiceList;
	}

	
}
