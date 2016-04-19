package net.codejava.spring.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.spring.dao.daointerface.Day_plan_tabDAO;
import net.codejava.spring.dao.daointerface.Produce_plan_tabDAO;
import net.codejava.spring.model.Produce_plan_tab;
import net.codejava.spring.model.Users;
import net.codejava.spring.service.DateCalService;
import net.codejava.spring.model.Day_plan_tab;
import net.codejava.spring.model.List_Day_plan_tab;

@Controller 
public class Day_plan_tabController {
	@Autowired
	private Produce_plan_tabDAO produce_plan_tabDAO;
	@Autowired
	private Day_plan_tabDAO day_plan_tabDAO;
	
	@RequestMapping(value="/today_plan_tab")
	public ModelAndView toDay_plan_tab(HttpServletRequest request,@RequestParam String produce_plan_num ){
		ModelAndView model=new ModelAndView();
		Produce_plan_tab produce_plan_tab=produce_plan_tabDAO.get(produce_plan_num);
		int totaldays=1+DateCalService.daysBetween(produce_plan_tab.getPlan_start_time(),produce_plan_tab.getPlan_end_time());
		System.out.println(totaldays);
		List<Day_plan_tab> listday_plan_tab=new ArrayList();
		
	    int average=produce_plan_tab.getPlan_quan()/totaldays;
	    int total=produce_plan_tab.getPlan_quan();
		   for(int i=0;i<totaldays;i++){
		   Day_plan_tab  day_plan_tab=new Day_plan_tab();
		   day_plan_tab.setPlan_date(DateCalService.addDays(produce_plan_tab.getPlan_start_time(),i));
		   System.out.println(day_plan_tab.getPlan_date());
		   day_plan_tab.setPlan_quan(average);
		   listday_plan_tab.add(i,day_plan_tab);		   
		   }
		model.addObject("listday_plan_tab",listday_plan_tab);
		model.addObject("produce_plan_num",produce_plan_num);
		model.addObject("total",total);
		model.setViewName("day_plan_decom");
		return model;
	}
	 
	@RequestMapping(value="/dayplandecom")  
	public @ResponseBody ModelAndView dayPlanDecom(HttpServletRequest request,HttpServletResponse response,@DateTimeFormat(pattern="yyyy-MM-dd") Date[] plan_date,int[] plan_quan,String produce_plan_num ) throws IOException{ 
         
		for(int i=0;i<plan_date.length;i++){
		    Day_plan_tab day_plan_tab=new Day_plan_tab();
		    day_plan_tab.setPlan_date(plan_date[i]);
		    day_plan_tab.setPlan_quan(plan_quan[i]);
		    day_plan_tab.setProduce_plan_num(produce_plan_num);
		    Date nowdate=new Date();
		    day_plan_tab.setEdit_time(nowdate);
		    day_plan_tab.setDay_plan_recorder_num(request.getUserPrincipal().getName());
		    day_plan_tab.setPlan_status("0");
			day_plan_tabDAO.add(day_plan_tab);	}
		Produce_plan_tab produce_plan_tab=new Produce_plan_tab();
		produce_plan_tab.setProduce_plan_num(produce_plan_num);
	    produce_plan_tabDAO.updateSingleColumn(produce_plan_tab,"plan_status","2");		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.println("<script language='javascript'>alert('已生成日生产计划!');window.opener.location.reload();window.close();</script>");
		return  null;
	
	}

	@RequestMapping(value="/showday_plan_tab")  	
	public @ResponseBody List<Day_plan_tab> allDayplan(HttpServletRequest request) throws IOException{
		String produce_plan_num="all";
		String plan_status_type="all";
		if((request.getParameter("produce_plan_num")!=null)&&(!request.getParameter("produce_plan_num").equals(""))) produce_plan_num=request.getParameter("produce_plan_num");
		
		if((request.getParameter("plan_status_type")!=null)&&(!request.getParameter("plan_status_type").equals(""))) plan_status_type=request.getParameter("plan_status_type");
		List<Day_plan_tab> allDay_plan_tab=day_plan_tabDAO.list(produce_plan_num,plan_status_type);				
		return allDay_plan_tab;
	}
	

	@RequestMapping(value="/editday_plan_tab")  	
	public @ResponseBody String editJqGrid(HttpServletRequest request,@RequestParam(value ="plan_date",required=false) @DateTimeFormat(pattern="yyyy-MM-dd") Date date,@RequestParam(value ="edit_time",required=false) @DateTimeFormat(pattern="yyyy-MM-dd") Date date1) throws ParseException {
		Day_plan_tab day_plan_tab=new Day_plan_tab();
		String oper=request.getParameter("oper");
		String day_plan_num=request.getParameter("day_plan_num");
				
		day_plan_tab.setDay_plan_num(request.getParameter("day_plan_num"));
		day_plan_tab.setDay_plan_recorder_num(request.getUserPrincipal().getName());
		day_plan_tab.setPlan_date(date);
		day_plan_tab.setEdit_time(date1);
		day_plan_tab.setPlan_status(request.getParameter("plan_status"));
		if(request.getParameter("plan_quan")!=null){
		day_plan_tab.setPlan_quan(Integer.parseInt(request.getParameter("plan_quan")));	
				}
	
		if(oper != null && oper.equals("edit")){
		if(day_plan_tab.getDay_plan_num()=="") day_plan_tab.setDay_plan_num(null);		
		day_plan_tabDAO.update(day_plan_tab);   		
		}
		else if(oper != null && oper.equals("add")){
			if(day_plan_tab.getDay_plan_num()=="") day_plan_tab.setProduce_plan_num(null);
			day_plan_tab.setPlan_status("0");
			day_plan_tabDAO.add(day_plan_tab);
		}
		else if(oper != null && oper.equals("del")){
			String[] ids=day_plan_num.split(",");
			for(int i=0;i<ids.length;i++)
				day_plan_tabDAO.delete(ids[i]);	
		}
		else if(oper != null && oper.equals("batch_edit")){
			String[] ids=day_plan_num.split(",");
			String column_name=request.getParameter("column_name");
			System.out.println("column_name:"+column_name);
			String column_value=request.getParameter("column_value");
			System.out.println("column_value:"+column_value);
			for(int i=0;i<ids.length;i++)
				  {day_plan_tab.setDay_plan_num(ids[i]);
			      
			     day_plan_tabDAO.updateSingleColumn(day_plan_tab,column_name,column_value);	
				  }
		     }
		return "done";
	}
	
}
