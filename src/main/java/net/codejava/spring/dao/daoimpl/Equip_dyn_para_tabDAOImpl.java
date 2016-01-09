package net.codejava.spring.dao.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import net.codejava.spring.dao.daointerface.Equip_dyn_para_tabDAO;
import net.codejava.spring.model.Equip_dyn_para_tab;
import net.codejava.spring.model.Equip_dyn_record;
import net.codejava.spring.model.Equip_para_tab;
import net.codejava.spring.model.Equip_tab;

public class Equip_dyn_para_tabDAOImpl implements  Equip_dyn_para_tabDAO{
	private JdbcTemplate jdbcTemplate;
	
	public Equip_dyn_para_tabDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public List<Equip_dyn_record> getLastDynPara(String equip_num) {
		String sql = " with lastunique  as (SELECT MAX(dyn_time) as dyn_time,a.para_num FROM equip_dyn_para_tab as a,equip_para_tab as b WHERE a.para_num=b.para_num group by a.para_num),"+
 "total as (Select a.para_num,a.dyn_num,a.product_num,a.dyn_para_val,a.dyn_time,b.down_lim_val,b.equip_num,b.para_name,b.para_recorder_num,b.para_unit,b.up_lim_val from equip_dyn_para_tab as a,equip_para_tab as b "+
 "WHERE a.para_num=b.para_num) SELECT * FROM total,lastunique where total.dyn_time=lastunique.dyn_time and total.para_num=lastunique.para_num and total.equip_num='"+equip_num+"'";
		
		
		List<Equip_dyn_record> listEquip_dyn_para = jdbcTemplate.query(sql, new RowMapper<Equip_dyn_record>() {
        
			@Override
			public Equip_dyn_record mapRow(ResultSet rs, int rowNum) throws SQLException {
				
	            Equip_dyn_para_tab  equip_dyn_para_tab=new Equip_dyn_para_tab();
	            Equip_para_tab equip_para_tab =new Equip_para_tab(); 
	            equip_dyn_para_tab.setDyn_num(rs.getString("dyn_num"));
	            equip_dyn_para_tab.setDyn_para_val(rs.getFloat("dyn_para_val"));
	            equip_dyn_para_tab.setDyn_time(rs.getTime("dyn_time"));
	            equip_dyn_para_tab.setProduct_num(rs.getString("product_num"));
	            equip_dyn_para_tab.setPara_num(rs.getString("para_num"));
	            
	            equip_para_tab.setDown_lim_val(rs.getFloat("down_lim_val"));
	            equip_para_tab.setEquip_num(rs.getString("equip_num"));
	            equip_para_tab.setPara_name(rs.getString("para_name"));
	            equip_para_tab.setPara_num(rs.getString("para_num"));
	            equip_para_tab.setPara_recorder_num(rs.getString("para_recorder_num"));
	            equip_para_tab.setPara_unit(rs.getString("para_unit"));
	            equip_para_tab.setUp_lim_val(rs.getFloat("up_lim_val"));
	            Equip_dyn_record aEquip_dyn_record = new Equip_dyn_record(equip_dyn_para_tab,equip_para_tab);
				return aEquip_dyn_record;
			}
			
		});
		
		return listEquip_dyn_para;
	}


}
