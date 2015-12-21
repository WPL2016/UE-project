package net.codejava.spring.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.codejava.spring.model.EchartData;
import net.codejava.spring.model.Series;


@Controller
public class EchartsController {
	 @RequestMapping(value="/echartlinedata")
		public @ResponseBody EchartData echartsline() throws IOException{ 
	
	     
		 List<String> legend = new ArrayList<String>(Arrays.asList(new String[]{"一月","二月"}));//数据分组  
		       List<String> category = new ArrayList<String>(Arrays.asList(new String []{"周一","周二","周三","周四","周五","周六"}));//横坐标  
		       List<Series> series = new ArrayList<Series>();//纵坐标  
		     
		        series.add(new Series("一月", "line",   
		                        new ArrayList<Integer>(Arrays.asList(  
		                                21,23,28,26,21,33)), new ArrayList<String>()));  
		        series.add(new Series("二月", "line",   
                        new ArrayList<Integer>(Arrays.asList(  
                                55,98,12,53,10,89)),new ArrayList<String>()));    
		        EchartData data=new EchartData(legend, category, series);  
		 
		        return data;  

		    
			
	    
		}
	 
	 @RequestMapping(value="/echartpiedata")
		public @ResponseBody EchartData echartspie() throws IOException{ 
		  
		   List<String> legend = new ArrayList<String>(Arrays.asList(new String[]{"工人操作失误","机器故障","原材料不合格","运输损坏"}));//数据分组  
	       List<String> category = new ArrayList<String>(Arrays.asList(new String []{""}));
	       List<Series> series = new ArrayList<Series>();//series
	     
	        series.add(new Series("", "pie",   
	                        new ArrayList<Integer>(Arrays.asList(  
	                                21,23,28,26)), new ArrayList<String>(Arrays.asList(new String[]{"工人操作失误","机器故障","原材料不合格","运输损坏"}))));  
	       
	        EchartData data=new EchartData(legend, category, series);  
	        System.out.println(data.getLegend());
	        return data;  

		    
			
	    
		}
	 
	 
}
