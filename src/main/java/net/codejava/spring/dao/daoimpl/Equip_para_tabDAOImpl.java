package net.codejava.spring.dao.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

import net.codejava.spring.dao.daointerface.Equip_para_tabDAO;
import net.codejava.spring.model.Equip_para_tab;
import net.codejava.spring.model.Equip_tab;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

/**
 * An implementation of the ContactDAO interface.
 * @author www.codejava.net
 *
 */
@SuppressWarnings("unused")
public class Equip_para_tabDAOImpl implements Equip_para_tabDAO {

	private JdbcTemplate jdbcTemplate;
	
	public Equip_para_tabDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(Equip_para_tab equip_para_tab) {
		
        String abc = "SELECT COUNT(*) FROM equip_para_tab WHERE para_num=?";
		
		@SuppressWarnings("deprecation")
		int i=jdbcTemplate.queryForInt(abc,equip_para_tab.getPara_num());
		System.out.println(i);
		if (i!=0) {
			// update
			String sql = "UPDATE equip_para_tab SET equip_num=?,para_unit=?, para_name=?,"
						+ "para_recorder_num=?, up_lim_val=?, down_lim_val=? WHERE para_num=?";
			jdbcTemplate.update(sql, equip_para_tab.getEquip_num(),equip_para_tab.getPara_unit(), equip_para_tab.getPara_name(),
					equip_para_tab.getPara_recorder_num(),equip_para_tab.getUp_lim_val(),equip_para_tab.getDown_lim_val(),equip_para_tab.getPara_num());
		} else {
			// insert
			String sql = "INSERT INTO equip_para_tab (para_num, para_unit, para_name, para_recorder_num, up_lim_val, down_lim_val, equip_num)"
						+ " VALUES (?, ?, ?,?,?,?,?)";
			jdbcTemplate.update(sql, equip_para_tab.getPara_num(),equip_para_tab.getPara_unit(), equip_para_tab.getPara_name(),
					equip_para_tab.getPara_recorder_num(), equip_para_tab.getUp_lim_val(), equip_para_tab.getDown_lim_val(), equip_para_tab.getEquip_num());
		}
		
	}

	@Override
	public void delete(String para_num) {
		String sql = "DELETE FROM equip_para_tab WHERE para_num=?";
		jdbcTemplate.update(sql, para_num);
	}

	@Override
	public List<Equip_para_tab> list() {
		String sql = "SELECT * FROM equip_para_tab";
		List<Equip_para_tab> listEquip_para_tab = jdbcTemplate.query(sql, new RowMapper<Equip_para_tab>() {

			@Override
			public Equip_para_tab mapRow(ResultSet rs, int rowNum) throws SQLException {
				Equip_para_tab aEquip_para_tab = new Equip_para_tab();
	
				aEquip_para_tab.setPara_num(rs.getString("para_num"));
				aEquip_para_tab.setPara_unit(rs.getString("para_unit"));
				aEquip_para_tab.setPara_name(rs.getString("para_name"));
				aEquip_para_tab.setPara_recorder_num(rs.getString("para_recorder_num"));
				aEquip_para_tab.setUp_lim_val(rs.getFloat("up_lim_val"));
				aEquip_para_tab.setDown_lim_val(rs.getFloat("down_lim_val"));
				aEquip_para_tab.setEquip_num(rs.getString("equip_num"));
				
				return aEquip_para_tab;
			}
			
		});
		
		return listEquip_para_tab;
	}

	@Override
	public Equip_para_tab get(String para_num) {
		String sql = "SELECT * FROM equip_para_tab WHERE para_num=" + para_num;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Equip_para_tab>() {

			@Override
			public Equip_para_tab extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Equip_para_tab aEquip_para_tab = new Equip_para_tab();
					aEquip_para_tab.setPara_num(rs.getString("para_num"));
					aEquip_para_tab.setPara_unit(rs.getString("para_unit"));
					aEquip_para_tab.setPara_name(rs.getString("para_name"));
					aEquip_para_tab.setPara_recorder_num(rs.getString("para_recorder_num"));
					aEquip_para_tab.setUp_lim_val(rs.getFloat("up_lim_val"));
					aEquip_para_tab.setDown_lim_val(rs.getFloat("down_lim_val"));
					aEquip_para_tab.setEquip_num(rs.getString("equip_num"));
					
					return aEquip_para_tab;
				}
				
				return null;
			}
			
		});
	}
	@Override
	public int updateSingleColumn(Equip_para_tab equip_para_tab,String column,String value){
		   System.out.println("updating...");
	        String sql = "UPDATE equip_tab SET "+column+" = '"+value+"' WHERE equip_num='"+equip_para_tab.getEquip_num()+"'";
	        //int i=jdbcTemplate.update(sql,column,value,equip_para_tab.getEquip_num());	
	        int i=jdbcTemplate.update(sql);
	        System.out.println("updating result:"+i);
	        return i;
	}
	@Override
	public List<Equip_para_tab> getSomeEquip(String type){
		String sql="";
		if(type=="main") { sql = "SELECT * FROM equip_para_tab where equip_num not in(select equ_equip_num from equip_para_tab where equ_equip_num is NOT NULL)";}
		  else if(type=="sup"){ sql = "SELECT * FROM equip_para_tab where equip_num in(select equ_equip_num from equip_para_tab where equ_equip_num is NOT NULL)";}
		      else  sql = "SELECT * FROM equip_para_tab";
		List<Equip_para_tab> listEquip_para_tab = jdbcTemplate.query(sql, new RowMapper<Equip_para_tab>() {

			@Override
			public Equip_para_tab mapRow(ResultSet rs, int rowNum) throws SQLException {
				Equip_para_tab aEquip_para_tab = new Equip_para_tab();
	
				aEquip_para_tab.setPara_num(rs.getString("para_num"));
				aEquip_para_tab.setPara_unit(rs.getString("para_unit"));
				aEquip_para_tab.setPara_name(rs.getString("para_name"));
				aEquip_para_tab.setPara_recorder_num(rs.getString("para_recorder_num"));
				aEquip_para_tab.setUp_lim_val(rs.getFloat("up_lim_val"));
				aEquip_para_tab.setDown_lim_val(rs.getFloat("down_lim_val"));
				aEquip_para_tab.setEquip_num(rs.getString("equip_num"));
				
				return aEquip_para_tab;
			}
			
		});
		
		return listEquip_para_tab;
	}
	
}
