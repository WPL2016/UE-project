package net.codejava.spring.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OEEData {
     
        private Float  passrate;
        //以秒计算的总时间
	    private int    runtime ;
	    private int    waittime ;
	    private int    breaktime ;  
	    private int    stoptime ; 
	    private int    quantity;
	    private int    infe_quantity;
	    private Float  oeerate;
	    //某一组汇总数据的起始时间和结束时间，比如按周汇总时第二组数据的起始时间是第二周周一，结束时间是第二周周日，注意不是用户所选择的总体汇总的起始时间和结束时间
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
