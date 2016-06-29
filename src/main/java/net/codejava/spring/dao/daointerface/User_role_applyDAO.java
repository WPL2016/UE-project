package net.codejava.spring.dao.daointerface;

import java.util.List;

import net.codejava.spring.model.User_role_apply;

public interface User_role_applyDAO {
	public List<User_role_apply> list();
	public List<User_role_apply> listOfFlag(int apply_flag);
	public List<User_role_apply> listOfType(String apply_role_type);
	//public List<User_role_apply> listWithout(String username);
	public void save(User_role_apply user_role_apply);
	public int applyExist(User_role_apply user_role_apply);
	public int delete(String username);
}
