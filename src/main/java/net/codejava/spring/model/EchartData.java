package net.codejava.spring.model;

import java.util.ArrayList;
import java.util.List;
//echarts的数据类
public class EchartData {

	    private List<String> legend = new ArrayList<String>();//数据分组  
	    private List<String> category = new ArrayList<String>();//横坐标  
	    private List<Series> series = new ArrayList<Series>();//纵坐标  
	       
	    public EchartData(){}  
	    public EchartData(List<String> legendList, List<String> categoryList, List<Series> seriesList) {  
	         this.legend = legendList;  
	         this.category = categoryList;  
	         this.series = seriesList;  
	     }  
		
	    public List<String> getLegend() {
			return legend;
		}

		public void setLegend(List<String> legend) {
			this.legend = legend;
		}
		
		public List<String> getCategory() {
				return category;
		}

		public void setCategory(List<String> category) {
				this.category = category;
		}
	    public List<Series> getSeries() {
				return series;
			}

		public void setSeries(List<Series> series) {
				this.series = series;
			}
		
}
