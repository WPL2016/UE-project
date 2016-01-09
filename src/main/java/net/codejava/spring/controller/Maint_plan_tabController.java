package net.codejava.spring.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.codejava.spring.dao.daointerface.ContactDAO;
import net.codejava.spring.dao.daointerface.Maint_plan_tabDAO;
import net.codejava.spring.model.Maint_plan_tab;
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
public class Maint_plan_tabController {

	@Autowired
	private Maint_plan_tabDAO maint_plan_tabDAO;
	@Autowired
	private ContactDAO contactDAO;
	
	@RequestMapping(value="/tomaintenance")
	public ModelAndView toMaint_plan_tab(ModelAndView model) throws IOException{
		
		int recordnum=contactDAO.countRecord();
		model.addObject("recordnum",recordnum+"");
		model.setViewName("maintenance");
		return model;
	}
	
	@RequestMapping(value="/showmaint_plan_tab")  	
	public @ResponseBody List<Maint_plan_tab> allEquip_tab(HttpServletRequest request) throws IOException{

		List<Maint_plan_tab> allMaint_plan_tab = maint_plan_tabDAO.list();		
		return allMaint_plan_tab;
	}
	
	@RequestMapping(value="/showsomemaint_plan_tab")  	
	public @ResponseBody List<Maint_plan_tab> someEquip_tab(HttpServletRequest request) throws IOException{
		String equip_num=request.getParameter("equip_num");
		System.out.println(equip_num);
		List<Maint_plan_tab> someMaint_plan_tab = maint_plan_tabDAO.list(equip_num);		
		return someMaint_plan_tab;
	}

	@RequestMapping(value="/editmaint_plan_tab")  	
	public @ResponseBody String editJqGrid(HttpServletRequest request, @RequestParam(value ="maint_plan_date",required=false) @DateTimeFormat(pattern="yyyy-MM-dd") Date date) {
		Maint_plan_tab maint_plan_tab=new Maint_plan_tab();
		String oper=request.getParameter("oper");
		String maint_plan_num=request.getParameter("maint_plan_num");
		
		
		
		maint_plan_tab.setMaint_plan_num(request.getParameter("maint_plan_num"));
		maint_plan_tab.setMaint_plan_obj_num(request.getParameter("maint_plan_obj_num"));
		
			

	
		maint_plan_tab.setMaint_plan_date(date);
		maint_plan_tab.setMaint_plan_per_num(request.getParameter("maint_plan_per_num"));
		maint_plan_tab.setMaint_plan_cont(request.getParameter("maint_plan_cont"));
		//if(request.getParameter("chan_quan")!=null){
		//atype_use_inf_tab.setChan_quan(Integer.parseUnsignedInt(request.getParameter("chan_quan")));}
			
		
		System.out.println("oper:"+oper);
		
		
		 
	    //System.out.println("½øÈë0");
		if(oper != null && oper.equals("edit")){
			System.out.println("maint_plan_num"+maint_plan_tab.getMaint_plan_num());
			System.out.println("date:"+maint_plan_tab.getMaint_plan_date());
			
			
			
			maint_plan_tabDAO.saveOrUpdate(maint_plan_tab);   
			System.out.println("after search:"+maint_plan_tab.getMaint_plan_obj_num());
			
			
		}
		else if(oper != null && oper.equals("add")){
			maint_plan_tabDAO.saveOrUpdate(maint_plan_tab);
		}
		else if(oper != null && oper.equals("del")){
			
			String[] ids=maint_plan_num.split(",");
			for(int i=0;i<ids.length;i++)
				maint_plan_tabDAO.delete(ids[i]);	
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
	
	

	@RequestMapping(value="/maint_plan_tab")
	public ModelAndView listMaint_plan_tab(ModelAndView model) throws IOException{
		List<Maint_plan_tab> listMaint_plan_tab = maint_plan_tabDAO.list();
		model.addObject("listMaint_plan_tab", listMaint_plan_tab);
		model.setViewName("maint_plan_tab");
		
		return model;
	}
	
	@RequestMapping(value = "maint_plan_tab/newMaint_plan_tab", method = RequestMethod.GET)
	public ModelAndView newEquip_tab(ModelAndView model) {
		Maint_plan_tab newMaint_plan_tab = new Maint_plan_tab();
		model.addObject("maint_plan_tab", newMaint_plan_tab);
		model.setViewName("Maint_plan_tabForm");
		return model;
	}
	
	@RequestMapping(value = "maint_plan_tab/saveMaint_plan_tab", method = RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute Maint_plan_tab maint_plan_tab) {
		maint_plan_tabDAO.saveOrUpdate(maint_plan_tab);
		return new ModelAndView("redirect:/maint_plan_tab");
	}
	
	@RequestMapping(value = "maint_plan_tab/deleteMaint_plan_tab", method = RequestMethod.GET)
	public ModelAndView deleteEquip_tab(HttpServletRequest request) {
		String maint_plan_num = request.getParameter("maint_plan_num");
		maint_plan_tabDAO.delete(maint_plan_num);
		return new ModelAndView("redirect:/maint_plan_tab");
	}
	
	@RequestMapping(value = "maint_plan_tab/editMaint_plan_tab", method = RequestMethod.GET)
	public ModelAndView editEquip_tab(HttpServletRequest request) {
		String maint_plan_num = request.getParameter("maint_plan_num");
		Maint_plan_tab maint_plan_tab = maint_plan_tabDAO.get(maint_plan_num);
		ModelAndView model = new ModelAndView("Maint_plan_tabForm");
		model.addObject("maint_plan_tab", maint_plan_tab);
		
		return model;
	}
}

