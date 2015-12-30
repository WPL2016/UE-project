package net.codejava.spring.dao.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;


import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import net.codejava.spring.dao.daointerface.Mater_pur_tabDAO;
import net.codejava.spring.model.Mater_pur_tab;

/**
 * An implementation of the ContactDAO interface.
 * @author www.codejava.net
 *
 */
public class Mater_pur_tabDAOImpl implements Mater_pur_tabDAO {

	private JdbcTemplate jdbcTemplate;
	
	public Mater_pur_tabDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(Mater_pur_tab  mater_pur_tab) {
        String abc = "SELECT COUNT(*) FROM mater_stock_stat_tab WHERE stock_stat_num=?";
		
		@SuppressWarnings("deprecation")
		int i=jdbcTemplate.queryForInt(abc,mater_pur_tab.getStock_stat_num());
		if (i!=0) {
			// update
			String sql = "UPDATE mater_stock_stat_tab SET mater_num=?, stock_stat_per_num=?, stock_stat_time=?, "
						+ "stock_quan=? WHERE stock_stat_num=?";
			jdbcTemplate.update(sql, mater_pur_tab.getMater_num(), mater_pur_tab.getStock_stat_per_num(),
					mater_pur_tab.getStock_stat_time(), mater_pur_tab.getStock_quan(), mater_pur_tab.getStock_stat_num());
		} else {
			// insert
			String sql = "INSERT INTO mater_stock_stat_tab (mater_num, stock_stat_per_num,stock_stat_time,stock_quan,stock_stat_num)"
						+ " VALUES (?, ?, ?, ?, ?)";
			jdbcTemplate.update(sql,  mater_pur_tab.getMater_num(), mater_pur_tab.getStock_stat_per_num(),
					mater_pur_tab.getStock_stat_time(), mater_pur_tab.getStock_quan(), mater_pur_tab.getStock_stat_num());
		}
		
	}

	@Override
	public void delete(String stock_stat_num) {
		String sql = "DELETE FROM mater_stock_stat_tab WHERE stock_stat_num=?";
		jdbcTemplate.update(sql, stock_stat_num);
	}

	@Override
	public List<Mater_pur_tab> list() {
		String sql = "SELECT  stock_stat_num, stock_stat_time, stock_quan, "+
        " stock_stat_per_num, mater_name, mater_stock_stat_tab.mater_num,mater_unit"+
" FROM   mater_stock_stat_tab  JOIN mater_tab ON mater_stock_stat_tab.mater_num = mater_tab.mater_num ";
		List<Mater_pur_tab> listMater_pur_tab = jdbcTemplate.query(sql, new RowMapper<Mater_pur_tab>() {

			@Override
			public Mater_pur_tab mapRow(ResultSet rs, int rowNum) throws SQLException {
				Mater_pur_tab aMater_pur_tab = new Mater_pur_tab();
	
				aMater_pur_tab.setMater_num(rs.getString("mater_num"));
				aMater_pur_tab.setMater_name(rs.getString("mater_name"));
				aMater_pur_tab.setStock_stat_per_num(rs.getString("stock_stat_per_num"));
				aMater_pur_tab.setStock_stat_num(rs.getString("stock_stat_num"));
				aMater_pur_tab.setStock_stat_time(rs.getDate("stock_stat_time"));
				aMater_pur_tab.setStock_quan(rs.getFloat("stock_quan"));
				aMater_pur_tab.setMater_unit(rs.getString("mater_unit"));
				return aMater_pur_tab;
			}
			
		});
		
		return listMater_pur_tab;
	}

	@Override
	public Mater_pur_tab get(String Stock_stat_num) {
		String sql = "SELECT * FROM mater_stock_stat_tab WHERE Stock_stat_num=" + Stock_stat_num;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Mater_pur_tab>() {

			@Override
			public Mater_pur_tab extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Mater_pur_tab aMater_pur_tab = new Mater_pur_tab();
					
					aMater_pur_tab.setMater_num(rs.getString("mater_num"));
					aMater_pur_tab.setStock_stat_per_num(rs.getString("stock_stat_per_num"));
					aMater_pur_tab.setStock_stat_num(rs.getString("stock_stat_num"));
					aMater_pur_tab.setStock_stat_time(rs.getDate("stock_stat_time"));
					aMater_pur_tab.setStock_quan(rs.getFloat("stock_quan"));
					aMater_pur_tab.setMater_unit(rs.getString("mater_unit"));
					return aMater_pur_tab;
				}
				
				return null;
			}
			
			});
		}
		
		@Override
		public int updateSingleColumn(Mater_pur_tab mater_pur_tab,String column,String value){
			   System.out.println("updating...");
		        String sql = "UPDATE mater_stock_stat_tab SET "+column+" = '"+value+"' WHERE stock_stat_num='"+mater_pur_tab.getStock_stat_num()+"'";
		        //int i=jdbcTemplate.update(sql,column,value,mater_tab.getMater_num());	
		        int i=jdbcTemplate.update(sql);
		        System.out.println("updating result:"+i);
		        return i;
		}
}
