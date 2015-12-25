package net.codejava.spring.dao.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import net.codejava.spring.dao.daointerface.Maint_reg_tabDAO;
import net.codejava.spring.model.Maint_reg_tab;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.text.Format;
import java.text.SimpleDateFormat;
/**
 * An implementation of the ContactDAO interface.
 * @author www.codejava.net
 *
 */
public class Maint_reg_tabDAOImpl implements Maint_reg_tabDAO {

	private JdbcTemplate jdbcTemplate;
	
	public Maint_reg_tabDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(Maint_reg_tab maint_reg_tab) {
    String abc = "SELECT COUNT(*) FROM maint_reg_tab WHERE maint_reg_num=?";
		
		@SuppressWarnings("deprecation")
		int i=jdbcTemplate.queryForInt(abc,maint_reg_tab.getMaint_reg_num());
		if (i!=0) {
			// update
			String sql = "UPDATE maint_reg_tab SET maint_reg_cont=?, maint_reg_obj_num=?, maint_reg_per_num=?, "
						+ "maint_reg_date=? WHERE maint_reg_num=?";
			jdbcTemplate.update(sql, maint_reg_tab.getMaint_reg_cont(), maint_reg_tab.getMaint_reg_obj_num(),
					maint_reg_tab.getMaint_reg_per_num(), maint_reg_tab.getMaint_reg_date(), maint_reg_tab.getMaint_reg_num());
		} else {
			// insert
			String sql = "INSERT INTO maint_reg_tab (maint_reg_num, maint_reg_cont, maint_reg_obj_num, maint_reg_per_num, maint_reg_date)"
						+ " VALUES (?,?, ?, ?, ?)";
			jdbcTemplate.update(sql, maint_reg_tab.getMaint_reg_num(),maint_reg_tab.getMaint_reg_cont(), maint_reg_tab.getMaint_reg_obj_num(),
					maint_reg_tab.getMaint_reg_per_num(), maint_reg_tab.getMaint_reg_date());
		}
		
	}

	@Override
	public void delete(String maint_reg_num) {
		String sql = "DELETE FROM maint_reg_tab WHERE maint_reg_num=?";
		jdbcTemplate.update(sql, maint_reg_num);
	}

	@Override
	public List<Maint_reg_tab> list(String equip_num) {
		String sql = "SELECT * FROM maint_reg_tab where maint_reg_obj_num='"+equip_num+"'";
		List<Maint_reg_tab> listMaint_reg_tab = jdbcTemplate.query(sql, new RowMapper<Maint_reg_tab>() {

			@Override
			public Maint_reg_tab mapRow(ResultSet rs, int rowNum) throws SQLException {
				Maint_reg_tab aMaint_reg_tab = new Maint_reg_tab();
	
				aMaint_reg_tab.setMaint_reg_cont(rs.getString("maint_reg_cont"));
				aMaint_reg_tab.setMaint_reg_obj_num(rs.getString("maint_reg_obj_num"));
				aMaint_reg_tab.setMaint_reg_num(rs.getString("maint_reg_num"));
				aMaint_reg_tab.setMaint_reg_per_num(rs.getString("maint_reg_per_num"));
				
				
				
				aMaint_reg_tab.setMaint_reg_date(rs.getDate("maint_reg_date"));
				return aMaint_reg_tab;
			}
			
		});
		
		return listMaint_reg_tab;
	}

	@Override
	public Maint_reg_tab get(String maint_reg_num) {
		String sql = "SELECT * FROM maint_reg_tab WHERE maint_reg_num=" + maint_reg_num;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Maint_reg_tab>() {

			@Override
			public Maint_reg_tab extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Maint_reg_tab aMaint_reg_tab = new Maint_reg_tab();
					
					aMaint_reg_tab.setMaint_reg_cont(rs.getString("maint_reg_cont"));
					aMaint_reg_tab.setMaint_reg_obj_num(rs.getString("maint_reg_obj_num"));
					aMaint_reg_tab.setMaint_reg_num(rs.getString("maint_reg_num"));
					aMaint_reg_tab.setMaint_reg_per_num(rs.getString("maint_reg_per_num"));
					
					aMaint_reg_tab.setMaint_reg_date(rs.getTimestamp("maint_reg_date"));
					return aMaint_reg_tab;
				}
				
				return null;
			}
			
		});
	}

}
