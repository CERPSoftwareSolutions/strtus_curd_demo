package com.centris.campus.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

public class HelperClass {
private static final Logger logger = Logger.getLogger(HelperClass.class);
	
	public static String convertUIToDatabase(String date) {
		logger.info("Starting");
		String currdate = null;

		try {
			Date sd = new SimpleDateFormat("dd-MM-yyyy").parse(date);
			currdate = new SimpleDateFormat("yyyy-MM-dd").format(sd);
		} catch (ParseException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.info("Ending");
		return currdate;
	}
	
	public static String convertDatabaseToUI(String date) {
		logger.info("Starting");
		String currdate = null;

		try {
			Date sd = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			currdate = new SimpleDateFormat("dd-MM-yyyy").format(sd);
		} catch (ParseException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.info("Ending");
		return currdate;
	}
	
	public static Timestamp getCurrentTimestamp() {
		return new Timestamp(System.currentTimeMillis());
	}
	
	public static java.sql.Date getCurrentSqlDate() {
		java.util.Date sd = new java.util.Date();
		
		return new java.sql.Date(sd.getTime());
	}
	
	public static java.sql.Date getTomorrowDate(java.sql.Date date) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		cal.add(Calendar.DATE, 1);

		date = new java.sql.Date(cal.getTimeInMillis());

		return date;
	}
	
	public static Boolean DateValidator(String date){

		String DATE_PATTERN ="(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)";

		Pattern pattern = Pattern.compile(DATE_PATTERN);

		Matcher matcher = pattern.matcher(date);
		if(matcher.matches()){
			matcher.reset();

			if(matcher.find()){
				String day = matcher.group(1);
				String month = matcher.group(2);
				int year = Integer.parseInt(matcher.group(3));

				if (day.equals("31") && 
						(month.equals("4") || month .equals("6") || month.equals("9") ||
								month.equals("11") || month.equals("04") || month .equals("06") ||
								month.equals("09"))) {
					return false; // only 1,3,5,7,8,10,12 has 31 days
				} else if (month.equals("2") || month.equals("02")) {
					//leap year
					if(year % 4==0){
						if(day.equals("30") || day.equals("31")){
							return false;
						}else{
							return true;
						}
					}else{
						if(day.equals("29")||day.equals("30")||day.equals("31")){
							return false;
						}else{
							return true;
						}
					}
				}else{				 
					return true;				 
				}
			}else{
				return false;
			}		  
		}else{
			return false;
		}	

	}

}
