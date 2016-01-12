package net.codejava.spring.dao.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import net.codejava.spring.dao.daointerface.UsersDAO;
import net.codejava.spring.model.Contact;
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
	
	@Override
	 public Users getUser(String username){
		String sql="select * from users where username='"+username+"'";
		return jdbcTemplate.query(sql, new ResultSetExtractor<Users>() {

			@Override
			public Users extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Users users= new Users();
					users.setUsername(rs.getString("username"));
					users.setPerson_name(rs.getString("person_name"));
					users.setBirth_day(rs.getDate("birth_day"));
					users.setEmail(rs.getString("email"));
					users.setEnabled(rs.getInt("enabled"));
					users.setUser_dep(rs.getString("user_dep"));
					users.setUser_duty(rs.getString("user_duty"));
					users.setUser_tel(rs.getString("user_tel"));
					return users;
				}
				
				return null;
			}
			
		});
		
	}
	@Override
	public int update(Users users){
		String sql="UPDATE users SET  email=?, person_name=?,birth_day=?, "
				+ "user_tel=?,user_dep=?,user_duty=?  WHERE  username=?";
	int i;
	try{
		jdbcTemplate.update(sql,users.getEmail(),users.getPerson_name(),users.getBirth_day(),users.getUser_tel(),users.getUser_dep(),users.getUser_duty(),users.getUsername());
		i=1;
	}catch(Exception e){i=0;}
	
	return i;
	}
	
	@Override
	public int frozen(String  username){
		String sql="UPDATE users SET  enabled=0 WHERE  username=?";
	int i;
	try{
		jdbcTemplate.update(sql,username);
		i=1;
	}catch(Exception e){i=0;}
	
	return i;
	}
	
	@Override
	public int unfrozen(String  username){
		String sql="UPDATE users SET  enabled=1 WHERE  username=?";
	int i;
	try{
		jdbcTemplate.update(sql,username);
		i=1;
	}catch(Exception e){i=0;}
	
	return i;
	}
	
}
