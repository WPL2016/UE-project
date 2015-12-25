package net.codejava.spring.dao.daointerface;


import java.util.List;

import net.codejava.spring.model.Ener_stat_tab;


/**
 * Defines DAO operations for the contact model.
 * 
 *
 */
public interface Ener_stat_tabDAO {
	
    public void saveOrUpdate(Ener_stat_tab ener_stat_tab);
	
	public void delete(String ener_stat_num);
	
	public Ener_stat_tab get(String ener_stat_num);
	
	public List<Ener_stat_tab> list();
	
	public int updateSingleColumn(Ener_stat_tab ener_stat_tab,String column,String value);
	
	public List<Ener_stat_tab> GetSpecData(String equip_num, String start_time, String end_time, String ener_type);

	
}
