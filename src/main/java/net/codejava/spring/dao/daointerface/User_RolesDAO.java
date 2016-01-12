package net.codejava.spring.dao.daointerface;


import net.codejava.spring.model.User_Roles;

public interface User_RolesDAO {

    public void save(User_Roles user_roles);
	
	public void delete(String username);

}
