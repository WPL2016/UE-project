package net.codejava.spring.dao.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import net.codejava.spring.dao.daointerface.Product_tabDAO;
import net.codejava.spring.model.Product_tab;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

/**
 * An implementation of the ContactDAO interface.
 * @author www.codejava.net
 *
 */
public class Product_tabDAOImpl implements Product_tabDAO {

	private JdbcTemplate jdbcTemplate;
	
	public Product_tabDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(Product_tab product_tab) {
        String abc = "SELECT COUNT(*) FROM product_tab WHERE product_num=?";
		
		@SuppressWarnings("deprecation")
		int i=jdbcTemplate.queryForInt(abc,product_tab.getProduct_num());
		if (i!=0) {
			// update
			String sql = "UPDATE product_tab SET product_name=?,"
						+ "product_recorder_num=?,mater_num=? WHERE product_num=?";
			jdbcTemplate.update(sql, product_tab.getProduct_name(), product_tab.getProduct_recorder_num(),
					product_tab.getMater_num(),product_tab.getProduct_num());
		} else {
			// insert
			String sql = "INSERT INTO product_tab (product_num,product_name, product_recorder_num,mater_num)"
						+ " VALUES (?, ?, ?,?)";
			jdbcTemplate.update(sql, product_tab.getProduct_num(),product_tab.getProduct_name(), product_tab.getProduct_recorder_num(),product_tab.getMater_num());
		}
		
	}

	@Override
	public void delete(String product_num) {
		String sql = "DELETE FROM product_tab WHERE product_num=?";
		jdbcTemplate.update(sql, product_num);
	}

	@Override
	public List<Product_tab> list() {
		String sql = "SELECT * FROM product_tab";
		List<Product_tab> listProduct_tab = jdbcTemplate.query(sql, new RowMapper<Product_tab>() {

			@Override
			public Product_tab mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product_tab aProduct_tab = new Product_tab();
	
				aProduct_tab.setProduct_num(rs.getString("product_num"));
				aProduct_tab.setProduct_name(rs.getString("product_name"));
				aProduct_tab.setProduct_recorder_num(rs.getString("product_recorder_num"));
				aProduct_tab.setMater_num(rs.getString("mater_num"));
							
				
				return aProduct_tab;
			}
			
		});
		
		return listProduct_tab;
	}

	@Override
	public Product_tab get(String product_num) {
		String sql = "SELECT * FROM product_tab WHERE product_num=" + product_num;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Product_tab>() {

			@Override
			public Product_tab extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Product_tab aProduct_tab = new Product_tab();
					aProduct_tab.setProduct_num(rs.getString("product_num"));
					aProduct_tab.setProduct_name(rs.getString("product_name"));
					aProduct_tab.setProduct_recorder_num(rs.getString("product_recorder_num"));
					aProduct_tab.setMater_num(rs.getString("mater_num"));	
					
					return aProduct_tab;
				}
				
				return null;
			}
			
			});
		}
		
		@Override
		public int updateSingleColumn(Product_tab product_tab,String column,String value){
			   System.out.println("updating...");
		        String sql = "UPDATE product_tab SET "+column+" = '"+value+"' WHERE product_num='"+product_tab.getProduct_num()+"'";
		        //int i=jdbcTemplate.update(sql,column,value,product_tab.getProduct_num());	
		        int i=jdbcTemplate.update(sql);
		        System.out.println("updating result:"+i);
		        return i;
		}

}
