package net.codejava.spring.dao.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import net.codejava.spring.dao.daointerface.Product_qual_stat_tabDAO;
import net.codejava.spring.model.Product_qual_stat_tab;
import net.codejava.spring.model.Qual_show_tab;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

/**
 * An implementation of the ContactDAO interface.
 * @author www.codejava.net
 *
 */
public class Product_qual_stat_tabDAOImpl implements Product_qual_stat_tabDAO {

	private JdbcTemplate jdbcTemplate;
	
	public Product_qual_stat_tabDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(Product_qual_stat_tab product_qual_stat_tab) {
		String abc = "SELECT COUNT(*) FROM product_qual_stat_tab WHERE qual_stat_num=?";
		
		@SuppressWarnings("deprecation")
		int i=jdbcTemplate.queryForInt(abc,product_qual_stat_tab.getQual_stat_num());
		if (i!=0) {
			// update
			String sql = "UPDATE product_qual_stat_tab SET qual_stat_num=?,equip_product_relat_num=?, "
						+ "infe_time=? WHERE infe_rea=?";
			jdbcTemplate.update(sql, product_qual_stat_tab.getQual_stat_num(),product_qual_stat_tab.getEquip_product_relat_num(),
					product_qual_stat_tab.getInfe_time(),product_qual_stat_tab.getInfe_rea());
		} else {
			// insert
			String sql = "INSERT INTO product_qual_stat_tab (qual_stat_num,product_num, infe_time, infe_rea)"
						+ " VALUES (?, ?, ?, ?, ?)";
			jdbcTemplate.update(sql, product_qual_stat_tab.getQual_stat_num(),product_qual_stat_tab.getEquip_product_relat_num(),
					product_qual_stat_tab.getInfe_time(),product_qual_stat_tab.getInfe_rea());
		}
		
	}

	@Override
	public void delete(String qual_stat_num) {
		String sql = "DELETE FROM product_qual_stat_tab WHERE qual_stat_num=?";
		jdbcTemplate.update(sql, qual_stat_num);
	}

	@Override
	public List<Product_qual_stat_tab> list() {
		String sql = "SELECT * FROM product_qual_stat_tab";
		List<Product_qual_stat_tab> listProduct_qual_stat_tab = jdbcTemplate.query(sql, new RowMapper<Product_qual_stat_tab>() {

			@Override
			public Product_qual_stat_tab mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product_qual_stat_tab aProduct_qual_stat_tab = new Product_qual_stat_tab();
	
				aProduct_qual_stat_tab.setQual_stat_num(rs.getString("qual_stat_num"));
				aProduct_qual_stat_tab.setEquip_product_relat_num(rs.getString("equip_product_relat_num"));
				aProduct_qual_stat_tab.setInfe_rea(rs.getString("infe_rea"));
				
				aProduct_qual_stat_tab.setInfe_time(rs.getDate("infe_time"));
				
				
				return aProduct_qual_stat_tab;
			}
			
		});
		
