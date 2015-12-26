package net.codejava.spring.dao.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import net.codejava.spring.dao.daointerface.Produce_prog_tabDAO;
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
public class Produce_prog_tabDAOImpl implements Produce_prog_tabDAO {

	private JdbcTemplate jdbcTemplate;
	
	public Produce_prog_tabDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(Produce_prog_tab produce_prog_tab) {
        String abc = "SELECT COUNT(*) FROM produce_prog_tab WHERE produce_prog_num=?";
		
		@SuppressWarnings("deprecation")
		int i=jdbcTemplate.queryForInt(abc,produce_prog_tab.getProduce_prog_num());
		if (i!=0) {
			// update
			String sql = "UPDATE produce_prog_tab SET equip_product_relat_num=?,"
						+ "bat_produce_start_time=?WHERE produce_prog_num=?";
			jdbcTemplate.update(sql, produce_prog_tab.getEquip_product_relat_num(), produce_prog_tab.getBat_produce_start_time(),
					produce_prog_tab.getProduce_prog_num());
		} else {
			// insert
			String sql = "INSERT INTO produce_plan_tab (equip_product_relat_num,bat_produce_start_time,produce_prog_num)"
						+ " VALUES (?, ?, ?)";
			jdbcTemplate.update(sql, produce_prog_tab.getEquip_product_relat_num(), produce_prog_tab.getBat_produce_start_time(),
					produce_prog_tab.getProduce_prog_num());
		}
		
	}

	@Override
	public void delete(String produce_prog_num) {
		String sql = "DELETE FROM produce_prog_tab WHERE produce_prog_num=?";
		jdbcTemplate.update(sql, produce_prog_num);
	}

	@Override
	public List<Produce_prog_tab> list() {
		String sql = "SELECT * FROM produce_prog_tab";
		List<Produce_prog_tab> listProduce_prog_tab = jdbcTemplate.query(sql, new RowMapper<Produce_prog_tab>() {

			@Override
			public Produce_prog_tab mapRow(ResultSet rs, int rowNum) throws SQLException {
				Produce_prog_tab aProduce_prog_tab = new Produce_prog_tab();
	
				aProduce_prog_tab.setProduce_prog_num(rs.getString("produce_prog_num"));
				aProduce_prog_tab.setEquip_product_relat_num(rs.getString("equip_product_relat_num"));
					
				
				aProduce_prog_tab.setBat_produce_start_time(rs.getTimestamp ("bat_produce_start_time"));
				
												
				return aProduce_prog_tab;
			}
			
		});
		
		return listProduce_prog_tab;
	}

