package net.codejava.spring.dao.daoimpl;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import net.codejava.spring.dao.daointerface.User_RolesDAO;
import net.codejava.spring.model.User_Roles;


public class User_RolesDAOImpl implements User_RolesDAO {

    private JdbcTemplate jdbcTemplate;
	
	public User_RolesDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	
	@Override
	public void save(User_Roles user_roles) {
    
			// insert
			String sql = "INSERT INTO user_roles (username,role_id)"
						+ " VALUES (?, ?)";
			jdbcTemplate.update(sql, user_roles.getUsername(),user_roles.getRole_id());
		
		
	}
		

	@Override
	public void delete(String username) {
		String sql = "DELETE FROM user_roles WHERE username=?";
		jdbcTemplate.update(sql, username);
	}

}
