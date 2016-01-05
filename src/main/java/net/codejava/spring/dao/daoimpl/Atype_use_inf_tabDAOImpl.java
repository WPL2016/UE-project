package net.codejava.spring.dao.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.sql.DataSource;

import net.codejava.spring.dao.daointerface.Atype_use_inf_tabDAO;
import net.codejava.spring.model.Atype_use_inf_tab;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

/**
 * An implementation of the ContactDAO interface.
 * @author www.codejava.net
 *
 */
public class Atype_use_inf_tabDAOImpl implements Atype_use_inf_tabDAO {

	private JdbcTemplate jdbcTemplate;
	
	public Atype_use_inf_tabDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(Atype_use_inf_tab atype_use_inf_tab) {
        String abc = "SELECT COUNT(*) FROM atype_use_inf_tab WHERE atype_use_inf_num=?";
		
		@SuppressWarnings("deprecation")
		int i=jdbcTemplate.queryForInt(abc,atype_use_inf_tab.getAtype_use_inf_num());
		if (i!=0) {
			// update
			String sql = "UPDATE atype_use_inf_tab SET chan_date=?, chan_quan=?, chan_per_num=?,atype_num=?,equip_num=? "
						+ " WHERE atype_use_inf_num=?";
			jdbcTemplate.update(sql, atype_use_inf_tab.getChan_date(), atype_use_inf_tab.getChan_quan(),
					atype_use_inf_tab.getChan_per_num(), atype_use_inf_tab.getAtype_num(),atype_use_inf_tab.getEquip_num(),atype_use_inf_tab.getAtype_use_inf_num());
		} else {
			// insert
			String sql = "INSERT INTO atype_use_inf_tab (Atype_use_inf_num,Chan_date, Chan_quan, Chan_per_num,Atype_num,Equip_num)"
						+ " VALUES (?, ?, ?,?, ?,?)";
			jdbcTemplate.update(sql, atype_use_inf_tab.getAtype_use_inf_num(), atype_use_inf_tab.getChan_date(),
					atype_use_inf_tab.getChan_quan(),atype_use_inf_tab.getChan_per_num(),atype_use_inf_tab.getAtype_num(),atype_use_inf_tab.getEquip_num());
		}
		
	}

	@Override
	public void delete(String atype_use_inf_num) {
		String sql = "DELETE FROM atype_use_inf_tab WHERE atype_use_inf_num=?";
		jdbcTemplate.update(sql, atype_use_inf_num);
	}

	@Override
	public List<Atype_use_inf_tab> list() {
		String sql = "SELECT * FROM atype_use_inf_tab";
		List<Atype_use_inf_tab> listAtype_use_inf_tab = jdbcTemplate.query(sql, new RowMapper<Atype_use_inf_tab>() {

			@Override
			public Atype_use_inf_tab mapRow(ResultSet rs, int rowNum) throws SQLException {
				Atype_use_inf_tab aAtype_use_inf_tab = new Atype_use_inf_tab();
	
				aAtype_use_inf_tab.setAtype_use_inf_num(rs.getString("atype_use_inf_num"));
				
				aAtype_use_inf_tab.setChan_date(rs.getDate("chan_date"));
				
				aAtype_use_inf_tab.setChan_quan(rs.getInt("chan_quan"));
				aAtype_use_inf_tab.setChan_per_num(rs.getString("chan_per_num"));
				aAtype_use_inf_tab.setAtype_num(rs.getString("atype_num"));
				aAtype_use_inf_tab.setEquip_num(rs.getString("equip_num"));
	
				
				return aAtype_use_inf_tab;
			}
			
		});
		
		return listAtype_use_inf_tab;
	}

	@Override
	public List<Atype_use_inf_tab> list(String atype_num) {
		String sql = "SELECT * FROM atype_use_inf_tab where atype_num='"+atype_num+"'";
		List<Atype_use_inf_tab> listAtype_use_inf_tab = jdbcTemplate.query(sql, new RowMapper<Atype_use_inf_tab>() {

			@Override
			public Atype_use_inf_tab mapRow(ResultSet rs, int rowNum) throws SQLException {
				Atype_use_inf_tab aAtype_use_inf_tab = new Atype_use_inf_tab();
	
				aAtype_use_inf_tab.setAtype_use_inf_num(rs.getString("atype_use_inf_num"));
				
				aAtype_use_inf_tab.setChan_date(rs.getDate("chan_date"));
				
				aAtype_use_inf_tab.setChan_quan(rs.getInt("chan_quan"));
				aAtype_use_inf_tab.setChan_per_num(rs.getString("chan_per_num"));
				aAtype_use_inf_tab.setAtype_num(rs.getString("atype_num"));
				aAtype_use_inf_tab.setEquip_num(rs.getString("equip_num"));
	
				
				return aAtype_use_inf_tab;
			}
			
		});
		
		return listAtype_use_inf_tab;
	}	
	
	
	
	@Override
	public Atype_use_inf_tab get(String atype_use_inf_num) {
		String sql = "SELECT * FROM atype_use_inf_tab WHEREatype_use_inf_num=" + atype_use_inf_num;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Atype_use_inf_tab>() {

			@Override
			public Atype_use_inf_tab extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
										
					Atype_use_inf_tab aAtype_use_inf_tab = new Atype_use_inf_tab();
					
					aAtype_use_inf_tab.setAtype_use_inf_num(rs.getString("atype_use_inf_num"));
					
					
				
					aAtype_use_inf_tab.setChan_date(rs.getDate("chan_date"));
					
					aAtype_use_inf_tab.setChan_quan(rs.getInt("chan_quan"));
					aAtype_use_inf_tab.setChan_per_num(rs.getString("chan_per_num"));
					aAtype_use_inf_tab.setAtype_num(rs.getString("atype_num"));
					aAtype_use_inf_tab.setEquip_num(rs.getString("equip_num"));
		
					
					return aAtype_use_inf_tab;
				}
				
				return null;
			}
			
		});
	}

}