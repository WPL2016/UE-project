package net.codejava.spring.dao.daointerface;

import java.util.List;

import net.codejava.spring.model.Authors;


public interface AuthorsDAO {

	public List<Authors> list();
	public List<Authors> list(int role_id);
	public List<Authors> listWithout(int role_id);

}
