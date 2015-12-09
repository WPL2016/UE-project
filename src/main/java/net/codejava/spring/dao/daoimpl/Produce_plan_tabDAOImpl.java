package net.codejava.spring.dao.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
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
			String sql = "UPDATE produce_plan_tab SET equip_product_relat_num=?,"
						+ "plan_time=?,equip_product_relat_num=?,plan_quan=?,plan_work_time=?,produce_plan_recorder_num=?WHERE produce_plan_num=?";
			jdbcTemplate.update(sql, produce_plan_tab.getEquip_product_relat_num(), produce_plan_tab.getPlan_time(),
					produce_plan_tab.getPlan_quan(),produce_plan_tab.getPlan_work_time(),produce_plan_tab.getProduce_plan_recorder_num(), produce_plan_tab.getProduce_plan_num());
		} else {
			// insert
			String sql = "INSERT INTO produce_plan_tab (equip_product_relat_num,produce_plan_num,plan_time,plan_quan,plan_work_time,produce_plan_recorder_num)"
						+ " VALUES (?, ?, ?,?,?,?)";
			jdbcTemplate.update(sql, produce_plan_tab.getEquip_product_relat_num(), produce_plan_tab.getProduce_plan_num(),produce_plan_tab.getPlan_time(),
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
		String sql = "SELECT * FROM produce_plan_tab";
		List<Produce_plan_tab> listProduce_plan_tab = jdbcTemplate.query(sql, new RowMapper<Produce_plan_tab>() {

			@Override
			public Produce_plan_tab mapRow(ResultSet rs, int rowNum) throws SQLException {
				Produce_plan_tab aProduce_plan_tab = new Produce_plan_tab();
	
				aProduce_plan_tab.setProduce_plan_num(rs.getString("produce_plan_num"));
				aProduce_plan_tab.setEquip_product_relat_num(rs.getString("equip_product_relat_num"));
					
				Format formatter = new SimpleDateFormat("yyyy-M-dd");
				String str = formatter.format(rs.getDate("plan_time"));
				SimpleDateFormat simple= new SimpleDateFormat(str);
				aProduce_plan_tab.setPlan_time(simple);
				
				aProduce_plan_tab.setPlan_quan(rs.getInt("plan_quan"));
				aProduce_plan_tab.setPlan_work_time(rs.getInt("plan_work_time"));
				aProduce_plan_tab.setProduce_plan_recorder_num(rs.getString("produce_plan_recorder_num"));
								
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
						
					Format formatter = new SimpleDateFormat("yyyy-M-dd");
					String str = formatter.format(rs.getDate("plan_time"));
					SimpleDateFormat simple= new SimpleDateFormat(str);
					aProduce_plan_tab.setPlan_time(simple);
					
					aProduce_plan_tab.setPlan_quan(rs.getInt("plan_quan"));
					aProduce_plan_tab.setPlan_work_time(rs.getInt("plan_work_time"));
					aProduce_plan_tab.setProduce_plan_recorder_num(rs.getString("produce_plan_recorder_num"));
									
					return aProduce_plan_tab;
				}
				
				return null;
			}
			
		});
	}

}
