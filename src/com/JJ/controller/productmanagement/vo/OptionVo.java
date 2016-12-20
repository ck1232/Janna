package com.JJ.controller.productmanagement.vo;

import java.io.Serializable;
import java.util.List;

public class OptionVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer optionId;
	private String optionName;
	private List<SubOptionVo> subOptionList;
	private String subOptionListComma;
	private Integer sequence;
	public Integer getOptionId() {
		return optionId;
	}
	public void setOptionId(Integer optionId) {
		this.optionId = optionId;
	}
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
	public Integer getSequence() {
		return sequence;
	}
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}
	public String getSubOptionListComma() {
		String subOptionListComma = "";
		for(SubOptionVo vo: subOptionList){
			subOptionListComma += vo.getSubOptionName() + ", ";
		}
		return subOptionListComma.substring(0, subOptionListComma.length()-2);
	}
	public void setSubOptionListComma(String subOptionListComma) {
		this.subOptionListComma = subOptionListComma;
	}

}
