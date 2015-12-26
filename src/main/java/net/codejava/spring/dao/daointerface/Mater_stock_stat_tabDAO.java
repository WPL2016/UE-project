package net.codejava.spring.dao.daointerface;

import java.util.List;


import net.codejava.spring.model.Mater_stock_stat_tab;

/**
 * Defines DAO operations for the contact model.
 * 
 *
 */
public interface Mater_stock_stat_tabDAO {
	
	//public void saveOrUpdate(Mater_stock_stat_tab mater_stock_stat_tab);
	
	//public void delete(String stock_num);
	
	//public Mater_stock_stat_tab get(String stock_num);
	
	public List<Mater_stock_stat_tab> listMater_stock_stat_tab();
	
	//public int updateSingleColumn(Mater_stock_stat_tab mater_stock_stat_tab,String column,String value);
}
