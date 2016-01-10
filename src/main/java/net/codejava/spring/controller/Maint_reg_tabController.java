package net.codejava.spring.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.codejava.spring.dao.daointerface.ContactDAO;
import net.codejava.spring.dao.daointerface.Maint_reg_tabDAO;
import net.codejava.spring.model.Maint_reg_tab;
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
public class Maint_reg_tabController {

	@Autowired
	private Maint_reg_tabDAO maint_reg_tabDAO;
	
	@Autowired
	private ContactDAO contactDAO;
	
	
	@RequestMapping(value="/tomaint_reg")
	public ModelAndView toMaint_plan_tab(ModelAndView model) throws IOException{
		model.setViewName("maint_reg");
		int recordnum=contactDAO.countRecord();
		model.addObject("recordnum",recordnum+"");
		return model;
	}
	
	@RequestMapping(value="/showmaint_reg_tab")  	
	public @ResponseBody List<Maint_reg_tab> allMaint_reg_tab() throws IOException{		
	     List<Maint_reg_tab> allMaint_reg_tab= maint_reg_tabDAO.list();
		 return allMaint_reg_tab;
	}
	
	@RequestMapping(value="/showsomemaint_reg_tab")  	
	public @ResponseBody List<Maint_reg_tab> someMaint_plan_tab(HttpServletRequest request) throws IOException{
		String maint_plan_num=request.getParameter("maint_plan_num");
		//System.out.println(mou_num);
		List<Maint_reg_tab> someMaint_reg_tab = maint_reg_tabDAO.list(maint_plan_num);		
		return someMaint_reg_tab;
	}
	
	
	
	
	@RequestMapping(value="/editmaint_reg_tab")  	
	public @ResponseBody String editJqGrid(HttpServletRequest request, @RequestParam(value ="maint_reg_date",required=false) @DateTimeFormat(pattern="yyyy-MM-dd") Date date) {
		Maint_reg_tab maint_reg_tab=new Maint_reg_tab();
		String oper=request.getParameter("oper");
		String maint_reg_num=request.getParameter("maint_reg_num");
		
		
		
		maint_reg_tab.setMaint_reg_num(request.getParameter("maint_reg_num"));
		maint_reg_tab.setMaint_plan_num(request.getParameter("maint_plan_num"));
		maint_reg_tab.setMaint_reg_cont(request.getParameter("maint_reg_cont"));	
		maint_reg_tab.setMaint_reg_date(date);
		maint_reg_tab.setMaint_reg_per_num(request.getUserPrincipal().getName());

		System.out.println("oper:"+oper);
		
		
		 
	    //System.out.println("½øÈë0");
		if(oper != null && oper.equals("edit")){
		//	System.out.println("maint_reg_tab_num"+mou_use_inf_tab.getMou_use_inf_num());
		//	System.out.println("date:"+mou_use_inf_tab.getMou_chan_time());
			
			
			
			maint_reg_tabDAO.saveOrUpdate(maint_reg_tab);   
		
			
			
		}
		else if(oper != null && oper.equals("add")){
			maint_reg_tabDAO.saveOrUpdate(maint_reg_tab);
		}
		else if(oper != null && oper.equals("del")){
			
			String[] ids=maint_reg_num.split(",");
			for(int i=0;i<ids.length;i++)
				maint_reg_tabDAO.delete(ids[i]);	
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
	
	
	
	
	
	
	@RequestMapping(value="/maint_reg_tab")
	public ModelAndView listMaint_reg_tab(ModelAndView model) throws IOException{
		List<Maint_reg_tab> listMaint_reg_tab = maint_reg_tabDAO.list();
		model.addObject("listMaint_reg_tab", listMaint_reg_tab);
		model.setViewName("maint_reg_tab");
		
		return model;
	}
	
	@RequestMapping(value = "maint_reg_tab/newMaint_reg_tab", method = RequestMethod.GET)
	public ModelAndView newMaint_reg_tab(ModelAndView model) {
		Maint_reg_tab newMaint_reg_tab = new Maint_reg_tab();
		model.addObject("maint_reg_tab", newMaint_reg_tab);
		model.setViewName("Maint_reg_tabForm");
		return model;
	}
	
	@RequestMapping(value = "maint_reg_tab/saveMaint_reg_tab", method = RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute Maint_reg_tab maint_reg_tab) {
		maint_reg_tabDAO.saveOrUpdate(maint_reg_tab);
		return new ModelAndView("redirect:/maint_reg_tab");
	}
	
	@RequestMapping(value = "maint_reg_tab/deleteMaint_reg_tab", method = RequestMethod.GET)
	public ModelAndView deleteMaint_reg_tab(HttpServletRequest request) {
		String maint_reg_num = request.getParameter("maint_reg_num");
		maint_reg_tabDAO.delete(maint_reg_num);
		return new ModelAndView("redirect:/maint_reg_tab");
	}
	
	@RequestMapping(value = "maint_reg_tab/editMaint_reg_tab", method = RequestMethod.GET)
	public ModelAndView editMaint_reg_tab(HttpServletRequest request) {
		String maint_reg_num = request.getParameter("maint_reg_num");
		Maint_reg_tab maint_reg_tab = maint_reg_tabDAO.get(maint_reg_num);
		ModelAndView model = new ModelAndView("Maint_reg_tabForm");
		model.addObject("maint_reg_tab", maint_reg_tab);
		
		return model;
	}
}