		return listProduct_qual_stat_tab;
	}

	@Override
	public Product_qual_stat_tab get(String qual_stat_num) {
		String sql = "SELECT * FROM product_qual_stat_tab WHERE qual_stat_num='"+qual_stat_num+"'" ;
		return jdbcTemplate.query(sql,new ResultSetExtractor<Product_qual_stat_tab>() {

			@Override
			public Product_qual_stat_tab extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Product_qual_stat_tab aProduct_qual_stat_tab = new Product_qual_stat_tab();
					aProduct_qual_stat_tab.setQual_stat_num(rs.getString("qual_stat_num"));
					aProduct_qual_stat_tab.setEquip_product_relat_num(rs.getString("equip_product_relat_num"));
					aProduct_qual_stat_tab.setInfe_rea(rs.getString("infe_rea"));
					
					aProduct_qual_stat_tab.setInfe_time(rs.getTimestamp("infe_time"));
					return aProduct_qual_stat_tab;
					
					
				}
				
				return null;
			}
			
		});
	}
	
	@Override
	public int updateSingleColumn(Product_qual_stat_tab product_qual_stat_tab, String column, String value) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public List<Qual_show_tab> getSomeQual(String product_num, String start_time, String end_time,
			String timechoice) {
		// TODO Auto-generated method stub
				String sql = new String();
				final String str= timechoice;
				//System.out.println("1111");
				List<Qual_show_tab> listQual_show_tab = new ArrayList<Qual_show_tab>();
				//System.out.println("2222");
				/*sql = "SELECT * FROM ener_stat_tab WHERE equip_num='"+equip_num+"' AND "
						+ "ener_type='"+ener_type+"' AND DATEDIFF(SS,'"+start_time+"',ener_collect_time)>=0 AND "
						+ "DATEDIFF(SS,'"+end_time+"',ener_collect_time)<=0 order by ener_collect_time asc";*/
				if(timechoice.equals("0")){
					sql="with quantity as("+
                         " select a.product_num,SUM (mou_hole_num) as quantity,year(a.bat_produce_start_time) as year,month(a.bat_produce_start_time) as month,DAY(a.bat_produce_start_time)"+
                         " as day from produce_module_time_mapping as a,mou_use_inf_tab as b,mou_tab as c where a.equip_num=b.equip_num and a.mou_chan_time=b.mou_chan_time and b.mou_num=c.mou_num"+
                         " group by a.product_num,year(a.bat_produce_start_time),month(a.bat_produce_start_time),DAY(a.bat_produce_start_time)),"+
                         " infe_quantity as (select  b.product_num,COUNT(infe_time) as infe_quantity,YEAR(infe_time) as year,month(infe_time) as month,day(infe_time)as day from product_qual_stat_tab as a ,"+
                         " equip_product_relat_tab as b,equip_tab as c where a.equip_product_relat_num=b.equip_product_relat_num"+
                         " and b.equip_num=c.equip_num group by YEAR(infe_time),MONTH(infe_time),DAY(infe_time),b.product_num)"+
                         " select a.product_num,a.quantity,a.year,a.month,a.day,b.infe_quantity from quantity as a left outer join infe_quantity as b on a.product_num=b.product_num and a.year=b.year and a.month=b.month and a.day=b.day WHERE a.product_num='"+product_num+"'"+
                         " AND DATEDIFF(DD,(cast(a.year as varchar(10))+'-'+CAST(a.month as varchar(2))+'-'+CAST(a.day as varchar(2))),'"+start_time+"')<=0 and DATEDIFF(DD,(cast(a.year as varchar(10))+'-'+CAST(a.month as varchar(2))+'-'+CAST(a.day as varchar(2))),'"+end_time+"')>=0";
					
				}
				if(timechoice.equals("1")){
					sql=" with quantity as(select a.product_num,SUM (mou_hole_num) as quantity,year(a.bat_produce_start_time) as year,month(a.bat_produce_start_time)"+ 
						" as month,DAY(a.bat_produce_start_time) as day from produce_module_time_mapping as a,mou_use_inf_tab as b,mou_tab as c where a.equip_num=b.equip_num"+ 
							" and a.mou_chan_time=b.mou_chan_time and b.mou_num=c.mou_num"+
							" and DATEDIFF(DD,a.bat_produce_start_time,'"+start_time+"')<=0 and DATEDIFF(DD,a.bat_produce_start_time,'"+end_time+"')>=0"+
							" group by a.product_num,year(a.bat_produce_start_time),month(a.bat_produce_start_time),DAY(a.bat_produce_start_time)"+
							" ),infe_quantity as (select  b.product_num,COUNT(infe_time) as infe_quantity,YEAR(infe_time) as year,month(infe_time) as month,day(infe_time)as day"+ 
							" from product_qual_stat_tab as a ,equip_product_relat_tab as b,equip_tab as c where a.equip_product_relat_num=b.equip_product_relat_num"+
							" and b.equip_num=c.equip_num and DATEDIFF(DD,infe_time,'"+start_time+"')<=0 and DATEDIFF(DD,infe_time,'"+end_time+"')>=0"+
							" group by YEAR(infe_time),MONTH(infe_time),DAY(infe_time),b.product_num)select a.product_num,SUM(a.quantity) AS quantity,"+
							" datename(week,(cast(a.year as varchar(10))+'-'+CAST(a.month as varchar(2))+'-'+CAST(a.day as varchar(2)))) as week,SUM(b.infe_quantity)"+ 
							" AS infe_quantity from quantity as a left outer join infe_quantity as b on a.product_num=b.product_num and a.year=b.year and a.month=b.month and a.day=b.day "+
							 "WHERE a.product_num='"+product_num+"'"+
							" group by a.product_num,datename(week,(cast(a.year as varchar(10))+'-'+CAST(a.month as varchar(2))+'-'+CAST(a.day as varchar(2))))";
							
				}
				
				if(timechoice.equals("2")){
					sql="with quantity as(select a.product_num,SUM (mou_hole_num) as quantity,year(a.bat_produce_start_time) as year,month(a.bat_produce_start_time) as month from produce_module_time_mapping as a,mou_use_inf_tab as b,mou_tab as c where a.equip_num=b.equip_num and"+
						 " a.mou_chan_time=b.mou_chan_time and b.mou_num=c.mou_num"+
						 " and DATEDIFF(DD,a.bat_produce_start_time,'"+start_time+"')<=0 and DATEDIFF(DD,a.bat_produce_start_time,'"+end_time+"')>=0"+
						 " group by a.product_num,year(a.bat_produce_start_time),month(a.bat_produce_start_time)),"+
						 " infe_quantity as (select  b.product_num,COUNT(infe_time) as infe_quantity,YEAR(infe_time) as year,month(infe_time) as month from product_qual_stat_tab as a ,equip_product_relat_tab as b,equip_tab as c where a.equip_product_relat_num=b.equip_product_relat_num"+
						 " and b.equip_num=c.equip_num  and  DATEDIFF(DD,infe_time,'"+start_time+"')<=0 and DATEDIFF(DD,infe_time,'"+end_time+"')>=0"+
						 " group by YEAR(infe_time),MONTH(infe_time),b.product_num)"+
						 " select a.product_num,a.quantity,a.year,a.month,b.infe_quantity from quantity as a left outer join infe_quantity as b on a.product_num=b.product_num and a.year=b.year and a.month=b.month  WHERE a.product_num='"+product_num+"'";
				}
				if(timechoice.equals("3")){
					
					sql="with quantity as(select a.product_num,SUM (mou_hole_num) as quantity,year(a.bat_produce_start_time) as year from produce_module_time_mapping as a,mou_use_inf_tab as b,mou_tab as c where a.equip_num=b.equip_num and"+
						 " a.mou_chan_time=b.mou_chan_time and b.mou_num=c.mou_num"+
						 " and DATEDIFF(DD,a.bat_produce_start_time,'"+start_time+"')<=0 and DATEDIFF(DD,a.bat_produce_start_time,'"+end_time+"')>=0"+
						 " group by a.product_num,year(a.bat_produce_start_time)),"+
						 " infe_quantity as (select  b.product_num,COUNT(infe_time) as infe_quantity,YEAR(infe_time) as year from product_qual_stat_tab as a ,equip_product_relat_tab as b,equip_tab as c where a.equip_product_relat_num=b.equip_product_relat_num"+
						 " and b.equip_num=c.equip_num and DATEDIFF(DD,infe_time,'"+start_time+"')<=0 and DATEDIFF(DD,infe_time,'"+end_time+"')>=0"+
						 " group by YEAR(infe_time),b.product_num) select a.product_num,a.quantity,a.year,b.infe_quantity from quantity as a left outer join infe_quantity as b on a.product_num=b.product_num and a.year=b.year WHERE a.product_num='"+product_num+"' ";
			
				}
				//System.out.println("3333");
				listQual_show_tab = jdbcTemplate.query(sql, new RowMapper<Qual_show_tab>() {

					@Override
					public Qual_show_tab mapRow(ResultSet rs, int rowNum) throws SQLException {
						Qual_show_tab aQual_show_tab = new Qual_show_tab();

						aQual_show_tab.setProduct_num(rs.getString("product_num"));			

						if(str.equals("0")){aQual_show_tab.setInfe_time(rs.getString("year")+"-"+rs.getString("month")+"-"+rs.getString("day"));}
						if(str.equals("1")){aQual_show_tab.setInfe_time("µÚ"+rs.getString("week")+"ÖÜ");		}
						if(str.equals("2")){aQual_show_tab.setInfe_time(rs.getString("year")+"-"+rs.getString("month"));		}
						if(str.equals("3")){aQual_show_tab.setInfe_time(rs.getString("year"));}
						
						
						System.out.println(Float.parseFloat(rs.getString("infe_quantity")));
						System.out.println(Float.parseFloat(rs.getString("quantity")));
						System.out.println(Float.parseFloat(rs.getString("infe_quantity"))/Float.parseFloat(rs.getString("quantity")));
						System.out.println(Float.parseFloat("1")-Float.parseFloat(rs.getString("infe_quantity"))/Float.parseFloat(rs.getString("quantity")));
						
						Float fpy = Float.parseFloat("1")-Float.parseFloat(rs.getString("infe_quantity"))/Float.parseFloat(rs.getString("quantity"));
						
						aQual_show_tab.setFpy_val(fpy);

						return aQual_show_tab; 
				}
				});
				
				return listQual_show_tab;
			}
	
	@Override
	public List<Product_qual_stat_tab> getByProductnum(String product_num,String start_time, String end_time) {
		String sql = "WITH infe_quantity as (select  b.product_num,COUNT(infe_time) as infe_quantity,infe_rea from product_qual_stat_tab as a ,"+
                      " equip_product_relat_tab as b,equip_tab as c where a.equip_product_relat_num=b.equip_product_relat_num"+
                      " and b.equip_num=c.equip_num and DATEDIFF(DD,infe_time,'"+start_time+"')<=0 and DATEDIFF(DD,infe_time,'"+end_time+"')>=0 and b.product_num ='"+product_num+"'"+
                      " group by b.product_num, a.infe_rea )"+ 
                      " SELECT a.product_name,b.infe_quantity,b.infe_rea from product_tab as a JOIN infe_quantity as b on a.product_num=b.product_num";
	    
                      
                      List<Product_qual_stat_tab> listProduct_qual_stat_tab = jdbcTemplate.query(sql, new RowMapper<Product_qual_stat_tab>() {

				@Override
				public Product_qual_stat_tab mapRow(ResultSet rs, int rowNum) throws SQLException {
					Product_qual_stat_tab aProduct_qual_stat_tab = new Product_qual_stat_tab();
		
					//aProduct_qual_stat_tab.setQual_stat_num(rs.getString("qual_stat_num"));
					aProduct_qual_stat_tab.setEquip_product_relat_num(rs.getString("product_name"));
					aProduct_qual_stat_tab.setInfe_rea(rs.getString("infe_rea"));
					aProduct_qual_stat_tab.setQual_stat_num(rs.getString("infe_quantity"));
					
					return aProduct_qual_stat_tab;
				}
				
			});
			
			return listProduct_qual_stat_tab;
		}
}