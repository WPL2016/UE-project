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


import net.codejava.spring.dao.daointerface.Product_qual_stat_tabDAO;
import net.codejava.spring.model.EchartData;
import net.codejava.spring.model.Product_qual_stat_tab;
import net.codejava.spring.model.Qual_show_tab;
import net.codejava.spring.model.Series;


@Controller
public class Product_qual_stat_tabController {
	  @Autowired
       private Product_qual_stat_tabDAO product_qual_stat_tabDAO;
	//折线图、柱状图数据
	 @RequestMapping(value="/qualitylinedata")
		   public @ResponseBody EchartData qualityline(HttpServletRequest request) throws IOException{ 
		     String start_time=request.getParameter("starttime");
		     String end_time=request.getParameter("endtime");
		     String timechoice =request.getParameter("timechoice");
		  //   System.out.println("line: start:"+start_time+"end:"+end_time+"时间段："+timechoice+request.getParameter("equip_selected"));
		       
		       String user_select_product[]=request.getParameter("product_selected").split(",");   
		       String product_num[] = new String[user_select_product.length];     
		       int product_serie_num= user_select_product.length;
		       
		       int j;
		       
		       List<Qual_show_tab> Product_qual_stat_tab_for_a_product = new ArrayList<Qual_show_tab>();
		       
		       List<Series> series = new ArrayList<Series>(); 
		       
		    //   List<List<String>> equip_num = new ArrayList<List<String>>(equip_serie_num); 
	           List<List<String>> infe_time = new ArrayList<List<String>>();
	           List<List<Float>> fpy_val= new ArrayList<List<Float>>(); 
	           
	           int maxsize=0,maxsizeflag=0;
       
               for (j=0;j<product_serie_num;j++){
            	   Product_qual_stat_tab_for_a_product = product_qual_stat_tabDAO.getSomeQual(user_select_product[j],start_time,end_time,timechoice);             	   
    		   
        		//   equip_num.add(j, new ArrayList<String>());
            	   infe_time.add(j, new ArrayList<String>());
            	   fpy_val.add(j, new ArrayList<Float>());
       		   
            	   product_num[j]=Product_qual_stat_tab_for_a_product.get(0).getProduct_num();
        		  
            	   for(int i=0;i<Product_qual_stat_tab_for_a_product.size();i++){  
		         // equip_num.get(j).add(Ener_stat_tab_for_a_equip.get(i).getEquip_num());
            		   infe_time.get(j).add(Product_qual_stat_tab_for_a_product.get(i).getInfe_time());
            		   fpy_val.get(j).add(Product_qual_stat_tab_for_a_product.get(i).getFpy_val());
		           
		           //System.out.println(ener_collect_time.toString());
		          
		           }   
            	   
            	   series.add(j,new Series(product_num[j],"line",fpy_val.get(j),infe_time.get(j)));
            	  
            	   if (Product_qual_stat_tab_for_a_product.size()>maxsize){maxsize=Product_qual_stat_tab_for_a_product.size(); maxsizeflag=j;}
            	   
               }
		       //序列的值
		        	   		    		       
		       //数据分组 
		       List<String> legend = new ArrayList<String>(Arrays.asList(product_num)); 
		        //横坐标名称
		       List<String> category = infe_time.get(maxsizeflag);
		       //序列的值

		        EchartData data=new EchartData(legend, category, series);  
		        //返回数据
		        return data;  
		        
		}
	 //饼图数据
	 @RequestMapping(value="/qualitypiedata")
		public @ResponseBody EchartData echartspie(HttpServletRequest request) throws IOException{ 
		  
		   
		  //序列
	        //添加第一个饼图的数据，第一项不用填，第二项为类型，第三项为序列的值，第四项是数据分组，注意第三项和第四项的顺序是对应的
		     String start_time=request.getParameter("starttime");
		     String end_time=request.getParameter("endtime");
		     String user_select_product[]=request.getParameter("product_selected").split(",");       
		     int product_serie_num= user_select_product.length;
       
		    
		   ArrayList<Float>  total_num= new  ArrayList<Float>(Arrays.asList(new Float[]{Float.parseFloat("0"),Float.parseFloat("0"),Float.parseFloat("0"),Float.parseFloat("0"),Float.parseFloat("0")}));
	       ArrayList<String> rea_label= new  ArrayList<String>(Arrays.asList(new String[]{"五星脚整形压坏","喷涂不良","外观焊渣","喷涂后划伤","中管不良"}));
	       
	      
	       List<Product_qual_stat_tab> qual_tab_for_a_product = new ArrayList<Product_qual_stat_tab>();
	       
	       qual_tab_for_a_product = product_qual_stat_tabDAO.getByProductnum(user_select_product[0],start_time,end_time);             	   
  		   
	       if(product_serie_num==1){
	    	   
	    	   
	    	for(int i =0;i<qual_tab_for_a_product.size();i++){
	    		
	    		System.out.println("指示"+Float.parseFloat(qual_tab_for_a_product.get(i).getQual_stat_num()));
	    		
	    		if(qual_tab_for_a_product.get(i).getInfe_rea().equals("0")){total_num.set(0, Float.parseFloat(qual_tab_for_a_product.get(i).getQual_stat_num()));}
	    		if(qual_tab_for_a_product.get(i).getInfe_rea().equals("1")){total_num.set(1, Float.parseFloat(qual_tab_for_a_product.get(i).getQual_stat_num()));}
	    		if(qual_tab_for_a_product.get(i).getInfe_rea().equals("2")){total_num.set(2, Float.parseFloat(qual_tab_for_a_product.get(i).getQual_stat_num()));}
	    		if(qual_tab_for_a_product.get(i).getInfe_rea().equals("3")){total_num.set(3, Float.parseFloat(qual_tab_for_a_product.get(i).getQual_stat_num()));}
	    		if(qual_tab_for_a_product.get(i).getInfe_rea().equals("4")){total_num.set(4, Float.parseFloat(qual_tab_for_a_product.get(i).getQual_stat_num()));}
	    		
	    	}
	    	   
	    	   
	       }
	       
	      
        	  
           	  
           
           
           //数据分组
		   List<String> legend = new ArrayList<String>(rea_label);  
	       //饼图没有横坐标哦，所以赋予空值
		   List<String> category = new ArrayList<String>(Arrays.asList(new String []{""}));
		   
		   List<Series> series = new ArrayList<Series>();
		   series.add(new Series("所选产品不良品产生原因比例","pie",total_num,rea_label));
	        //添加第一个饼图的数据，第一项不用填，第二项为类型，第三项为序列的值，第四项是数据分组，注意第三项和第四项的顺序是对应的
	        //返回数据
	        EchartData data=new EchartData(legend, category, series);  
	        //System.out.println(data.getLegend());
	        return data;  
	        
		}
	 
	 
	 @RequestMapping(value="/showproduct_qual_stat_tab")  	
	 public @ResponseBody List<Qual_show_tab> qual_show_tab(HttpServletRequest request) throws IOException{ 
		  
		   
		     String start_time=request.getParameter("starttime");
		     String end_time=request.getParameter("endtime");
		     String timechoice =request.getParameter("timechoice");
		     String user_select_product[]=request.getParameter("product_selected").split(","); 
		     
		   //  System.out.println("1111"+user_select_product[0]+"2222");
		     
		       String product_num[] = new String[user_select_product.length];  
		       int product_serie_num= user_select_product.length;
		       
		       System.out.println("用户选择产品个数"+product_serie_num);
      
		       int j;
		       
		
	       
	       List<Qual_show_tab> Product_qual_stat_show_list = new ArrayList<Qual_show_tab>();
	       List<Qual_show_tab> Product_qual_stat_tab_for_a_product = new ArrayList<Qual_show_tab>();
	                 
          for (j=0;j<product_serie_num;j++){

        	  Product_qual_stat_tab_for_a_product = product_qual_stat_tabDAO.getSomeQual(user_select_product[j],start_time,end_time,timechoice);             	   
   		   
         		//   equip_num.add(j, new ArrayList<String>());
             	
             	   product_num[j]=Product_qual_stat_tab_for_a_product.get(0).getProduct_num();
         		  
             	   for(int i=0;i<Product_qual_stat_tab_for_a_product.size();i++){  
             		   
             		   
             		   Qual_show_tab qual_show_tab= new Qual_show_tab();
  		     
             	 
             		 qual_show_tab.setFpy_val(Product_qual_stat_tab_for_a_product.get(i).getFpy_val());
             		 qual_show_tab.setInfe_time(Product_qual_stat_tab_for_a_product.get(i).getInfe_time());
             		 qual_show_tab.setProduct_num(Product_qual_stat_tab_for_a_product.get(i).getProduct_num());
             		  
             		 Product_qual_stat_show_list.add(qual_show_tab);
  		          
           	   }
        	   }
        	  
 
	        return Product_qual_stat_show_list;  
	        
		}
	 
	 
}


