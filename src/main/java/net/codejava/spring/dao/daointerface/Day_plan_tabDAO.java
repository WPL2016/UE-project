package net.codejava.spring.dao.daointerface;

import java.util.List;

import net.codejava.spring.model.Day_plan_tab;
import net.codejava.spring.model.Produce_plan_tab;


public interface Day_plan_tabDAO {
	
	public void update(Day_plan_tab day_plan_tab);
	
	public void add(Day_plan_tab day_plan_tab);
	
	public void delete(String day_plan_num);
	
	public Day_plan_tab get(String day_plan_num);
	
	//列出同时符合生产计划编号和计划状态的日生产计划记录，若参数为all则表示列出所有日生产计划
	public List<Day_plan_tab> list(String produce_plan_num,String plan_status_type);
	
	//public List<Day_plan_tab> listOfOper();
  
	public int updateSingleColumn(Day_plan_tab day_plan_tab,String column,String value);
	
	
	
}
