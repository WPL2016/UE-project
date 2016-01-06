package net.codejava.spring.dao.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.sql.DataSource;
import net.codejava.spring.dao.daointerface.Fou_use_stat_tabDAO;
import net.codejava.spring.model.Fou_use_stat_tab;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

/**
 * An implementation of the ContactDAO interface.
 * @author www.codejava.net
 *
 */
public class Fou_use_stat_tabDAOImpl implements Fou_use_stat_tabDAO {

	private JdbcTemplate jdbcTemplate;
	
	public Fou_use_stat_tabDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(Fou_use_stat_tab fou_use_stat_tab) {
		
		String abc = "SELECT COUNT(*) FROM fou_use_stat_tab WHERE fou_use_stat_num=?";
		
		@SuppressWarnings("deprecation")
		int i=jdbcTemplate.queryForInt(abc,fou_use_stat_tab.getFou_use_stat_num());
		if (i!=0) {
			// update
			String sql = "UPDATE fou_use_stat_tab SET fou_use_quan=?,fou_use_time=?, equip_product_relat_num=?,"
						+ " WHERE fou_use_stat_num=?";
			jdbcTemplate.update(sql, fou_use_stat_tab.getFou_use_quan(),fou_use_stat_tab.getFou_use_time(), fou_use_stat_tab.getEquip_product_relat_num(),
					fou_use_stat_tab.getFou_use_stat_num());
		} else {
			// insert
			String sql = "INSERT INTO fou_use_stat_tab (fou_use_quan,fou_use_time, equip_product_relat_num,fou_use_stat_num,)"
						+ " VALUES (?, ?, ?,  ?)";
			jdbcTemplate.update(sql, fou_use_stat_tab.getFou_use_quan(),fou_use_stat_tab.getFou_use_time(), fou_use_stat_tab.getEquip_product_relat_num(),
					fou_use_stat_tab.getFou_use_stat_num());
		}
		
	}

	@Override
	public void delete(String fou_use_stat_num) {
		String sql = "DELETE FROM fou_use_stat_tab WHERE fou_use_stat_num=?";
		jdbcTemplate.update(sql, fou_use_stat_num);
	}

	@Override
	public List<Fou_use_stat_tab> list() {
		String sql = "SELECT * FROM fou_use_stat_tab";
		List<Fou_use_stat_tab> listFou_use_stat_tab = jdbcTemplate.query(sql, new RowMapper<Fou_use_stat_tab>() {

			@Override
			public Fou_use_stat_tab mapRow(ResultSet rs, int rowNum) throws SQLException {
				Fou_use_stat_tab aFou_use_stat_tab = new Fou_use_stat_tab();
	
				aFou_use_stat_tab.setFou_use_stat_num(rs.getString("fou_use_stat_num"));
				aFou_use_stat_tab.setFou_use_quan(rs.getFloat("fou_use_quan"));
				
				Format formatter = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
				String str = formatter.format(rs.getDate("fou_use_time"));
				SimpleDateFormat simple= new SimpleDateFormat(str);
				aFou_use_stat_tab.setFou_use_time(simple);
						
			
				aFou_use_stat_tab.setEquip_product_relat_num(rs.getString(" equip_product_relat_num"));
								
				return aFou_use_stat_tab;
			}
			
		});
		
		return listFou_use_stat_tab;
	}

	@Override
	public Fou_use_stat_tab get(String fou_use_stat_num) {
		String sql = "SELECT * FROM fou_use_stat_tab WHERE fou_use_stat_num='"+fou_use_stat_num+"'" ;
		return jdbcTemplate.query(sql,new ResultSetExtractor<Fou_use_stat_tab>() {

			@Override
			public Fou_use_stat_tab extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Fou_use_stat_tab aFou_use_stat_tab = new Fou_use_stat_tab();

					aFou_use_stat_tab.setFou_use_stat_num(rs.getString("fou_use_stat_num"));
					aFou_use_stat_tab.setFou_use_quan(rs.getFloat("fou_use_quan"));
					
					Format formatter = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
					String str = formatter.format(rs.getDate("fou_use_time"));
					SimpleDateFormat simple= new SimpleDateFormat(str);
					aFou_use_stat_tab.setFou_use_time(simple);
							
				
					aFou_use_stat_tab.setEquip_product_relat_num(rs.getString(" equip_product_relat_num"));
									
					return aFou_use_stat_tab;
				}
				
				return null;
			}
			
		});
	}
	
	@Override
	public int updateSingleColumn(Fou_use_stat_tab fou_use_stat_tab,String column,String value){
		   System.out.println("updating...");
	        String sql = "UPDATE fou_use_stat_tab SET "+column+" = '"+value+"' WHERE equip_num='"+fou_use_stat_tab.getFou_use_stat_num()+"'";
	        //int i=jdbcTemplate.update(sql,column,value,equip_tab.getEquip_num());	
	        int i=jdbcTemplate.update(sql);
	        System.out.println("updating result:"+i);
	        return i;
	}

}
