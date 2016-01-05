package net.codejava.spring.dao.daointerface;

import java.util.List;

import net.codejava.spring.model.Roles;


public interface RolesDAO {

	public List<Roles> list(String username);
	public List<Roles> listWithout(String username);
}
