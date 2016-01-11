package net.codejava.spring.dao.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import net.codejava.spring.dao.daointerface.Produce_prog_tabDAO;
import net.codejava.spring.model.Atype_use_inf_tab;
import net.codejava.spring.model.Produce_prog_tab;
import net.codejava.spring.model.Produce_static_tab;
import net.codejava.spring.model.Product_qual_stat_tab;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

/**
 * An implementation of the ContactDAO interface.
 * @author www.codejava.net
 *
 */
public class Produce_prog_tabDAOImpl implements Produce_prog_tabDAO {

	private JdbcTemplate jdbcTemplate;
	
	public Produce_prog_tabDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(Produce_prog_tab produce_prog_tab) {
        String abc = "SELECT COUNT(*) FROM produce_prog_tab WHERE produce_prog_num=?";
		
		@SuppressWarnings("deprecation")
		int i=jdbcTemplate.queryForInt(abc,produce_prog_tab.getProduce_prog_num());
		if (i!=0) {
			// update
			String sql = "UPDATE produce_prog_tab SET equip_product_relat_num=?,"
						+ "bat_produce_start_time=?WHERE produce_prog_num=?";
			jdbcTemplate.update(sql, produce_prog_tab.getEquip_product_relat_num(), produce_prog_tab.getBat_produce_start_time(),
					produce_prog_tab.getProduce_prog_num());
		} else {
			// insert
			String sql = "INSERT INTO produce_plan_tab (equip_product_relat_num,bat_produce_start_time,produce_prog_num)"
						+ " VALUES (?, ?, ?)";
			jdbcTemplate.update(sql, produce_prog_tab.getEquip_product_relat_num(), produce_prog_tab.getBat_produce_start_time(),
					produce_prog_tab.getProduce_prog_num());
		}
		
	}

	@Override
	public void delete(String produce_prog_num) {
		String sql = "DELETE FROM produce_prog_tab WHERE produce_prog_num=?";
		jdbcTemplate.update(sql, produce_prog_num);
	}

	@Override
	public List<Produce_prog_tab> list() {
		String sql = "SELECT * FROM produce_prog_tab";
		List<Produce_prog_tab> listProduce_prog_tab = jdbcTemplate.query(sql, new RowMapper<Produce_prog_tab>() {

			@Override
			public Produce_prog_tab mapRow(ResultSet rs, int rowNum) throws SQLException {
				Produce_prog_tab aProduce_prog_tab = new Produce_prog_tab();
	
				aProduce_prog_tab.setProduce_prog_num(rs.getString("produce_prog_num"));
				aProduce_prog_tab.setEquip_product_relat_num(rs.getString("equip_product_relat_num"));
					
				
				aProduce_prog_tab.setBat_produce_start_time(rs.getTimestamp ("bat_produce_start_time"));
				
												
				return aProduce_prog_tab;
			}
			
		});
		
		return listProduce_prog_tab;
	}

