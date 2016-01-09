package net.codejava.spring.dao.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;

import javax.sql.DataSource;

import net.codejava.spring.dao.daointerface.Product_qual_asse_tabDAO;
import net.codejava.spring.model.Product_qual_asse_tab;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

/**
 * An implementation of the ContactDAO interface.
 * @author www.codejava.net
 *
 */
public class Product_qual_asse_tabDAOImpl implements Product_qual_asse_tabDAO {

	private JdbcTemplate jdbcTemplate;
	
	public Product_qual_asse_tabDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(Product_qual_asse_tab product_qual_asse_tab) {
        String abc = "SELECT COUNT(*) FROM product_qual_asse_tab WHERE product_qual_asse_num=?";
		
		@SuppressWarnings("deprecation")
		int i=jdbcTemplate.queryForInt(abc,product_qual_asse_tab.getProduct_qual_asse_num());
		if (i!=0) {
			// update
			String sql = "UPDATE product_qual_asse_tab SET product_qual_asse_cont=?,"
						+ "product_qual_asse_res=?,product_qual_asse_date=?,product_qual_asse_per_num=?,product_num=?WHERE product_qual_asse_num=?";
			jdbcTemplate.update(sql, product_qual_asse_tab.getProduct_qual_asse_cont(),product_qual_asse_tab.getProduct_qual_asse_res(),product_qual_asse_tab.getProduct_qual_asse_date(),
					product_qual_asse_tab.getProduct_qual_asse_per_num(),product_qual_asse_tab.getProduct_num(),product_qual_asse_tab.getProduct_qual_asse_num());
		} else {
			// insert
			String sql = "INSERT INTO product_qual_asse_tab (product_qual_asse_num,product_qual_asse_cont, product_qual_asse_res,product_qual_asse_date,product_qual_asse_per_num,product_num)"
						+ " VALUES (?, ?, ?,?,?,?)";
			jdbcTemplate.update(sql, product_qual_asse_tab.getProduct_qual_asse_num(),product_qual_asse_tab.getProduct_qual_asse_cont(),product_qual_asse_tab.getProduct_qual_asse_res(),product_qual_asse_tab.getProduct_qual_asse_date(),
					product_qual_asse_tab.getProduct_qual_asse_per_num(),product_qual_asse_tab.getProduct_num());
		}
		
	}

	@Override
	public void delete(String product_qual_asse_num) {
		String sql = "DELETE FROM product_qual_asse_tab WHERE product_qual_asse_num=?";
		jdbcTemplate.update(sql, product_qual_asse_num);
	}

	@Override
	public List<Product_qual_asse_tab> list() {
		String sql = "SELECT * FROM product_qual_asse_tab";
		List<Product_qual_asse_tab> listProduct_qual_asse_tab = jdbcTemplate.query(sql, new RowMapper<Product_qual_asse_tab>() {

			@Override
			public Product_qual_asse_tab mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product_qual_asse_tab aProduct_qual_asse_tab = new Product_qual_asse_tab();
	
				aProduct_qual_asse_tab.setProduct_qual_asse_num(rs.getString("product_qual_asse_num"));
				aProduct_qual_asse_tab.setProduct_qual_asse_cont(rs.getString("product_qual_asse_cont"));
				aProduct_qual_asse_tab.setProduct_qual_asse_res(rs.getString("product_qual_asse_res"));
				aProduct_qual_asse_tab.setProduct_qual_asse_per_num(rs.getString("product_qual_asse_per_num"));
				aProduct_qual_asse_tab.setProduct_num(rs.getString("product_num"));
				
							
				aProduct_qual_asse_tab.setProduct_qual_asse_date(rs.getDate("product_qual_asse_date"));
				return aProduct_qual_asse_tab;
				
				
			}
			
		});
		
		return listProduct_qual_asse_tab;
	}

	@Override
	public Product_qual_asse_tab get(String product_qual_asse_num) {
		String sql = "SELECT * FROM product_tab WHERE product_qual_asse_num=" + product_qual_asse_num;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Product_qual_asse_tab>() {

			@Override
			public Product_qual_asse_tab extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Product_qual_asse_tab aProduct_qual_asse_tab = new Product_qual_asse_tab();
					
					aProduct_qual_asse_tab.setProduct_qual_asse_num(rs.getString("product_qual_asse_num"));
					aProduct_qual_asse_tab.setProduct_qual_asse_cont(rs.getString("product_qual_asse_cont"));
					aProduct_qual_asse_tab.setProduct_qual_asse_res(rs.getString("product_qual_asse_res"));
					aProduct_qual_asse_tab.setProduct_qual_asse_per_num(rs.getString("product_qual_asse_per_num"));
					aProduct_qual_asse_tab.setProduct_num(rs.getString("product_num"));
					
					aProduct_qual_asse_tab.setProduct_qual_asse_date(rs.getTimestamp("product_qual_asse_date"));
					return aProduct_qual_asse_tab;
				
				}
				
				return null;
			}
			
		});
	}

	@Override
	public int updateSingleColumn(Product_qual_asse_tab product_qual_asse_tab, String column, String value) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Product_qual_asse_tab> getSomeProduct(String type) {
		// TODO Auto-generated method stub
		return null;
	}

}
