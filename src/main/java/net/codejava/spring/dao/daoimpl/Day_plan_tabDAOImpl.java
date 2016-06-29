package net.codejava.spring.dao.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;


import java.util.List;

import javax.sql.DataSource;

import net.codejava.spring.dao.daointerface.Day_plan_tabDAO;
import net.codejava.spring.model.Day_plan_tab;
import net.codejava.spring.model.Produce_plan_tab;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 */
public class Day_plan_tabDAOImpl implements Day_plan_tabDAO {

	private JdbcTemplate jdbcTemplate;
	
	public Day_plan_tabDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void update(Day_plan_tab day_plan_tab) {
        String abc = "SELECT COUNT(*) FROM day_plan_tab WHERE day_plan_num=?";
		
		@SuppressWarnings("deprecation")
		int i=jdbcTemplate.queryForInt(abc,day_plan_tab.getDay_plan_num());
		if (i!=0) {
			// update
			String sql = "UPDATE day_plan_tab SET plan_date=?,edit_time=?,plan_quan= ?,day_plan_recorder_num= ?"+
 " WHERE day_plan_num= ?";
					//	+ "plan_time=?,plan_quan=?,plan_work_time=?,produce_plan_recorder_num=?WHERE produce_plan_num=?";
			jdbcTemplate.update(sql, day_plan_tab.getPlan_date(),day_plan_tab.getEdit_time(),day_plan_tab.getPlan_quan(),day_plan_tab.getDay_plan_recorder_num(),day_plan_tab.getDay_plan_num());
			//jdbcTemplate.update(sql);
		} 
		
	}
	
	@Override
	public void add(Day_plan_tab day_plan_tab){
	 String abc = "SELECT COUNT(*) FROM day_plan_tab WHERE day_plan_num=?";
		
		@SuppressWarnings("deprecation")
		int i=jdbcTemplate.queryForInt(abc,day_plan_tab.getDay_plan_num());
		if (i==0) {// insert
			String sql = "INSERT INTO day_plan_tab (produce_plan_num,edit_time,plan_date,plan_quan,day_plan_recorder_num,plan_status)"
					+ " VALUES (?,?,?,?,?,?)";
		jdbcTemplate.update(sql,day_plan_tab.getProduce_plan_num(),day_plan_tab.getEdit_time(),day_plan_tab.getPlan_date(),day_plan_tab.getPlan_quan(),day_plan_tab.getDay_plan_recorder_num(),day_plan_tab.getPlan_status());
			
		} 
		
	}
	
	@Override
	public void delete(String produce_plan_num) {
		String sql = "DELETE FROM day_plan_tab WHERE day_plan_num=?";
		jdbcTemplate.update(sql, produce_plan_num);
	}

	@Override
	public Day_plan_tab get(String day_plan_num) {
		String sql = "SELECT * FROM day_plan_tab WHERE day_plan_num=" + day_plan_num;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Day_plan_tab>() {

			@Override
			public Day_plan_tab extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Day_plan_tab aDay_plan_tab = new Day_plan_tab();
					
					aDay_plan_tab.setProduce_plan_num(rs.getString("produce_plan_num"));
				    aDay_plan_tab.setDay_plan_num(rs.getString("day_plan_num"));	
					aDay_plan_tab.setPlan_date(rs.getDate("plan_date"));
					aDay_plan_tab.setEdit_time(rs.getDate("edit_time"));
					
					aDay_plan_tab.setPlan_quan(rs.getInt("plan_quan"));
				
					aDay_plan_tab.setDay_plan_recorder_num(rs.getString("day_plan_recorder_num"));
					
					
					aDay_plan_tab.setPlan_status(rs.getString("plan_status"));
					return aDay_plan_tab;
				}
				
				return null;
			}
			
		});
	    }
	@Override
	public List<Day_plan_tab> list(String produce_plan_num,String plan_status_type) {
		String sql = "select a.produce_plan_num,a.day_plan_num,a.plan_date,a.edit_time,a.plan_quan,a.day_plan_recorder_num,a.plan_status,c.product_num,c.product_name from day_plan_tab as a,produce_plan_tab as b,product_tab as c where a.produce_plan_num=b.produce_plan_num and b.product_num=c.product_num";
		if(!(produce_plan_num.equals("all"))){
			 sql=sql+" and a.produce_plan_num='"+produce_plan_num+"'";
		}
		
		switch(plan_status_type){
		   case "unpub": sql=sql+" and a.plan_status='0'";break;
		   case "pubed": sql=sql+" and a.plan_status<>'0'";break;
		                        }
		 
		
		
			
		 
		List<Day_plan_tab> listDay_plan_tab = jdbcTemplate.query(sql, new RowMapper<Day_plan_tab>() {

			@Override
			public Day_plan_tab mapRow(ResultSet rs, int rowNum) throws SQLException {
				Day_plan_tab aDay_plan_tab = new Day_plan_tab();
	
				aDay_plan_tab.setProduce_plan_num(rs.getString("produce_plan_num"));
			    aDay_plan_tab.setDay_plan_num(rs.getString("day_plan_num"));	
				aDay_plan_tab.setPlan_date(rs.getDate("plan_date"));
				aDay_plan_tab.setEdit_time(rs.getDate("edit_time"));
				
				aDay_plan_tab.setPlan_quan(rs.getInt("plan_quan"));
			
				aDay_plan_tab.setDay_plan_recorder_num(rs.getString("day_plan_recorder_num"));
				
				
				aDay_plan_tab.setPlan_status(rs.getString("plan_status"));
				aDay_plan_tab.setProduct_name(rs.getString("product_name"));	
				aDay_plan_tab.setProduct_num(rs.getString("product_num"));
				
							
				return aDay_plan_tab;
			}
			
		});
		
		return listDay_plan_tab;
	}

	
		@Override
		public int updateSingleColumn(Day_plan_tab day_plan_tab,String column,String value){
			   //System.out.println("updating...");
		        String sql = "UPDATE day_plan_tab SET "+column+" = '"+value+"' WHERE day_plan_num='"+day_plan_tab.getDay_plan_num()+"'";
		        //int i=jdbcTemplate.update(sql,column,value,equip_tab.getEquip_num());	
		        int i=jdbcTemplate.update(sql);
		        System.out.println("updating result:"+i);
		        return i;
		}
	

}
