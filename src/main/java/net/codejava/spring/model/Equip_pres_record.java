package net.codejava.spring.model;

import java.util.ArrayList;
import java.util.List;

public class Equip_pres_record {

    private Equip_pres_para_tab equip_pres_para_tab = new Equip_pres_para_tab();//���ݷ���  
    private Equip_para_tab equip_para_tab = new Equip_para_tab();//������  	
	
	
	public Equip_pres_record() {
		// TODO Auto-generated constructor stub
	}
	 public Equip_pres_record( Equip_pres_para_tab equip_pres_para_tab, Equip_para_tab equip_para_tab) {  
         this.equip_pres_para_tab = equip_pres_para_tab;  
         this.equip_para_tab =equip_para_tab;  
        
     }  
	 
	    public Equip_pres_para_tab getEquip_pres_para_tab() {
				return equip_pres_para_tab;
			}

			public void setEquip_pres_para_tab(Equip_pres_para_tab equip_pres_para_tab) {
				this.equip_pres_para_tab = equip_pres_para_tab;
			}
			

		    public Equip_para_tab getEquip_para_tab() {
					return equip_para_tab;
				}

				public void setEquip_para_tab(Equip_para_tab equip_para_tab) {
					this.equip_para_tab =equip_para_tab;
				}
}
