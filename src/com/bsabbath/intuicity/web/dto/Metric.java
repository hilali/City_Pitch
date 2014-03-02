package com.bsabbath.intuicity.web.dto;

public class Metric {
	
	private String name;
	
	private MetricValue value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}		
	
	public MetricValue getValue() {
		return value;
	}

	public void setValue(MetricValue value) {
		this.value = value;
	}

	@Override
	public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("[");        
        sb.append("\"");
        sb.append(name);
        sb.append("\"");
        sb.append(",");
        sb.append("\"");
        sb.append(value);
        sb.append("\"");        
        sb.append("]");
        
        return sb.toString();	
        
	}
	
}
