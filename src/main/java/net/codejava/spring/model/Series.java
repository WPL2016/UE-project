package net.codejava.spring.model;

import java.util.List;

//Echarts的series类 
public class Series {

	    private String name;  
	     
	    private String type;  
	      
	    private List<Integer> data;//这里要用int 不能用String 不然前台显示不正常（特别是在做数学运算的时候）  
	    
	    private List<String> label; 
	   
	    public Series(){}
	    
	    public Series( String name, String type, List<Integer> data,List<String> label) {  
	        super();  
	        this.name = name;  
	        this.type = type;  
	        this.data = data;  
	        this.label=label;
	    }  
	    
	    public String getName() {
	 			return name;
	 		}

	 	public void setName(String name) {
	 			this.name = name;
	 		}
	 	public String getType() {
	 			return type;
	 		}

	 	public void setType(String type) {
	 			this.type = type;
	 		}	
	 	public List<Integer> getData() {
	 			return data;
	 		}

	 	public void setData(List<Integer> data) {
	 			this.data = data;
	 		}
	 	
	 	public List<String> getLabel() {
	 			return label;
	 		}

	 	public void setLabel(List<String> label) {
	 			this.label = label;
	 		}
}
