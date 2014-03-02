package com.bsabbath.intuicity.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bsabbath.intuicity.model.ErrorMessage;
import com.bsabbath.intuicity.web.dto.LifeQualityCriteria;
import com.bsabbath.intuicity.web.dto.LifeQualityCriterias;
import com.bsabbath.intuicity.web.dto.Metric;
import com.bsabbath.intuicity.web.dto.Metrics;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping( value = "ws" )
public class WSController {


	private static final Logger LOGGER = LoggerFactory.getLogger(WSController.class);


	@RequestMapping(value = "/v1/metrics/{city}", method = RequestMethod.POST)
	@ResponseBody
	public Metrics getMetrics(@PathVariable String city,@RequestBody LifeQualityCriterias criterias)	
	{
		LOGGER.info("Metrics Asked for  ["+city+"]");
		
		LOGGER.info("NB LifeQualityCriterias  ["+((null != criterias) ? criterias.getCriterias().size():0)+"]");

		Metrics metrics = null;
		
		try {
			
			metrics = getMockedMetrics(criterias);
			
		}catch(NullPointerException e){ 
			metrics = new Metrics();
			metrics.setErrorMessage(new ErrorMessage("ERROR_CODE_BAD_ARGUMENTS", e.getMessage()));

			LOGGER.error(metrics.getErrorMessage().toString());
			
			
		}
		catch (Exception e){
			metrics = new Metrics();
			metrics.setErrorMessage(new ErrorMessage("ERROR_CODE_UNDEFINED", e.getMessage()));
			LOGGER.error(metrics.getErrorMessage().toString());
		}
		
		return metrics;
	}
	
	private Metrics getMockedMetrics(LifeQualityCriterias criterias)
	{
		final String[] M_VALUES = {"Good","Very Good","Excellent","Not Bad","Bad","Very Bad"};
		Metrics metrics = new Metrics();
		Metric metric = null;
		
		if (null != criterias)
		{
			int index = 0;
			for(LifeQualityCriteria criteria:criterias.getCriterias())
			{
				metric = new Metric(criteria.getName(),M_VALUES[index++]);
				
				metrics.addMetric(metric);				
			}
		}
		
		return metrics;
	}


	private HttpStatus getHttpStatusFromErrorCode(String code){
		/*
		 * TODO : Complete this... I don't like this code
		 * ntf_ : 404
		 * ite_ : 500 erreur serveur interne
		 * 
		 * 
		 */
		
		return HttpStatus.INTERNAL_SERVER_ERROR;
	}
	
}
