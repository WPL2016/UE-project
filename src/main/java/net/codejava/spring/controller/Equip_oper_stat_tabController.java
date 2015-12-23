package net.codejava.spring.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.spring.dao.daointerface.ContactDAO;
import net.codejava.spring.dao.daointerface.Equip_oper_stat_tabDAO;
import net.codejava.spring.model.Equip_oper_stat_tab;
import net.codejava.spring.model.Equip_tab;

@Controller 
public class Equip_oper_stat_tabController {
	@Autowired
	private Equip_oper_stat_tabDAO equip_oper_stat_tabDAO;
	@Autowired
	private ContactDAO contactDAO;
	
	
	@RequestMapping(value="/showequip_oper_stat_tab")  	
	public @ResponseBody List<Equip_oper_stat_tab> allState() throws IOException{
		List<Equip_oper_stat_tab> allEquip_tab = equip_oper_stat_tabDAO.getLastUniqueRecord();		
		return allEquip_tab;
	}
	
	@RequestMapping(value="/todayequip_oper_stat_tab")  	
	public @ResponseBody Map TodayStat() throws IOException{
    Map<String,Object> map = new HashMap<String,Object>();
    Timestamp time=new Timestamp(System.currentTimeMillis());
    int totalstarttime=equip_oper_stat_tabDAO.somedayStatTime(time, "开机");
    int totalalerttime=equip_oper_stat_tabDAO.somedayStatTime(time, "报警");
    int totalstoptime=equip_oper_stat_tabDAO.somedayStatTime(time, "停机");
    int totalwaittime=equip_oper_stat_tabDAO.somedayStatTime(time, "待机");
    map.put("totalstarttime",totalstarttime);
    map.put("totalalerttime",totalalerttime);
    map.put("totalstoptime",totalstoptime);
    map.put("totalwaittime",totalwaittime);
    return map;
	
		
	}
}
