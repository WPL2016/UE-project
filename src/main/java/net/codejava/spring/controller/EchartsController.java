package net.codejava.spring.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
//import java.util.HashMap;
import java.util.List;
//import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.codejava.spring.model.EchartData;
import net.codejava.spring.model.Series;


@Controller
public class EchartsController {
	//折线图、柱状图数据
	 @RequestMapping(value="/echartlinedata")
		public @ResponseBody EchartData echartsline() throws IOException{ 
	
		        //数据分组 
		       List<String> legend = new ArrayList<String>(Arrays.asList(new String[]{"一月","二月"})); 
		        //横坐标名称
		       List<String> category = new ArrayList<String>(Arrays.asList(new String []{"周一","周二","周三","周四","周五","周六"}));
		       //序列的值
		       List<Series> series = new ArrayList<Series>(); 
		        //添加第一条曲线的值，请从数据库查询得到，第一项为序列对应的数据分组，第二列为曲线的类型，第三项为折线、柱状序列的值，第四项饼图的值，这里不用填
		        series.add(new Series("一月", "line",   
		                        new ArrayList<Integer>(Arrays.asList(  
		                                21,23,28,26,21,33)), new ArrayList<String>())); 
		        //添加第二条曲线的值
		        series.add(new Series("二月", "line",   
                        new ArrayList<Integer>(Arrays.asList(  
                                55,98,12,53,10,89)),new ArrayList<String>()));
		        //将值赋给EchartData类，该类在EchartData.java中定义，series在Series.java中定义
		        EchartData data=new EchartData(legend, category, series);  
		        //返回数据
		        return data;  

		    
			
	    
		}
	 //饼图数据
	 @RequestMapping(value="/echartpiedata")
		public @ResponseBody EchartData echartspie() throws IOException{ 
		   //数据分组
		   List<String> legend = new ArrayList<String>(Arrays.asList(new String[]{"工人操作失误","机器故障","原材料不合格","运输损坏"}));  
	       //饼图没有横坐标哦，所以赋予空值
		   List<String> category = new ArrayList<String>(Arrays.asList(new String []{""}));
		   //序列
	       List<Series> series = new ArrayList<Series>();
	        //添加第一个饼图的数据，第一项不用填，第二项为类型，第三项为序列的值，第四项是数据分组，注意第三项和第四项的顺序是对应的
	        series.add(new Series("", "pie",   
	                        new ArrayList<Integer>(Arrays.asList(  
	                                21,23,28,26)), new ArrayList<String>(Arrays.asList(new String[]{"工人操作失误","机器故障","原材料不合格","运输损坏"}))));  
	        //返回数据
	        EchartData data=new EchartData(legend, category, series);  
	        //System.out.println(data.getLegend());
	        return data;  

		    
			
	    
		}
	 
	 
}
