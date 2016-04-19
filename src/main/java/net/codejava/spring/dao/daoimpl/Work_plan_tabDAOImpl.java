package net.codejava.spring.dao.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import net.codejava.spring.dao.daointerface.Work_plan_tabDAO;
import net.codejava.spring.model.Work_plan_tab;
import net.codejava.spring.model.Equip_tab;
import net.codejava.spring.model.Produce_plan_exe_stat_tab;
import net.codejava.spring.model.Produce_plan_tab;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 */
public class Work_plan_tabDAOImpl implements Work_plan_tabDAO {

	private JdbcTemplate jdbcTemplate;
	
	public Work_plan_tabDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void update(Work_plan_tab work_plan_tab) {
        String abc = "SELECT COUNT(*) FROM work_plan_tab WHERE work_plan_num=?";
		
		@SuppressWarnings("deprecation")
		int i=jdbcTemplate.queryForInt(abc,work_plan_tab.getWork_plan_num());
		if (i!=0) {
			// update
			String sql = "UPDATE work_plan_tab SET equip_product_relat_num=?,plan_shift=?,plan_date=?,edit_time=?,plan_quan= ?,work_plan_recorder_num= ?,plan_status=?"+
 " WHERE Work_plan_num= ?";
					//	+ "plan_time=?,plan_quan=?,plan_work_time=?,produce_plan_recorder_num=?WHERE produce_plan_num=?";
			jdbcTemplate.update(sql, work_plan_tab.getEquip_product_relat_num(),work_plan_tab.getPlan_shift(),work_plan_tab.getPlan_date(),work_plan_tab.getEdit_time(),work_plan_tab.getPlan_quan(),work_plan_tab.getWork_plan_recorder_num(),work_plan_tab.getPlan_status(),work_plan_tab.getWork_plan_num());
			//jdbcTemplate.update(sql);
		} 
		
	}
	
	@Override
	public void add(Work_plan_tab work_plan_tab){
	 String abc = "SELECT COUNT(*) FROM Work_plan_tab WHERE Work_plan_num=?";
		
		@SuppressWarnings("deprecation")
		int i=jdbcTemplate.queryForInt(abc,work_plan_tab.getWork_plan_num());
		if (i==0) {// insert
			String sql = "INSERT INTO Work_plan_tab (equip_product_relat_num,plan_shift,day_plan_num,edit_time,plan_date,plan_quan,work_plan_recorder_num,plan_status)"
					+ " VALUES (?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql, work_plan_tab.getEquip_product_relat_num(),work_plan_tab.getPlan_shift(),work_plan_tab.getDay_plan_num(),work_plan_tab.getEdit_time(),work_plan_tab.getPlan_date(),work_plan_tab.getPlan_quan(),work_plan_tab.getWork_plan_recorder_num(),work_plan_tab.getPlan_status());
			
		} 
		
	}
	
	@Override
	public void delete(String produce_plan_num) {
		String sql = "DELETE FROM work_plan_tab WHERE Work_plan_num=?";
		jdbcTemplate.update(sql, produce_plan_num);
	}

