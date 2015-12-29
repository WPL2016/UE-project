package net.codejava.spring.dao.daointerface;

import java.util.List;

import net.codejava.spring.model.Atype_tab;



/**
 * Defines DAO operations for the contact model.
 * 
 *
 */
public interface Atype_tabDAO {
	
	public void saveOrUpdate(Atype_tab atype_tab);
	
	public void delete(String atype_num);
	
	public Atype_tab get(String atype_num);
	
	public List<Atype_tab> list();
	
	public int updateSingleColumn(Atype_tab atype_tab,String column,String value);
}
