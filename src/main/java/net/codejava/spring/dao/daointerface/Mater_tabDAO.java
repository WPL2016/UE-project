package net.codejava.spring.dao.daointerface;

import java.util.List;

import net.codejava.spring.model.Mater_tab;

/**
 * Defines DAO operations for the contact model.
 * 
 *
 */
public interface Mater_tabDAO {
	
	public void saveOrUpdate(Mater_tab mater_tab);
	
	public void delete(String mater_num);
	
	public Mater_tab get(String mater_num);
	
	public List<Mater_tab> list();
}
