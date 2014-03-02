package com.bsabbath.intuicity.web.dto;

public class MetricValue {
	
	private String nationalPercentageAverage;
	
	private String metricPercentage;
	
	private String topThree;
	
	
	public String getNationalPercentageAverage() {
		return nationalPercentageAverage;
	}

	public void setNationalPercentageAverage(String nationalPercentageAverage) {
		this.nationalPercentageAverage = nationalPercentageAverage;
	}

	public String getMetricPercentage() {
		return metricPercentage;
	}

	public void setMetricPercentage(String metricPercentage) {
		this.metricPercentage = metricPercentage;
	}

	public String getTopThree() {
		return topThree;
	}


	public void setTopThree(String topThree) {
		this.topThree = topThree;
	}


	@Override
	public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("[NPA,P,T3] : ["); 
        sb.append(getNationalPercentageAverage());
        sb.append(","); 
        sb.append(getMetricPercentage());
        sb.append(",");
        sb.append(getTopThree());     
        sb.append("]");
        
        return sb.toString();	
        
	}
	
}
