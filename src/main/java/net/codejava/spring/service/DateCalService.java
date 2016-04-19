package net.codejava.spring.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class DateCalService {

	public DateCalService() {
		// TODO Auto-generated constructor stub
	}
	//计算两日期的天数之差
	 public static int daysBetween(Date date1,Date date2)  

	    {  

	        Calendar cal = Calendar.getInstance();  
	        cal.setTime(date1); 
	       
	        long time1 = cal.getTimeInMillis();               
	        cal.setTime(date2);  
	        long time2 = cal.getTimeInMillis();       
	        long between_days=(time2-time1)/(1000*3600*24);  
	       return Integer.parseInt(String.valueOf(between_days));         

	    } 
	//将日期向后推i天 
	public static Date addDays(Date date,int i){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, i);
		
		
		Date newdate=cal.getTime();
		return newdate;
		
	}
}
