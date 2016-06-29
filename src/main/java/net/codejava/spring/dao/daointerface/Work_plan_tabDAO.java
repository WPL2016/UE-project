package net.codejava.spring.dao.daointerface;

import java.util.Date;
import java.util.List;

import net.codejava.spring.model.Equip_tab;
import net.codejava.spring.model.Produce_plan_exe_stat_tab;
import net.codejava.spring.model.Work_plan_tab;



public interface Work_plan_tabDAO {
	
	public void update(Work_plan_tab work_plan_tab);
	
	public void add(Work_plan_tab work_plan_tab);
	
	public void delete(String work_plan_num);
	
	public Work_plan_tab get(String work_plan_num);
	
	public List<Work_plan_tab> list(String day_plan_num,String plan_status_type);
	
	public List<Equip_tab> getUsableEquip(String day_plan_num);
	//根据日生产计划编号获取该日计划所对应的产品编号
	public String getProduct_num(String day_plan_num);

	//public List<Work_plan_tab> listOfOper();
  
	public int updateSingleColumn(Work_plan_tab Work_plan_tab,String column,String value);
	
	public int excuteWorkPlan(String work_plan_num);
	public int excuteRecord(Produce_plan_exe_stat_tab excutestat);
}
