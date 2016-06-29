package net.codejava.spring.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.spring.dao.daointerface.Day_plan_tabDAO;
import net.codejava.spring.dao.daointerface.Equip_product_relat_tabDAO;
import net.codejava.spring.dao.daointerface.Produce_plan_tabDAO;
import net.codejava.spring.dao.daointerface.Work_plan_tabDAO;
import net.codejava.spring.model.Day_plan_tab;
import net.codejava.spring.model.Equip_tab;
import net.codejava.spring.model.Produce_plan_exe_stat_tab;
import net.codejava.spring.model.Produce_plan_tab;
import net.codejava.spring.model.Work_plan_tab;
import net.codejava.spring.service.DateCalService;
@Controller
public class Work_plan_tabController {
	@Autowired
	private Work_plan_tabDAO work_plan_tabDAO;
	@Autowired
	private Day_plan_tabDAO day_plan_tabDAO;
	@Autowired
	private Equip_product_relat_tabDAO equip_product_relat_tabDAO;
	
	@RequestMapping(value="/towork_plan_tab")
	public ModelAndView toWork_plan_tab(HttpServletRequest request ){
		ModelAndView model=new ModelAndView();
		model.setViewName("work_plan_tab");
		return model;
		
	}
	@RequestMapping(value="/showwork_plan_tab")  	
	public @ResponseBody List<Work_plan_tab> allWorkplan(HttpServletRequest request) throws IOException{
		String day_plan_num="all";
		String plan_status_type="all";
		if((request.getParameter("day_plan_num")!=null)&&(!request.getParameter("day_plan_num").equals(""))) day_plan_num=request.getParameter("day_plan_num");
		
		if((request.getParameter("plan_status_type")!=null)&&(!request.getParameter("plan_status_type").equals(""))) plan_status_type=request.getParameter("plan_status_type");
		System.out.println("日计划编号："+day_plan_num);
		List<Work_plan_tab> allWork_plan_tab=work_plan_tabDAO.list(day_plan_num,plan_status_type);				
		return allWork_plan_tab;
	}
	
	@RequestMapping(value="/towork_plan_decom")
	public ModelAndView toWork_plan_tab(HttpServletRequest request,@RequestParam String day_plan_num ){
		ModelAndView model=new ModelAndView();
		Day_plan_tab day_plan_tab=day_plan_tabDAO.get(day_plan_num);
		
		List<Equip_tab> usableequip=work_plan_tabDAO.getUsableEquip(day_plan_num);
		int average=day_plan_tab.getPlan_quan()/(3*usableequip.size());
		int total=day_plan_tab.getPlan_quan();
		model.addObject("usableequip",usableequip);
		model.addObject("average",average);
		model.addObject("day_plan_num",day_plan_num);
		model.addObject("total",total);
		model.setViewName("work_plan_decom");
		return model;
	}
	
