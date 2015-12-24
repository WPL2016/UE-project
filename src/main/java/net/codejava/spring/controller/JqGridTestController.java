package net.codejava.spring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.spring.dao.daointerface.ContactDAO;
import net.codejava.spring.model.Contact;

@Controller 
public class JqGridTestController {
	@Autowired
	private ContactDAO contactDAO;
	
	
	@RequestMapping(value="/showjqgrid")  	
	public @ResponseBody List<Contact> allContact() throws IOException{
		List<Contact> allContact = contactDAO.list();		
		return allContact;
	}
	
	@RequestMapping(value="/editjqgrid")  	
	public @ResponseBody String editJqGrid(HttpServletRequest request) {
		Contact contact=new Contact();
		String oper=request.getParameter("oper");
		String id=request.getParameter("id");
		int contactId = 0;
		
		contact.setAddress(request.getParameter("address"));
		contact.setEmail(request.getParameter("email"));
		contact.setName(request.getParameter("name"));
		contact.setTelephone(request.getParameter("telephone"));
		contact.setReason(request.getParameter("reason"));
		
		System.out.println(contact.getAddress()); 
		System.out.println(id); 
		System.out.println(contact.getName()); 
		System.out.println(contact.getEmail()); 
		System.out.println(contact.getTelephone()); 
		System.out.println(contact.getReason()); 
		
		
		
		
		 System.out.println("进入0");
		if(oper != null && oper.equals("edit")){
		if((id!="")&&(id!=null)){
				contactId = Integer.parseInt(id);			
				}
		contact.setId(contactId);	
		 contactDAO.saveOrUpdate(contact);
		 System.out.println("进入1");                                               }
		else if(oper != null && oper.equals("add")){
	   contact.setId(0);
	   contactDAO.saveOrUpdate(contact);
	   System.out.println("进入2");			
		}
		else if(oper != null && oper.equals("del")){
			contactId = Integer.parseInt(request.getParameter("id"));
			 contactDAO.delete(contactId);	
			 System.out.println("进入3");	
		}
	
		return "done";
	}
	
	
}
