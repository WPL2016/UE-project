package net.codejava.spring.dao.daointerface;

import java.util.List;

import net.codejava.spring.model.Mou_use_inf_tab;


/**
 * Defines DAO operations for the contact model.
 * 
 *
 */
public interface Mou_use_inf_tabDAO {
	
	public void saveOrUpdate(Mou_use_inf_tab mou_use_inf_tab);
	
	public void delete(String mou_use_inf_num);
	
	public Mou_use_inf_tab get(String mou_use_inf_num);
	
	public List<Mou_use_inf_tab> list();
	
	public List<Mou_use_inf_tab> list(String mou_num);
}
