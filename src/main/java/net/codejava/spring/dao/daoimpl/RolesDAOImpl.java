package net.codejava.spring.dao.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import net.codejava.spring.dao.daointerface.RolesDAO;
import net.codejava.spring.model.Roles;
import net.codejava.spring.model.Users;

public class RolesDAOImpl implements RolesDAO {

private JdbcTemplate jdbcTemplate;
	
	public RolesDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Roles> list(String username) {
		String sql = "SELECT * FROM roles,user_roles where user_roles.username='"+username+"' and roles.role_id=user_roles.role_id";
		List<Roles> listContact = jdbcTemplate.query(sql, new RowMapper<Roles>() {

			@Override
			public Roles mapRow(ResultSet rs, int rowNum) throws SQLException {
				Roles aRoles = new Roles();
	
				aRoles.setRole_id(rs.getInt("role_id"));
				aRoles.setRole_name(rs.getString("role_name"));
				
				return aRoles;
			}
			
		});
		
		return listContact;
	}

	@Override
	public List<Roles> listWithout(String username) {
		String sql = "SELECT DISTINCT* FROM roles where  role_id not in (select role_id from user_roles where username='"+username+"')";
		List<Roles> listContact = jdbcTemplate.query(sql, new RowMapper<Roles>() {

			@Override
			public Roles mapRow(ResultSet rs, int rowNum) throws SQLException {
				Roles aRoles = new Roles();
	
				aRoles.setRole_id(rs.getInt("role_id"));
				aRoles.setRole_name(rs.getString("role_name"));
				
				return aRoles;
			}
			
		});
		
		return listContact;
	}
	
	
}
