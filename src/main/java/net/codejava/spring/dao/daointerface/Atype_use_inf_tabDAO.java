package net.codejava.spring.dao.daointerface;

import java.util.List;

import net.codejava.spring.model.Atype_use_inf_tab;


/**
 * Defines DAO operations for the contact model.
 * 
 *
 */
public interface Atype_use_inf_tabDAO {
	
	public void saveOrUpdate(Atype_use_inf_tab atype_use_inf_tab);
	
	public void delete(String atype_use_inf_num);
	
	public Atype_use_inf_tab get(String atyp_use_infe_num);
	
	public List<Atype_use_inf_tab> list();
	public List<Atype_use_inf_tab> list(String atype_num);
}
	