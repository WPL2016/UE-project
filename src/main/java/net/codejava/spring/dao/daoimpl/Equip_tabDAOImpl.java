package net.codejava.spring.dao.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;
import net.codejava.spring.dao.daointerface.Equip_tabDAO;
import net.codejava.spring.model.Equip_tab;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

/**
 * An implementation of the ContactDAO interface.
 * @author www.codejava.net
 *
 */
public class Equip_tabDAOImpl implements Equip_tabDAO {

	private JdbcTemplate jdbcTemplate;
	
	public Equip_tabDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(Equip_tab equip_tab) {
		
		String abc = "SELECT COUNT(*) FROM equip_tab WHERE equip_num=?";
		
		@SuppressWarnings("deprecation")
		int i=jdbcTemplate.queryForInt(abc,equip_tab.getEquip_num());
		if (i!=0) {
			// update
			String sql = "UPDATE equip_tab SET equ_equip_num=?,equip_sup=?, equip_name=?,"
						+ "equip_recorder_num=? WHERE equip_num=?";
			jdbcTemplate.update(sql, equip_tab.getEqu_equip_num(),equip_tab.getEquip_sup(), equip_tab.getEquip_name(),
					equip_tab.getEquip_recorder_num(),equip_tab.getEquip_num());
		} else {
			// insert
			String sql = "INSERT INTO equip_tab (equip_num,equ_equip_num,equip_sup, equip_name, equip_recorder_num)"
						+ " VALUES (?, ?, ?, ?, ?)";
			jdbcTemplate.update(sql, equip_tab.getEquip_num(),equip_tab.getEqu_equip_num(),equip_tab.getEquip_sup(), equip_tab.getEquip_name(),
					equip_tab.getEquip_recorder_num());
		}
		
	}

	@Override
	public void delete(String equip_num) {
		String sql = "DELETE FROM equip_tab WHERE equip_num=?";
		jdbcTemplate.update(sql, equip_num);
	}

	@Override
	public List<Equip_tab> list() {
		String sql = "SELECT * FROM equip_tab";
		List<Equip_tab> listEquip_tab = jdbcTemplate.query(sql, new RowMapper<Equip_tab>() {

			@Override
			public Equip_tab mapRow(ResultSet rs, int rowNum) throws SQLException {
				Equip_tab aEquip_tab = new Equip_tab();
	
				aEquip_tab.setEquip_num(rs.getString("equip_num"));
				aEquip_tab.setEqu_equip_num(rs.getString("equ_equip_num"));
				aEquip_tab.setEquip_sup(rs.getString("equip_sup"));
				aEquip_tab.setEquip_name(rs.getString("equip_name"));
				aEquip_tab.setEquip_recorder_num(rs.getString("equip_recorder_num"));
				
				return aEquip_tab;
			}
			
		});
		
		return listEquip_tab;
	}

	@Override
	public Equip_tab get(String equip_num) {
		String sql = "SELECT * FROM equip_tab WHERE equip_num='"+equip_num+"'" ;
		return jdbcTemplate.query(sql,new ResultSetExtractor<Equip_tab>() {

			@Override
			public Equip_tab extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Equip_tab aEquip_tab = new Equip_tab();
					aEquip_tab.setEquip_num(rs.getString("equip_num"));
					aEquip_tab.setEqu_equip_num(rs.getString("equ_equip_num"));
					aEquip_tab.setEquip_sup(rs.getString("equip_sup"));
					aEquip_tab.setEquip_name(rs.getString("equip_name"));
					aEquip_tab.setEquip_recorder_num(rs.getString("equip_recorder_num"));
					
					return aEquip_tab;
				}
				
				return null;
			}
			
		});
	}

}
