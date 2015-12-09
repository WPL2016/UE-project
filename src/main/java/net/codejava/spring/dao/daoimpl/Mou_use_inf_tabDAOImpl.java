package net.codejava.spring.dao.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.sql.DataSource;

import net.codejava.spring.dao.daointerface.Mou_use_inf_tabDAO;
import net.codejava.spring.model.Mou_use_inf_tab;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

/**
 * An implementation of the ContactDAO interface.
 * @author www.codejava.net
 *
 */
public class Mou_use_inf_tabDAOImpl implements Mou_use_inf_tabDAO {

	private JdbcTemplate jdbcTemplate;
	
	public Mou_use_inf_tabDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(Mou_use_inf_tab mou_use_inf_tab) {
        String abc = "SELECT COUNT(*) FROM mou_use_inf_tab WHERE mou_use_inf_num=?";
		
		@SuppressWarnings("deprecation")
		int i=jdbcTemplate.queryForInt(abc,mou_use_inf_tab.getMou_use_inf_num());
		if (i!=0) {
			// update
			String sql = "UPDATE mou_use_inf_tab SET mou_chan_per_num=?, mou_chan_time=?, mou_num=?, equip_num=?"
						+ " WHERE mou_use_inf_num=?";
			jdbcTemplate.update(sql, mou_use_inf_tab.getMou_chan_per_num(), mou_use_inf_tab.getMou_chan_time(),
					mou_use_inf_tab.getMou_num(), mou_use_inf_tab.getEquip_num(), mou_use_inf_tab.getMou_use_inf_num());
		} else {
			// insert
			String sql = "INSERT INTO Mou_use_inf_tab (mou_chan_per_num, mou_chan_time, mou_num, equip_num, mou_use_inf_num)"
						+ " VALUES (?, ?, ?, ?, ?)";
			jdbcTemplate.update(sql, mou_use_inf_tab.getMou_chan_per_num(), mou_use_inf_tab.getMou_chan_time(),
					mou_use_inf_tab.getMou_num(), mou_use_inf_tab.getEquip_num(), mou_use_inf_tab.getMou_use_inf_num());
		}
		
	}

	@Override
	public void delete(String mou_use_inf_num) {
		String sql = "DELETE FROM mou_use_inf_tab WHERE mou_use_inf_num=?";
		jdbcTemplate.update(sql, mou_use_inf_num);
	}

	@Override
	public List<Mou_use_inf_tab> list() {
		String sql = "SELECT * FROM Mou_use_inf_tab";
		List<Mou_use_inf_tab> listMou_use_inf_tab = jdbcTemplate.query(sql, new RowMapper<Mou_use_inf_tab>() {

			@Override
			public Mou_use_inf_tab mapRow(ResultSet rs, int rowNum) throws SQLException {
				Mou_use_inf_tab aMou_use_inf_tab = new Mou_use_inf_tab();
	
				aMou_use_inf_tab.setMou_use_inf_num(rs.getString("mou_use_inf_num"));
				aMou_use_inf_tab.setMou_chan_per_num(rs.getString("mou_chan_per_num"));
				
				Format formatter = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
				String str = formatter.format(rs.getDate("mou_chan_time"));
				SimpleDateFormat simple= new SimpleDateFormat(str);
				aMou_use_inf_tab.setMou_chan_time(simple);
				
				aMou_use_inf_tab.setMou_num(rs.getString("mou_num"));
				aMou_use_inf_tab.setEquip_num(rs.getString("equip_num"));
				
				return aMou_use_inf_tab;
			}
			
		});
		
		return listMou_use_inf_tab;
	}

	@Override
	public Mou_use_inf_tab get(String mou_use_inf_num) {
		String sql = "SELECT * FROM mou_use_inf_tab WHERE mou_use_inf_num=" + mou_use_inf_num;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Mou_use_inf_tab>() {

			@Override
			public Mou_use_inf_tab extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Mou_use_inf_tab aMou_use_inf_tab = new Mou_use_inf_tab();
					
					aMou_use_inf_tab.setMou_use_inf_num(rs.getString("mou_use_inf_num"));
					aMou_use_inf_tab.setMou_chan_per_num(rs.getString("mou_chan_per_num"));
					
					Format formatter = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
					String str = formatter.format(rs.getDate("mou_chan_time"));
					SimpleDateFormat simple= new SimpleDateFormat(str);
					aMou_use_inf_tab.setMou_chan_time(simple);
					
					aMou_use_inf_tab.setMou_num(rs.getString("mou_num"));
					aMou_use_inf_tab.setEquip_num(rs.getString("equip_num"));
					
					return aMou_use_inf_tab;
				}
				
				return null;
			}
			
		});
	}

}