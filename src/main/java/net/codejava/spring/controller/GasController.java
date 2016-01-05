package net.codejava.spring.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
//import java.util.HashMap;
import java.util.List;
//import java.util.Map;

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
	//����ͼ����״ͼ����
	 @RequestMapping(value="/gaslinedata")
		public @ResponseBody EchartData gasline() throws IOException{ 
		 
		       int equip_serie_num=2;
		       int j;
		       String user_select_equip[]=new String[equip_serie_num];       
		       user_select_equip[0]= "HSLW2";
		       user_select_equip[1]= "HSLW5";
		       
		       String start_time=new String("2015-11-09 00:00:00");
		       String end_time=new String("2015-11-09 23:59:59"); 
		       
		       List<Ener_stat_tab> Ener_stat_tab_for_a_equip = new ArrayList<Ener_stat_tab>();
		       
		       List<Series> series = new ArrayList<Series>(); 
		       
		       List<List<String>> equip_num = new ArrayList<List<String>>(equip_serie_num); 
	           List<List<SimpleDateFormat>> ener_collect_time = new ArrayList<List<SimpleDateFormat>>(equip_serie_num);
	           List<List<String>> ener_collect_time_s = new ArrayList<List<String>>(equip_serie_num);
	           
	           List<List<Float>> ener_val= new ArrayList<List<Float>>(); 
       
               for (j=0;j<equip_serie_num;j++){
            	  
            	   System.out.println("j��"+Integer.toString(j));
            	   
            	   Ener_stat_tab_for_a_equip = ener_stat_tabDAO.GetSpecData(user_select_equip[j],start_time,end_time,"gas");
            	   
            	  // System.out.println(Ener_stat_tab_for_a_equip.size());
		                	  		   
        		   equip_num.add(j, new ArrayList<String>());
        		   ener_collect_time.add(j, new ArrayList<SimpleDateFormat>());
        		   ener_collect_time_s.add(j, new ArrayList<String>());
        		   ener_val.add(j, new ArrayList<Float>());
        		   

        		  
            	   for(int i=0;i<Ener_stat_tab_for_a_equip.size();i++){  
		           equip_num.get(j).add(Ener_stat_tab_for_a_equip.get(i).getEquip_num());
		           ener_collect_time.get(j).add(Ener_stat_tab_for_a_equip.get(i).getEner_collect_time());
		           ener_collect_time_s.get(j).add(ener_collect_time.toString());
		           ener_val.get(j).add(Ener_stat_tab_for_a_equip.get(i).getEner_val());
		           
		       //    System.out.println(Ener_stat_tab_for_a_equip.get(i).getEner_val());
		          
		           }   
            	   
            	   series.add(j,new Series(user_select_equip[j],"line",ener_val.get(j),ener_collect_time_s.get(j)));
               }
		       //���е�ֵ
		        	   		    		       
		       //���ݷ��� 
		       List<String> legend = new ArrayList<String>(Arrays.asList(user_select_equip)); 
		        //����������
		       List<String> category = new ArrayList<String>(Arrays.asList(new String []{"��һ","�ܶ�","����","����","����","����"}));
		       //���е�ֵ

		        EchartData data=new EchartData(legend, category, series);  
		        //��������
		        return data;  
		        
		}
	 //��ͼ����
	 @RequestMapping(value="/gaspiedata")
		public @ResponseBody EchartData echartspie() throws IOException{ 
		  
		   //����
	        //��ӵ�һ����ͼ�����ݣ���һ�����ڶ���Ϊ���ͣ�������Ϊ���е�ֵ�������������ݷ��飬ע�������͵������˳���Ƕ�Ӧ��
		   int equip_serie_num=2;
	       int j;
	       String user_select_equip[]=new String[equip_serie_num];
	       user_select_equip[0]= "HSLW2";
	       user_select_equip[1]= "HSLW5";
	       
	       String start_time=new String("2015-11-09 10:30:24");
	       String end_time=new String("2015-11-09 23:30:24"); 
	       List<Float> total_energy= new ArrayList<Float>();
	       List<String> equip_label= new ArrayList<String>();
	       
	       List<Ener_stat_tab> Ener_stat_tab_for_a_equip = new ArrayList<Ener_stat_tab>();
	       List<List<String>> equip_num = new ArrayList<List<String>>(equip_serie_num); 
           List<List<SimpleDateFormat>> ener_collect_time = new ArrayList<List<SimpleDateFormat>>(equip_serie_num);
           List<List<String>> ener_collect_time_s = new ArrayList<List<String>>(equip_serie_num);
         
           List<List<Float>> ener_val= new ArrayList<List<Float>>(); 
           
           for (j=0;j<equip_serie_num;j++){
        	   
         	  // System.out.println("j��"+Integer.toString(j));
         	   
         	   Ener_stat_tab_for_a_equip = ener_stat_tabDAO.GetSpecData(user_select_equip[j],start_time,end_time,"gas");
         	   
         	   //System.out.println(Ener_stat_tab_for_a_equip.get(0).getEquip_num());
		                	  		   
     		   equip_num.add(j, new ArrayList<String>());
     		   ener_collect_time.add(j, new ArrayList<SimpleDateFormat>());
     		   ener_collect_time_s.add(j, new ArrayList<String>());
     		   ener_val.add(j, new ArrayList<Float>());
     		   
     		   total_energy.add(j, new Float(0));
     		   equip_label.add(j, "");
     		   

         	   for(int i=0;i<Ener_stat_tab_for_a_equip.size();i++){  
		           equip_num.get(j).add(Ener_stat_tab_for_a_equip.get(i).getEquip_num());
		           ener_collect_time.get(j).add(Ener_stat_tab_for_a_equip.get(i).getEner_collect_time());
		           ener_collect_time_s.get(j).add(ener_collect_time.toString());
		           ener_val.get(j).add(Ener_stat_tab_for_a_equip.get(i).getEner_val());
		           
		           total_energy.set(j,total_energy.get(j)+ener_val.get(j).get(i));
		           equip_label.set(j, user_select_equip[j]);
         	   }
           }
           
           //���ݷ���
		   List<String> legend = new ArrayList<String>(Arrays.asList(user_select_equip));  
	       //��ͼû�к�����Ŷ�����Ը����ֵ
		   List<String> category = new ArrayList<String>(Arrays.asList(new String []{""}));
		   
		   List<Series> series = new ArrayList<Series>();
		   series.add(new Series("��ѡ�豸������Ȼ������","pie",total_energy,equip_label));
	        //��ӵ�һ����ͼ�����ݣ���һ�����ڶ���Ϊ���ͣ�������Ϊ���е�ֵ�������������ݷ��飬ע�������͵������˳���Ƕ�Ӧ��
	        //��������
	        EchartData data=new EchartData(legend, category, series);  
	        //System.out.println(data.getLegend());
	        return data;  
	        
		}
	 
	 
}
