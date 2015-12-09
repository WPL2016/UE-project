package net.codejava.spring.dao.daointerface;

import java.util.List;

import net.codejava.spring.model.Maint_reg_tab;

/**
 * Defines DAO operations for the contact model.
 * 
 *
 */
public interface Maint_reg_tabDAO {
	
	public void saveOrUpdate(Maint_reg_tab maint_reg_tab);
	
	public void delete(String maint_reg_num);
	
	public Maint_reg_tab get(String maint_reg_num);
	
	public List<Maint_reg_tab> list();
}
