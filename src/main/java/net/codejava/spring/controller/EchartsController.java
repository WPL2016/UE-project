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
	//����ͼ����״ͼ����
	 @RequestMapping(value="/echartlinedata")
		public @ResponseBody EchartData echartsline() throws IOException{ 
	
		        //���ݷ��� 
		       List<String> legend = new ArrayList<String>(Arrays.asList(new String[]{"һ��","����"})); 
		        //����������
		       List<String> category = new ArrayList<String>(Arrays.asList(new String []{"��һ","�ܶ�","����","����","����","����"}));
		       //���е�ֵ
		       List<Series> series = new ArrayList<Series>(); 
		        //��ӵ�һ�����ߵ�ֵ��������ݿ��ѯ�õ�����һ��Ϊ���ж�Ӧ�����ݷ��飬�ڶ���Ϊ���ߵ����ͣ�������Ϊ���ߡ���״���е�ֵ���������ͼ��ֵ�����ﲻ����
		     
		        //��ֵ����EchartData�࣬������EchartData.java�ж��壬series��Series.java�ж���
		        EchartData data=new EchartData(legend, category, series);  
		        //��������
		        return data;  

		    
			
	    
		}
	 //��ͼ����
	 @RequestMapping(value="/echartpiedata")
		public @ResponseBody EchartData echartspie() throws IOException{ 
		   //���ݷ���
		   List<String> legend = new ArrayList<String>(Arrays.asList(new String[]{"���˲���ʧ��","��������","ԭ���ϲ��ϸ�","������"}));  
	       //��ͼû�к�����Ŷ�����Ը����ֵ
		   List<String> category = new ArrayList<String>(Arrays.asList(new String []{""}));
		   //����
	       List<Series> series = new ArrayList<Series>();
	        //��ӵ�һ����ͼ�����ݣ���һ�����ڶ���Ϊ���ͣ�������Ϊ���е�ֵ�������������ݷ��飬ע�������͵������˳���Ƕ�Ӧ��
	       
	        //��������
	        EchartData data=new EchartData(legend, category, series);  
	        //System.out.println(data.getLegend());
	        return data;  

		    
			
	    
		}
	 
	 
}
