package com.bsabbath.intuicity.web.dto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.StringUtils;

@XmlRootElement
public class LifeQualityCriterias {
	
//	public LifeQualityCriterias() {}
//    public LifeQualityCriterias(List<LifeQualityCriteria> criterias) {
//        this.criterias = criterias;
//    }

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

    public void seCriterias(List<LifeQualityCriteria> criterias) {
        this.criterias = criterias;
    }
    
	@XmlElementWrapper(name="criterias")
	@XmlElement (name="criteria")    
    private List<LifeQualityCriteria> criterias;
	

    
	public String toJSONString() 
	{
        StringBuilder sb = new StringBuilder();
               
        sb.append("{");
        
        sb.append("\"");
        sb.append("criterias");
        sb.append("\"");
        sb.append(":");
        sb.append("[");
        
        if (null != criterias)
        {
        	sb.append(StringUtils.join(criterias, ","));
        }
    		
    	sb.append("]");

        
        sb.append("}");
        return sb.toString();
	}	
	
}
