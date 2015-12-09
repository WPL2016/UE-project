package net.codejava.spring.dao.daointerface;

import java.util.List;
import net.codejava.spring.model.Mou_tab;

/**
 * Defines DAO operations for the contact model.
 * 
 *
 */
public interface Mou_tabDAO {
	
	public void saveOrUpdate(Mou_tab mou_tab);
	
	public void delete(String mou_num);
	
	public Mou_tab get(String mou_num);
	
	public List<Mou_tab> list();
}
