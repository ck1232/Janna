package com.JJ.controller.productmanagement.vo;

import java.io.Serializable;
import java.util.List;

public class OptionVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String optionName;
	private List<SubOptionVo> subOptionList;
	public String getOptionName() {
		return optionName;
	}
	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}
	public List<SubOptionVo> getSubOptionList() {
		return subOptionList;
	}
	public void setSubOptionList(List<SubOptionVo> subOptionList) {
		this.subOptionList = subOptionList;
	}

}
