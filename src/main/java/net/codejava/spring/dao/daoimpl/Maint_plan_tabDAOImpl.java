package net.codejava.spring.dao.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.sql.DataSource;

import net.codejava.spring.dao.daointerface.Maint_plan_tabDAO;
import net.codejava.spring.model.Atype_use_inf_tab;
import net.codejava.spring.model.Maint_plan_tab;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

/**
 * An implementation of the ContactDAO interface.
 * @author www.codejava.net
 *
 */
public class Maint_plan_tabDAOImpl implements Maint_plan_tabDAO {

	private JdbcTemplate jdbcTemplate;
	
	public Maint_plan_tabDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(Maint_plan_tab maint_plan_tab) {
String abc = "SELECT COUNT(*) FROM maint_plan_tab WHERE maint_plan_num=?";
		
		@SuppressWarnings("deprecation")
		int i=jdbcTemplate.queryForInt(abc,maint_plan_tab.getMaint_plan_num());
		if (i!=0) {
			// update
			String sql = "UPDATE maint_plan_tab SET maint_plan_cont=?, maint_plan_obj_num=?, maint_plan_per_num=?, "
						+ "maint_plan_date=? WHERE maint_plan_num=?";
			jdbcTemplate.update(sql, maint_plan_tab.getMaint_plan_cont(), maint_plan_tab.getMaint_plan_obj_num(),
					maint_plan_tab.getMaint_plan_per_num(), maint_plan_tab.getMaint_plan_date(), maint_plan_tab.getMaint_plan_num());
		} else {
			// insert
			String sql = "INSERT INTO maint_plan_tab (maint_plan_num, maint_plan_cont, maint_plan_obj_num, maint_plan_per_num, maint_plan_date)"
						+ " VALUES (?, ?, ?, ?, ?)";
			jdbcTemplate.update(sql, maint_plan_tab.getMaint_plan_num(),maint_plan_tab.getMaint_plan_cont(), maint_plan_tab.getMaint_plan_obj_num(),
					maint_plan_tab.getMaint_plan_per_num(), maint_plan_tab.getMaint_plan_date());
		}
		
	}

	@Override
	public void delete(String maint_plan_num) {
		String sql = "DELETE FROM maint_plan_tab WHERE maint_plan_num=?";
		jdbcTemplate.update(sql, maint_plan_num);
	}

	@Override
	public List<Maint_plan_tab> list() {
		String sql = "SELECT * FROM maint_plan_tab";
		List<Maint_plan_tab> listMaint_plan_tab = jdbcTemplate.query(sql, new RowMapper<Maint_plan_tab>() {

			@Override
			public Maint_plan_tab mapRow(ResultSet rs, int rowNum) throws SQLException {
				Maint_plan_tab aMaint_plan_tab = new Maint_plan_tab();
	
				aMaint_plan_tab.setMaint_plan_cont(rs.getString("maint_plan_cont"));
				aMaint_plan_tab.setMaint_plan_obj_num(rs.getString("maint_plan_obj_num"));
				aMaint_plan_tab.setMaint_plan_num(rs.getString("maint_plan_num"));
				aMaint_plan_tab.setMaint_plan_per_num(rs.getString("maint_plan_per_num"));
				
				aMaint_plan_tab.setMaint_plan_date(rs.getDate("maint_plan_date"));
				
				return aMaint_plan_tab;
			}
			
		});
		
		return listMaint_plan_tab;
	}

	
	@Override
	public List<Maint_plan_tab> list(String maint_plan_obj_num) {
		String sql = "SELECT * FROM maint_plan_tab where maint_plan_obj_num='"+maint_plan_obj_num+"'";
		List<Maint_plan_tab> listMaint_plan_tab = jdbcTemplate.query(sql, new RowMapper<Maint_plan_tab>() {
	
			@Override
			public Maint_plan_tab mapRow(ResultSet rs, int rowNum) throws SQLException {
				Maint_plan_tab aMaint_plan_tab = new Maint_plan_tab();
	
					aMaint_plan_tab.setMaint_plan_cont(rs.getString("maint_plan_cont"));
					aMaint_plan_tab.setMaint_plan_obj_num(rs.getString("maint_plan_obj_num"));
					aMaint_plan_tab.setMaint_plan_num(rs.getString("maint_plan_num"));
					aMaint_plan_tab.setMaint_plan_per_num(rs.getString("maint_plan_per_num"));
					
					aMaint_plan_tab.setMaint_plan_date(rs.getDate("maint_plan_date"));
					
					return aMaint_plan_tab;
				}
		});
				
				return listMaint_plan_tab;
			}
			
	@Override
	public Maint_plan_tab get(String maint_plan_num) {
		String sql = "SELECT * FROM maint_plan_tab WHEREmaint_plan_num=" + maint_plan_num;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Maint_plan_tab>() {

			@Override
			public Maint_plan_tab extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
										
					Maint_plan_tab aMaint_plan_tab = new Maint_plan_tab();
					
					aMaint_plan_tab.setMaint_plan_num(rs.getString("maint_plan_num"));
					
					
				
					aMaint_plan_tab.setMaint_plan_cont(rs.getString("maint_plan_cont"));
					aMaint_plan_tab.setMaint_plan_obj_num(rs.getString("maint_plan_obj_num"));
				    aMaint_plan_tab.setMaint_plan_per_num(rs.getString("maint_plan_per_num"));
					
					aMaint_plan_tab.setMaint_plan_date(rs.getDate("maint_plan_date"));
					
					return aMaint_plan_tab;
				}
				
				return null;
			}
			
		});
	}

}



