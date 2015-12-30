package net.codejava.spring.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.codejava.spring.dao.daointerface.Atype_use_inf_tabDAO;
import net.codejava.spring.dao.daointerface.ContactDAO;
import net.codejava.spring.model.Atype_use_inf_tab;
import net.codejava.spring.model.Equip_tab;

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
public class Atype_use_inf_tabController {

	@Autowired
	private Atype_use_inf_tabDAO atype_use_inf_tabDAO;
	@Autowired
	private ContactDAO contactDAO;
	
	
	
	@RequestMapping(value="/toatype_use_inf_tab")
	public ModelAndView toAtype_use_inf_tab(ModelAndView model) throws IOException{
	
		int recordnum=contactDAO.countRecord();		
		model.addObject("recordnum",recordnum+"");		
		model.setViewName("atype_use_inf_tab");		
		return model;
	}
	
	
	@RequestMapping(value="/showeatype_use_inf_tab")  	
	public @ResponseBody List<Atype_use_inf_tab> allAtype_tab(HttpServletRequest request) throws IOException{

		List<Atype_use_inf_tab> allAtype_use_inf_tab = atype_use_inf_tabDAO.list();		
		return allAtype_use_inf_tab;
	}
	
	@RequestMapping(value="/showsomeeatype_use_inf_tab")  	
	public @ResponseBody List<Atype_use_inf_tab> someAtype_tab(HttpServletRequest request) throws IOException{
		String atype_num=request.getParameter("atype_num");
		System.out.println(atype_num);
		List<Atype_use_inf_tab> someAtype_use_inf_tab = atype_use_inf_tabDAO.list(atype_num);		
		return someAtype_use_inf_tab;
	}
	
	@RequestMapping(value="/editatype_use_inf_tab")  	
	public @ResponseBody String editJqGrid(HttpServletRequest request, @RequestParam(value ="chan_date",required=false) @DateTimeFormat(pattern="yyyy-MM-dd") Date date) {
		Atype_use_inf_tab atype_use_inf_tab=new Atype_use_inf_tab();
		String oper=request.getParameter("oper");
		String atype_use_inf_num=request.getParameter("atype_use_inf_num");
		
		
		
		atype_use_inf_tab.setAtype_use_inf_num(request.getParameter("atype_use_inf_num"));
		atype_use_inf_tab.setAtype_num(request.getParameter("atype_num"));
		
			

	
		atype_use_inf_tab.setChan_date(date);
		atype_use_inf_tab.setChan_per_num(request.getParameter("chan_per_num"));
		atype_use_inf_tab.setEquip_num(request.getParameter("equip_num"));
		if(request.getParameter("chan_quan")!=null){
		atype_use_inf_tab.setChan_quan(Integer.parseUnsignedInt(request.getParameter("chan_quan")));}
		
		
		System.out.println("oper:"+oper);
		
		
		 
	    //System.out.println("½øÈë0");
		if(oper != null && oper.equals("edit")){
			System.out.println("atype_use_inf_num"+atype_use_inf_tab.getAtype_use_inf_num());
			System.out.println("date:"+atype_use_inf_tab.getChan_date());
			
			
			
			atype_use_inf_tabDAO.saveOrUpdate(atype_use_inf_tab);   
			System.out.println("after search:"+atype_use_inf_tab.getChan_quan());
			
			
		}
		else if(oper != null && oper.equals("add")){
			atype_use_inf_tabDAO.saveOrUpdate(atype_use_inf_tab);
		}
		else if(oper != null && oper.equals("del")){
			
			String[] ids=atype_use_inf_num.split(",");
			for(int i=0;i<ids.length;i++)
				atype_use_inf_tabDAO.delete(ids[i]);	
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
	
	

	@RequestMapping(value="/atype_use_inf_tab")
	public ModelAndView listAtype_use_inf_tab(ModelAndView model) throws IOException{
		List<Atype_use_inf_tab> listAtype_use_inf_tab = atype_use_inf_tabDAO.list();
		model.addObject("listAtype_use_inf_tab", listAtype_use_inf_tab);
		model.setViewName("atype_use_inf_tab");
		
		return model;
	}
	
	@RequestMapping(value = "atype_use_inf_tab/newAtype_use_inf_tab", method = RequestMethod.GET)
	public ModelAndView newAtype_tab(ModelAndView model) {
		Atype_use_inf_tab newAtype_use_inf_tab = new Atype_use_inf_tab();
		model.addObject("atype_use_inf_tab", newAtype_use_inf_tab);
		model.setViewName("Atype_use_inf_tabForm");
		return model;
	}
	
	@RequestMapping(value = "atype_use_inf_tab/saveAtype_use_inf_tab", method = RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute Atype_use_inf_tab atype_use_inf_tab) {
		atype_use_inf_tabDAO.saveOrUpdate(atype_use_inf_tab);
		return new ModelAndView("redirect:/atype_use_inf_tab");
	}
	
	@RequestMapping(value = "atype_use_inf_tab/deleteAtype_use_inf_tab", method = RequestMethod.GET)
	public ModelAndView deleteAtype_tab(HttpServletRequest request) {
		String atype_use_inf_num = request.getParameter("atype_use_inf_num");
		atype_use_inf_tabDAO.delete(atype_use_inf_num);
		return new ModelAndView("redirect:/atype_use_inf_tab");
	}
	
	@RequestMapping(value = "atype_use_inf_tab/editAtype_use_inf_tab", method = RequestMethod.GET)
	public ModelAndView editAtype_tab(HttpServletRequest request) {
		String atype_use_inf_num = request.getParameter("atype_use_inf_num");
		Atype_use_inf_tab atype_use_inf_tab = atype_use_inf_tabDAO.get(atype_use_inf_num);
		ModelAndView model = new ModelAndView("Atype_use_inf_tabForm");
		model.addObject("atype_use_inf_tab", atype_use_inf_tab);
		
		return model;
	}
}
