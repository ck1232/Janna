package com.JJ.controller.productmanagement.vo;

import java.io.Serializable;

public class SubOptionVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer subOptionId;
	private String subOptionName;
	private String code;
	private boolean display;
	private String optionName;
	private int seq;
	public Integer getSubOptionId() {
		return subOptionId;
	}
	public void setSubOptionId(Integer subOptionId) {
		this.subOptionId = subOptionId;
	}
	public String getSubOptionName() {
		return subOptionName;
	}
	public void setSubOptionName(String subOptionName) {
		this.subOptionName = subOptionName;
	}
	public String getOptionName() {
		return optionName;
	}
	public void setOptionName(String optionName) {
		this.optionName = optionName;
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
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + seq;
		result = prime * result + ((subOptionName == null) ? 0 : subOptionName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SubOptionVO other = (SubOptionVO) obj;
		if (seq != other.seq)
			return false;
		if (subOptionName == null) {
			if (other.subOptionName != null)
				return false;
		} else if (!subOptionName.equals(other.subOptionName))
			return false;
		return true;
	}
}
