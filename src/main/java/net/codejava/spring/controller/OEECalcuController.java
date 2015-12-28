package net.codejava.spring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.spring.dao.daointerface.ContactDAO;
import net.codejava.spring.dao.daointerface.Equip_tabDAO;
import net.codejava.spring.dao.daointerface.OEE_calcuDAO;
import net.codejava.spring.model.Equip_tab;
import net.codejava.spring.model.OEEData;

@Controller 
public class OEECalcuController {
	@Autowired
	private OEE_calcuDAO oee_calcuDAO;

	
	@RequestMapping(value="/getoeedata")
	public @ResponseBody  List<OEEData> calculOEE(ModelAndView model,HttpServletRequest request) throws IOException{
		List<OEEData> oeedata=oee_calcuDAO.getOEEDataByQuery(request.getParameter("starttime"),request.getParameter("endtime"),request.getParameter("summarytype"),request.getParameter("equip_num"));
		System.out.println(request.getParameter("starttime")+"-"+request.getParameter("endtime")+"-"+request.getParameter("summarytype")+"-"+request.getParameter("equip_num"));
		return oeedata;
	}
}