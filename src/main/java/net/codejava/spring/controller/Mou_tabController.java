package net.codejava.spring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.codejava.spring.dao.daointerface.ContactDAO;
import net.codejava.spring.dao.daointerface.Mou_tabDAO;
import net.codejava.spring.model.Atype_tab;
import net.codejava.spring.model.Mou_tab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * This controller routes accesses to the application to the appropriate
 * hanlder methods. 

 *
 */
@Controller
public class Mou_tabController {

	@Autowired
	private Mou_tabDAO mou_tabDAO;
	@Autowired
	private ContactDAO contactDAO;
	
	
	@RequestMapping(value="/tomou_tab")
	public ModelAndView toMou_tab(ModelAndView model) throws IOException{
		model.setViewName("mou_tab");
		int recordnum=contactDAO.countRecord();
		model.addObject("recordnum",recordnum+"");
		return model;
	}
	
	
	@RequestMapping(value="/showemou_tab")  	
	public @ResponseBody List<Mou_tab> allAtype_tab() throws IOException{
		List<Mou_tab> allMou_tab = mou_tabDAO.list();		
		return allMou_tab;
	}
	
	@RequestMapping(value="/editmou_tab")  	
	public @ResponseBody String editJqGrid(HttpServletRequest request) {
		Mou_tab mou_tab=new Mou_tab();
		String oper=request.getParameter("oper");
		String mou_num=request.getParameter("mou_num");
		
		
		
		
		mou_tab.setMou_num(request.getParameter("mou_num"));
		mou_tab.setMou_name(request.getParameter("mou_name"));
		if(request.getParameter("mou_hole_num")!=null)
		  mou_tab.setMou_hole_num(Integer.parseInt(request.getParameter("mou_hole_num")));
		mou_tab.setMou_recorder_num(request.getUserPrincipal().getName());
		mou_tab.setMou_sup(request.getParameter("mou_sup"));
		mou_tab.setProduct_num(request.getParameter("product_num"));
			
		
		
		System.out.println("oper:"+oper);
		
		
		 
	    //System.out.println("½øÈë0");
		if(oper != null && oper.equals("edit")){
			//System.out.println("atype_use_inf_num"+atype_use_inf_tab.getAtype_use_inf_num());
		//	System.out.println("date:"+atype_use_inf_tab.getChan_date());
			
			
			
			mou_tabDAO.saveOrUpdate(mou_tab);   
			
			
			
		}
		else if(oper != null && oper.equals("add")){
			mou_tabDAO.saveOrUpdate(mou_tab);
		}
		else if(oper != null && oper.equals("del")){
			System.out.println("deleting..."+mou_num);
			String[] ids=mou_num.split(",");
			for(int i=0;i<ids.length;i++)
				mou_tabDAO.delete(ids[i]);	
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
	
	
	
	
	
	
	
	
	@RequestMapping(value="/mou_tab")
	public ModelAndView listMou_tab(ModelAndView model) throws IOException{
		List<Mou_tab> listMou_tab = mou_tabDAO.list();
		model.addObject("listMou_tab", listMou_tab);
		model.setViewName("mou_tab");
		
		return model;
	}
	
	@RequestMapping(value = "mou_tab/newMou_tab", method = RequestMethod.GET)
	public ModelAndView newMou_tab(ModelAndView model) {
		Mou_tab newMou_tab = new Mou_tab();
		model.addObject("mou_tab", newMou_tab);
		model.setViewName("Mou_tabForm");
		return model;
	}
	
	@RequestMapping(value = "mou_tab/saveMou_tab", method = RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute Mou_tab mou_tab) {
		mou_tabDAO.saveOrUpdate(mou_tab);
		return new ModelAndView("redirect:/mou_tab");
	}
	
	@RequestMapping(value = "mou_tab/deleteMou_tab", method = RequestMethod.GET)
	public ModelAndView deleteMou_tab(HttpServletRequest request) {
		String mou_num = request.getParameter("mou_num");
		mou_tabDAO.delete(mou_num);
		return new ModelAndView("redirect:/mou_tab");
	}
	
	@RequestMapping(value = "mou_tab/editMou_tab", method = RequestMethod.GET)
	public ModelAndView editMou_tab(HttpServletRequest request) {
		String mou_num = request.getParameter("mou_num");
		Mou_tab mou_tab = mou_tabDAO.get(mou_num);
		ModelAndView model = new ModelAndView("Mou_tabForm");
		model.addObject("mou_tab", mou_tab);
		
		return model;
	}
}
