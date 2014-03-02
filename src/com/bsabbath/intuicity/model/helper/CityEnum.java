package com.bsabbath.intuicity.model.helper;

public enum CityEnum {
	
	//Mapped with the database on table BUILD_STATUS
	
	MONTREAL("MTL"),
	QUEBEC("QC"),
	TORONTO("TRT"),
	VANCOUVER("VAN"),
	CALGARY("CLG");
	 
	 private final String code;
	 
	 private CityEnum(String code) {
	   this.code = code;
	 }
	 
	 public String getCode() {
	   return code;
	 }
}
