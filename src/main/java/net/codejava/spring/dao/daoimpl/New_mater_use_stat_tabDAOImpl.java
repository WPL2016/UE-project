package net.codejava.spring.dao.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.sql.DataSource;
import net.codejava.spring.dao.daointerface.New_mater_use_stat_tabDAO;

import net.codejava.spring.model.New_mater_use_stat_tab;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

/**
 * An implementation of the ContactDAO interface.
 * @author www.codejava.net
 *
 */
public class New_mater_use_stat_tabDAOImpl implements New_mater_use_stat_tabDAO {

	private JdbcTemplate jdbcTemplate;
	
	public New_mater_use_stat_tabDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(New_mater_use_stat_tab new_mater_use_stat_tab) {
		
		String abc = "SELECT COUNT(*) FROM new_mater_use_stat_tab WHERE new_mater_use_stat_num=?";
		
		@SuppressWarnings("deprecation")
		int i=jdbcTemplate.queryForInt(abc,new_mater_use_stat_tab.getNew_mater_use_stat_num());
		if (i!=0) {
			// update
			String sql = "UPDATE new_mater_use_stat_tab SET new_mater_use_quan=?,new_mater_use_time=?, equip_product_relat_num=?,"
						+ " WHERE new_mater_use_stat_num=?";
			jdbcTemplate.update(sql, new_mater_use_stat_tab.getNew_mater_use_quan(),new_mater_use_stat_tab.getNew_mater_use_time(), new_mater_use_stat_tab.getEquip_product_relat_num(),
					new_mater_use_stat_tab.getNew_mater_use_stat_num());
		} else {
			// insert
			String sql = "INSERT INTO new_mater_use_stat_tab (new_mater_use_quan,new_mater_use_time, equip_product_relat_num,new_mater_use_stat_num,)"
						+ " VALUES (?, ?, ?,  ?)";
			jdbcTemplate.update(sql, new_mater_use_stat_tab.getNew_mater_use_quan(),new_mater_use_stat_tab.getNew_mater_use_time(),new_mater_use_stat_tab.getEquip_product_relat_num(),
					new_mater_use_stat_tab.getNew_mater_use_stat_num());
		}
		
	}

	@Override
	public void delete(String new_mater_use_stat_num) {
		String sql = "DELETE FROM new_mater_use_stat_tab WHERE new_mater_use_stat_num=?";
		jdbcTemplate.update(sql, new_mater_use_stat_num);
	}

	@Override
	public List<New_mater_use_stat_tab> list() {
		String sql = "SELECT * FROM new_mater_use_stat_tab";
		List<New_mater_use_stat_tab> listNew_mater_use_stat_tab = jdbcTemplate.query(sql, new RowMapper<New_mater_use_stat_tab>() {

			@Override
			public New_mater_use_stat_tab mapRow(ResultSet rs, int rowNum) throws SQLException {
				New_mater_use_stat_tab aNew_mater_use_stat_tab = new New_mater_use_stat_tab();
	
				aNew_mater_use_stat_tab.setNew_mater_use_stat_num(rs.getString("new_mater_use_stat_num"));
				aNew_mater_use_stat_tab.setNew_mater_use_quan(rs.getFloat("new_mater_use_quan"));
				
				Format formatter = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
				String str = formatter.format(rs.getDate("new_mater_use_time"));
				SimpleDateFormat simple= new SimpleDateFormat(str);
				aNew_mater_use_stat_tab.setNew_mater_use_time(simple);
						
			
				aNew_mater_use_stat_tab.setEquip_product_relat_num(rs.getString(" equip_product_relat_num"));
								
				return aNew_mater_use_stat_tab;
			}
			
		});
		
		return listNew_mater_use_stat_tab;
	}

	@Override
	public New_mater_use_stat_tab get(String new_mater_use_stat_num) {
		String sql = "SELECT * FROM new_mater_use_stat_tab WHERE new_mater_use_stat_num='"+new_mater_use_stat_num+"'" ;
		return jdbcTemplate.query(sql,new ResultSetExtractor<New_mater_use_stat_tab>() {

			@Override
			public New_mater_use_stat_tab extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					New_mater_use_stat_tab aNew_mater_use_stat_tab = new New_mater_use_stat_tab();

					aNew_mater_use_stat_tab.setNew_mater_use_stat_num(rs.getString("new_mater_use_stat_num"));
					aNew_mater_use_stat_tab.setNew_mater_use_quan(rs.getFloat("new_mater_use_quan"));
					
					Format formatter = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
					String str = formatter.format(rs.getDate("new_mater_use_time"));
					SimpleDateFormat simple= new SimpleDateFormat(str);
					aNew_mater_use_stat_tab.setNew_mater_use_time(simple);
							
				
					aNew_mater_use_stat_tab.setEquip_product_relat_num(rs.getString(" equip_product_relat_num"));
									
					return aNew_mater_use_stat_tab;
				}
				
				return null;
			}
			
		});
	}
	
	@Override
	public int updateSingleColumn(New_mater_use_stat_tab new_mater_use_stat_tab,String column,String value){
		   System.out.println("updating...");
	        String sql = "UPDATE new_mater_use_stat_tab SET "+column+" = '"+value+"' WHERE new_mater_use_stat_num='"+new_mater_use_stat_tab.getNew_mater_use_stat_num()+"'";
	        //int i=jdbcTemplate.update(sql,column,value,equip_tab.getEquip_num());	
	        int i=jdbcTemplate.update(sql);
	        System.out.println("updating result:"+i);
	        return i;
	}

}
