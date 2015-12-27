package net.codejava.spring.dao.daoimpl;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import net.codejava.spring.dao.daointerface.Ener_stat_tabDAO;
import net.codejava.spring.model.Ener_stat_tab;


import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

/**
 * An implementation of the ContactDAO interface.
 * @author www.codejava.net
 *
 */
public class Ener_stat_tabDAOImpl implements Ener_stat_tabDAO {

	private JdbcTemplate jdbcTemplate;
	
	public Ener_stat_tabDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(Ener_stat_tab ener_stat_tab) {
		
		String abc = "SELECT COUNT(*) FROM ener_stat_tab WHERE ener_stat_num=?";
		
		@SuppressWarnings("deprecation")
		int i=jdbcTemplate.queryForInt(abc,ener_stat_tab.getEner_stat_num());
		if (i!=0) {
			// update
			String sql = "UPDATE ener_stat_tab SET equip_num=?,ener_collect_time=?, ener_val=?,"
						+ "ener_type=? WHERE ener_stat_num=?";
			jdbcTemplate.update(sql, ener_stat_tab.getEquip_num(),ener_stat_tab.getEner_collect_time(), ener_stat_tab.getEner_val(),
					ener_stat_tab.getEner_type(),ener_stat_tab.getEner_stat_num());
		} else {
			// insert
			String sql = "INSERT INTO equip_tab (equip_num,ener_collect_time,ener_val, ener_type, ener_stat_num)"
						+ " VALUES (?, ?, ?, ?, ?)";
			jdbcTemplate.update(sql, ener_stat_tab.getEquip_num(),ener_stat_tab.getEner_collect_time(), ener_stat_tab.getEner_val(),
					ener_stat_tab.getEner_type(),ener_stat_tab.getEner_stat_num());
		}
		
	}

	@Override
	public void delete(String ener_stat_num) {
		String sql = "DELETE FROM Ener_stat_tab WHERE ener_stat_num=?";
		jdbcTemplate.update(sql, ener_stat_num);
	}

	@Override
	public List<Ener_stat_tab> list() {
		String sql = "SELECT * FROM ener_stat_tab";
		List<Ener_stat_tab> listEner_stat_tab = jdbcTemplate.query(sql, new RowMapper<Ener_stat_tab>() {

			@Override
			public Ener_stat_tab mapRow(ResultSet rs, int rowNum) throws SQLException {
				Ener_stat_tab aEner_stat_tab = new Ener_stat_tab();
	
				aEner_stat_tab.setEquip_num(rs.getString("equip_num"));
				
				Format formatter = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
				String str = formatter.format(rs.getDate("ener_collect_time"));
				//SimpleDateFormat simple= new SimpleDateFormat(str);
				aEner_stat_tab.setEner_collect_time(str);
				
				aEner_stat_tab.setEner_val(rs.getFloat("ener_val"));
				aEner_stat_tab.setEner_type(rs.getString("ener_type"));
				aEner_stat_tab.setEner_stat_num(rs.getString("ener_stat_num"));
				
				return aEner_stat_tab;
			}
			
		});
		
		return listEner_stat_tab;
	}

