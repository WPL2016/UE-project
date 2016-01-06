
package net.codejava.spring.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.codejava.spring.dao.daointerface.Atype_tabDAO;
import net.codejava.spring.dao.daointerface.ContactDAO;
import net.codejava.spring.model.Atype_tab;
import net.codejava.spring.model.Atype_use_inf_tab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * This controller routes accesses to the application to the appropriate
 * hanlder methods. 

 *
 */
@Controller
public class Atype_tabController {

	@Autowired
	private Atype_tabDAO atype_tabDAO;
	@Autowired
	private ContactDAO contactDAO;
	
	@RequestMapping(value="/toatype_tab")
	public ModelAndView toAtype_use_inf_tab(ModelAndView model) throws IOException{
	
		int recordnum=contactDAO.countRecord();		
		model.addObject("recordnum",recordnum+"");		
		model.setViewName("atype_tab");		
		return model;
	}
	
	
	@RequestMapping(value="/editatype_tab")  	
	public @ResponseBody String editJqGrid(HttpServletRequest request) {
		Atype_tab atype_tab=new Atype_tab();
		String oper=request.getParameter("oper");
		String atype_num=request.getParameter("atype_num");
		
		
		
		
		atype_tab.setAtype_num(request.getParameter("atype_num"));
		
			

	
		
		atype_tab.setAtype_name(request.getParameter("atype_name"));
		atype_tab.setAtype_recorder_num(request.getParameter("atype_recorder_num"));
		
	
		atype_tab.setAtype_sup(request.getParameter("atype_sup"));
		
		
		System.out.println("oper:"+oper);
		
		
		 
	    //System.out.println("½øÈë0");
		if(oper != null && oper.equals("edit")){
			//System.out.println("atype_use_inf_num"+atype_use_inf_tab.getAtype_use_inf_num());
		//	System.out.println("date:"+atype_use_inf_tab.getChan_date());
			
			
			
			atype_tabDAO.saveOrUpdate(atype_tab);   
			
			
			
		}
		else if(oper != null && oper.equals("add")){
			atype_tabDAO.saveOrUpdate(atype_tab);
		}
		else if(oper != null && oper.equals("del")){
			
			String[] ids=atype_num.split(",");
			for(int i=0;i<ids.length;i++)
				atype_tabDAO.delete(ids[i]);	
		}
		/*else if(oper != null && oper.equals("batch_edit")){
			String[] ids=atype_use_inf_num.split(",");
			String column_name=request.getParameter("column_name");
			System.out.println("column_name:"+column_name);
			String column_value=request.getParameter("column_value");
			System.out.println("column_value:"+column_value);
			for(int i=0;i<ids.length;i++)
				  {atype_use_inf_tabDAO.setEquip_num(ids[i]);
			      System.out.println("update:"+ids[i]);
			  
			      System.out.println("update:"+equip_tab.getEquip_num());
			      atype_use_inf_tabDAO.updateSingleColumn(atype_use_inf_num,column_name,column_value);	
				  }
		     }*/
		return "done";
	}
	
	
	
	
	@RequestMapping(value="/showeatype_tab")  	
	public @ResponseBody List<Atype_tab> allAtype_tab() throws IOException{
		List<Atype_tab> allAtype_tab = atype_tabDAO.list();		
		return allAtype_tab;
	}
	
	
	
	@RequestMapping(value="/atype_tab")
	public ModelAndView listAtype_tab(ModelAndView model) throws IOException{
		List<Atype_tab> listAtype_tab = atype_tabDAO.list();
		model.addObject("listAtype_tab", listAtype_tab);
		model.setViewName("atype_tab");
		
		return model;
	}
	
	@RequestMapping(value = "atype_tab/newAtype_tab", method = RequestMethod.GET)
	public ModelAndView newAtype_tab(ModelAndView model) {
		Atype_tab newAtype_tab = new Atype_tab();
		model.addObject("atype_tab", newAtype_tab);
		model.setViewName("Atype_tabForm");
		return model;
	}
	
	@RequestMapping(value = "atype_tab/saveAtype_tab", method = RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute Atype_tab atype_tab) {
		atype_tabDAO.saveOrUpdate(atype_tab);
		return new ModelAndView("redirect:/atype_tab");
	}
	
	@RequestMapping(value = "atype_tab/deleteAtype_tab", method = RequestMethod.GET)
	public ModelAndView deleteAtype_tab(HttpServletRequest request) {
		String atype_num = request.getParameter("atype_num");
		atype_tabDAO.delete(atype_num);
		return new ModelAndView("redirect:/atype_tab");
	}
	
	@RequestMapping(value = "atype_tab/editAtype_tab", method = RequestMethod.GET)
	public ModelAndView editAtype_tab(HttpServletRequest request) {
		String atype_num = request.getParameter("atype_num");
		Atype_tab atype_tab = atype_tabDAO.get(atype_num);
		ModelAndView model = new ModelAndView("Atype_tabForm");
		model.addObject("atype_tab", atype_tab);
		
		return model;
	}
}

