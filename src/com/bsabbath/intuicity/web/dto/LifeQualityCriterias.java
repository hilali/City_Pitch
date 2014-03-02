package com.bsabbath.intuicity.web.dto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LifeQualityCriterias {
	
	public LifeQualityCriterias() {}
    public LifeQualityCriterias(List<LifeQualityCriteria> criterias) {
        this.criterias = criterias;
    }

    public void addCriteria(LifeQualityCriteria pCriteria)
    {
    	getCriterias().add(pCriteria);
    }    

    public List<LifeQualityCriteria> getCriterias() {
    	
    	if (null == this.criterias)
    	{
    		seCriterias(new ArrayList<LifeQualityCriteria>());
    	}
        return criterias;
    }

    @XmlElement(name = "criteria")
    public void seCriterias(List<LifeQualityCriteria> criterias) {
        this.criterias = criterias;
    }
    
    private List<LifeQualityCriteria> criterias;
}