	@RequestMapping(value="/work_plan_decom")
	public ModelAndView work_plan_tab(HttpServletRequest request,HttpServletResponse response,@RequestParam String[] equip_num1,String[] equip_num2,String[] equip_num3,int[] plan_quan1,int[] plan_quan2,int[] plan_quan3,String day_plan_num){
		System.out.println("日计划编号："+day_plan_num);
		ModelAndView model=new ModelAndView();	
        String product_num=work_plan_tabDAO.getProduct_num(day_plan_num);     
        Day_plan_tab day_plan_tab=day_plan_tabDAO.get(day_plan_num);    
        Date plan_date=day_plan_tab.getPlan_date();
		Date nowdate=new Date();
	    
		for(int i=0;i<equip_num1.length;i++){
		Work_plan_tab work_plan_tab=new Work_plan_tab();	
		System.out.println("1号班设备编号："+equip_num1[i]);
		String equip_product_relat_num=equip_product_relat_tabDAO.getEquip_product_relate_num(equip_num1[i], product_num);
		work_plan_tab.setEquip_product_relat_num(equip_product_relat_num);		
		work_plan_tab.setDay_plan_num(day_plan_num);
		work_plan_tab.setPlan_quan(plan_quan1[i]);
		work_plan_tab.setEdit_time(nowdate);
		work_plan_tab.setPlan_shift("1号班");
		work_plan_tab.setPlan_date(plan_date);
		work_plan_tab.setPlan_status("0");
		work_plan_tab.setWork_plan_recorder_num(request.getUserPrincipal().getName());
		work_plan_tabDAO.add(work_plan_tab);
		}
		System.out.println("3");
		for(int i=0;i<equip_num2.length;i++){
			Work_plan_tab work_plan_tab=new Work_plan_tab();		
			String equip_product_relat_num=equip_product_relat_tabDAO.getEquip_product_relate_num(equip_num2[i], product_num);
			work_plan_tab.setEquip_product_relat_num(equip_product_relat_num);		
			work_plan_tab.setDay_plan_num(day_plan_num);
			work_plan_tab.setPlan_quan(plan_quan2[i]);
			work_plan_tab.setEdit_time(nowdate);
			work_plan_tab.setPlan_shift("2号班");
			work_plan_tab.setPlan_date(plan_date);
			work_plan_tab.setPlan_status("0");
			work_plan_tab.setWork_plan_recorder_num(request.getUserPrincipal().getName());
			work_plan_tabDAO.add(work_plan_tab);
			}
		for(int i=0;i<equip_num3.length;i++){
			Work_plan_tab work_plan_tab=new Work_plan_tab();		
			String equip_product_relat_num=equip_product_relat_tabDAO.getEquip_product_relate_num(equip_num3[i], product_num);
			work_plan_tab.setEquip_product_relat_num(equip_product_relat_num);		
			work_plan_tab.setDay_plan_num(day_plan_num);
			work_plan_tab.setPlan_quan(plan_quan3[i]);
			work_plan_tab.setEdit_time(nowdate);
			work_plan_tab.setPlan_shift("3号班");
			work_plan_tab.setPlan_date(plan_date);
			work_plan_tab.setPlan_status("0");
			work_plan_tab.setWork_plan_recorder_num(request.getUserPrincipal().getName());
			work_plan_tabDAO.add(work_plan_tab);
			
			}
		
	    day_plan_tab.setDay_plan_num(day_plan_num);
	    day_plan_tabDAO.updateSingleColumn(day_plan_tab,"plan_status","2");		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out;
		try {
			out = response.getWriter();
			out.println("<script language='javascript'>alert('已生成作业计划!');window.opener.location.reload();window.close();</script>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return  null;
		
		
	}
	
	@RequestMapping(value="/editwork_plan_tab")  	
	public @ResponseBody String editJqGrid(HttpServletRequest request,@RequestParam(value ="plan_date",required=false) @DateTimeFormat(pattern="yyyy-MM-dd") Date date) throws ParseException {
		Work_plan_tab work_plan_tab=new Work_plan_tab();
		String oper=request.getParameter("oper");
		String work_plan_num=request.getParameter("work_plan_num");
				
		work_plan_tab.setWork_plan_num(request.getParameter("work_plan_num"));
		work_plan_tab.setWork_plan_recorder_num(request.getUserPrincipal().getName());
		work_plan_tab.setPlan_date(date);
		Date nowdate=new Date();
		work_plan_tab.setEdit_time(nowdate);
		work_plan_tab.setPlan_status(request.getParameter("plan_status"));
		if(request.getParameter("plan_quan")!=null){
		work_plan_tab.setPlan_quan(Integer.parseInt(request.getParameter("plan_quan")));	
				}
	
		if(oper != null && oper.equals("edit")){
		if(work_plan_tab.getDay_plan_num()=="") work_plan_tab.setDay_plan_num(null);		
		work_plan_tabDAO.update(work_plan_tab);   		
		}
		else if(oper != null && oper.equals("add")){
			if(work_plan_tab.getWork_plan_num()=="") work_plan_tab.setWork_plan_num(null);
			work_plan_tab.setPlan_status("未发布");
			work_plan_tabDAO.add(work_plan_tab);
		}
		else if(oper != null && oper.equals("del")){
			String[] ids=work_plan_num.split(",");
			for(int i=0;i<ids.length;i++)
				day_plan_tabDAO.delete(ids[i]);	
		}
		else if(oper != null && oper.equals("batch_edit")){
			String[] ids=work_plan_num.split(",");
			String column_name=request.getParameter("column_name");
			System.out.println("column_name:"+column_name);
			String column_value=request.getParameter("column_value");
			System.out.println("column_value:"+column_value);
			for(int i=0;i<ids.length;i++)
				  {work_plan_tab.setWork_plan_num(ids[i]);
			      
			     work_plan_tabDAO.updateSingleColumn(work_plan_tab,column_name,column_value);	
				  }
		     }
		return "done";
	}
	
	@RequestMapping(value="/excutework_plan")  	
	public @ResponseBody String excuteWork_plan(HttpServletRequest request,@RequestParam String work_plan_num){
		System.out.println("开始执行计划...");
		work_plan_tabDAO.excuteWorkPlan(work_plan_num);
		String username=request.getUserPrincipal().getName();				
		Produce_plan_exe_stat_tab excutestat=new Produce_plan_exe_stat_tab();
		Date nowdate=new Date();
		excutestat.setExe_start_time(nowdate);
		System.out.println(excutestat.getExe_start_time());
		excutestat.setWork_plan_num(work_plan_num);
		excutestat.setProduce_plan_exe_stat_recorder_num(username);
		work_plan_tabDAO.excuteRecord(excutestat);
		return "done";
		
	}
}
