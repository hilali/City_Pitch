package com.bsabbath.intuicity.web.dto;


public class LifeQualityCriteria {

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	private String name ;

	@Override
	public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("{");
        
        sb.append("\"");
        sb.append("name");
        sb.append("\"");
        sb.append(":");
        sb.append("\"");
        sb.append(name);
        sb.append("\"");
        
        sb.append("}");
        return sb.toString();	
        
	}
}
