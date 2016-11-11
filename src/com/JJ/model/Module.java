package com.JJ.model;

import java.io.Serializable;
import java.util.List;

public class Module extends Base implements Serializable {

	private Integer id;

	private String name;

	private String icon;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	private static final long serialVersionUID = 1L;

	public List<Submodule> subModuleList;
    public List<Submodule> getSubModuleList() {
		return subModuleList;
	}

	public void setSubModuleList(List<Submodule> subModuleList) {
		this.subModuleList = subModuleList;
	}

	@Override
	public String toString() {
		return "Module [id=" + id + ", name=" + name + ", icon=" + icon + ", deleteind=" + super.getDeleteind() + "]";
	}
}