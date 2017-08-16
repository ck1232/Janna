package com.JJ.controller.productcategorymanagement;

public enum ImageLinkRefTypeEnum {
	
	PRODUCT_CATEGORY("product_category");
	
	private String type;
	
	ImageLinkRefTypeEnum(String type){
		this.type = type;
	}
	public String getType(){
		return type;
	}
	
	public static String getEnum(String enumString){
		if(ImageLinkRefTypeEnum.values() != null && ImageLinkRefTypeEnum.values().length > 0){
			for(ImageLinkRefTypeEnum employmentEnum : ImageLinkRefTypeEnum.values()){
				if(employmentEnum.toString().equals(enumString)){
					return employmentEnum.getType();
				}
			}
		}
		return null;
	}
}