	@Override
	public Produce_prog_tab get(String produce_prog_num) {
		String sql = "SELECT * FROM produce_prog_tab WHERE produce_prog_num=" + produce_prog_num;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Produce_prog_tab>() {

			@Override
			public Produce_prog_tab extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Produce_prog_tab aProduce_prog_tab = new Produce_prog_tab();
					
					aProduce_prog_tab.setProduce_prog_num(rs.getString("produce_prog_num"));
					aProduce_prog_tab.setEquip_product_relat_num(rs.getString("equip_product_relat_num"));
						
					
					aProduce_prog_tab.setBat_produce_start_time(rs.getTimestamp("bat_produce_start_time"));
									
					return aProduce_prog_tab;
				}
				
				return null;
			}
			
		});
	    }
		@Override
		public int updateSingleColumn(Produce_prog_tab produce_prog_tab,String column,String value){
			   System.out.println("updating...");
		        String sql = "UPDATE produce_prog_tab SET "+column+" = '"+value+"' WHERE produce_prog_num='"+produce_prog_tab.getProduce_prog_num()+"'";
		        //int i=jdbcTemplate.update(sql,column,value,equip_tab.getEquip_num());	
		        int i=jdbcTemplate.update(sql);
		        System.out.println("updating result:"+i);
		        return i;
		}

		@Override
		public List<Produce_static_tab> listProduce_static_tab() {
			// TODO Auto-generated method stub
			/*
			List<Produce_static_tab> listProduce_static_tab = new ArrayList<Produce_static_tab>(); 
			
			String sql = "SELECT * FROM produce_prog_tab";
			List<Produce_prog_tab> listProduce_prog_tab = jdbcTemplate.query(sql, new RowMapper<Produce_prog_tab>() {

				@Override
				public Produce_prog_tab mapRow(ResultSet rs, int rowNum) throws SQLException {
					Produce_prog_tab aProduce_prog_tab = new Produce_prog_tab();
		
					aProduce_prog_tab.setProduce_prog_num(rs.getString("produce_prog_num"));
					aProduce_prog_tab.setEquip_product_relat_num(rs.getString("equip_product_relat_num"));
						
			
				//	aProduce_prog_tab.setBat_produce_start_time(rs.getTimestamp ("bat_produce_start_time"));
					
													
					return aProduce_prog_tab;
				}
				
			});
			
			sql = "SELECT * FROM product_qual_stat_tab";
			List<Product_qual_stat_tab> listProduct_qual_stat_tab = jdbcTemplate.query(sql, new RowMapper<Product_qual_stat_tab>() {

				@Override
				public Product_qual_stat_tab mapRow(ResultSet rs, int rowNum) throws SQLException {
					Product_qual_stat_tab aProduct_qual_stat_tab = new Product_qual_stat_tab();
		
					aProduct_qual_stat_tab.setQual_stat_num(rs.getString("qual_stat_num"));
					//aProduct_qual_stat_tab.setInfe_rea(rs.getString("infe_rea"));
					aProduct_qual_stat_tab.setProduct_num(rs.getString("product_num"));
			
				//	aProduct_qual_stat_tab.setInfe_time(rs.getSimpleDateFormat ("infe_time"));
					
													
					return aProduct_qual_stat_tab;
				}
				
			});*/
			
         
			
			String sql= "  WITH count_product_quantity(value,equip_product_relat_num) AS"+
					 " (SELECT  COUNT( produce_prog_tab.produce_prog_num) ,  produce_prog_tab.equip_product_relat_num"+
		              " FROM  produce_prog_tab "+
                      " WHERE datediff(dd, bat_produce_start_time , getdate())=1 "+
                      " GROUP BY  produce_prog_tab.equip_product_relat_num ),"+
                      " count_qulifiedproduct_quantity(qulified_product,equip_product_relat_num) AS"+
                       " (SELECT  COUNT( product_qual_stat_tab.qual_stat_num) ,  product_qual_stat_tab.equip_product_relat_num"+
		               " FROM  product_qual_stat_tab  "+
                       " WHERE datediff(dd, infe_time , getdate())=1"+
                       " GROUP BY  product_qual_stat_tab.equip_product_relat_num )"+
                        " SELECT equip_name  ,product_name ,value  ,value-qulified_product AS count_qulified_product "+
                       " FROM  count_product_quantity   JOIN  equip_product_relat_tab ON count_product_quantity.equip_product_relat_num =  equip_product_relat_tab.equip_product_relat_num "+  
                       " JOIN count_qulifiedproduct_quantity ON count_qulifiedproduct_quantity.equip_product_relat_num =  equip_product_relat_tab.equip_product_relat_num   "+
                        " JOIN equip_tab ON  equip_product_relat_tab.equip_num =  equip_tab.equip_num   "+
                        " JOIN product_tab ON  equip_product_relat_tab.product_num =  product_tab.product_num";
			List<Produce_static_tab> listProduce_static_tab =jdbcTemplate.query(sql, new RowMapper<Produce_static_tab>() {

				@Override
				public Produce_static_tab mapRow(ResultSet rs, int rowNum) throws SQLException {
					Produce_static_tab aProduce_static_tab = new Produce_static_tab();
		
					aProduce_static_tab.setEquip_name(rs.getString("equip_name"));
					aProduce_static_tab.setProduct_name(rs.getString("product_name"));
					aProduce_static_tab.setValue(rs.getString("value"));
					aProduce_static_tab.setCount_qulified_product(rs.getString("count_qulified_product"));	
			
				//	aProduce_prog_tab.setBat_produce_start_time(rs.getTimestamp ("bat_produce_start_time"));
					
				
					return aProduce_static_tab;
				}
				
			});
			
			return listProduce_static_tab;
		}

}
