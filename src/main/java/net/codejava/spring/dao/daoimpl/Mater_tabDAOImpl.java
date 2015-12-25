package net.codejava.spring.dao.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;
import net.codejava.spring.dao.daointerface.Mater_tabDAO;
import net.codejava.spring.model.Mater_tab;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

/**
 * An implementation of the ContactDAO interface.
 * @author www.codejava.net
 *
 */
public class Mater_tabDAOImpl implements Mater_tabDAO {

	private JdbcTemplate jdbcTemplate;
	
	public Mater_tabDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(Mater_tab mater_tab) {
        String abc = "SELECT COUNT(*) FROM mater_tab WHERE mater_num=?";
		
		@SuppressWarnings("deprecation")
		int i=jdbcTemplate.queryForInt(abc,mater_tab.getMater_num());
		if (i!=0) {
			// update
			String sql = "UPDATE mater_tab SET mater_sup=?, mater_name=?, mater_recorder_num=?, "
						+ "mater_stan=? WHERE mater_num=?";
			jdbcTemplate.update(sql, mater_tab.getMater_sup(), mater_tab.getMater_name(),
					mater_tab.getMater_recorder_num(), mater_tab.getMater_stan(), mater_tab.getMater_num());
		} else {
			// insert
			String sql = "INSERT INTO mater_tab (mater_num, mater_sup, mater_name, mater_recorder_num, mater_stan)"
						+ " VALUES (?, ?, ?, ?, ?)";
			jdbcTemplate.update(sql, mater_tab.getMater_num(),mater_tab.getMater_sup(), mater_tab.getMater_name(),
					mater_tab.getMater_recorder_num(), mater_tab.getMater_stan());
		}
		
	}

	@Override
	public void delete(String mater_num) {
		String sql = "DELETE FROM mater_tab WHERE mater_num=?";
		jdbcTemplate.update(sql, mater_num);
	}

	@Override
	public List<Mater_tab> list() {
		String sql = "SELECT * FROM mater_tab";
		List<Mater_tab> listMater_tab = jdbcTemplate.query(sql, new RowMapper<Mater_tab>() {

			@Override
			public Mater_tab mapRow(ResultSet rs, int rowNum) throws SQLException {
				Mater_tab aMater_tab = new Mater_tab();
	
				aMater_tab.setMater_num(rs.getString("mater_num"));
				aMater_tab.setMater_sup(rs.getString("mater_sup"));
				aMater_tab.setMater_name(rs.getString("mater_name"));
				aMater_tab.setMater_recorder_num(rs.getString("mater_recorder_num"));
				aMater_tab.setMater_stan(rs.getString("mater_stan"));
				
				return aMater_tab;
			}
			
		});
		
		return listMater_tab;
	}

	@Override
	public Mater_tab get(String mater_num) {
		String sql = "SELECT * FROM mater_tab WHERE mater_num=" + mater_num;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Mater_tab>() {

			@Override
			public Mater_tab extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Mater_tab aMater_tab = new Mater_tab();
					aMater_tab.setMater_num(rs.getString("mater_num"));
					aMater_tab.setMater_sup(rs.getString("mater_sup"));
					aMater_tab.setMater_name(rs.getString("mater_name"));
					aMater_tab.setMater_recorder_num(rs.getString("mater_recorder_num"));
					aMater_tab.setMater_stan(rs.getString("mater_stan"));
					
					return aMater_tab;
				}
				
				return null;
			}
			
			});
		}
		
		@Override
		public int updateSingleColumn(Mater_tab mater_tab,String column,String value){
			   System.out.println("updating...");
		        String sql = "UPDATE mater_tab SET "+column+" = '"+value+"' WHERE mater_num='"+mater_tab.getMater_num()+"'";
		        //int i=jdbcTemplate.update(sql,column,value,mater_tab.getMater_num());	
		        int i=jdbcTemplate.update(sql);
		        System.out.println("updating result:"+i);
		        return i;
		}
}
