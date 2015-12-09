package net.codejava.spring.dao.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.sql.DataSource;
import net.codejava.spring.dao.daointerface.Equip_pres_para_tabDAO;
import net.codejava.spring.model.Equip_pres_para_tab;

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
				
				Format formatter = new SimpleDateFormat("yyyy-M-dd");
				String str = formatter.format(rs.getDate("pres_date"));
				SimpleDateFormat simple= new SimpleDateFormat(str);
				aEquip_pres_para_tab.setPres_date(simple);
				
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
					
					Format formatter = new SimpleDateFormat("yyyy-M-dd");
					String str = formatter.format(rs.getDate("pres_date"));
					SimpleDateFormat simple= new SimpleDateFormat(str);
					aEquip_pres_para_tab.setPres_date(simple);
					
					aEquip_pres_para_tab.setPres_num(rs.getString("pres_num"));
					aEquip_pres_para_tab.setProduct_num(rs.getString("product_num"));
					aEquip_pres_para_tab.setPara_num(rs.getString("para_num"));
			
					return aEquip_pres_para_tab;
				}
				
				return null;
			}
			
		});
	}

}