	@Override
	public Ener_stat_tab get(String ener_stat_num) {
		String sql = "SELECT * FROM ener_stat_tab WHERE ener_stat_num='"+ener_stat_num+"'" ;
		return jdbcTemplate.query(sql,new ResultSetExtractor<Ener_stat_tab>() {

			@Override
			public Ener_stat_tab extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Ener_stat_tab aEner_stat_tab = new Ener_stat_tab();
					
					aEner_stat_tab.setEquip_num(rs.getString("equip_num"));
					
					Format formatter = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
					String str = formatter.format(rs.getDate("ener_collect_time"));
					//SimpleDateFormat simple= new SimpleDateFormat(str);
					aEner_stat_tab.setEner_collect_time(str);
					
					aEner_stat_tab.setEner_val(rs.getFloat("ener_val"));
					aEner_stat_tab.setEner_type(rs.getString("ener_type"));
					aEner_stat_tab.setEner_stat_num(rs.getString("ener_stat_num"));
					
					return aEner_stat_tab;
				}
				
				return null;
			}
			
		});
	}
	
	@Override
	public int updateSingleColumn(Ener_stat_tab ener_stat_tab,String column,String value){
		   System.out.println("updating...");
	        String sql = "UPDATE ener_stat_tab SET "+column+" = '"+value+"' WHERE ener_stat_num='"+ener_stat_tab.getEner_stat_num()+"'";
	        //int i=jdbcTemplate.update(sql,column,value,equip_tab.getEquip_num());	
	        int i=jdbcTemplate.update(sql);
	        System.out.println("updating result:"+i);
	        return i;
	}
	
	@Override
	public List<Ener_stat_tab> GetSpecData(String equip_num, String start_time, String end_time, String ener_type, String timechoice){
		// TODO Auto-generated method stub
		String sql = new String();
		final String str= timechoice;
		//System.out.println("1111");
		List<Ener_stat_tab> listEner_stat_tab = new ArrayList<Ener_stat_tab>();
		//System.out.println("2222");
		/*sql = "SELECT * FROM ener_stat_tab WHERE equip_num='"+equip_num+"' AND "
				+ "ener_type='"+ener_type+"' AND DATEDIFF(SS,'"+start_time+"',ener_collect_time)>=0 AND "
				+ "DATEDIFF(SS,'"+end_time+"',ener_collect_time)<=0 order by ener_collect_time asc";*/
		if(timechoice.equals("0")){
			sql ="SELECT DATENAME(year,ener_collect_time) AS nian ,DATENAME(month,ener_collect_time)AS yue, DATENAME(day,ener_collect_time)AS ri,"
					+ "SUM(ener_val) AS val FROM ener_stat_tab"+ 
	        " WHERE equip_num='"+equip_num+"' AND ener_type='"+ener_type+"' AND"+ 
	        " DATEDIFF(SS,'"+start_time+"',ener_collect_time)>=0"+ 
	        " AND DATEDIFF(SS,'"+end_time+"',ener_collect_time)<=0"+
	        " GROUP BY DATENAME(month,ener_collect_time)"+
	        " ,DATENAME(year,ener_collect_time), DATENAME(day,ener_collect_time) order by nian, yue, ri asc"+
	        " SELECT equip_name FROM equip_tab WHERE equip_num='"+equip_num+"'";
			
		}
		if(timechoice.equals("1")){
			sql = "SELECT DATENAME(year,ener_collect_time) AS nian ,DATENAME(month,ener_collect_time)AS yue,SUM(ener_val) AS val"+
	                " FROM ener_stat_tab"+ 
	                " WHERE equip_num='"+equip_num+"' AND ener_type='"+ener_type+"' AND"+ 
	                " DATEDIFF(SS,'"+start_time+"',ener_collect_time)>=0"+ 
	                " AND DATEDIFF(SS,'"+end_time+"',ener_collect_time)<=0"+
	                " GROUP BY DATENAME(month,ener_collect_time)"+
	                " ,DATENAME(year,ener_collect_time) order by nian, yue asc"+
	    	        " SELECT equip_name FROM equip_tab WHERE equip_num='"+equip_num+"'";
		}
		if(timechoice.equals("2")){
			sql = "SELECT DATENAME(year,ener_collect_time) AS nian ,SUM(ener_val) AS val"+
	                " FROM ener_stat_tab"+ 
	                " WHERE equip_num='"+equip_num+"' AND ener_type='"+ener_type+"' AND"+ 
	                " DATEDIFF(SS,'"+start_time+"',ener_collect_time)>=0"+ 
	                " AND DATEDIFF(SS,'"+end_time+"',ener_collect_time)<=0"+
	                " GROUP BY DATENAME(year,ener_collect_time) order by nian asc"+
	    	        " SELECT equip_name FROM equip_tab WHERE equip_num='"+equip_num+"'";
		}
		//System.out.println("3333");
		listEner_stat_tab = jdbcTemplate.query(sql, new RowMapper<Ener_stat_tab>() {

			@Override
			public Ener_stat_tab mapRow(ResultSet rs, int rowNum) throws SQLException {
				Ener_stat_tab aEner_stat_tab = new Ener_stat_tab();

				aEner_stat_tab.setEquip_num(rs.getString("equip_name"));			
				//Format formatter = new SimpleDateFormat("yyyy-M-dd");
				//String str = formatter.format(rs.getDate("ener_collect_time"));
				//SimpleDateFormat simple= new SimpleDateFormat(str);
				if(str.equals("0")){aEner_stat_tab.setEner_collect_time(rs.getString("nian")+"-"+rs.getString("yue")+"-"+rs.getString("ri"));}
				if(str.equals("1")){aEner_stat_tab.setEner_collect_time(rs.getString("nian")+"-"+rs.getString("yue"));		}
				if(str.equals("2")){aEner_stat_tab.setEner_collect_time(rs.getString("nian"));}
			
				aEner_stat_tab.setEner_val(Float.valueOf(rs.getString("val")));
				
				//aEner_stat_tab.setEner_type(rs.getString("ener_type"));
				//aEner_stat_tab.setEner_stat_num(rs.getString("ener_stat_num"));
	
				return aEner_stat_tab; 
		}
		});
		
		return listEner_stat_tab;
	}

}
