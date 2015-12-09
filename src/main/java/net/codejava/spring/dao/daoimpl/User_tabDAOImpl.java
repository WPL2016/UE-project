package net.codejava.spring.dao.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;
import net.codejava.spring.dao.daointerface.User_tabDAO;
import net.codejava.spring.model.User_tab;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

/**
 * An implementation of the ContactDAO interface.
 * @author www.codejava.net
 *
 */
public class User_tabDAOImpl implements User_tabDAO {

	private JdbcTemplate jdbcTemplate;
	
	public User_tabDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(User_tab user_tab) {
        String abc = "SELECT COUNT(*) FROM usertab WHERE user_num=?";
		
		@SuppressWarnings("deprecation")
		int i=jdbcTemplate.queryForInt(abc,user_tab.getUser_num());
		if (i!=0) {
			// update
			String sql = "UPDATE user_tab SET user_name=?, user_password=?,user_dep=?, "
						+ "user_tel=?,user_type=? WHERE user_num=?";
			jdbcTemplate.update(sql, user_tab.getUser_name(), user_tab.getUser_password(),
					user_tab.getUser_dep(), user_tab.getUser_tel(), user_tab.getUser_type() ,user_tab.getUser_num());
		} else {
			// insert
			String sql = "INSERT INTO mater_tab (user_num,user_name, user_password, user_dep, user_tel,user_type)"
						+ " VALUES (?,?, ?, ?, ?,?)";
			jdbcTemplate.update(sql, user_tab.getUser_num(),user_tab.getUser_name(), user_tab.getUser_password(),
					user_tab.getUser_dep(), user_tab.getUser_tel(), user_tab.getUser_type());
		}
		
	}

	@Override
	public void delete(String user_num) {
		String sql = "DELETE FROM user_tab WHERE user_num=?";
		jdbcTemplate.update(sql, user_num);
	}

	@Override
	public List<User_tab> list() {
		String sql = "SELECT * FROM user_tab";
		List<User_tab> listUser_tab = jdbcTemplate.query(sql, new RowMapper<User_tab>() {

			@Override
			public User_tab mapRow(ResultSet rs, int rowNum) throws SQLException {
				User_tab aUser_tab = new User_tab();
	
				aUser_tab.setUser_name(rs.getString("user_name"));
				aUser_tab.setUser_password(rs.getString("user_password"));
				aUser_tab.setUser_dep(rs.getString("user_dep"));
				aUser_tab.setUser_tel(rs.getInt("user_tel"));
				aUser_tab.setUser_type(rs.getString("user_type"));
				aUser_tab.setUser_num(rs.getString("user_num"));
				
				return aUser_tab;
			}
			
		});
		
		return listUser_tab;
	}

	@Override
	public User_tab get(String user_num) {
		String sql = "SELECT * FROM user_tab WHERE user_num=" + user_num;
		return jdbcTemplate.query(sql, new ResultSetExtractor<User_tab>() {

			@Override
			public User_tab extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					User_tab aUser_tab = new User_tab();
					
					aUser_tab.setUser_name(rs.getString("user_name"));
					aUser_tab.setUser_password(rs.getString("user_password"));
					aUser_tab.setUser_dep(rs.getString("user_dep"));
					aUser_tab.setUser_tel(rs.getInt("user_tel"));
					aUser_tab.setUser_type(rs.getString("user_type"));
					aUser_tab.setUser_num(rs.getString("user_num"));
					
					return aUser_tab;
				}
				
				return null;
			}
			
		});
	}

}
