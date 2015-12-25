package net.codejava.spring.dao.daointerface;

import java.util.List;


import net.codejava.spring.model.Product_tab;

/**
 * Defines DAO operations for the contact model.
 * 
 *
 */
public interface Product_tabDAO {
	
	public void saveOrUpdate(Product_tab product_tab);
	
	public void delete(String product_num);
	
	public Product_tab get(String product_num);
	
	public List<Product_tab> list();
	
	public int updateSingleColumn(Product_tab product_tab,String column,String value);
}
