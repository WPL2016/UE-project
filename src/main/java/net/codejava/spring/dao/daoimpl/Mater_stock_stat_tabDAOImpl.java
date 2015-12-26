package net.codejava.spring.dao.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.sql.DataSource;


import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import net.codejava.spring.dao.daointerface.Mater_stock_stat_tabDAO;
import net.codejava.spring.model.Mater_stock_stat_tab;

/**
 * An implementation of the ContactDAO interface.
 * @author www.codejava.net
 *
 */
public class Mater_stock_stat_tabDAOImpl implements Mater_stock_stat_tabDAO {

	private JdbcTemplate jdbcTemplate;
	
	public Mater_stock_stat_tabDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/*@Override
	public void saveOrUpdate(Mater_stock_stat_tab mater_stock_stat_tab) {
		
		String abc = "SELECT COUNT(*) FROM mater_stock_stat_tab WHERE stock_num=?";
		
		@SuppressWarnings("deprecation")
		int i=jdbcTemplate.queryForInt(abc,mater_stock_stat_tab.getStock_num());
		if (i!=0) {
			// update
			String sql = "UPDATE mater_stock_stat_tab SET stock_stat_per_num=?,stock_stat_time=?, "
						+ "stock_quan=?,mater_num=?, WHERE stock_num=?";
			jdbcTemplate.update(sql, mater_stock_stat_tab.getStock_stat_per_num(),mater_stock_stat_tab.getStock_stat_time(), mater_stock_stat_tab.getStock_quan(),
					mater_stock_stat_tab.getMater_num(),mater_stock_stat_tab .getStock_num());
		} else {
			// insert
			String sql = "INSERT INTO new_mater_use_stat_tab (stock_stat_per_num,stock_stat_time, stock_quan,mater_num, stock_num,)"
						+ " VALUES (?, ?, ?, ?, ?)";
			jdbcTemplate.update(sql, mater_stock_stat_tab.getStock_stat_per_num(),mater_stock_stat_tab.getStock_stat_time(), mater_stock_stat_tab.getStock_quan(),
					mater_stock_stat_tab.getMater_num(),mater_stock_stat_tab .getStock_num());
		}
		
	}

	@Override
	public void delete(String stock_num) {
		String sql = "DELETE FROM mater_stock_stat_tab WHERE stock_num=?";
		jdbcTemplate.update(sql, stock_num);
	}
*/
	@Override
	public List<Mater_stock_stat_tab> listMater_stock_stat_tab() {
		String sql = " WITH new_mater(equip_product_relat_num,new_mater_use_quan)AS "+ 
" (SELECT  new_mater_use_stat_tab.equip_product_relat_num, SUM( new_mater_use_stat_tab.new_mater_use_quan)"+
" FROM  new_mater_use_stat_tab "+
" GROUP BY  new_mater_use_stat_tab.equip_product_relat_num),"+
" mater_stock(mater_num,stock_quan)AS"+
" (SELECT  mater_stock_stat_tab.mater_num, SUM( mater_stock_stat_tab.stock_quan)"+
" FROM  mater_stock_stat_tab"+
" GROUP BY  mater_stock_stat_tab.mater_num)"+
" SELECT  product_tab.mater_num ,mater_name ,stock_quan-new_mater_use_quan AS mater_quan"+
" FROM new_mater   JOIN   equip_product_relat_tab ON new_mater.equip_product_relat_num= equip_product_relat_tab.equip_product_relat_num "+ 
 " JOIN product_tab ON  equip_product_relat_tab.product_num=  product_tab.product_num   "+
 " JOIN mater_tab ON  product_tab.mater_num= mater_tab.mater_num   "+
 " JOIN mater_stock ON mater_stock.mater_num= mater_tab.mater_num  ";
		List<Mater_stock_stat_tab> listMater_stock_stat_tab = jdbcTemplate.query(sql, new RowMapper<Mater_stock_stat_tab>() {

			@Override
			public Mater_stock_stat_tab mapRow(ResultSet rs, int rowNum) throws SQLException {
				Mater_stock_stat_tab aMater_stock_stat_tab = new Mater_stock_stat_tab();
	
				
				aMater_stock_stat_tab.setMater_num(rs.getString("mater_num"));
				aMater_stock_stat_tab.setMater_name(rs.getString("mater_name"));
				aMater_stock_stat_tab.setMater_quan(rs.getFloat("mater_quan"));
								
				return aMater_stock_stat_tab;
			}
			
		});
		
		return listMater_stock_stat_tab;
	}

	/*@Override
	public Mater_stock_stat_tab get(String stock_num) {
		String sql = "SELECT * FROM mater_stock_stat_tab WHERE stock_num='"+stock_num+"'" ;
		return jdbcTemplate.query(sql,new ResultSetExtractor<Mater_stock_stat_tab>() {

			@Override
			public Mater_stock_stat_tab extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Mater_stock_stat_tab aMater_stock_stat_tab = new Mater_stock_stat_tab();
					
					aMater_stock_stat_tab.setStock_num(rs.getString("stock_num"));
					aMater_stock_stat_tab.setStock_quan(rs.getFloat("stock_quan"));
					
					Format formatter = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
					String str = formatter.format(rs.getDate("new_mater_use_time"));
					SimpleDateFormat simple= new SimpleDateFormat(str);
					aMater_stock_stat_tab.setStock_stat_time(simple);
							
					aMater_stock_stat_tab.setStock_stat_per_num(rs.getString("stock_stat_per_num"));
					aMater_stock_stat_tab.setMater_num(rs.getString("mater_num"));
									
					return aMater_stock_stat_tab;
				}
				
				return null;
			}
			
		});
	}
	
	@Override
	public int updateSingleColumn(Mater_stock_stat_tab mater_stock_stat_tab,String column,String value){
		   System.out.println("updating...");
	        String sql = "UPDATE mater_stock_stat_tab SET "+column+" = '"+value+"' WHERE mater_stock_stat_tab='"+mater_stock_stat_tab.getStock_num()+"'";
	        //int i=jdbcTemplate.update(sql,column,value,equip_tab.getEquip_num());	
	        int i=jdbcTemplate.update(sql);
	        System.out.println("updating result:"+i);
	        return i;
	}*/

}
