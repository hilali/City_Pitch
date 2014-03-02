package com.bsabbath.intuicity.web.dto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.bsabbath.intuicity.model.ErrorMessage;

@XmlRootElement (name="metricPerCity", namespace="http://www.bsabbath.com/intuicity")
@XmlAccessorType(XmlAccessType.FIELD)
public class Metrics {
	
	public Metrics() {}
    public Metrics(List<Metric> metrics) {
        this.metrics = metrics;
    }

    public void addMetric(Metric pMetric)
    {
    	getMetrics().add(pMetric);
    }

    public List<Metric> getMetrics() {
    	
    	if (null == this.metrics)
    	{
    		setMetrics(new ArrayList<Metric>());
    	}
    	
        return metrics;
    }

    public void setMetrics(List<Metric> metrics) {
        this.metrics = metrics;
    }

	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public boolean hasErrors()
	{
		return (null != getErrorMessage());
	}
    
	@XmlElementWrapper(name="metrics")
	@XmlElement (name="metric")
    private List<Metric> metrics;
	
	@XmlElement (name="error")
	private ErrorMessage errorMessage ;
}
