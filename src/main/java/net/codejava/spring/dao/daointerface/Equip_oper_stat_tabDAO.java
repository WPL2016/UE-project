package net.codejava.spring.dao.daointerface;

import java.util.Date;
import java.util.List;

import net.codejava.spring.model.Equip_oper_stat_tab;


public interface Equip_oper_stat_tabDAO {
	
		
		public void saveOrUpdate(Equip_oper_stat_tab equip_oper_stat_tab);
		
		public void delete(String stat_num);
		
		public  Equip_oper_stat_tab get(String stat_num);
		
		public List< Equip_oper_stat_tab> list();
		
		public int updateSingleColumn(Equip_oper_stat_tab equip_oper_stat_tab,String column,String value);
		
		public List< Equip_oper_stat_tab> getLastUniqueRecord(String equip_num);
		
		public int somedayStatTime(Date data,String stat_name,String equip_num);
}
