package net.codejava.spring.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.codejava.spring.dao.daointerface.ContactDAO;
import net.codejava.spring.dao.daointerface.Mou_use_inf_tabDAO;
import net.codejava.spring.model.Atype_use_inf_tab;
import net.codejava.spring.model.Mou_tab;
import net.codejava.spring.model.Mou_use_inf_tab;

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
public class Mou_use_inf_tabController {

	@Autowired
	private Mou_use_inf_tabDAO mou_use_inf_tabDAO;
	
	@Autowired
	private ContactDAO contactDAO;
	
	
	@RequestMapping(value="/tomou_use_inf_tab")
	public ModelAndView toMou_tab(ModelAndView model) throws IOException{
		model.setViewName("mou_use_inf_tab");
		int recordnum=contactDAO.countRecord();
		model.addObject("recordnum",recordnum+"");
		return model;
	}
	
	@RequestMapping(value="/showmou_use_inf_tab")  	
	public @ResponseBody List<Mou_use_inf_tab> allAtype_tab() throws IOException{		
	     List<Mou_use_inf_tab> allMou_use_inf_tab= mou_use_inf_tabDAO.list();
		 return allMou_use_inf_tab;
	}
	
	@RequestMapping(value="/showsomemou_use_inf_tab")  	
	public @ResponseBody List<Mou_use_inf_tab> someAtype_tab(HttpServletRequest request) throws IOException{
		String mou_num=request.getParameter("mou_num");
		System.out.println(mou_num);
		List<Mou_use_inf_tab> someMou_use_inf_tab = mou_use_inf_tabDAO.list(mou_num);		
		return someMou_use_inf_tab;
	}
	
	
	
	
	@RequestMapping(value="/editmou_use_inf_tab")  	
	public @ResponseBody String editJqGrid(HttpServletRequest request, @RequestParam(value ="mou_chan_time",required=false) @DateTimeFormat(pattern="yyyy-MM-dd") Date date) {
		Mou_use_inf_tab mou_use_inf_tab=new Mou_use_inf_tab();
		String oper=request.getParameter("oper");
		String mou_use_inf_num=request.getParameter("mou_use_inf_num");
		
		
		
		mou_use_inf_tab.setMou_use_inf_num(request.getParameter("mou_use_inf_num"));
		mou_use_inf_tab.setMou_num(request.getParameter("mou_num"));
		mou_use_inf_tab.setEquip_num(request.getParameter("equip_num"));
		mou_use_inf_tab.setMou_chan_per_num(request.getParameter("mou_chan_per_num"));
		mou_use_inf_tab.setMou_chan_time(date);
		
		
		
		System.out.println("oper:"+oper);
		
		
		 
	    //System.out.println("½øÈë0");
		if(oper != null && oper.equals("edit")){
			System.out.println("atype_use_inf_num"+mou_use_inf_tab.getMou_use_inf_num());
			System.out.println("date:"+mou_use_inf_tab.getMou_chan_time());
			
			
			
			mou_use_inf_tabDAO.saveOrUpdate(mou_use_inf_tab);   
		
			
			
		}
		else if(oper != null && oper.equals("add")){
			mou_use_inf_tabDAO.saveOrUpdate(mou_use_inf_tab);
		}
		else if(oper != null && oper.equals("del")){
			
			String[] ids=mou_use_inf_num.split(",");
			for(int i=0;i<ids.length;i++)
				mou_use_inf_tabDAO.delete(ids[i]);	
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
	
	
	
	
	
	
	@RequestMapping(value="/mou_use_inf_tab")
	public ModelAndView listMou_use_inf_tab(ModelAndView model) throws IOException{
		List<Mou_use_inf_tab> listMou_use_inf_tab = mou_use_inf_tabDAO.list();
		model.addObject("listMou_use_inf_tab", listMou_use_inf_tab);
		model.setViewName("mou_use_inf_tab");
		
		return model;
	}
	
	@RequestMapping(value = "mou_use_inf_tab/newMou_use_inf_tab", method = RequestMethod.GET)
	public ModelAndView newMou_use_inf_tab(ModelAndView model) {
		Mou_use_inf_tab newMou_use_inf_tab = new Mou_use_inf_tab();
		model.addObject("mou_use_inf_tab", newMou_use_inf_tab);
		model.setViewName("Mou_use_inf_tabForm");
		return model;
	}
	
	@RequestMapping(value = "mou_use_inf_tab/saveMou_use_inf_tab", method = RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute Mou_use_inf_tab mou_use_inf_tab) {
		mou_use_inf_tabDAO.saveOrUpdate(mou_use_inf_tab);
		return new ModelAndView("redirect:/mou_use_inf_tab");
	}
	
	@RequestMapping(value = "mou_use_inf_tab/deleteMou_use_inf_tab", method = RequestMethod.GET)
	public ModelAndView deleteMou_use_inf_tab(HttpServletRequest request) {
		String mou_use_inf_num = request.getParameter("mou_use_inf_num");
		mou_use_inf_tabDAO.delete(mou_use_inf_num);
		return new ModelAndView("redirect:/mou_use_inf_tab");
	}
	
	@RequestMapping(value = "mou_use_inf_tab/editMou_use_inf_tab", method = RequestMethod.GET)
	public ModelAndView editMou_use_inf_tab(HttpServletRequest request) {
		String mou_use_inf_num = request.getParameter("mou_use_inf_num");
		Mou_use_inf_tab mou_use_inf_tab = mou_use_inf_tabDAO.get(mou_use_inf_num);
		ModelAndView model = new ModelAndView("Mou_use_inf_tabForm");
		model.addObject("mou_use_inf_tab", mou_use_inf_tab);
		
		return model;
	}
}
