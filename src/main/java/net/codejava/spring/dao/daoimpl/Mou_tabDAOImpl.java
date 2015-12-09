package net.codejava.spring.dao.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;
import net.codejava.spring.dao.daointerface.Mou_tabDAO;
import net.codejava.spring.model.Mou_tab;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

/**
 * An implementation of the ContactDAO interface.
 * @author www.codejava.net
 *
 */
public class Mou_tabDAOImpl implements Mou_tabDAO {

	private JdbcTemplate jdbcTemplate;
	
	public Mou_tabDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(Mou_tab mou_tab) {
        String abc = "SELECT COUNT(*) FROM mou_tab WHERE mou_num=?";
		
		@SuppressWarnings("deprecation")
		int i=jdbcTemplate.queryForInt(abc,mou_tab.getMou_num());
		if (i!=0) {
			// update
			String sql = "UPDATE mou_tab SET mou_sup=?, mou_name=?, mou_recorder_num=?, "
						+ "mou_hole_num=?,product_num=? WHERE mou_num=?";
			jdbcTemplate.update(sql, mou_tab.getMou_sup(), mou_tab.getMou_name(),
					mou_tab.getMou_recorder_num(), mou_tab.getMou_hole_num(), mou_tab.getProduct_num(),mou_tab.getMou_num());
		} else {
			// insert
			String sql = "INSERT INTO mou_tab (mou_num, mou_sup, mou_name, mou_recorder_num, mou_hole_num, product_num)"
						+ " VALUES (?, ?, ?, ?, ?,?)";
			jdbcTemplate.update(sql,mou_tab.getMou_num(), mou_tab.getMou_sup(), mou_tab.getMou_name(),
					mou_tab.getMou_recorder_num(), mou_tab.getMou_hole_num(),mou_tab.getProduct_num());
		}
		
	}

	@Override
	public void delete(String mou_num) {
		String sql = "DELETE FROM mou_tab WHERE mou_num=?";
		jdbcTemplate.update(sql, mou_num);
	}

	@Override
	public List<Mou_tab> list() {
		String sql = "SELECT * FROM mou_tab";
		List<Mou_tab> listMou_tab = jdbcTemplate.query(sql, new RowMapper<Mou_tab>() {

			@Override
			public Mou_tab mapRow(ResultSet rs, int rowNum) throws SQLException {
				Mou_tab aMou_tab = new Mou_tab();
	
				aMou_tab.setMou_num(rs.getString("mou_num"));
				aMou_tab.setMou_sup(rs.getString("mou_sup"));
				aMou_tab.setMou_name(rs.getString("mou_name"));
				aMou_tab.setMou_recorder_num(rs.getString("mou_recorder_num"));
				aMou_tab.setMou_hole_num(rs.getInt("mou_hole_num"));
				aMou_tab.setProduct_num(rs.getString("product_num"));
				
				return aMou_tab;
			}
			
		});
		
		return listMou_tab;
	}

	@Override
	public Mou_tab get(String mou_num) {
		String sql = "SELECT * FROM mou_tab WHERE mou_num=" + mou_num;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Mou_tab>() {

			@Override
			public Mou_tab extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Mou_tab aMou_tab = new Mou_tab();
					aMou_tab.setMou_num(rs.getString("mou_num"));
					aMou_tab.setMou_sup(rs.getString("mou_sup"));
					aMou_tab.setMou_name(rs.getString("mou_name"));
					aMou_tab.setMou_recorder_num(rs.getString("mou_recorder_num"));
					aMou_tab.setMou_hole_num(rs.getInt("mou_hole_num"));
					aMou_tab.setProduct_num(rs.getString("product_num"));
					
					return aMou_tab;
				}
				
				return null;
			}
			
		});
	}

}
