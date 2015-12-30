package net.codejava.spring.dao.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import net.codejava.spring.dao.daointerface.Atype_tabDAO;
import net.codejava.spring.model.Atype_tab;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

/**
 * An implementation of the ContactDAO interface.
 * @author www.codejava.net
 *
 */
public class Atype_tabDAOImpl implements Atype_tabDAO {

	private JdbcTemplate jdbcTemplate;
	
	public Atype_tabDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(Atype_tab atype_tab) {
        String abc = "SELECT COUNT(*) FROM atype_tab WHERE atype_num=?";
		
		@SuppressWarnings("deprecation")
		int i=jdbcTemplate.queryForInt(abc,atype_tab.getAtype_num());
		if (i!=0) {
			// update
			String sql = "UPDATE atype_tab SET atype_sup=?, atype_name=?, atype_recorder_num=?  "
						+ " WHERE atype_num=?";
			jdbcTemplate.update(sql, atype_tab.getAtype_sup(), atype_tab.getAtype_name(),
					atype_tab.getAtype_recorder_num(), atype_tab.getAtype_num());
		} else {
			// insert
			String sql = "INSERT INTO atype_tab (atype_sup, atype_name, atype_recorder_num, atype_num)"
						+ " VALUES (?, ?, ?, ?)";
			jdbcTemplate.update(sql, atype_tab.getAtype_sup(), atype_tab.getAtype_name(),
					atype_tab.getAtype_recorder_num(), atype_tab.getAtype_num());
		}
		
	}

	@Override
	public void delete(String atype_num) {
		String sql = "DELETE FROM atype_tab WHERE atype_num=?";
		jdbcTemplate.update(sql, atype_num);
	}

	@Override
	public List<Atype_tab> list() {
		String sql = "SELECT * FROM atype_tab";
		List<Atype_tab> listAtype_tab = jdbcTemplate.query(sql, new RowMapper<Atype_tab>() {

			@Override
			public Atype_tab mapRow(ResultSet rs, int rowNum) throws SQLException {
				Atype_tab aAtype_tab = new Atype_tab();
	
				aAtype_tab.setAtype_num(rs.getString("atype_num"));
				aAtype_tab.setAtype_sup(rs.getString("atype_sup"));
				aAtype_tab.setAtype_name(rs.getString("atype_name"));
				aAtype_tab.setAtype_recorder_num(rs.getString("atype_recorder_num"));
	
				
				return aAtype_tab;
			}
			
		});
		
		return listAtype_tab;
	}

	@Override
	public Atype_tab get(String atype_num) {
		String sql = "SELECT * FROM atype_tab WHERE atype_num=" + atype_num;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Atype_tab>() {

			@Override
			public Atype_tab extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Atype_tab aAtype_tab = new Atype_tab();
					aAtype_tab.setAtype_num(rs.getString("atype_num"));
					aAtype_tab.setAtype_sup(rs.getString("atype_sup"));
					aAtype_tab.setAtype_name(rs.getString("atype_name"));
					aAtype_tab.setAtype_recorder_num(rs.getString("atype_recorder_num"));
					
					
					return aAtype_tab;
				}
				
				return null;
			}
			
		});
	}

}