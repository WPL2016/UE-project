package net.codejava.spring.dao.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import net.codejava.spring.dao.daointerface.Mater_use_stock_tabDAO;
import net.codejava.spring.dao.daointerface.Produce_prog_tabDAO;
import net.codejava.spring.model.Mater_use_stock_tab;
import net.codejava.spring.model.Produce_prog_tab;
import net.codejava.spring.model.Produce_static_tab;
import net.codejava.spring.model.Product_qual_stat_tab;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

/**
 * An implementation of the ContactDAO interface.
 * @author www.codejava.net
 *
 */
public class Mater_use_stock_tabDAOImpl implements Mater_use_stock_tabDAO {

	private JdbcTemplate jdbcTemplate;
	
	public Mater_use_stock_tabDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}



		@Override
		public List<Mater_use_stock_tab> listMater_use_stock_tab() {
			// TODO Auto-generated method stub
			
			
         
			
			String sql= "WITH new_mater_quantity(new_value,equip_product_relat_num) AS"+
" (SELECT  SUM( new_mater_use_stat_tab.new_mater_use_quan) , equip_product_relat_num"+
" FROM  new_mater_use_stat_tab "+
" WHERE datediff(dd, new_mater_use_stat_tab.new_mater_use_time,getdate())=0"+
" GROUP BY new_mater_use_stat_tab.equip_product_relat_num),"+
" fou_quantity (fou_value,equip_product_relat_num)AS"+
" (SELECT SUM (fou_use_stat_tab.fou_use_quan) , equip_product_relat_num"+
" FROM  fou_use_stat_tab "+
" WHERE datediff(dd, fou_use_stat_tab.fou_use_time ,getdate())=0"+
" GROUP BY fou_use_stat_tab.equip_product_relat_num)"+
" SELECT equip_name,product_name,mater_tab.mater_num,mater_name,new_value,mater_unit,fou_value,new_value/fou_value AS mater_percent"+
" FROM  new_mater_quantity JOIN  equip_product_relat_tab ON new_mater_quantity.equip_product_relat_num =  equip_product_relat_tab.equip_product_relat_num"+  
 " JOIN fou_quantity ON fou_quantity.equip_product_relat_num =  equip_product_relat_tab.equip_product_relat_num "+ 
 " JOIN equip_tab ON  equip_product_relat_tab.equip_num =  equip_tab.equip_num   "+
 " JOIN product_tab ON  equip_product_relat_tab.product_num =  product_tab.product_num " + 
 " JOIN mater_tab ON mater_tab.mater_num = product_tab.mater_num";
			List<Mater_use_stock_tab> listMater_use_stock_tab =jdbcTemplate.query(sql, new RowMapper<Mater_use_stock_tab>() {

				@Override
				public Mater_use_stock_tab mapRow(ResultSet rs, int rowNum) throws SQLException {
					Mater_use_stock_tab aMater_use_stock_tab = new Mater_use_stock_tab();
		
					aMater_use_stock_tab.setEquip_name(rs.getString("equip_name"));
					aMater_use_stock_tab.setProduct_name(rs.getString("product_name"));
					aMater_use_stock_tab.setMater_name(rs.getString("mater_name"));
					aMater_use_stock_tab.setMater_unit(rs.getString("mater_unit"));
					aMater_use_stock_tab.setMater_num(rs.getString("mater_num"));
					aMater_use_stock_tab.setNew_value(rs.getString("new_value"));
					aMater_use_stock_tab.setFou_value(rs.getString("fou_value"));	
					aMater_use_stock_tab.setMater_percent(rs.getString("mater_percent"));
	
					return aMater_use_stock_tab;
					
				}
				
			});
			
			return listMater_use_stock_tab;
		}
		@Override
		public List<Mater_use_stock_tab> listMater_use_stock_tab(String mater_num) {
			// TODO Auto-generated method stub
			
			
         
			
			String sql= "WITH new_mater_quantity(new_value,equip_product_relat_num) AS"+
" (SELECT  SUM( new_mater_use_stat_tab.new_mater_use_quan) , equip_product_relat_num"+
" FROM  new_mater_use_stat_tab "+
" WHERE datediff(dd, new_mater_use_stat_tab.new_mater_use_time,getdate())=0"+
" GROUP BY new_mater_use_stat_tab.equip_product_relat_num),"+
" fou_quantity (fou_value,equip_product_relat_num)AS"+
" (SELECT SUM (fou_use_stat_tab.fou_use_quan) , equip_product_relat_num"+
" FROM  fou_use_stat_tab "+
" WHERE datediff(dd, fou_use_stat_tab.fou_use_time ,getdate())=0"+
" GROUP BY fou_use_stat_tab.equip_product_relat_num)"+
" SELECT equip_name,product_name,mater_tab.mater_num,mater_name,new_value,mater_unit,fou_value,new_value/fou_value AS mater_percent"+
" FROM  new_mater_quantity JOIN  equip_product_relat_tab ON new_mater_quantity.equip_product_relat_num =  equip_product_relat_tab.equip_product_relat_num"+  
 " JOIN fou_quantity ON fou_quantity.equip_product_relat_num =  equip_product_relat_tab.equip_product_relat_num "+ 
 " JOIN equip_tab ON  equip_product_relat_tab.equip_num =  equip_tab.equip_num   "+
 " JOIN product_tab ON  equip_product_relat_tab.product_num =  product_tab.product_num " + 
 " JOIN mater_tab ON mater_tab.mater_num = product_tab.mater_num where mater_tab.mater_num='"+mater_num+"'";
			List<Mater_use_stock_tab> listMater_use_stock_tab =jdbcTemplate.query(sql, new RowMapper<Mater_use_stock_tab>() {

				@Override
				public Mater_use_stock_tab mapRow(ResultSet rs, int rowNum) throws SQLException {
					Mater_use_stock_tab aMater_use_stock_tab = new Mater_use_stock_tab();
		
					aMater_use_stock_tab.setEquip_name(rs.getString("equip_name"));
					aMater_use_stock_tab.setProduct_name(rs.getString("product_name"));
					aMater_use_stock_tab.setMater_name(rs.getString("mater_name"));
					aMater_use_stock_tab.setMater_unit(rs.getString("mater_unit"));
					aMater_use_stock_tab.setMater_num(rs.getString("mater_num"));
					aMater_use_stock_tab.setNew_value(rs.getString("new_value"));
					aMater_use_stock_tab.setFou_value(rs.getString("fou_value"));	
					aMater_use_stock_tab.setMater_percent(rs.getString("mater_percent"));
				//	aProduce_prog_tab.setBat_produce_start_time(rs.getTimestamp ("bat_produce_start_time"));
					
					System.out.println(rs.getString("new_value"));
					System.out.println(rs.getString("fou_value"));
					return aMater_use_stock_tab;
					
				}
				
			});
			return listMater_use_stock_tab;
		}
		
			@Override
			public List<Mater_use_stock_tab> listOper_mater_use_stock_tab() {
				// TODO Auto-generated method stub
				
				String sql= "SELECT  new_mater_use_stat_tab.new_mater_use_time AS new_mater_use_time,mater_tab.mater_name AS mater_name,"+
						" new_mater_use_stat_tab.new_mater_use_quan AS new_value,equip_product_relat_tab.equip_num AS equip_num"+
						" , mater_tab.mater_unit AS mater_unit"+
						" FROM  new_mater_use_stat_tab JOIN equip_product_relat_tab "+
						" ON  new_mater_use_stat_tab.equip_product_relat_num=equip_product_relat_tab.equip_product_relat_num"+
						" JOIN product_tab ON product_tab.product_num=equip_product_relat_tab.product_num"+
						" JOIN mater_tab ON product_tab.mater_num=mater_tab.mater_num"+
						" WHERE datediff(dd, new_mater_use_stat_tab.new_mater_use_time,getdate())<=100"+
						" Order by new_mater_use_stat_tab.new_mater_use_time DESC";
									List<Mater_use_stock_tab> listOper_mater_use_stock_tab=jdbcTemplate.query(sql, new RowMapper<Mater_use_stock_tab>() {

										@Override
										public Mater_use_stock_tab mapRow(ResultSet rs, int rowNum) throws SQLException {
											Mater_use_stock_tab aMater_use_stock_tab = new Mater_use_stock_tab();
								
											aMater_use_stock_tab.setMater_unit(rs.getString("mater_unit"));
											aMater_use_stock_tab.setEquip_num(rs.getString("equip_num"));
											aMater_use_stock_tab.setMater_name(rs.getString("mater_name"));
											aMater_use_stock_tab.setNew_value(rs.getString("new_value"));
										    
											aMater_use_stock_tab.setNew_mater_use_time(rs.getTimestamp("new_mater_use_time"));
											
					
											return aMater_use_stock_tab;
											
										}
										
									});
									
									return  listOper_mater_use_stock_tab;
								}
			@Override
			public List<Mater_use_stock_tab> listOper_fou_mater_use_stock_tab() {
				// TODO Auto-generated method stub
				
				String sql= "SELECT  fou_use_stat_tab.fou_use_time AS fou_mater_use_time,mater_tab.mater_name AS mater_name,"
						+ "	fou_use_stat_tab.fou_use_quan AS fou_value,equip_product_relat_tab.equip_num AS equip_num,"+
						" mater_tab.mater_unit AS mater_unit"+
						" FROM  fou_use_stat_tab JOIN equip_product_relat_tab "+
						" ON  fou_use_stat_tab.equip_product_relat_num=equip_product_relat_tab.equip_product_relat_num"+
						" JOIN product_tab ON product_tab.product_num=equip_product_relat_tab.product_num"+
						" JOIN mater_tab ON product_tab.mater_num=mater_tab.mater_num"+
						" WHERE datediff(dd, fou_use_stat_tab.fou_use_time,getdate())<=100"+
						" Order by fou_use_stat_tab.fou_use_time DESC";
									List<Mater_use_stock_tab> listOper_fou_mater_use_stock_tab=jdbcTemplate.query(sql, new RowMapper<Mater_use_stock_tab>() {

										@Override
										public Mater_use_stock_tab mapRow(ResultSet rs, int rowNum) throws SQLException {
											Mater_use_stock_tab aMater_use_stock_tab = new Mater_use_stock_tab();
								
											aMater_use_stock_tab.setMater_unit(rs.getString("mater_unit"));
											aMater_use_stock_tab.setEquip_num(rs.getString("equip_num"));
											aMater_use_stock_tab.setMater_name(rs.getString("mater_name"));
											aMater_use_stock_tab.setFou_value(rs.getString("fou_value"));
										    
											aMater_use_stock_tab.setFou_mater_use_time(rs.getTimestamp("fou_mater_use_time"));
											
					
											return aMater_use_stock_tab;
											
										}
										
									});
									
									return  listOper_fou_mater_use_stock_tab;
								}
}
