package net.codejava.spring.dao.daointerface;

import java.util.List;


import net.codejava.spring.model.Product_qual_asse_tab;

/**
 * Defines DAO operations for the contact model.
 * 
 *
 */
public interface Product_qual_asse_tabDAO {
	
	public void saveOrUpdate(Product_qual_asse_tab product_qual_asse_tab);
	
	public void delete(String product_qual_asse_num);
	
	public Product_qual_asse_tab get(String product_qual_asse_num);
	
	public List<Product_qual_asse_tab> list();
	
	public int updateSingleColumn(Product_qual_asse_tab product_qual_asse_tab,String column,String value);
	
	public List<Product_qual_asse_tab> getSomeProduct(String type);
}
