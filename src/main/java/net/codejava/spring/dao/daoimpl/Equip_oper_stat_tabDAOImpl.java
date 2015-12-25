package net.codejava.spring.dao.daoimpl;


import java.sql.ResultSet;
import java.sql.SQLException;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import net.codejava.spring.dao.daointerface.Equip_oper_stat_tabDAO;
import net.codejava.spring.model.Equip_oper_stat_tab;


import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;


public class Equip_oper_stat_tabDAOImpl implements Equip_oper_stat_tabDAO {

	private JdbcTemplate jdbcTemplate;
	
	public Equip_oper_stat_tabDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(Equip_oper_stat_tab equip_oper_stat_tab) {
		
		String abc = "SELECT COUNT(*) FROM equip_oper_stat_tab WHERE stat_num=?";
		
		@SuppressWarnings("deprecation")
		int i=jdbcTemplate.queryForInt(abc,equip_oper_stat_tab.getStat_num());
		if (i!=0) {
			// update
			String sql = "UPDATE equip_oper_stat_tab SET equip_num=?,stat_time=?, stat_name=?,"
						+ "stat_reason=?,stat_recorder_num=? WHERE stat_num=?";
			jdbcTemplate.update(sql, equip_oper_stat_tab.getEquip_num(),equip_oper_stat_tab.getStat_time(), equip_oper_stat_tab.getStat_name(),
					equip_oper_stat_tab.getStat_reason(),equip_oper_stat_tab.getStat_num());
		} else {
			// insert
			String sql = "INSERT INTO equip_oper_stat_tab (stat_num,equip_num,stat_time, stat_name, stat_reason,stat_recorder_num)"
						+ " VALUES (?, ?, ?, ?, ?)";
			jdbcTemplate.update(sql, equip_oper_stat_tab.getStat_num(),equip_oper_stat_tab.getEquip_num(),equip_oper_stat_tab.getStat_time(), equip_oper_stat_tab.getStat_name(),
					equip_oper_stat_tab.getStat_reason(),equip_oper_stat_tab.getStat_recorder_num());
		}
		
	}

	@Override
	public void delete(String stat_num) {
		String sql = "DELETE FROM equip_oper_stat_tab WHERE stat_num=?";
		jdbcTemplate.update(sql, stat_num);
	}

	@Override
	public List<Equip_oper_stat_tab> list() {
		String sql = "SELECT * FROM equip_oper_stat_tab";
		List<Equip_oper_stat_tab> listEquip_oper_stat_tab = jdbcTemplate.query(sql, new RowMapper<Equip_oper_stat_tab>() {

			@Override
			public Equip_oper_stat_tab mapRow(ResultSet rs, int rowNum) throws SQLException {
				Equip_oper_stat_tab aEquip_oper_stat_tab = new Equip_oper_stat_tab();
				aEquip_oper_stat_tab.setStat_num(rs.getString("stat_num"));
				aEquip_oper_stat_tab.setEquip_num(rs.getString("equip_num"));
				aEquip_oper_stat_tab.setStat_time(rs.getTime("stat_time"));
				aEquip_oper_stat_tab.setStat_name(rs.getString("stat_name"));
				aEquip_oper_stat_tab.setStat_reason(rs.getString("stat_reason"));
				aEquip_oper_stat_tab.setStat_recorder_num(rs.getString("stat_recorder_num"));
				
				return aEquip_oper_stat_tab;
			}
			
		});
		
		return listEquip_oper_stat_tab;
	}

	@Override
	public Equip_oper_stat_tab get(String stat_num) {
		String sql = "SELECT * FROM equip_oper_stat_tab WHERE stat_num='"+stat_num+"'" ;
		return jdbcTemplate.query(sql,new ResultSetExtractor<Equip_oper_stat_tab>() {

			@Override
			public Equip_oper_stat_tab extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Equip_oper_stat_tab aEquip_oper_stat_tab = new Equip_oper_stat_tab();
					aEquip_oper_stat_tab.setStat_num(rs.getString("stat_num"));
					aEquip_oper_stat_tab.setEquip_num(rs.getString("equip_num"));					
					aEquip_oper_stat_tab.setStat_time(rs.getTime("stat_time"));					
					aEquip_oper_stat_tab.setStat_name(rs.getString("stat_name"));
					aEquip_oper_stat_tab.setStat_reason(rs.getString("stat_reason"));
					aEquip_oper_stat_tab.setStat_recorder_num(rs.getString("stat_recorder_num"));
					
					return aEquip_oper_stat_tab;
				}
				
				return null;
			}
			
		});
	}
	
	@Override
	public int updateSingleColumn(Equip_oper_stat_tab equip_oper_stat_tab,String column,String value){
		   System.out.println("updating...");
	        String sql = "UPDATE equip_oper_stat_tab SET "+column+" = '"+value+"' WHERE stat_num='"+equip_oper_stat_tab.getStat_num()+"'";
	        //int i=jdbcTemplate.update(sql,column,value,equip_tab.getEquip_num());	
	        int i=jdbcTemplate.update(sql);
	        System.out.println("updating result:"+i);
	        return i;
	}
	
	@Override
	public List< Equip_oper_stat_tab> getLastUniqueRecord(String equip_num){
		String sql = "WITH lastunique as (SELECT stat_name, MAX(stat_time) as stat_time FROM equip_oper_stat_tab GROUP BY stat_name)"+
",total as (SELECT * FROM equip_oper_stat_tab) SELECT * FROM total,lastunique WHERE total.stat_time=lastunique.stat_time AND total.stat_name=lastunique.stat_name and total.equip_num="+"'"+equip_num+"' ORDER BY total.stat_time";
		List<Equip_oper_stat_tab> listEquip_oper_stat_tab = jdbcTemplate.query(sql, new RowMapper<Equip_oper_stat_tab>() {

			@Override
			public Equip_oper_stat_tab mapRow(ResultSet rs, int rowNum) throws SQLException {
				Equip_oper_stat_tab aEquip_oper_stat_tab = new Equip_oper_stat_tab();
				aEquip_oper_stat_tab.setStat_num(rs.getString("stat_num"));
				aEquip_oper_stat_tab.setEquip_num(rs.getString("equip_num"));
				aEquip_oper_stat_tab.setStat_time(rs.getTime("stat_time"));
				aEquip_oper_stat_tab.setStat_name(rs.getString("stat_name"));
				aEquip_oper_stat_tab.setStat_reason(rs.getString("stat_reason"));
				aEquip_oper_stat_tab.setStat_recorder_num(rs.getString("stat_recorder_num"));
				
				return aEquip_oper_stat_tab;
			}
			
		});
		
		return listEquip_oper_stat_tab;	
		
	}
	
	@Override
	public int somedayStatTime(Date date,String  stat_name,String equip_num) {
	        String sql = "SELECT datediff(ss,MIN(stat_time),MAX(stat_time)) as stat_time from equip_oper_stat_tab where stat_name=? and DATEDIFF(DD,stat_time,?)=0 and equip_num='"+equip_num+"'";
	        //int i=jdbcTemplate.update(sql,column,value,equip_tab.getEquip_num());	
	        System.out.println("updating result11:"+date);
	        //date=new Date("2015-12-25 19:36:00.000");
	        System.out.println("updating result:"+stat_name); 
	        @SuppressWarnings("deprecation")
			int i=jdbcTemplate.queryForInt(sql,stat_name,date);
	        System.out.println("updating result:"+i);      
	        return i;
	}
	

}

