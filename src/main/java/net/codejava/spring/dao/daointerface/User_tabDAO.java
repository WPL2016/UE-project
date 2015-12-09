package net.codejava.spring.dao.daointerface;

import java.util.List;
import net.codejava.spring.model.User_tab;

/**
 * Defines DAO operations for the contact model.
 * 
 *
 */
public interface User_tabDAO {
	
	public void saveOrUpdate(User_tab user_tab);
	
	public void delete(String user_num);
	
	public User_tab get(String user_num);
	
	public List<User_tab> list();
}
