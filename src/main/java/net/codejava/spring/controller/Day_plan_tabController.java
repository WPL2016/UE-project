package net.codejava.spring.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import net.codejava.spring.dao.daointerface.Produce_plan_tabDAO;
import net.codejava.spring.model.Produce_plan_tab;
import net.codejava.spring.model.Day_plan_tab;

@Controller 
public class Day_plan_tabController {
	@Autowired
	private Produce_plan_tabDAO produce_plan_tabDAO;
	
	
	@RequestMapping(value="/today_plan_tab")
	public ModelAndView toDay_plan_tab(HttpServletRequest request,@RequestParam String produce_plan_num ){
		ModelAndView model=new ModelAndView();
		Produce_plan_tab produce_plan_tab=produce_plan_tabDAO.get(produce_plan_num);
		int totaldays=1+daysBetween(produce_plan_tab.getPlan_start_time(),produce_plan_tab.getPlan_end_time());
		System.out.println(totaldays);
		List<Day_plan_tab> listday_plan_tab=new ArrayList();
		Day_plan_tab  day_plan_tab=new Day_plan_tab();
		   for(int i=0;i<totaldays;i++){
			
		   }
		return model;
	}
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

}
