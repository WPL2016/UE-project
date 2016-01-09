package net.codejava.spring.dao.daointerface;

import java.util.List;

import net.codejava.spring.model.Roles;


public interface RolesDAO {
	public List<Roles> list();
	public List<Roles> list(String username);
	public List<Roles> listWithout(String username);
	public void save(Roles roles);
	public int role_nameExist(Roles roles);
	public int delete(String role_id);
}
