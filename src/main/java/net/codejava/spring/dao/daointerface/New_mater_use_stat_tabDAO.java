package net.codejava.spring.dao.daointerface;

import java.util.List;



import net.codejava.spring.model.New_mater_use_stat_tab;

/**
 * Defines DAO operations for the contact model.
 * 
 *
 */
public interface New_mater_use_stat_tabDAO {
	
	public void saveOrUpdate(New_mater_use_stat_tab new_mater_use_stat_tab);
	
	public void delete(String new_mater_use_stat_num);
	
	public New_mater_use_stat_tab get(String new_mater_use_stat_num);
	
	public List<New_mater_use_stat_tab> list();
	
	public int updateSingleColumn(New_mater_use_stat_tab new_mater_use_stat_tab,String column,String value);
}
