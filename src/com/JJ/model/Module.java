package com.JJ.model;

import java.util.List;

public class Module {
   

	/**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column module.id
     *
     * @mbggenerated Sat Oct 15 16:50:06 SGT 2016
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column module.name
     *
     * @mbggenerated Sat Oct 15 16:50:06 SGT 2016
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column module.icon
     *
     * @mbggenerated Sat Oct 15 16:50:06 SGT 2016
     */
    private String icon;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column module.deleteInd
     *
     * @mbggenerated Sat Oct 15 16:50:06 SGT 2016
     */
    private String deleteind;
    public List<Submodule> subModuleList;
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column module.id
     *
     * @return the value of module.id
     *
     * @mbggenerated Sat Oct 15 16:50:06 SGT 2016
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column module.id
     *
     * @param id the value for module.id
     *
     * @mbggenerated Sat Oct 15 16:50:06 SGT 2016
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column module.name
     *
     * @return the value of module.name
     *
     * @mbggenerated Sat Oct 15 16:50:06 SGT 2016
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column module.name
     *
     * @param name the value for module.name
     *
     * @mbggenerated Sat Oct 15 16:50:06 SGT 2016
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column module.icon
     *
     * @return the value of module.icon
     *
     * @mbggenerated Sat Oct 15 16:50:06 SGT 2016
     */
    public String getIcon() {
        return icon;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column module.icon
     *
     * @param icon the value for module.icon
     *
     * @mbggenerated Sat Oct 15 16:50:06 SGT 2016
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column module.deleteInd
     *
     * @return the value of module.deleteInd
     *
     * @mbggenerated Sat Oct 15 16:50:06 SGT 2016
     */
    public String getDeleteind() {
        return deleteind;
    }
    
   

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column module.deleteInd
     *
     * @param deleteind the value for module.deleteInd
     *
     * @mbggenerated Sat Oct 15 16:50:06 SGT 2016
     */
    public void setDeleteind(String deleteind) {
        this.deleteind = deleteind;
    }
    
    public List<Submodule> getSubModuleList() {
		return subModuleList;
	}

	public void setSubModuleList(List<Submodule> subModuleList) {
		this.subModuleList = subModuleList;
	}

	@Override
	public String toString() {
		return "Module [id=" + id + ", name=" + name + ", icon=" + icon + ", deleteind=" + deleteind + "]";
	}
}