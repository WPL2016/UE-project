package net.codejava.spring.controller;

 

 
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;  
  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.spring.dao.daointerface.ContactDAO;
import net.codejava.spring.model.Contact;  
@Controller  

public class AjaxController {  
	@Autowired
	private ContactDAO contactDAO;
	
	
	@RequestMapping(value="/toajax")
	public ModelAndView listContact(ModelAndView model) throws IOException{
		
		model.setViewName("ajaxtest");
		
		return model;
	}
	
   @RequestMapping(value="/ajaxlogin")  
   public @ResponseBody List<Map> ajaxlogin(HttpServletRequest request,HttpServletResponse response) throws IOException{  
        System.out.println(request.getParameter("name"));  
        Map<String,Object> map = new HashMap<String,Object>();  
        Map<String,Object> map2 = new HashMap<String,Object>();
        List<Map> list = new ArrayList<Map>();  
       if(request.getParameter("name").equals("123")){  
          
            map.put("msg", "成功");  
            map.put("first", "成功");
            map.put("second", "成功");   
            map2.put("msg", "2");  
            map2.put("first", "3");
            map2.put("second", "4");  
       //     map.put("third", "成功");
            list.add(map);
            list.add(map2);
        }else{  
            System.out.println("失败");  
            map.put("msg", "失败");
            map.put("msg", "失败");
            list.add(map);
            list.add(map2);
       }  
        return list;  
    }  
   
   @RequestMapping(value="/autoajax")
	public @ResponseBody List<Contact> allContact() throws IOException{
		List<Contact> allContact = contactDAO.list();
	
		
		return allContact;
	}
	
     
}  

	
