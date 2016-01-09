package net.codejava.spring.dao.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import net.codejava.spring.dao.daointerface.UsersDAO;

import net.codejava.spring.model.Users;

public class UsersDAOImpl implements UsersDAO{

private JdbcTemplate jdbcTemplate;
	
	public UsersDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}


	@Override
	public List<Users> list() {
		String sql = "SELECT * FROM users ";
		List<Users> listContact = jdbcTemplate.query(sql, new RowMapper<Users>() {

			@Override
			public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
				Users aUser = new Users();
	
				aUser.setUsername(rs.getString("username"));
				aUser.setEnabled(rs.getInt("enabled"));
				
				return aUser;
			}
			
		});
		
		return listContact;
	}
	
	@Override
	public int exist(Users users){
		String sql="SELECT Count(*) FROM users where username=?";
		@SuppressWarnings("deprecation")
		int i=jdbcTemplate.queryForInt(sql, users.getUsername());
		return i;
	}
	
	@Override
    public void save(Users users){
       String sql="INSERT INTO users (username,password,enabled,person_name,user_dep,user_tel,birth_day,user_duty,email)"
				+ " VALUES (?, ?, ?, ?, ?,?,?,?,?)";
	jdbcTemplate.update(sql, users.getUsername(),users.getPassword(),users.getEnabled(),users.getPerson_name(),users.getUser_dep(),users.getUser_tel(),users.getBirth_day(),users.getUser_duty(),users.getEmail());
	}
}
