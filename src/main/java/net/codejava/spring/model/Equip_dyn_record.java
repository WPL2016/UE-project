package net.codejava.spring.model;

import java.util.ArrayList;
import java.util.List;

public class Equip_dyn_record {

    private Equip_dyn_para_tab equip_dyn_para_tab = new Equip_dyn_para_tab();//数据分组  
    private Equip_para_tab equip_para_tab = new Equip_para_tab();//横坐标  	
	
	
	public Equip_dyn_record() {
		// TODO Auto-generated constructor stub
	}
	 public Equip_dyn_record( Equip_dyn_para_tab equip_dyn_para_tab, Equip_para_tab equip_para_tab) {  
         this.equip_dyn_para_tab = equip_dyn_para_tab;  
         this.equip_para_tab =equip_para_tab;  
        
     }  
	 
	    public Equip_dyn_para_tab getEquip_dyn_para_tab() {
				return equip_dyn_para_tab;
			}

			public void setEquip_dyn_para_tab(Equip_dyn_para_tab equip_dyn_para_tab) {
				this.equip_dyn_para_tab = equip_dyn_para_tab;
			}
			

		    public Equip_para_tab getEquip_para_tab() {
					return equip_para_tab;
				}

				public void setEquip_para_tab(Equip_para_tab equip_para_tab) {
					this.equip_para_tab =equip_para_tab;
				}
}
