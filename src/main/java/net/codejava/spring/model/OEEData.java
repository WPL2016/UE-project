package net.codejava.spring.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OEEData {
     
        private Float  passrate;
        //����������ʱ��
	    private int    runtime ;
	    private int    waittime ;
	    private int    breaktime ;  
	    private int    stoptime ; 
	    private int    quantity;
	    private int    infe_quantity;
	    private Float  oeerate;
	    //ĳһ��������ݵ���ʼʱ��ͽ���ʱ�䣬���簴�ܻ���ʱ�ڶ������ݵ���ʼʱ���ǵڶ�����һ������ʱ���ǵڶ������գ�ע�ⲻ���û���ѡ���������ܵ���ʼʱ��ͽ���ʱ��
	    private String   startdate; 
	    private Date   enddate;
	    public OEEData(){}
	    public OEEData(Float passrate, int runtime, int waittime, int breaktime, int stoptime, int quantity ,int infe_quantity,Float oeerate,String startdate,Date enddate ) {  
	         this.passrate = passrate;  
	         this.runtime = runtime;  
	         this.waittime = waittime;
	         this.breaktime=breaktime;
	         this.stoptime=stoptime;
	         this.quantity=quantity;
	         this.infe_quantity=infe_quantity;
	         this.oeerate=oeerate;
	         this.startdate=startdate;
	         this.enddate=enddate;
	     }  
	    public Float getPassrate() {
				return passrate;
			}

			public void setPassrate(Float passrate) {
				this.passrate = passrate;
			}
		    public int getRuntime() {
				return runtime;
			}

			public void setRuntime(int runtime) {
				this.runtime = runtime;
			}
		    public int getWaittime() {
				return waittime;
			}

			public void setWaittime(int waittime) {
				this.waittime = waittime;
			}
		    public int  getBreaktime() {
				return breaktime;
			}

			public void setBreaktime(int breaktime) {
				this.breaktime = breaktime;
			}
		    public int getStoptime() {
				return stoptime;
			}

			public void setStoptime(int stoptime) {
				this.stoptime =stoptime;
			}
			
			
			public void setQuantity(int quantity) {
				this.quantity =quantity;
			}
			
			public int  getQuantity() {
					return quantity;
				}
			
			public void setInfe_quantity(int infe_quantity) {
				this.infe_quantity =infe_quantity;
			}
			
			public int  getInfe_quantity() {
					return infe_quantity;
				}
			
			
			public Float  getOeerate() {
					return oeerate;
				}
			
			

		   public void setOeerate(Float oeerate) {
					this.oeerate = oeerate;
				}
		  public String  getStartdate() {
		 				return startdate;
					}

		 public void setStartdate(String startdate) {
						this.startdate = startdate;
					}
		 public Date  getEnddate() {
				return enddate;
			}

        public void setEnddate(Date enddate) {
				this.enddate = enddate;
			}
				
}
