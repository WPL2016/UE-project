package net.codejava.spring.dao.daointerface;

import java.util.List;

import net.codejava.spring.model.Equip_product_relat_tab;


/**
 * Defines DAO operations for the contact model.
 * 
 *
 */
public interface Equip_product_relat_tabDAO {
	
	public void saveOrUpdate(Equip_product_relat_tab equip_product_relat_tab);
	
	public void delete(String equip_product_relat_num);
	
	public Equip_product_relat_tab get(String equip_product_relat_num);
	
	public List<Equip_product_relat_tab> list();
}
