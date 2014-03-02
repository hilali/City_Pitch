package com.bsabbath.intuicity.task;

import java.io.File;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

import com.bsabbath.intuicity.helper.DateHelper;

public class ApplicationTask {
	private static String cookiePrefix;

	private static String appVersion;

	private static final Logger logger = Logger.getLogger(ApplicationTask.class);

	@Value("${tempDir}") String tempDir;
	@Value("${app.version}") String appVersionPropValue;

	// create temporary directory
	public void onStartup() {
		File filesTemp = new File(tempDir);

        if (filesTemp.exists()){
            logger.info("Temp Directory already exists,");
        } else if (!filesTemp.mkdirs()) {
            logger.error("Warning:Temp Directory not created.");
        }

		initCookie();

		appVersion = appVersionPropValue;
	}

	private void initCookie() {
		cookiePrefix = "cpitch_" + DateHelper.today("yyyyMMddhhmmss") + "_";
	}

	public static String getCookiePrefix() {
		return cookiePrefix;
	}

	public static String getApplicationVersion() {
		return appVersion;
	}
}
