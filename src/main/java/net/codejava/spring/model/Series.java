package net.codejava.spring.model;

import java.util.List;

//Echarts的series类 
public class Series {
        //序列的名称
	    private String name;  
	    //序列的类型 
	    private String type;  
	    //序列的值  
	    private List<Float> data;//这里要用int 不能用String 不然前台显示不正常（特别是在做数学运算的时候）  
	    //序列数据分组的标签，只用于饼图
	    private List<String> label; 
	   
	    public Series(){}
	    
	    public Series( String name, String type, List<Float> data,List<String> label) {  
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
	 	public List<Float> getData() {
	 			return data;
	 		}

	 	public void setData(List<Float> data) {
	 			this.data = data;
	 		}
	 	
	 	public List<String> getLabel() {
	 			return label;
	 		}

	 	public void setLabel(List<String> label) {
	 			this.label = label;
	 		}
}
