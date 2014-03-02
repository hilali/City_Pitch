package com.bsabbath.intuicity.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bsabbath.intuicity.model.ErrorMessage;
import com.bsabbath.intuicity.web.dto.Metric;
import com.bsabbath.intuicity.web.dto.Metrics;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping( value = "ws" )
public class WSController {


	private static final Logger LOGGER = LoggerFactory.getLogger(WSController.class);


	@RequestMapping(value = "/v1/metrics/{city}", method = RequestMethod.GET)
	@ResponseBody
	//public ResponseEntity<Metrics> getMetrics(@PathVariable String city,@RequestBody LifeQualityCriterias criterias)
	public ResponseEntity<Metrics> getMetrics(@PathVariable String city)
	{
		LOGGER.info("Metrics Asked for  ["+city+"]");

		ResponseEntity<Metrics> response;
		HttpStatus responseStatus = HttpStatus.OK;
		Metrics metrics = new Metrics();
		
		try {
			
			metrics = new Metrics();
			
			Metric metric = new Metric();
			metric.setValue("Good");
			metrics.addMetric(metric);
			
			metric = new Metric();
			metric.setValue("Very Good");
			metrics.addMetric(metric);
			
			metric = new Metric();
			metric.setValue("Excellent");
			metrics.addMetric(metric);
			
			metric = new Metric();
			metric.setValue("Not Bad");
			metrics.addMetric(metric);
			
			metric = new Metric();
			metric.setValue("Bad");
			metrics.addMetric(metric);
			
			metric = new Metric();
			metric.setValue("Very Bad");
			metrics.addMetric(metric);
			
			if (metrics.hasErrors()){
				responseStatus = getHttpStatusFromErrorCode(metrics.getErrorMessage().getCode());
			}
			
		}catch(NullPointerException e){ 
			metrics = new Metrics();
			metrics.setErrorMessage(new ErrorMessage("ERROR_CODE_BAD_ARGUMENTS", e.getMessage()));
			responseStatus = HttpStatus.BAD_REQUEST;
			LOGGER.error(metrics.getErrorMessage().toString());
			
			
		}
		catch (Exception e){
			metrics = new Metrics();
			metrics.setErrorMessage(new ErrorMessage("ERROR_CODE_UNDEFINED", e.getMessage()));
			responseStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			LOGGER.error(metrics.getErrorMessage().toString());
		}
		
		response = new ResponseEntity<Metrics>(metrics,responseStatus);
		
		return response;
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