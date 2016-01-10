package net.codejava.spring.dao.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;
import net.codejava.spring.dao.daointerface.Equip_pres_para_tabDAO;
import net.codejava.spring.model.Equip_dyn_para_tab;
import net.codejava.spring.model.Equip_dyn_record;
import net.codejava.spring.model.Equip_para_tab;
import net.codejava.spring.model.Equip_pres_para_tab;
import net.codejava.spring.model.Equip_pres_record;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

/**
 * An implementation of the ContactDAO interface.
 * @author www.codejava.net
 *
 */
public class Equip_pres_para_tabDAOImpl implements Equip_pres_para_tabDAO {

	private JdbcTemplate jdbcTemplate;
	
	public Equip_pres_para_tabDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(Equip_pres_para_tab equip_pres_para_tab) {
        String abc = "SELECT COUNT(*) FROM atype_tab WHERE pres_num=?";
		
		@SuppressWarnings("deprecation")
		int i=jdbcTemplate.queryForInt(abc,equip_pres_para_tab.getPres_num());
		if (i!=0) {
			// update
			String sql = "UPDATE equip_pres_para_tab SET pres_para_val=?, pres_date=?, para_num=?, product_num=?,"
						+ " WHERE pres_num=?";
			jdbcTemplate.update(sql, equip_pres_para_tab.getPres_para_val(), equip_pres_para_tab.getPres_date(),
					equip_pres_para_tab.getPara_num(), equip_pres_para_tab.getProduct_num(), equip_pres_para_tab.getPres_num());
		} else {
			// insert
			String sql = "INSERT INTO equip_pres_para_tab (pres_para_val, pres_date, pres_num, product_num, para_num)"
						+ " VALUES (?, ?, ?, ?, ?)";
			jdbcTemplate.update(sql, equip_pres_para_tab.getPres_para_val(), equip_pres_para_tab.getPres_date(),
					equip_pres_para_tab.getPres_num(), equip_pres_para_tab.getProduct_num(), equip_pres_para_tab.getPara_num());
		}
		
	}

	@Override
	public void delete(String pres_num) {
		String sql = "DELETE FROM equip_pres_para_tab WHERE pres_num=?";
		jdbcTemplate.update(sql, pres_num);
	}

	@Override
	public List<Equip_pres_para_tab> list() {
		String sql = "SELECT * FROM equip_pres_para_tab";
		List<Equip_pres_para_tab> listEquip_pres_para_tab = jdbcTemplate.query(sql, new RowMapper<Equip_pres_para_tab>() {

			@Override
			public Equip_pres_para_tab mapRow(ResultSet rs, int rowNum) throws SQLException {
				Equip_pres_para_tab aEquip_pres_para_tab = new Equip_pres_para_tab();
	
				aEquip_pres_para_tab.setPres_para_val(rs.getFloat("pres_para_val"));
				
				Date date = new Date();
				aEquip_pres_para_tab.setPres_date(date);
				
				aEquip_pres_para_tab.setPres_num(rs.getString("pres_num"));
				aEquip_pres_para_tab.setProduct_num(rs.getString("product_num"));
				aEquip_pres_para_tab.setPara_num(rs.getString("para_num"));
		
				return aEquip_pres_para_tab;
			}
			
		});
		
		return listEquip_pres_para_tab;
	}

	@Override
	public Equip_pres_para_tab get(String pres_num) {
		String sql = "SELECT * FROM Equip_pres_para_tab WHERE pres_num=" + pres_num;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Equip_pres_para_tab>() {

			@Override
			public Equip_pres_para_tab extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Equip_pres_para_tab aEquip_pres_para_tab = new Equip_pres_para_tab();
					
					aEquip_pres_para_tab.setPres_para_val(rs.getFloat("pres_para_val"));
					
					Date date=new Date();
					aEquip_pres_para_tab.setPres_date(date);
					
					aEquip_pres_para_tab.setPres_num(rs.getString("pres_num"));
					aEquip_pres_para_tab.setProduct_num(rs.getString("product_num"));
					aEquip_pres_para_tab.setPara_num(rs.getString("para_num"));
			
					return aEquip_pres_para_tab;
				}
				
				return null;
			}
			
		});
	}
	@Override
	public List<Equip_pres_record> getLastPresStat(String equip_num){
		String sql = "with lastunique  as (SELECT MAX(pres_date) as pres_date,a.para_num FROM "
		+ "equip_pres_para_tab as a,equip_para_tab as b WHERE a.para_num=b.para_num group by a.para_num),"
		+ "total as (Select a.para_num,a.pres_num,a.product_num,a.pres_para_val,a.pres_date,b.down_lim_val,b.equip_num,b.para_name,"
		+ "b.para_recorder_num,b.para_unit,b.up_lim_val from equip_pres_para_tab as a,equip_para_tab as b WHERE a.para_num=b.para_num) "
		+ "SELECT * FROM total,lastunique where total.pres_date=lastunique.pres_date and total.para_num=lastunique.para_num and equip_num='"+equip_num+"'";
						List<Equip_pres_record> listEquip_pres_record = jdbcTemplate.query(sql, new RowMapper<Equip_pres_record>() {

							@Override
							public Equip_pres_record mapRow(ResultSet rs, int rowNum) throws SQLException {
								
					            Equip_pres_para_tab  equip_pres_para_tab=new Equip_pres_para_tab();
					            Equip_para_tab equip_para_tab =new Equip_para_tab(); 
					            
					            equip_pres_para_tab.setPres_num(rs.getString("pres_num"));
					            equip_pres_para_tab.setPres_para_val(rs.getFloat("pres_para_val"));
					            equip_pres_para_tab.setPres_date(rs.getTime("pres_date"));
					            equip_pres_para_tab.setProduct_num(rs.getString("product_num"));
					            equip_pres_para_tab.setPara_num(rs.getString("para_num"));
					            
					            equip_para_tab.setDown_lim_val(rs.getFloat("down_lim_val"));
					            equip_para_tab.setEquip_num(rs.getString("equip_num"));
					            equip_para_tab.setPara_name(rs.getString("para_name"));
					            equip_para_tab.setPara_num(rs.getString("para_num"));
					            equip_para_tab.setPara_recorder_num(rs.getString("para_recorder_num"));
					            equip_para_tab.setPara_unit(rs.getString("para_unit"));
					            equip_para_tab.setUp_lim_val(rs.getFloat("up_lim_val"));
					            Equip_pres_record aEquip_pres_record = new Equip_pres_record(equip_pres_para_tab,equip_para_tab);
								return aEquip_pres_record;
							}
							
						});
						
						return listEquip_pres_record;
					

	}
	
	
}