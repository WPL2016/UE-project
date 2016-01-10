package net.codejava.spring.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import net.codejava.spring.dao.daointerface.OEE_calcuDAO;
import net.codejava.spring.model.EchartData;
import net.codejava.spring.model.OEEData;
import net.codejava.spring.model.Series;

@Controller 
public class OEECalcuController {
	@Autowired
	private OEE_calcuDAO oee_calcuDAO;

	
	@RequestMapping(value="/getoeedata")
	public @ResponseBody  List<OEEData> calculOEE(ModelAndView model,HttpServletRequest request) throws IOException{
		List<OEEData> oeedata=oee_calcuDAO.getOEEDataByQuery(request.getParameter("starttime"),request.getParameter("endtime"),request.getParameter("summarytype"),request.getParameter("equip_num"));
		System.out.println(request.getParameter("starttime")+"-"+request.getParameter("endtime")+"-"+request.getParameter("summarytype")+"-"+request.getParameter("equip_num"));
		return oeedata;
	}
	
	
	@RequestMapping(value="/oeelinedata")
	public @ResponseBody EchartData oeeline(HttpServletRequest request) throws IOException{ 
	     String start_time=request.getParameter("starttime");
	     String end_time=request.getParameter("endtime");
	     String summarytype =request.getParameter("summarytype");
	     String equip_num = request.getParameter("equip_num");
	
	     List<OEEData> oeedata=oee_calcuDAO.getOEEDataByQuery(start_time,end_time,summarytype,equip_num);
	     List<Series> series = new ArrayList<Series>();  
	     //  int j;

	    //List<List<String>> equip_num = new ArrayList<List<String>>(equip_serie_num); 
          List<String> date = new ArrayList<String>();
          List<Float> oee_val= new ArrayList<Float>(); 
          List<Float> pass_rate= new ArrayList<Float>(); 
          List<Float> time_utility_rate= new ArrayList<Float>(); 
          List<Float> performance_rate= new ArrayList<Float>(); 
          
       
       	   for(int i=0;i<oeedata.size();i++){  
	         // equip_num.get(j).add(Ener_stat_tab_for_a_equip.get(i).getEquip_num());
       		   date.add(oeedata.get(i).getStartdate());
       		   oee_val.add(oeedata.get(i).getOeerate());
       		   pass_rate.add(oeedata.get(i).getPassrate());
       		   time_utility_rate.add(oeedata.get(i).getTimeutilityrate());
       		   performance_rate.add(oeedata.get(i).getPerformancerate());
	           //System.out.println(ener_collect_time.toString());
	          
	           }   
       	   
       	   series.add(0,new Series("所选设备OEE","line",oee_val,date));
       	   series.add(1,new Series("所选设备产品合格率","line",pass_rate,date));
       	   series.add(2,new Series("所选设备时间利用率","line",time_utility_rate,date));
       	   series.add(3,new Series("所选设备性能利用率","line",performance_rate,date));
       	  
        
	       //序列的值
	        	   		    		       
	       //数据分组 
	       List<String> legend = new ArrayList<String>(Arrays.asList("所选设备OEE","所选设备产品合格率","所选设备时间利用率","所选设备性能利用率")); 
	        //横坐标名称
	       List<String> category = date;
	       //序列的值

	        EchartData data=new EchartData(legend, category, series);  
	        //返回数据
	        return data;  
	        
	}
}

