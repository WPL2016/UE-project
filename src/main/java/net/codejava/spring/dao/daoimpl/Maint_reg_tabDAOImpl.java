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
			String sql = "UPDATE maint_reg_tab SET maint_reg_cont=?, maint_plan_num=?, maint_reg_date=?, maint_reg_per_num=?"
						+ " WHERE maint_reg_num=?";
			jdbcTemplate.update(sql, maint_reg_tab.getMaint_reg_cont(), maint_reg_tab.getMaint_plan_num(),
					maint_reg_tab.getMaint_reg_date(), maint_reg_tab.getMaint_reg_per_num(), maint_reg_tab.getMaint_reg_num());
		} else {
			// insert
			String sql = "INSERT INTO maint_reg_tab (maint_reg_cont, maint_plan_num, maint_reg_date, maint_reg_per_num, maint_reg_num)"
						+ " VALUES (?, ?, ?, ?, ?)";
			jdbcTemplate.update(sql,  maint_reg_tab.getMaint_reg_cont(), maint_reg_tab.getMaint_plan_num(),
					maint_reg_tab.getMaint_reg_date(), maint_reg_tab.getMaint_reg_per_num(), maint_reg_tab.getMaint_reg_num());
		}
		
	}

	@Override
	public void delete(String maint_reg_num) {
		String sql = "DELETE FROM maint_reg_tab WHERE maint_reg_num=?";
		jdbcTemplate.update(sql, maint_reg_num);
	}

	@Override
	public List<Maint_reg_tab> list() {
		String sql = "SELECT * FROM Maint_reg_tab";
		List<Maint_reg_tab> listMaint_reg_tab = jdbcTemplate.query(sql, new RowMapper<Maint_reg_tab>() {

			@Override
			public Maint_reg_tab mapRow(ResultSet rs, int rowNum) throws SQLException {
				Maint_reg_tab aMaint_reg_tab = new Maint_reg_tab();
	
				aMaint_reg_tab.setMaint_reg_cont(rs.getString("maint_reg_cont"));
				aMaint_reg_tab.setMaint_plan_num(rs.getString("maint_plan_num"));
				
				
				System.out.println("TIME:"+rs.getTimestamp("maint_reg_date"));
				
				aMaint_reg_tab.setMaint_reg_date(rs.getTimestamp("maint_reg_date"));
				
				System.out.println("TIME2:"+aMaint_reg_tab.getMaint_reg_date());
				
				aMaint_reg_tab.setMaint_reg_num(rs.getString("maint_reg_num"));
				aMaint_reg_tab.setMaint_reg_per_num(rs.getString("maint_reg_per_num"));
				
				return aMaint_reg_tab;
			}
			
		});
		
		return listMaint_reg_tab;
	}

	@Override
	public List<Maint_reg_tab> list(String maint_plan_num) {
		String sql = "SELECT * FROM Maint_reg_tab where Maint_reg_tab.maint_plan_num='"+maint_plan_num+"'";
		List<Maint_reg_tab> listMaint_reg_tab = jdbcTemplate.query(sql, new RowMapper<Maint_reg_tab>() {

			@Override
			public Maint_reg_tab mapRow(ResultSet rs, int rowNum) throws SQLException {
				Maint_reg_tab aMaint_reg_tab = new Maint_reg_tab();
				
				aMaint_reg_tab.setMaint_reg_cont(rs.getString("maint_reg_cont"));
				aMaint_reg_tab.setMaint_plan_num(rs.getString("maint_plan_num"));
				
				
				System.out.println("TIME:"+rs.getTimestamp("maint_reg_date"));
				
				aMaint_reg_tab.setMaint_reg_date(rs.getTimestamp("maint_reg_date"));
				
				System.out.println("TIME2:"+aMaint_reg_tab.getMaint_reg_date());
				
				aMaint_reg_tab.setMaint_reg_num(rs.getString("maint_reg_num"));
				aMaint_reg_tab.setMaint_reg_per_num(rs.getString("maint_reg_per_num"));
				
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
					aMaint_reg_tab.setMaint_plan_num(rs.getString("maint_plan_num"));
					
					
					System.out.println("TIME:"+rs.getTimestamp("maint_reg_date"));
					
					aMaint_reg_tab.setMaint_reg_date(rs.getTimestamp("maint_reg_date"));
					
					System.out.println("TIME2:"+aMaint_reg_tab.getMaint_reg_date());
					
					aMaint_reg_tab.setMaint_reg_num(rs.getString("maint_reg_num"));
					aMaint_reg_tab.setMaint_reg_per_num(rs.getString("maint_reg_per_num"));
					
					return aMaint_reg_tab;
				}
				
				return null;
			}
			
		});
	}

	@Override
	public List<Maint_reg_tab> listMaint_reg_tab(String maint_plan_obj_num) {
		String sql = "select maint_reg_num,maint_reg_date,maint_reg_cont,maint_reg_per_num,maint_plan_obj_num"+
 " FROM maint_reg_tab JOIN maint_plan_tab ON maint_reg_tab. maint_plan_num=maint_plan_tab. maint_plan_num where maint_plan_tab.maint_plan_obj_num='"+maint_plan_obj_num+"'";
		List<Maint_reg_tab> listMaint_reg_tab = jdbcTemplate.query(sql, new RowMapper<Maint_reg_tab>() {

			@Override
			public Maint_reg_tab mapRow(ResultSet rs, int rowNum) throws SQLException {
				Maint_reg_tab aMaint_reg_tab = new Maint_reg_tab();
				
				aMaint_reg_tab.setMaint_reg_cont(rs.getString("maint_reg_cont"));
								
				
				System.out.println("TIME:"+rs.getTimestamp("maint_reg_date"));
				
				aMaint_reg_tab.setMaint_reg_date(rs.getTimestamp("maint_reg_date"));
				
				System.out.println("TIME2:"+aMaint_reg_tab.getMaint_reg_date());
				
				aMaint_reg_tab.setMaint_reg_num(rs.getString("maint_reg_num"));
				aMaint_reg_tab.setMaint_reg_per_num(rs.getString("maint_reg_per_num"));
				aMaint_reg_tab.setMaint_plan_obj_num(rs.getString("maint_plan_obj_num"));
				return aMaint_reg_tab;
			}
			
		});
		
		return listMaint_reg_tab;
	}

}