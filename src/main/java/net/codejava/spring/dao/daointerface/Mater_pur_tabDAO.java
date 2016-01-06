package net.codejava.spring.dao.daointerface;

import java.util.List;

import net.codejava.spring.model.Mater_pur_tab;


/**
 * Defines DAO operations for the contact model.
 * 
 *
 */
public interface Mater_pur_tabDAO {
	
	public void saveOrUpdate(Mater_pur_tab  mater_pur_tab);
	
	public void delete(String stock_stat_num);
	
	public Mater_pur_tab  get(String stock_stat_num);
	
	public List<Mater_pur_tab> list();
	
	public int updateSingleColumn(Mater_pur_tab  mater_pur_tab,String column,String value);
}
