package com.bsabbath.intuicity.helper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;

public abstract class DateHelper {

	public static final String ISO_FORMAT_DATE = "yyyy-MM-dd";
	public static final String SHORT_FORMAT_DATE = "dd/MM/yyyy";
	public static final String LONG_FORMAT_DATE = "dd/MM/yyyy HH:mm:ss";
	public static final String START_DAY_TIME = "00:00:00";
	public static final String START_MORNING_TIME = "00:00:00";
	public static final String END_MORNING_TIME = "00:00:00";

	public static final String START_AFTERNOON_TIME = "12:00:01";
	public static final String END_AFTERNOON_TIME = "18:00:00";

	public static final String START_EVENING_TIME = "18:00:01";
	public static final String END_EVENING_TIME = "23:59:59";

	public static final String END_DAY_TIME = "23:59:59";
	
	public static final String REGEX_DATE_ISO = "^(19|20)\\d\\d([- /.])(0[1-9]|1[012])\\2(0[1-9]|[12][0-9]|3[01])$";

	/**
	 * Return Date as String in the ISO Format.
	 * 
	 * @param date
	 * @return
	 */
	public static String dateToString(Date date) {
		return dateToString(date, SHORT_FORMAT_DATE);
	}

	/**
	 * @param Date
	 * @param String
	 *            format
	 * @return String date
	 */
	public static String dateToString(Date date, String format) {
		DateFormat formatter = new SimpleDateFormat(format, Locale.US);
		return formatter.format(date);
	}

	public static Date dateFromStringISO(String dateStr) throws ParseException {
		return dateFromString(dateStr, SHORT_FORMAT_DATE);
	}

	/**
	 * @param dateStr
	 * @param format
	 * @return
	 * @throws ParseException
	 */
	public static Date dateFromString(String dateStr, String format) throws ParseException {

		if (StringUtils.isBlank(dateStr)) {
			return null;
		}

		DateFormat formatter = new SimpleDateFormat(format, Locale.US);

		return formatter.parse(dateStr);
	}

	// dd-MMM-yy
	public static Date dateFromStringFormatShortMonth(String dateStr) throws ParseException {

		if (StringUtils.isBlank(dateStr)) {
			return null;
		}
		// String strParam = dateStr.replaceAll("janv-",
		// "janv.-").replaceAll("févr-", "févr.-").replaceAll("avr-",
		// "avr.-").replaceAll("juil-", "juil.-").replaceAll("sept-",
		// "sept.-").replaceAll("oct-", "oct.-").replaceAll("nov-",
		// "nov.-").replaceAll("déc-", "déc.-");
		String strParam = dateStr;
		DateFormat formatter = new SimpleDateFormat("dd-MMM-yy", Locale.US);

		return formatter.parse(strParam);
	}

	/**
	 * Return ToDay Date as String (Default Format)
	 * 
	 * @return
	 */
	public static String today() {
		return today(SHORT_FORMAT_DATE);
	}

	public static Date todayDate() {
		return new Date();
	}

	/**
	 * Return ToDay Date as String (Default Format)
	 * 
	 * @return
	 */
	public static String today(String format) {
		return dateToString(todayDate(), format);
	}

	/**
	 * 
	 * @param date
	 * @param nbDays
	 * @return
	 */
	public static String dateNDaysBeforeStr(Date date, int nbDays) {
		String resultStr = null;

		Date beforeDate = DateUtils.addDays(date, -nbDays);

		resultStr = dateToString(dateNDaysBefore(beforeDate, nbDays));

		return resultStr;
	}

	public static Date dateNDaysBefore(Date date, int nbDays) {
		Date beforeDate = DateUtils.addDays(date, -nbDays);

		return beforeDate;
	}

	public static Date dateNDaysBeforeToDay(int nbDays) {
		return dateNDaysBefore(todayDate(), nbDays);
	}

	/**
	 * 
	 * @param date
	 * @param nbDays
	 * @return
	 */
	public static String dateNDaysAfterStr(Date date, int nbDays) {
		String resultStr = null;

		resultStr = dateToString(dateNDaysAfter(date, nbDays));

		return resultStr;
	}

	public static Date dateNDaysAfter(Date date, int nbDays) {
		Date afterDate = DateUtils.addDays(date, nbDays);

		return afterDate;
	}

	public static Date dateNDaysAfterToDay(int nbDays) {
		return dateNDaysAfter(todayDate(), nbDays);
	}
}
