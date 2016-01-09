package net.codejava.spring.dao.daointerface;

import java.util.List;

import net.codejava.spring.model.Product_qual_stat_tab;
import net.codejava.spring.model.Qual_show_tab;

/**
 * Defines DAO operations for the contact model.
 * 
 *
 */
public interface Product_qual_stat_tabDAO {
	
	public void saveOrUpdate(Product_qual_stat_tab product_qual_stat_tab);
	
	public void delete(String qual_stat_num);
	
	public Product_qual_stat_tab get(String qual_stat_num);
	
	public List<Product_qual_stat_tab> list();

	public int updateSingleColumn(Product_qual_stat_tab product_qual_stat_tab,String column,String value);
	
	public List<Qual_show_tab> getSomeQual(String product_num, String start_time, String end_time ,String timechoice);

	public List<Product_qual_stat_tab> getByProductnum(String product_num,String start_time, String end_time);
}
