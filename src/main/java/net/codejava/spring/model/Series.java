package net.codejava.spring.model;

import java.util.List;

//Echarts��series�� 
public class Series {

	    private String name;  
	     
	    private String type;  
	      
	    private List<Integer> data;//����Ҫ��int ������String ��Ȼǰ̨��ʾ���������ر���������ѧ�����ʱ��  
	    
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
