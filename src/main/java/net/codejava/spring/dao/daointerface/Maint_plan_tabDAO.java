package net.codejava.spring.dao.daointerface;

import java.util.List;

import net.codejava.spring.model.Maint_plan_tab;

/**
 * Defines DAO operations for the contact model.
 * 
 *
 */
public interface Maint_plan_tabDAO {
	
	public void saveOrUpdate(Maint_plan_tab maint_plan_tab);
	
	public void delete(String maint_plan_num);
	
	public Maint_plan_tab get(String maint_plan_num);
	
	public List<Maint_plan_tab> list();
}
