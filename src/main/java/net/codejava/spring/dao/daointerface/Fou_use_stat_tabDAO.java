package net.codejava.spring.dao.daointerface;

import java.util.List;


import net.codejava.spring.model.Fou_use_stat_tab;

/**
 * Defines DAO operations for the contact model.
 * 
 *
 */
public interface Fou_use_stat_tabDAO {
	
	public void saveOrUpdate(Fou_use_stat_tab fou_use_stat_tab);
	
	public void delete(String fou_use_stat_num);
	
	public Fou_use_stat_tab get(String fou_use_stat_num);
	
	public List<Fou_use_stat_tab> list();
	
	public int updateSingleColumn(Fou_use_stat_tab fou_use_stat_tab,String column,String value);
}
