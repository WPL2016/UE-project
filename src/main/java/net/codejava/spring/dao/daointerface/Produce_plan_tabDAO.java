package net.codejava.spring.dao.daointerface;

import java.util.List;

import net.codejava.spring.model.Produce_plan_tab;

/**
 * Defines DAO operations for the contact model.
 * 
 *
 */
public interface Produce_plan_tabDAO {
	
	public void saveOrUpdate(Produce_plan_tab produce_plan_tab);
	
	public void add(Produce_plan_tab produce_plan_tab);
	
	public void delete(String produce_plan_num);
	
	public Produce_plan_tab get(String produce_plan_num);
	
	public List<Produce_plan_tab> list();
	
	public List<Produce_plan_tab> listOfOper();
  
	public int updateSingleColumn(Produce_plan_tab produce_plan_tab,String column,String value);
}