	@Override
	public Produce_prog_tab get(String produce_prog_num) {
		String sql = "SELECT * FROM produce_prog_tab WHERE produce_prog_num=" + produce_prog_num;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Produce_prog_tab>() {

			@Override
			public Produce_prog_tab extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Produce_prog_tab aProduce_prog_tab = new Produce_prog_tab();
					
					aProduce_prog_tab.setProduce_prog_num(rs.getString("produce_prog_num"));
					aProduce_prog_tab.setEquip_product_relat_num(rs.getString("equip_product_relat_num"));
						
					
					aProduce_prog_tab.setBat_produce_start_time(rs.getTimestamp("bat_produce_start_time"));
									
					return aProduce_prog_tab;
				}
				
				return null;
			}
			
		});
	    }
		@Override
		public int updateSingleColumn(Produce_prog_tab produce_prog_tab,String column,String value){
			   System.out.println("updating...");
		        String sql = "UPDATE produce_prog_tab SET "+column+" = '"+value+"' WHERE produce_prog_num='"+produce_prog_tab.getProduce_prog_num()+"'";
		        //int i=jdbcTemplate.update(sql,column,value,equip_tab.getEquip_num());	
		        int i=jdbcTemplate.update(sql);
		        System.out.println("updating result:"+i);
		        return i;
		}

		@Override
		public List<Produce_static_tab> listProduce_static_tab() {
				
         
			
			String sql= " WITH count_product_quantity(value,equip_product_relat_num)AS"+
" (SELECT  COUNT( produce_prog_tab.produce_prog_num) ,  produce_prog_tab.equip_product_relat_num"+
" FROM  produce_prog_tab JOIN  recent_produce_start_time ON produce_prog_tab.equip_product_relat_num=recent_produce_start_time.equip_product_relat_num"+
" WHERE produce_prog_tab.bat_produce_start_time > recent_produce_start_time.recent_start_time"+
" GROUP BY  produce_prog_tab.equip_product_relat_num ),"+
" count_qulifiedproduct_quantity(qulified_product,equip_product_relat_num)AS"+
" (SELECT  COUNT( product_qual_stat_tab.qual_stat_num) ,  product_qual_stat_tab.equip_product_relat_num"+
"  FROM  product_qual_stat_tab   JOIN  recent_produce_start_time ON product_qual_stat_tab .equip_product_relat_num= recent_produce_start_time.equip_product_relat_num"+
" WHERE product_qual_stat_tab.infe_time > recent_produce_start_time.recent_start_time"+
" GROUP BY  product_qual_stat_tab.equip_product_relat_num "+
" )"+
" SELECT DISTINCT equip_name  ,product_name ,value*mou_hole_num  AS value ,value*mou_hole_num-qulified_product AS count_qulified_product,"+
" produce_plan_tab.plan_quan AS  plan_quan,produce_plan_tab.produce_plan_num AS produce_plan_num"+
" FROM  count_product_quantity   JOIN  equip_product_relat_tab ON count_product_quantity.equip_product_relat_num =  equip_product_relat_tab.equip_product_relat_num "+ 
" JOIN count_qulifiedproduct_quantity ON count_qulifiedproduct_quantity.equip_product_relat_num =  equip_product_relat_tab.equip_product_relat_num   "+
" JOIN equip_tab ON  equip_product_relat_tab.equip_num =  equip_tab.equip_num   "+
" JOIN  mou_use_inf_tab ON mou_use_inf_tab.equip_num=equip_tab.equip_num"+
" JOIN  mou_tab ON mou_tab.mou_num=mou_use_inf_tab.mou_num "+
" JOIN  product_tab ON   mou_tab.product_num =  product_tab.product_num "+
" JOIN  produce_plan_tab ON produce_plan_tab.equip_product_relat_num =equip_product_relat_tab.equip_product_relat_num "+
" JOIN  produce_plan_exe_stat_tab ON produce_plan_exe_stat_tab.produce_plan_num=produce_plan_tab.produce_plan_num "+
" JOIN  recent_produce_start_time ON produce_plan_exe_stat_tab.exe_start_time=recent_produce_start_time.recent_start_time"+
" JOIN  produce_module_time_mapping ON produce_module_time_mapping.equip_num=equip_tab.equip_num  and  mou_tab.product_num=produce_module_time_mapping.product_num "+ 
" WHERE  produce_module_time_mapping.mou_chan_time=mou_use_inf_tab.mou_chan_time ";
			List<Produce_static_tab> listProduce_static_tab =jdbcTemplate.query(sql, new RowMapper<Produce_static_tab>() {

				@Override
				public Produce_static_tab mapRow(ResultSet rs, int rowNum) throws SQLException {
					Produce_static_tab aProduce_static_tab = new Produce_static_tab();
		
					aProduce_static_tab.setEquip_name(rs.getString("equip_name"));
					aProduce_static_tab.setProduct_name(rs.getString("product_name"));
					aProduce_static_tab.setValue(rs.getString("value"));
					aProduce_static_tab.setCount_qulified_product(rs.getString("count_qulified_product"));
					aProduce_static_tab.setPlan_quan(rs.getFloat("plan_quan"));
					aProduce_static_tab.setProduce_plan_num(rs.getString("produce_plan_num"));
				//	aProduce_prog_tab.setBat_produce_start_time(rs.getTimestamp ("bat_produce_start_time"));
					
				
					return aProduce_static_tab;
				}
				
			});
			
			return listProduce_static_tab;
		}
		
		@Override
		public List<Produce_static_tab> list(String produce_plan_num) {
			String sql = " WITH count_product_quantity(value,equip_product_relat_num)AS"+
" (SELECT  COUNT( produce_prog_tab.produce_prog_num) ,  produce_prog_tab.equip_product_relat_num"+
" FROM  produce_prog_tab JOIN  recent_produce_start_time ON produce_prog_tab.equip_product_relat_num=recent_produce_start_time.equip_product_relat_num"+
" WHERE produce_prog_tab.bat_produce_start_time > recent_produce_start_time.recent_start_time"+
" GROUP BY  produce_prog_tab.equip_product_relat_num ),"+
" count_qulifiedproduct_quantity(qulified_product,equip_product_relat_num)AS"+
" (SELECT  COUNT( product_qual_stat_tab.qual_stat_num) ,  product_qual_stat_tab.equip_product_relat_num"+
"  FROM  product_qual_stat_tab   JOIN  recent_produce_start_time ON product_qual_stat_tab .equip_product_relat_num= recent_produce_start_time.equip_product_relat_num"+
" WHERE product_qual_stat_tab.infe_time > recent_produce_start_time.recent_start_time"+
" GROUP BY  product_qual_stat_tab.equip_product_relat_num "+
" )"+
" SELECT DISTINCT equip_name  ,product_name ,value*mou_hole_num  AS value ,value*mou_hole_num-qulified_product AS count_qulified_product,"+
" produce_plan_tab.plan_quan AS  plan_quan,produce_plan_tab.produce_plan_num AS produce_plan_num"+
" FROM  count_product_quantity   JOIN  equip_product_relat_tab ON count_product_quantity.equip_product_relat_num =  equip_product_relat_tab.equip_product_relat_num "+ 
" JOIN count_qulifiedproduct_quantity ON count_qulifiedproduct_quantity.equip_product_relat_num =  equip_product_relat_tab.equip_product_relat_num   "+
" JOIN equip_tab ON  equip_product_relat_tab.equip_num =  equip_tab.equip_num   "+
" JOIN  produce_module_time_mapping ON produce_module_time_mapping.equip_num=equip_tab.equip_num "+
" JOIN  mou_use_inf_tab ON mou_use_inf_tab.equip_num=equip_tab.equip_num"+
" JOIN  mou_tab ON mou_tab.mou_num=mou_use_inf_tab.mou_num "+
" JOIN  product_tab ON   mou_tab.product_num =  product_tab.product_num "+
" JOIN  produce_plan_tab ON produce_plan_tab.equip_product_relat_num =equip_product_relat_tab.equip_product_relat_num "+
" JOIN  produce_plan_exe_stat_tab ON produce_plan_exe_stat_tab.produce_plan_num=produce_plan_tab.produce_plan_num "+
" JOIN  recent_produce_start_time ON produce_plan_exe_stat_tab.exe_start_time=recent_produce_start_time.recent_start_time"+
" WHERE  produce_module_time_mapping.mou_chan_time=mou_use_inf_tab.mou_chan_time AND produce_plan_tab.produce_plan_num='"+produce_plan_num+"'";
			List<Produce_static_tab> listProduce_static_tab = jdbcTemplate.query(sql, new RowMapper<Produce_static_tab>() {

				@Override
				public Produce_static_tab mapRow(ResultSet rs, int rowNum) throws SQLException {
					Produce_static_tab aProduce_static_tab = new Produce_static_tab();
					
					aProduce_static_tab.setEquip_name(rs.getString("equip_name"));
					aProduce_static_tab.setProduct_name(rs.getString("product_name"));
					aProduce_static_tab.setValue(rs.getString("value"));
					aProduce_static_tab.setCount_qulified_product(rs.getString("count_qulified_product"));
					aProduce_static_tab.setPlan_quan(rs.getFloat("plan_quan"));
					aProduce_static_tab.setProduce_plan_num(rs.getString("produce_plan_num"));
				
					
				
					return aProduce_static_tab;
				}
				
			});
			
			return listProduce_static_tab;
		}	
		

}
