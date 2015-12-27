package net.codejava.spring.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
//import java.util.HashMap;
import java.util.List;
//import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.codejava.spring.dao.daointerface.Ener_stat_tabDAO;
import net.codejava.spring.model.EchartData;
import net.codejava.spring.model.Ener_stat_tab;
import net.codejava.spring.model.Series;


@Controller
public class GasController {
	  @Autowired
       private Ener_stat_tabDAO ener_stat_tabDAO;
	//折线图、柱状图数据
	 @RequestMapping(value="/gaslinedata")
		   public @ResponseBody EchartData gasline(HttpServletRequest request) throws IOException{ 
		     String start_time=request.getParameter("starttime");
		     String end_time=request.getParameter("endtime");
		     String timechoice =request.getParameter("timechoice");
		  //   System.out.println("line: start:"+start_time+"end:"+end_time+"时间段："+timechoice+request.getParameter("equip_selected"));
		       
		       String user_select_equip[]=request.getParameter("equip_selected").split(",");   
		       String equip_name[] = new String[user_select_equip.length];     
		       int equip_serie_num= user_select_equip.length;
		       
		       int j;
		       
		       List<Ener_stat_tab> Ener_stat_tab_for_a_equip = new ArrayList<Ener_stat_tab>();
		       
		       List<Series> series = new ArrayList<Series>(); 
		       
		       List<List<String>> equip_num = new ArrayList<List<String>>(equip_serie_num); 
	           List<List<String>> ener_collect_time = new ArrayList<List<String>>(equip_serie_num);
	           List<List<Float>> ener_val= new ArrayList<List<Float>>(); 
	           
	           int maxsize=0,maxsizeflag=0;
       
               for (j=0;j<equip_serie_num;j++){
        		   Ener_stat_tab_for_a_equip = ener_stat_tabDAO.GetSpecData(user_select_equip[j],start_time,end_time,"gas",timechoice);             	   
    		   
        		   equip_num.add(j, new ArrayList<String>());
        		   ener_collect_time.add(j, new ArrayList<String>());
        		   ener_val.add(j, new ArrayList<Float>());
        		   

        		  
            	   for(int i=0;i<Ener_stat_tab_for_a_equip.size();i++){  
		         // equip_num.get(j).add(Ener_stat_tab_for_a_equip.get(i).getEquip_num());
		           ener_collect_time.get(j).add(Ener_stat_tab_for_a_equip.get(i).getEner_collect_time());
		           ener_val.get(j).add(Ener_stat_tab_for_a_equip.get(i).getEner_val());
		           
		           //System.out.println(ener_collect_time.toString());
		          
		           }   
            	   
            	   series.add(j,new Series(user_select_equip[j],"line",ener_val.get(j),ener_collect_time.get(j)));
            	  
            	   if (Ener_stat_tab_for_a_equip.size()>maxsize){maxsize=Ener_stat_tab_for_a_equip.size(); maxsizeflag=j;}
            	   
               }
		       //序列的值
		        	   		    		       
		       //数据分组 
		       List<String> legend = new ArrayList<String>(Arrays.asList(user_select_equip)); 
		        //横坐标名称
		       List<String> category = ener_collect_time.get(maxsizeflag);
		       //序列的值

		        EchartData data=new EchartData(legend, category, series);  
		        //返回数据
		        return data;  
		        
		}
	 //饼图数据
	 @RequestMapping(value="/gaspiedata")
		public @ResponseBody EchartData echartspie(HttpServletRequest request) throws IOException{ 
		  
		   
		  //序列
	        //添加第一个饼图的数据，第一项不用填，第二项为类型，第三项为序列的值，第四项是数据分组，注意第三项和第四项的顺序是对应的
		  String start_time=request.getParameter("starttime");
		     String end_time=request.getParameter("endtime");
		     String timechoice =request.getParameter("timechoice");
		     String user_select_equip[]=request.getParameter("equip_selected").split(",");       
		     String equip_name[] = new String[user_select_equip.length];  
		       int equip_serie_num= user_select_equip.length;
       
		       int j;
		       
	       List<Float> total_energy= new ArrayList<Float>();
	       List<String> equip_label= new ArrayList<String>();
	       
	       List<Ener_stat_tab> Ener_stat_tab_for_a_equip = new ArrayList<Ener_stat_tab>();
	       List<List<String>> equip_num = new ArrayList<List<String>>(equip_serie_num); 
           List<List<String>> ener_collect_time = new ArrayList<List<String>>(equip_serie_num);
           List<List<Float>> ener_val= new ArrayList<List<Float>>(); 
           
           for (j=0;j<equip_serie_num;j++){
 
        	   Ener_stat_tab_for_a_equip = ener_stat_tabDAO.GetSpecData(user_select_equip[j],start_time,end_time,"gas",timechoice);             	   
    		   
     		   equip_num.add(j, new ArrayList<String>());
     		   ener_collect_time.add(j, new ArrayList<String>());
     		   ener_val.add(j, new ArrayList<Float>());
     		   
     		   total_energy.add(j, new Float(0));
     		   equip_label.add(j, "");
     		   

         	   for(int i=0;i<Ener_stat_tab_for_a_equip.size();i++){  
		           equip_num.get(j).add(Ener_stat_tab_for_a_equip.get(i).getEquip_num());
		           ener_collect_time.get(j).add(Ener_stat_tab_for_a_equip.get(i).getEner_collect_time());
		           ener_val.get(j).add(Ener_stat_tab_for_a_equip.get(i).getEner_val());
		           
		           total_energy.set(j,total_energy.get(j)+ener_val.get(j).get(i));
		           equip_label.set(j, user_select_equip[j]);
         	   }
           }
           
           //数据分组
		   List<String> legend = new ArrayList<String>(Arrays.asList(user_select_equip));  
	       //饼图没有横坐标哦，所以赋予空值
		   List<String> category = new ArrayList<String>(Arrays.asList(new String []{""}));
		   
		   List<Series> series = new ArrayList<Series>();
		   series.add(new Series("所选设备消耗天然气比例","pie",total_energy,equip_label));
	        //添加第一个饼图的数据，第一项不用填，第二项为类型，第三项为序列的值，第四项是数据分组，注意第三项和第四项的顺序是对应的
	        //返回数据
	        EchartData data=new EchartData(legend, category, series);  
	        //System.out.println(data.getLegend());
	        return data;  
	        
		}
	 
	 
}
