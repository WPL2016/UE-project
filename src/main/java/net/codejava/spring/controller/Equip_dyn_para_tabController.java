package net.codejava.spring.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.codejava.spring.dao.daointerface.ContactDAO;
import net.codejava.spring.dao.daointerface.Equip_dyn_para_tabDAO;
import net.codejava.spring.dao.daointerface.Equip_oper_stat_tabDAO;
import net.codejava.spring.model.Equip_dyn_record;
import net.codejava.spring.model.Equip_oper_stat_tab;
@Controller
public class Equip_dyn_para_tabController {
	@Autowired
	private Equip_dyn_para_tabDAO equip_dyn_para_tabDAO;
	@Autowired
	private ContactDAO contactDAO;
	@RequestMapping(value="/showequip_dyn_para_tab")  	
	public @ResponseBody List<Equip_dyn_record> allState(HttpServletRequest request) throws IOException{
		String equip_num=request.getParameter("equip_num");
		List<Equip_dyn_record> lastDynRecord = equip_dyn_para_tabDAO.getLastDynPara(equip_num);		
		return lastDynRecord;
	}
	
	

}
