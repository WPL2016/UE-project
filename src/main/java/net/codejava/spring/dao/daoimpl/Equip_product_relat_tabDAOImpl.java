package net.codejava.spring.dao.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import net.codejava.spring.dao.daointerface.Equip_product_relat_tabDAO;
import net.codejava.spring.model.Equip_product_relat_tab;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

/**
 * An implementation of the ContactDAO interface.
 * @author www.codejava.net
 *
 */
public class Equip_product_relat_tabDAOImpl implements Equip_product_relat_tabDAO {

	private JdbcTemplate jdbcTemplate;
	
	public Equip_product_relat_tabDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(Equip_product_relat_tab equip_product_relat_tab) {
		
		String abc = "SELECT COUNT(*) FROM equip_product_relat_tab WHERE equip_product_relat_num=?";
		
		@SuppressWarnings("deprecation")
		int i=jdbcTemplate.queryForInt(abc,equip_product_relat_tab.getEquip_product_relat_num());
		if (i!=0) {
			// update
			String sql = "UPDATE equip_product_relat_tab SET equip_num=?, product_num=?,"
						+ "equip_product_relat_recorder_num=? WHERE equip_product_relat_num=?";
			jdbcTemplate.update(sql,  equip_product_relat_tab.getEquip_num(),
					equip_product_relat_tab.getProduct_num(),equip_product_relat_tab.getEquip_product_relat_recorder_num(),equip_product_relat_tab.getEquip_product_relat_num());
		} else {
			// insert
			String sql = "INSERT INTO equip_tab (equip_product_relat_num,equip_num, product_num, equip_product_relat_recorder_num)"
						+ " VALUES (?, ?, ?, ?)";
			jdbcTemplate.update(sql, equip_product_relat_tab.getEquip_product_relat_num(), equip_product_relat_tab.getEquip_num(),
					equip_product_relat_tab.getProduct_num(), equip_product_relat_tab.getEquip_product_relat_recorder_num());
		}
		
	}

	@Override
	public void delete(String equip_product_relat_num) {
		String sql = "DELETE FROM equip_product_relat_tab WHERE equip_product_relat_num=?";
		jdbcTemplate.update(sql, equip_product_relat_num);
	}

	@Override
	public List<Equip_product_relat_tab> list() {
		String sql = "SELECT * FROM equip_product_relat_tab";
		List<Equip_product_relat_tab> listEquip_product_relat_tab = jdbcTemplate.query(sql, new RowMapper<Equip_product_relat_tab>() {

			@Override
			public Equip_product_relat_tab mapRow(ResultSet rs, int rowNum) throws SQLException {
				Equip_product_relat_tab aEquip_product_relat_tab = new Equip_product_relat_tab();
	
				aEquip_product_relat_tab.setEquip_product_relat_num(rs.getString("equip_product_relat_num"));
				aEquip_product_relat_tab.setEquip_num(rs.getString("equip_num"));
				aEquip_product_relat_tab.setProduct_num(rs.getString("product_num"));
				aEquip_product_relat_tab.setEquip_product_relat_recorder_num(rs.getString("equip_product_relat_recorder_num"));
			
				
				return aEquip_product_relat_tab;
			}
			
		});
		
		return listEquip_product_relat_tab;
	}

	@Override
	public Equip_product_relat_tab get(String equip_product_relat_num) {
		String sql = "SELECT * FROM equip_product_relat_tab WHERE equip_product_relat_num='"+equip_product_relat_num+"'" ;
		return jdbcTemplate.query(sql,new ResultSetExtractor<Equip_product_relat_tab>() {

			@Override
			public Equip_product_relat_tab extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Equip_product_relat_tab aEquip_product_relat_tab = new Equip_product_relat_tab();
					
					aEquip_product_relat_tab.setEquip_product_relat_num(rs.getString("equip_product_relat_num"));
					aEquip_product_relat_tab.setEquip_num(rs.getString("equip_num"));
					aEquip_product_relat_tab.setProduct_num(rs.getString("product_num"));
					aEquip_product_relat_tab.setEquip_product_relat_recorder_num(rs.getString("equip_product_relat_recorder_num"));
				
					
					return aEquip_product_relat_tab;
				}
				
				return null;
			}
			
		});
	}

}
