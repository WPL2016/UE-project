package net.codejava.spring.dao.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import net.codejava.spring.dao.daointerface.OEE_calcuDAO;
import net.codejava.spring.model.Equip_oper_stat_tab;
import net.codejava.spring.model.OEEData;

public class OEE_calcuDAOImpl implements  OEE_calcuDAO{
private JdbcTemplate jdbcTemplate;
	
	public OEE_calcuDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override  
	public List<OEEData> getOEEDataByQuery (String starttime,String endtime,String summarytype,String equip_num){
		String sql="";
		System.out.println(starttime+"-"+endtime+"-"+summarytype+"-"+equip_num);
		final String summarytype0=summarytype;
		if(summarytype0.equals("day") ) {System.out.println("day summary");
			sql = "with run_time as (select SUM(DATEDIFF(ss,stat_time,next_stat_time))as runtime ,year(stat_time) as year ,month(stat_time) as month , day(stat_time) as day  from oper_time_caculate where stat_name='开机' and equip_num='"+equip_num+"' GROUP BY day(stat_time),MONTH(stat_time),YEAR(stat_time)),"+
"stop_time as (select SUM(DATEDIFF(ss,stat_time,next_stat_time))as stoptime ,year(stat_time) as year ,month(stat_time) as month , day(stat_time) as day  from oper_time_caculate where stat_name='关机' and equip_num='"+equip_num+"' GROUP BY equip_num,day(stat_time),MONTH(stat_time),YEAR(stat_time)),"+
"break_time as (select SUM(DATEDIFF(ss,stat_time,next_stat_time))as breaktime ,year(stat_time) as year ,month(stat_time) as month , day(stat_time) as day  from oper_time_caculate where stat_name='停机' and equip_num='"+equip_num+"' GROUP BY equip_num,day(stat_time),MONTH(stat_time),YEAR(stat_time)),"+
"wait_time as (select SUM(DATEDIFF(ss,stat_time,next_stat_time))as waittime ,year(stat_time) as year ,month(stat_time) as month , day(stat_time) as day  from oper_time_caculate where stat_name='待机' and equip_num='"+equip_num+"' GROUP BY equip_num,day(stat_time),MONTH(stat_time),YEAR(stat_time)),"+
"product_quantity  as"+
"(select SUM (mou_hole_num) as quantity,year(a.bat_produce_start_time) as year,month(a.bat_produce_start_time) as month,DAY(a.bat_produce_start_time) as day from produce_module_time_mapping as a,mou_use_inf_tab as b,mou_tab as c where a.equip_num='"+equip_num+"' and b.equip_num='"+equip_num+"'and a.mou_chan_time=b.mou_chan_time"+
" group by year(a.bat_produce_start_time),month(a.bat_produce_start_time),DAY(a.bat_produce_start_time)),"+
"infe_quantity as "+
"(select COUNT(infe_time) as infe_quantity,YEAR(infe_time) as year,month(infe_time) as month,day(infe_time)as day from product_qual_stat_tab as a ,equip_product_relat_tab as b,equip_tab as c where a.equip_product_relat_num=b.equip_product_relat_num "+
"and b.equip_num='"+equip_num+"' and c.equip_num='"+equip_num+"' group by YEAR(infe_time),MONTH(infe_time),DAY(infe_time))"+
"select a.year,a.month,a.day ,runtime,stoptime,breaktime,waittime,quantity,infe_quantity from run_time  as a full outer join stop_time  as b on a.day=b.day and a.month=b.month and a.year=b.year full outer join break_time as c on a.day=c.day and a.month=c.month and a.year=c.year full outer join wait_time as d on a.day=d.day  and a.month=d.month and a.year=d.year full outer join product_quantity  as e on a.day=e.day and a.month=e.month and a.year=e.year  full outer join infe_quantity as f on a.day=f.day and a.month=f.month and a.year=f.year"
+ " where DATEDIFF(DD,(cast(a.year as varchar(10))+'-'+CAST(a.month as varchar(2))+'-'+CAST(a.day as varchar(2))),'"+starttime+"')<=0 and DATEDIFF(DD,(cast(a.year as varchar(10))+'-'+CAST(a.month as varchar(2))+'-'+CAST(a.day as varchar(2))),'"+endtime+"')>=0";}
		else if(summarytype0.equals("month")) sql="with run_time as (select SUM(DATEDIFF(ss,stat_time,next_stat_time))as runtime ,year(stat_time) as year ,month(stat_time) as month , day(stat_time) as day  from oper_time_caculate where stat_name='开机' and equip_num='"+equip_num+"' GROUP BY day(stat_time),MONTH(stat_time),YEAR(stat_time)),"+
				"stop_time as (select SUM(DATEDIFF(ss,stat_time,next_stat_time))as stoptime ,year(stat_time) as year ,month(stat_time) as month , day(stat_time) as day  from oper_time_caculate where stat_name='关机' and equip_num='"+equip_num+"' GROUP BY equip_num,day(stat_time),MONTH(stat_time),YEAR(stat_time)),"+
				"break_time as (select SUM(DATEDIFF(ss,stat_time,next_stat_time))as breaktime ,year(stat_time) as year ,month(stat_time) as month , day(stat_time) as day  from oper_time_caculate where stat_name='停机' and equip_num='"+equip_num+"' GROUP BY equip_num,day(stat_time),MONTH(stat_time),YEAR(stat_time)),"+
				"wait_time as (select SUM(DATEDIFF(ss,stat_time,next_stat_time))as waittime ,year(stat_time) as year ,month(stat_time) as month , day(stat_time) as day  from oper_time_caculate where stat_name='待机' and equip_num='"+equip_num+"' GROUP BY equip_num,day(stat_time),MONTH(stat_time),YEAR(stat_time)),"+
				"product_quantity  as"+
				"(select SUM (mou_hole_num) as quantity,year(a.bat_produce_start_time) as year,month(a.bat_produce_start_time) as month,DAY(a.bat_produce_start_time) as day from produce_module_time_mapping as a,mou_use_inf_tab as b,mou_tab as c where a.equip_num='"+equip_num+"' and b.equip_num='"+equip_num+"'and a.mou_chan_time=b.mou_chan_time"+
				" group by year(a.bat_produce_start_time),month(a.bat_produce_start_time),DAY(a.bat_produce_start_time)),"+
				"infe_quantity as "+
				"(select COUNT(infe_time) as infe_quantity,YEAR(infe_time) as year,month(infe_time) as month,day(infe_time)as day from product_qual_stat_tab as a ,equip_product_relat_tab as b,equip_tab as c where a.equip_product_relat_num=b.equip_product_relat_num "+
				"and b.equip_num='"+equip_num+"' and c.equip_num='"+equip_num+"' group by YEAR(infe_time),MONTH(infe_time),DAY(infe_time))"+
				"select a.year,a.month ,sum(runtime) as runtime,sum(stoptime) as stoptime,sum(breaktime) as breaktime,sum(waittime) as waittime,sum(quantity) as quantity,sum(infe_quantity) as infe_quantity from run_time  as a full outer join stop_time  as b on a.day=b.day and a.month=b.month and a.year=b.year full outer join break_time as c on a.day=c.day and a.month=c.month and a.year=c.year full outer join wait_time as d on a.day=d.day  and a.month=d.month and a.year=d.year full outer join product_quantity  as e on a.day=e.day and a.month=e.month and a.year=e.year  full outer join infe_quantity as f on a.day=f.day and a.month=f.month and a.year=f.year"
				+ " where DATEDIFF(DD,(cast(a.year as varchar(10))+'-'+CAST(a.month as varchar(2))+'-'+CAST(a.day as varchar(2))),'"+starttime+"')<=0 and DATEDIFF(DD,(cast(a.year as varchar(10))+'-'+CAST(a.month as varchar(2))+'-'+CAST(a.day as varchar(2))),'"+endtime+"')>=0 group by a.year,a.month";
		     else if(summarytype0.equals("year"))   sql="with run_time as (select SUM(DATEDIFF(ss,stat_time,next_stat_time))as runtime ,year(stat_time) as year ,month(stat_time) as month , day(stat_time) as day  from oper_time_caculate where stat_name='开机' and equip_num='"+equip_num+"' GROUP BY day(stat_time),MONTH(stat_time),YEAR(stat_time)),"+
						"stop_time as (select SUM(DATEDIFF(ss,stat_time,next_stat_time))as stoptime ,year(stat_time) as year ,month(stat_time) as month , day(stat_time) as day  from oper_time_caculate where stat_name='关机' and equip_num='"+equip_num+"' GROUP BY equip_num,day(stat_time),MONTH(stat_time),YEAR(stat_time)),"+
						"break_time as (select SUM(DATEDIFF(ss,stat_time,next_stat_time))as breaktime ,year(stat_time) as year ,month(stat_time) as month , day(stat_time) as day  from oper_time_caculate where stat_name='停机' and equip_num='"+equip_num+"' GROUP BY equip_num,day(stat_time),MONTH(stat_time),YEAR(stat_time)),"+
						"wait_time as (select SUM(DATEDIFF(ss,stat_time,next_stat_time))as waittime ,year(stat_time) as year ,month(stat_time) as month , day(stat_time) as day  from oper_time_caculate where stat_name='待机' and equip_num='"+equip_num+"' GROUP BY equip_num,day(stat_time),MONTH(stat_time),YEAR(stat_time)),"+
						"product_quantity  as"+
						"(select SUM (mou_hole_num) as quantity,year(a.bat_produce_start_time) as year,month(a.bat_produce_start_time) as month,DAY(a.bat_produce_start_time) as day from produce_module_time_mapping as a,mou_use_inf_tab as b,mou_tab as c where a.equip_num='"+equip_num+"' and b.equip_num='"+equip_num+"'and a.mou_chan_time=b.mou_chan_time"+
						" group by year(a.bat_produce_start_time),month(a.bat_produce_start_time),DAY(a.bat_produce_start_time)),"+
						"infe_quantity as "+
						"(select COUNT(infe_time) as infe_quantity,YEAR(infe_time) as year,month(infe_time) as month,day(infe_time)as day from product_qual_stat_tab as a ,equip_product_relat_tab as b,equip_tab as c where a.equip_product_relat_num=b.equip_product_relat_num "+
						"and b.equip_num='"+equip_num+"' and c.equip_num='"+equip_num+"' group by YEAR(infe_time),MONTH(infe_time),DAY(infe_time))"+
						"select a.year ,sum(runtime) as runtime,sum(stoptime) as stoptime,sum(breaktime) as breaktime,sum(waittime) as waittime,sum(quantity) as quantity,sum(infe_quantity) as infe_quantity from run_time  as a full outer join stop_time  as b on a.day=b.day and a.month=b.month and a.year=b.year full outer join break_time as c on a.day=c.day and a.month=c.month and a.year=c.year full outer join wait_time as d on a.day=d.day  and a.month=d.month and a.year=d.year full outer join product_quantity  as e on a.day=e.day and a.month=e.month and a.year=e.year  full outer join infe_quantity as f on a.day=f.day and a.month=f.month and a.year=f.year"
						+ " where DATEDIFF(DD,(cast(a.year as varchar(10))+'-'+CAST(a.month as varchar(2))+'-'+CAST(a.day as varchar(2))),'"+starttime+"')<=0 and DATEDIFF(DD,(cast(a.year as varchar(10))+'-'+CAST(a.month as varchar(2))+'-'+CAST(a.day as varchar(2))),'"+endtime+"')>=0 group by a.year";
		          else if(summarytype0.equals("week")) sql="with run_time as (select SUM(DATEDIFF(ss,stat_time,next_stat_time))as runtime ,year(stat_time) as year ,month(stat_time) as month , day(stat_time) as day  from oper_time_caculate where stat_name='开机' and equip_num='"+equip_num+"' GROUP BY day(stat_time),MONTH(stat_time),YEAR(stat_time)),"+
							"stop_time as (select SUM(DATEDIFF(ss,stat_time,next_stat_time))as stoptime ,year(stat_time) as year ,month(stat_time) as month , day(stat_time) as day  from oper_time_caculate where stat_name='关机' and equip_num='"+equip_num+"' GROUP BY equip_num,day(stat_time),MONTH(stat_time),YEAR(stat_time)),"+
							"break_time as (select SUM(DATEDIFF(ss,stat_time,next_stat_time))as breaktime ,year(stat_time) as year ,month(stat_time) as month , day(stat_time) as day  from oper_time_caculate where stat_name='停机' and equip_num='"+equip_num+"' GROUP BY equip_num,day(stat_time),MONTH(stat_time),YEAR(stat_time)),"+
							"wait_time as (select SUM(DATEDIFF(ss,stat_time,next_stat_time))as waittime ,year(stat_time) as year ,month(stat_time) as month , day(stat_time) as day  from oper_time_caculate where stat_name='待机' and equip_num='"+equip_num+"' GROUP BY equip_num,day(stat_time),MONTH(stat_time),YEAR(stat_time)),"+
							"product_quantity  as"+
							"(select SUM (mou_hole_num) as quantity,year(a.bat_produce_start_time) as year,month(a.bat_produce_start_time) as month,DAY(a.bat_produce_start_time) as day from produce_module_time_mapping as a,mou_use_inf_tab as b,mou_tab as c where a.equip_num='"+equip_num+"' and b.equip_num='"+equip_num+"'and a.mou_chan_time=b.mou_chan_time"+
							" group by year(a.bat_produce_start_time),month(a.bat_produce_start_time),DAY(a.bat_produce_start_time)),"+
							"infe_quantity as "+
							"(select COUNT(infe_time) as infe_quantity,YEAR(infe_time) as year,month(infe_time) as month,day(infe_time)as day from product_qual_stat_tab as a ,equip_product_relat_tab as b,equip_tab as c where a.equip_product_relat_num=b.equip_product_relat_num "+
							"and b.equip_num='"+equip_num+"' and c.equip_num='"+equip_num+"' group by YEAR(infe_time),MONTH(infe_time),DAY(infe_time))"+
							"select datename(week,(cast(a.year as varchar(10))+'-'+CAST(a.month as varchar(2))+'-'+CAST(a.day as varchar(2)))) as week ,sum(runtime) as runtime,sum(stoptime) as stoptime,sum(breaktime) as breaktime,sum(waittime) as waittime,sum(quantity) as quantity,sum(infe_quantity) as infe_quantity from run_time  as a full outer join stop_time  as b on a.day=b.day and a.month=b.month and a.year=b.year full outer join break_time as c on a.day=c.day and a.month=c.month and a.year=c.year full outer join wait_time as d on a.day=d.day  and a.month=d.month and a.year=d.year full outer join product_quantity  as e on a.day=e.day and a.month=e.month and a.year=e.year  full outer join infe_quantity as f on a.day=f.day and a.month=f.month and a.year=f.year"
							+ " where DATEDIFF(DD,(cast(a.year as varchar(10))+'-'+CAST(a.month as varchar(2))+'-'+CAST(a.day as varchar(2))),'"+starttime+"')<=0 and DATEDIFF(DD,(cast(a.year as varchar(10))+'-'+CAST(a.month as varchar(2))+'-'+CAST(a.day as varchar(2))),'"+endtime+"')>=0 group by datename(week,(cast(a.year as varchar(10))+'-'+CAST(a.month as varchar(2))+'-'+CAST(a.day as varchar(2))))";
		
		
		List<OEEData> listOEEData = jdbcTemplate.query(sql, new RowMapper<OEEData>() {

							@Override
							public OEEData mapRow(ResultSet rs, int rowNum) throws SQLException {
								OEEData aOEEData = new OEEData();
								//aOEEData.setPassrate(rs.getFloat("passrate"));
								aOEEData.setRuntime(rs.getInt("runtime"));
								System.out.println("运行时间"+rs.getInt("runtime"));
								aOEEData.setWaittime(rs.getInt("waittime"));
								aOEEData.setBreaktime(rs.getInt("breaktime"));
								aOEEData.setStoptime(rs.getInt("stoptime"));
								aOEEData.setQuantity(rs.getInt("quantity"));
								aOEEData.setInfe_quantity(rs.getInt("infe_quantity"));
								if(summarytype0.equals("day")) aOEEData.setStartdate(rs.getString("year")+"-"+rs.getString("month")+"-"+rs.getString("day"));
								else if (summarytype0.equals("month")) aOEEData.setStartdate(rs.getString("year")+"-"+rs.getString("month"));
								else if(summarytype0.equals("year")) aOEEData.setStartdate(rs.getString("year"));
							     	else if(summarytype0.equals("week")) aOEEData.setStartdate("第"+rs.getString("week")+"周");
								System.out.println("日期"+aOEEData.getStartdate());
								aOEEData.setPassrate(1-(float)aOEEData.getInfe_quantity()/(float)aOEEData.getQuantity());
								int totaltime=aOEEData.getRuntime()+aOEEData.getBreaktime()+aOEEData.getStoptime()+aOEEData.getWaittime();
								float timeutility=(float)(aOEEData.getRuntime()+aOEEData.getStoptime()+aOEEData.getWaittime())/(float)totaltime;
								float performance=(float)(aOEEData.getRuntime()+aOEEData.getStoptime())/(float)(aOEEData.getRuntime()+aOEEData.getStoptime()+aOEEData.getWaittime());
								aOEEData.setOeerate(timeutility*performance*aOEEData.getPassrate());
								//aOEEData.setOEERate(rs.getFloat("OEErate"));
								//aOEEData.setStartdate(rs.getDate("startdate"));
								//aOEEData.setEnddate(rs.getDate("enddate"));
								//aOEEData.setPassrate(aOEEData.getInfe_quantity()/aOEEData.getQuantity());
								return aOEEData;
							}	});
	                    return listOEEData;
	}
	
}
