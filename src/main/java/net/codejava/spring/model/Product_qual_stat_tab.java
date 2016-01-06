
	package net.codejava.spring.model;

	import java.util.Date;


	public class Product_qual_stat_tab {
		private String qual_stat_num;
		private String equip_product_relat_num;
		private Date infe_time = new Date();
		private String infe_rea;
		

		public Product_qual_stat_tab() {
		}

		public Product_qual_stat_tab(String qual_stat_num, String equip_product_relat_num,  Date infe_time, String infe_rea) {
			this.qual_stat_num = qual_stat_num;
			this.equip_product_relat_num = equip_product_relat_num;
			this.infe_time = infe_time;
			this.infe_rea = infe_rea;
		   
		}

		public String getQual_stat_num() {
			return qual_stat_num;
		}

		public void setQual_stat_num(String qual_stat_num) {
			this.qual_stat_num = qual_stat_num;
		}

		public String getEquip_product_relat_num() {
			return equip_product_relat_num;
		}

		public void setEquip_product_relat_num(String equip_product_relat_num) {
			this.equip_product_relat_num = equip_product_relat_num;
		}


		public Date getInfe_time(){
			return infe_time;
		}
		
		public void setInfe_time(Date infe_time) {
			this.infe_time = infe_time;

		}
		
			
		public String getInfe_rea() {
			return infe_rea;
		}

		public void setInfe_rea(String infe_rea) {
			this.infe_rea = infe_rea;
		}
	}