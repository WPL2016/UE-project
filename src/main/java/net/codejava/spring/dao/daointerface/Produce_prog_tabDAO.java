package net.codejava.spring.dao.daointerface;

import java.util.List;

import net.codejava.spring.model.Produce_prog_tab;
import net.codejava.spring.model.Produce_static_tab;

/**
 * Defines DAO operations for the contact model.
 * 
 *
 */
public interface Produce_prog_tabDAO {
	
	public void saveOrUpdate(Produce_prog_tab produce_prog_tab);
	
	public void delete(String Produce_prog_num);
	
	public Produce_prog_tab get(String Produce_prog_num);
	
	public List<Produce_prog_tab> list();
  
	public int updateSingleColumn(Produce_prog_tab produce_prog_tab,String column,String value);
	
	public List<Produce_static_tab> listProduce_static_tab();
	
	public List<Produce_static_tab> list(String produce_plan_num);
}
