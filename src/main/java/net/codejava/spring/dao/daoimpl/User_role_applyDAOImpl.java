package net.codejava.spring.dao.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import net.codejava.spring.dao.daointerface.RolesDAO;
import net.codejava.spring.dao.daointerface.User_role_applyDAO;
import net.codejava.spring.model.Roles;
import net.codejava.spring.model.User_role_apply;
import net.codejava.spring.model.Users;

public class User_role_applyDAOImpl implements User_role_applyDAO {

private JdbcTemplate jdbcTemplate;
	
	public User_role_applyDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<User_role_apply> list() {
		String sql = "SELECT * FROM user_role_apply";
		List<User_role_apply> listContact= jdbcTemplate.query(sql, new RowMapper<User_role_apply>() {

			@Override
			public User_role_apply mapRow(ResultSet rs, int rowNum) throws SQLException {
				User_role_apply aUser_role_apply = new User_role_apply();
	
				aUser_role_apply.setUsername(rs.getString("username"));
				aUser_role_apply.setApply_role_type(rs.getString("apply_role_type"));
				aUser_role_apply.setApply_flag(rs.getInt("apply_flag"));
				aUser_role_apply.setLast_modify_date(rs.getDate("last_modify_date"));
				aUser_role_apply.setLast_modify_user(rs.getString("last_modify_user"));
				return aUser_role_apply;
			}
			
		});
		
		return listContact;
	}
	
	
	@Override
	public List<User_role_apply> listOfFlag(int apply_flag) {
		String sql = "SELECT * FROM user_role_apply where apply_flag="+apply_flag;
		List<User_role_apply> listContact= jdbcTemplate.query(sql, new RowMapper<User_role_apply>() {

			@Override
			public User_role_apply mapRow(ResultSet rs, int rowNum) throws SQLException {
				User_role_apply aUser_role_apply = new User_role_apply();
	
				aUser_role_apply.setUsername(rs.getString("username"));
				aUser_role_apply.setApply_role_type(rs.getString("apply_role_type"));
				aUser_role_apply.setApply_flag(rs.getInt("apply_flag"));
				aUser_role_apply.setLast_modify_date(rs.getDate("last_modify_date"));
				aUser_role_apply.setLast_modify_user(rs.getString("last_modify_user"));
				return aUser_role_apply;
			}
			
		});
		
		return listContact;
	}

	@Override
	public List<User_role_apply> listOfType(String apply_role_type) {
		String sql = "SELECT * FROM user_role_apply where apply_role_type="+apply_role_type;
		List<User_role_apply> listContact= jdbcTemplate.query(sql, new RowMapper<User_role_apply>() {

			@Override
			public User_role_apply mapRow(ResultSet rs, int rowNum) throws SQLException {
				User_role_apply aUser_role_apply = new User_role_apply();
	
				aUser_role_apply.setUsername(rs.getString("username"));
				aUser_role_apply.setApply_role_type(rs.getString("apply_role_type"));
				aUser_role_apply.setApply_flag(rs.getInt("apply_flag"));
				aUser_role_apply.setLast_modify_date(rs.getDate("last_modify_date"));
				aUser_role_apply.setLast_modify_user(rs.getString("last_modify_user"));
				return aUser_role_apply;
			}
			
		});
		
		return listContact;
	}

	
	@Override
	public int applyExist(User_role_apply user_role_apply){
	  String sql="select count(*) from user_role_apply where username=? and apply_flag=1";	
	  @SuppressWarnings("deprecation")
		int i=jdbcTemplate.queryForInt(sql,user_role_apply.getUsername());
	  return i;
	}
	
	@Override
	public void save(User_role_apply user_role_apply){
	  String sql="Insert into user_role_apply (username,apply_role_type,apply_flag,last_modify_date,last_modify_user) values (?,?,?,?,?)";	
	  jdbcTemplate.update(sql,user_role_apply.getUsername(),user_role_apply.getApply_role_type(),user_role_apply.getApply_flag(),user_role_apply.getLast_modify_date(),user_role_apply.getLast_modify_user());
	}
	@Override
	public int delete(String username){
	String sql="delete from user_role_apply where username=?";
	int i;
	try{		
	jdbcTemplate.update(sql, username);
	i=1;
	}catch(Exception e){i=0;}
	return i;
	}
	
}
