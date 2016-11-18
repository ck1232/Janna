package com.JJ.controller.productmanagement.vo;

import java.io.Serializable;

public class SubOptionVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String subOptionName;
	private boolean display;
	private int seq;
	public String getSubOptionName() {
		return subOptionName;
	}
	public void setSubOptionName(String subOptionName) {
		this.subOptionName = subOptionName;
	}
	public boolean isDisplay() {
		return display;
	}
	public void setDisplay(boolean display) {
		this.display = display;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
}
