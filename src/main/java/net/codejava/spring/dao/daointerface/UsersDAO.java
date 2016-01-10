package net.codejava.spring.dao.daointerface;


import java.util.List;

import net.codejava.spring.model.Contact;
import net.codejava.spring.model.Users;

/**
 * Defines DAO operations for the contact model.
 * 
 *
 */
public interface UsersDAO {
	
	
	
	public List<Users> list();
	public int exist(Users users);
	public void save(Users users);
	public Users getUser(String username);
	public int update(Users users);
	public int frozen(String username);
	public int unfrozen(String username);
	
}
