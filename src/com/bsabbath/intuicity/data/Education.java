package com.bsabbath.intuicity.data;

import java.util.HashMap;

import com.bsabbath.intuicity.web.dto.Metric;
import com.bsabbath.intuicity.web.dto.MetricValue;
import com.bsabbath.intuicity.web.dto.Metrics;

public class Education {

	private static HashMap<String, Float> m = new HashMap<String, Float>(20);
	
	static
	{
		m.put( "St. John's" , 1.30f);//100* (6855f/526702) );
		m.put( "Charlottetown", 1.1f);//100* (1599.18f/145855));
		m.put( "Halifax", 0.78f);//100* (7183.59f/921727));
		m.put( "Fredericton", 0.75f);//100*(5657.65f/751171));
		m.put( "Montreal", 2.30f);//100*(187913f/8155300));
		m.put( "Toronto", 1.27f);//100*(171904f/13538000));
		m.put( "Winnipeg", 0.59f);//100*(7406.65f/1265000));
		m.put( "Saskatoon", 0.47f);//100*(5285.12f/1114170));
		m.put( "Edmonton", 1.28f);//100*(51496.2f/4025100));
		m.put( "Vancouver", 2.06f);//100*(94548.5f/4582000));
		m.put( "Whitehorse", 0.15f);//100*(537.176f/367000));
		m.put( "Yellowknife", 0.16f);//100*(708.353f/435000));
		m.put( "Iqaluit", 0.1f);//100*(338.4f/356000));
	}
	
	public static void addMetric(Metrics pMetrics,String city)
	{
		if (null != pMetrics)
		{
			Metric metric = getMetric(city);
			pMetrics.addMetric(metric);
		}		
	}
	
	public static Metric getMetric(String city)
	{
		Metric metric = new Metric();
		metric.setName("Education");
		
		MetricValue value = new MetricValue();
		
		value.setMetricPercentage(String.valueOf(get(city)));
		value.setNationalPercentageAverage(String.valueOf((1.30f+1.1f+0.78f+0.75f+2.30f+1.27f+0.59f+0.47f+1.28f+2.06f+0.15f+0.16f+0.1f)/13));
		value.setTopThree("1) Montreal 2.30%,<br>2) Vancouver 2.06%,<br>3) St. John's 1.30%");
		
		metric.setValue(value);
		
		return metric;
	}
	
	private static Float get(String city)
	{
		Float fResult = m.get(city);
		
		if (null == fResult)
		{
			fResult = -1F;
		}
		
		return fResult;
	}

}
