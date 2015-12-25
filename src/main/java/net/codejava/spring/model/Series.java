package net.codejava.spring.model;

import java.util.List;

//Echarts��series�� 
public class Series {
        //���е�����
	    private String name;  
	    //���е����� 
	    private String type;  
	    //���е�ֵ  
	    private List<Float> data;//����Ҫ��int ������String ��Ȼǰ̨��ʾ���������ر���������ѧ�����ʱ��  
	    //�������ݷ���ı�ǩ��ֻ���ڱ�ͼ
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