	@Override
	public Work_plan_tab get(String work_plan_num) {
		String sql = "SELECT * FROM work_plan_tab WHERE work_plan_num=" + work_plan_num;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Work_plan_tab>() {

			
			
			@Override
			public Work_plan_tab extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					
					Work_plan_tab aWork_plan_tab = new Work_plan_tab();
					aWork_plan_tab.setEquip_product_relat_num(rs.getString("equip_product_relat_num"));
					aWork_plan_tab.setPlan_shift(rs.getString("plan_shift"));
					aWork_plan_tab.setDay_plan_num(rs.getString("day_plan_num"));
				    aWork_plan_tab.setWork_plan_num(rs.getString("Work_plan_num"));	
					aWork_plan_tab.setPlan_date(rs.getDate("plan_date"));
					aWork_plan_tab.setEdit_time(rs.getDate("edit_time"));
					
					aWork_plan_tab.setPlan_quan(rs.getInt("plan_quan"));
				
					aWork_plan_tab.setWork_plan_recorder_num(rs.getString("work_plan_recorder_num"));
					
					
					aWork_plan_tab.setPlan_status(rs.getString("plan_status"));
					return aWork_plan_tab;
				}
				
				return null;
			}
			
		});
	    }
	@Override
	public List<Work_plan_tab> list(String day_plan_num,String plan_status_type) {
		String sql = "select * from work_plan_tab as a,equip_product_relat_tab as b,equip_tab as c,product_tab as d "+
	"where a.equip_product_relat_num=b.equip_product_relat_num and b.equip_num=c.equip_num and b.product_num=d.product_num";
		
		if(!(day_plan_num.equals("all"))){
			 sql=sql+" and a.day_plan_num='"+day_plan_num+"'";
		}
		switch(plan_status_type){
		   case "unpub": sql=sql+" and a.plan_status='0'";break;
		   case "pubed": sql=sql+" and a.plan_status<>'0'";break;
		   case "operator": sql=sql+" and a.plan_status<>'0'  and a.plan_status<>'5'";
		                        }
		 
		List<Work_plan_tab> listWork_plan_tab = jdbcTemplate.query(sql, new RowMapper<Work_plan_tab>() {

			@Override
			public Work_plan_tab mapRow(ResultSet rs, int rowNum) throws SQLException {
				Work_plan_tab aWork_plan_tab = new Work_plan_tab();
				aWork_plan_tab.setEquip_product_relat_num(rs.getString("equip_product_relat_num"));
				aWork_plan_tab.setPlan_shift(rs.getString("plan_shift"));
				aWork_plan_tab.setDay_plan_num(rs.getString("day_plan_num"));
			    aWork_plan_tab.setWork_plan_num(rs.getString("work_plan_num"));	
				aWork_plan_tab.setPlan_date(rs.getDate("plan_date"));
				aWork_plan_tab.setEdit_time(rs.getDate("edit_time"));
				
				aWork_plan_tab.setPlan_quan(rs.getInt("plan_quan"));
			
				aWork_plan_tab.setWork_plan_recorder_num(rs.getString("Work_plan_recorder_num"));
				
				
				aWork_plan_tab.setPlan_status(rs.getString("plan_status"));					
				
				aWork_plan_tab.setProduct_num(rs.getString("product_num"));
				aWork_plan_tab.setProduct_name(rs.getString("product_name"));
				aWork_plan_tab.setEquip_num(rs.getString("equip_num"));
			    aWork_plan_tab.setEquip_name(rs.getString("equip_name"));
							
				return aWork_plan_tab;
			}
			
		});
		
		return listWork_plan_tab;
	}
  @Override
	public List<Equip_tab> getUsableEquip(String day_plan_num){
		String sql = "SELECT a.equip_num,a.equip_name,a.equ_equip_num,a.equip_recorder_num,a.equip_type,a.equip_sup FROM equip_tab as a,day_plan_tab as b,produce_plan_tab as c,equip_product_relat_tab as d"+
	" where b.produce_plan_num=c.produce_plan_num and c.product_num=d.product_num and d.equip_num=a.equip_num and b.day_plan_num='"+day_plan_num+"'";
		List<Equip_tab> listEquip_tab = jdbcTemplate.query(sql, new RowMapper<Equip_tab>() {

			@Override
			public Equip_tab mapRow(ResultSet rs, int rowNum) throws SQLException {
				Equip_tab aEquip_tab = new Equip_tab();
	
				aEquip_tab.setEquip_num(rs.getString("equip_num"));
				aEquip_tab.setEqu_equip_num(rs.getString("equ_equip_num"));
				aEquip_tab.setEquip_sup(rs.getString("equip_sup"));
				aEquip_tab.setEquip_name(rs.getString("equip_name"));
				aEquip_tab.setEquip_recorder_num(rs.getString("equip_recorder_num"));
				
				return aEquip_tab;
			}
			
		});
		
		return listEquip_tab;
	  
	  
  };
  
  @Override
  public String getProduct_num(String day_plan_num)
  {
  String product_num=jdbcTemplate.queryForObject("select product_num from produce_plan_tab as a,day_plan_tab as b where a.produce_plan_num=b.produce_plan_num and b.day_plan_num=?",new Object[] {day_plan_num},java.lang.String.class);
  return product_num;
  }
	
		@Override
		public int updateSingleColumn(Work_plan_tab work_plan_tab,String column,String value){
			   System.out.println("updating...");
		        String sql = "UPDATE work_plan_tab SET "+column+" = '"+value+"' WHERE work_plan_num='"+work_plan_tab.getWork_plan_num()+"'";
		        //int i=jdbcTemplate.update(sql,column,value,equip_tab.getEquip_num());	
		        int i=jdbcTemplate.update(sql);
		        System.out.println("updating result:"+i);
		        return i;
		}
		
 @Override
 public int excuteWorkPlan(String work_plan_num){
	 String sql1="Update work_plan_tab SET plan_status=3 where work_plan_num='"+work_plan_num+"'";
	 String sql2="with usingequip as"+
" (select b.equip_num from work_plan_tab as a,equip_product_relat_tab as b where a.equip_product_relat_num=b.equip_product_relat_num and a.work_plan_num='"+work_plan_num+"')"+
" update work_plan_tab set plan_status='4' where plan_status='3' and equip_product_relat_num in (select equip_product_relat_num from equip_product_relat_tab as a,usingequip as b where a.equip_num=b.equip_num)";
	 
	
	 int j=jdbcTemplate.update(sql2);
	 int i=jdbcTemplate.update(sql1);
	 System.out.println(i);
	 System.out.println(j);
	 return i+j; 
 }
 @Override
 public int excuteRecord(Produce_plan_exe_stat_tab excutestat){
	 
	 String sql="INSERT INTO produce_plan_exe_stat_tab (work_plan_num,exe_start_time,produce_plan_exe_stat_recorder_num)"
		+ " VALUES (?,?,?)";
	 int i=jdbcTemplate.update(sql,excutestat.getWork_plan_num(),excutestat.getExe_start_time(),excutestat.getProduce_plan_exe_stat_recorder_num());
	 return i;
 }
}
