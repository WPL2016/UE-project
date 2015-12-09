package net.codejava.spring.dao.daointerface;

import java.util.List;

import net.codejava.spring.model.Equip_para_tab;

/**
 * Defines DAO operations for the contact model.
 * 
 *
 */
public interface Equip_para_tabDAO {
	
	public void saveOrUpdate(Equip_para_tab equip_para_tab);
	
	public void delete(String para_num);
	
	public Equip_para_tab get(String para_num);
	
	public List<Equip_para_tab> list();
}
