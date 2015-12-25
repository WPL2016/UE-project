package net.codejava.spring.dao.daointerface;

import java.util.List;

import net.codejava.spring.model.Equip_pres_para_tab;
import net.codejava.spring.model.Equip_pres_record;


/**
 * Defines DAO operations for the contact model.
 * 
 *
 */
public interface Equip_pres_para_tabDAO {
	
	public void saveOrUpdate(Equip_pres_para_tab equip_pres_para_tab);
	
	public void delete(String para_num);
	
	public Equip_pres_para_tab get(String para_num);
	
	public List<Equip_pres_para_tab> list();
	
	public List<Equip_pres_record> getLastPresStat(String equip_num);
}
