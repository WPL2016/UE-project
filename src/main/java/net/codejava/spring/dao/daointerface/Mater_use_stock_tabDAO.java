package net.codejava.spring.dao.daointerface;

import java.util.List;

import net.codejava.spring.model.Mater_use_stock_tab;
import net.codejava.spring.model.Produce_prog_tab;
import net.codejava.spring.model.Produce_static_tab;

/**
 * Defines DAO operations for the contact model.
 * 
 *
 */
public interface Mater_use_stock_tabDAO {
	
	//public void saveOrUpdate(Mater_use_stock_tab mater_use_stock_tab);
	
	//public void delete(String Produce_prog_num);
	
	//public Produce_prog_tab get(String Produce_prog_num);
	
	public List<Mater_use_stock_tab> listMater_use_stock_tab();
  
	//public int updateSingleColumn(Produce_prog_tab produce_prog_tab,String column,String value);
	
	//public List<Produce_static_tab> listProduce_static_tab();
}
