package net.codejava.spring.dao.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;


import java.util.List;

import javax.sql.DataSource;

import net.codejava.spring.dao.daointerface.Produce_plan_tabDAO;

import net.codejava.spring.model.Produce_plan_tab;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

/**
 * An implementation of the ContactDAO interface.
 * @author www.codejava.net
 *
 */
public class Produce_plan_tabDAOImpl implements Produce_plan_tabDAO {

	private JdbcTemplate jdbcTemplate;
	
	public Produce_plan_tabDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(Produce_plan_tab produce_plan_tab) {
        String abc = "SELECT COUNT(*) FROM produce_plan_tab WHERE produce_plan_num=?";
		
		@SuppressWarnings("deprecation")
		int i=jdbcTemplate.queryForInt(abc,produce_plan_tab.getProduce_plan_num());
		if (i!=0) {
			// update
			String sql = "UPDATE produce_plan_tab SET equip_product_relat_num= ?,plan_start_time=?,plan_end_time=?,plan_quan= ?,plan_work_time= ?,produce_plan_recorder_num= ?"+
 " WHERE produce_plan_num= ?";
					//	+ "plan_time=?,plan_quan=?,plan_work_time=?,produce_plan_recorder_num=?WHERE produce_plan_num=?";
			jdbcTemplate.update(sql, produce_plan_tab.getEquip_product_relat_num(), produce_plan_tab.getPlan_start_time(), produce_plan_tab.getPlan_end_time(),
				produce_plan_tab.getPlan_quan(),produce_plan_tab.getPlan_work_time(),produce_plan_tab.getProduce_plan_recorder_num(), produce_plan_tab.getProduce_plan_num());
			//jdbcTemplate.update(sql);
		} else {
			// insert
			String sql = "INSERT INTO produce_plan_tab (equip_product_relat_num,produce_plan_num,plan_start_time,plan_end_time,plan_quan,plan_work_time,produce_plan_recorder_num)"
						+ " VALUES (?, ?,?, ?,?,?,?)";
			jdbcTemplate.update(sql, produce_plan_tab.getEquip_product_relat_num(), produce_plan_tab.getProduce_plan_num(),produce_plan_tab.getPlan_start_time(), produce_plan_tab.getPlan_end_time(),
					produce_plan_tab.getPlan_quan(),produce_plan_tab.getPlan_work_time(),produce_plan_tab.getProduce_plan_recorder_num());
		}
		
	}
	
	@Override
	public void add(Produce_plan_tab produce_plan_tab){
	 String abc = "SELECT COUNT(*) FROM produce_plan_tab WHERE produce_plan_num=?";
		
		@SuppressWarnings("deprecation")
		int i=jdbcTemplate.queryForInt(abc,produce_plan_tab.getProduce_plan_num());
		if (i==0) {// insert
			String sql = "INSERT INTO produce_plan_tab (equip_product_relat_num,produce_plan_num,plan_start_time,plan_end_time,plan_quan,plan_work_time,produce_plan_recorder_num)"
					+ " VALUES (?, ?,?, ?,?,?,?)";
		jdbcTemplate.update(sql, produce_plan_tab.getEquip_product_relat_num(), produce_plan_tab.getProduce_plan_num(),produce_plan_tab.getPlan_start_time(), produce_plan_tab.getPlan_end_time(),
				produce_plan_tab.getPlan_quan(),produce_plan_tab.getPlan_work_time(),produce_plan_tab.getProduce_plan_recorder_num());
			
		} 
		
	}
	
	@Override
	public void delete(String produce_plan_num) {
		String sql = "DELETE FROM produce_plan_tab WHERE produce_plan_num=?";
		jdbcTemplate.update(sql, produce_plan_num);
	}

	@Override
	public List<Produce_plan_tab> list() {
		String sql = "SELECT produce_plan_num,produce_plan_tab.equip_product_relat_num,plan_start_time,plan_end_time,plan_quan,plan_work_time,produce_plan_recorder_num,product_name,equip_name"+ 
" FROM produce_plan_tab JOIN equip_product_relat_tab"+ 
" ON produce_plan_tab.equip_product_relat_num=equip_product_relat_tab.equip_product_relat_num "+
" JOIN equip_tab ON equip_product_relat_tab.equip_num = equip_tab.equip_num "+
" JOIN product_tab ON product_tab.product_num=equip_product_relat_tab.product_num";
		List<Produce_plan_tab> listProduce_plan_tab = jdbcTemplate.query(sql, new RowMapper<Produce_plan_tab>() {

			@Override
			public Produce_plan_tab mapRow(ResultSet rs, int rowNum) throws SQLException {
				Produce_plan_tab aProduce_plan_tab = new Produce_plan_tab();
	
				aProduce_plan_tab.setProduce_plan_num(rs.getString("produce_plan_num"));
				aProduce_plan_tab.setEquip_product_relat_num(rs.getString("equip_product_relat_num"));
					
				
				aProduce_plan_tab.setPlan_start_time(rs.getDate("plan_start_time"));
				aProduce_plan_tab.setPlan_end_time(rs.getDate("plan_end_time"));
				
				aProduce_plan_tab.setPlan_quan(rs.getInt("plan_quan"));
				aProduce_plan_tab.setPlan_work_time(rs.getInt("plan_work_time"));
				aProduce_plan_tab.setProduce_plan_recorder_num(rs.getString("produce_plan_recorder_num"));
				aProduce_plan_tab.setProduct_name(rs.getString("product_name"));
				aProduce_plan_tab.setEquip_name(rs.getString("Equip_name"));
								
				return aProduce_plan_tab;
			}
			
		});
		
		return listProduce_plan_tab;
	}

	@Override
	public Produce_plan_tab get(String produce_plan_num) {
		String sql = "SELECT * FROM produce_plan_tab WHERE produce_plan_num=" + produce_plan_num;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Produce_plan_tab>() {

			@Override
			public Produce_plan_tab extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Produce_plan_tab aProduce_plan_tab = new Produce_plan_tab();
					
					aProduce_plan_tab.setProduce_plan_num(rs.getString("produce_plan_num"));
					aProduce_plan_tab.setEquip_product_relat_num(rs.getString("equip_product_relat_num"));
						
					
					aProduce_plan_tab.setPlan_start_time(rs.getDate("plan_start_time"));
					aProduce_plan_tab.setPlan_end_time(rs.getDate("plan_end_time"));
					
					aProduce_plan_tab.setPlan_quan(rs.getInt("plan_quan"));
					aProduce_plan_tab.setPlan_work_time(rs.getInt("plan_work_time"));
					aProduce_plan_tab.setProduce_plan_recorder_num(rs.getString("produce_plan_recorder_num"));
									
					return aProduce_plan_tab;
				}
				
				return null;
			}
			
		});
	    }
		@Override
		public int updateSingleColumn(Produce_plan_tab produce_plan_tab,String column,String value){
			   System.out.println("updating...");
		        String sql = "UPDATE produce_plan_tab SET "+column+" = '"+value+"' WHERE produce_plan_num='"+produce_plan_tab.getProduce_plan_num()+"'";
		        //int i=jdbcTemplate.update(sql,column,value,equip_tab.getEquip_num());	
		        int i=jdbcTemplate.update(sql);
		        System.out.println("updating result:"+i);
		        return i;
		}

}
