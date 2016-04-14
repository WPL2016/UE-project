package net.codejava.spring.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.spring.dao.daointerface.AuthorsDAO;
import net.codejava.spring.dao.daointerface.ContactDAO;
import net.codejava.spring.dao.daointerface.Role_AuthorsDAO;
import net.codejava.spring.dao.daointerface.RolesDAO;
import net.codejava.spring.dao.daointerface.User_RolesDAO;
import net.codejava.spring.dao.daointerface.User_role_applyDAO;
import net.codejava.spring.dao.daointerface.UsersDAO;
import net.codejava.spring.model.Authors;
import net.codejava.spring.model.Role_Authors;
import net.codejava.spring.model.Roles;
import net.codejava.spring.model.User_Roles;
import net.codejava.spring.model.User_role_apply;
import net.codejava.spring.model.Users;


@Controller
public class AuthorityTestController {
	
	@Autowired
	private ContactDAO contactDAO;
	@Autowired
	private UsersDAO usersDAO;
	@Autowired
	private RolesDAO rolesDAO;
	@Autowired
	private User_RolesDAO user_rolesDAO;
	@Autowired
	private AuthorsDAO authorsDAO;
	@Autowired
	private Role_AuthorsDAO role_authorsDAO;
	@Autowired
	private User_role_applyDAO user_role_applyDAO ;
	
	@RequestMapping(value="/toauthority")
	public ModelAndView toAuthority() {		
		ModelAndView model=new ModelAndView();		
		model.setViewName("authority");		
		return model;
	}
	
	@RequestMapping(value="/admin/admintest")
	public   ModelAndView adminTest(){
		ModelAndView model=new ModelAndView();
		model.setViewName("sucess");
		int recordnum=contactDAO.countRecord();
		model.addObject("recordnum",recordnum+"");
		return model;
	}
	
	
	@RequestMapping(value="/user/usertest")
	public ModelAndView userTest(){
		ModelAndView model=new ModelAndView();
		model.setViewName("sucess");
		int recordnum=contactDAO.countRecord();
		model.addObject("recordnum",recordnum+"");
		return model;
	}
	@RequestMapping(value="/engineer/engineertest")
	public ModelAndView engineerTest(){
		ModelAndView model=new ModelAndView();
		model.setViewName("sucess");	
		int recordnum=contactDAO.countRecord();
		model.addObject("recordnum",recordnum+"");
		return model;
	}
	
	
	
	
	
	
	@RequestMapping(value="/useroradmin/firsttest")
	public ModelAndView userOrAdmin(){
		ModelAndView model=new ModelAndView();
		model.setViewName("sucess");
		int recordnum=contactDAO.countRecord();
		model.addObject("recordnum",recordnum+"");
		return model;
	}

	@RequestMapping(value="/userandadmin/firsttest")
	public ModelAndView userAndAdmin(){
		ModelAndView model=new ModelAndView();
		model.setViewName("sucess");
		int recordnum=contactDAO.countRecord();
		model.addObject("recordnum",recordnum+"");
		return model;
	}
	
	@RequestMapping(value="toasignrole")
	public ModelAndView totoasignrole() {		
		ModelAndView model=new ModelAndView();		
		List<Users> users=usersDAO.list();
		model.setViewName("asignrole");	
		model.addObject("users",users);
		return model;
	}

	@RequestMapping(value="/toedituserrole")
	public ModelAndView toEditUserroles(HttpServletRequest request) {		
		ModelAndView model=new ModelAndView();	
		String username=request.getParameter("username");
		List<Roles> roles=rolesDAO.list(username);
		List<Roles> noroles=rolesDAO.listWithout(username);
		model.setViewName("user_roles");	
		model.addObject("roles",roles);
		model.addObject("noroles",noroles);
		model.addObject("username",username);
		return model;
	}
	
	@RequestMapping(value="/toassignauthors")
	public ModelAndView toAuthorRole(HttpServletRequest request) {		
		ModelAndView model=new ModelAndView();			
		List<Roles> roles=rolesDAO.list();	
		model.setViewName("assignauthors");	
		model.addObject("roles",roles);
		return model;
	}
	
	@RequestMapping(value="/frozenuser")
	public  ModelAndView  frozenUser(HttpServletRequest request,HttpServletResponse response) throws IOException{		
		String username=request.getParameter("username");
	
		if(usersDAO.frozen(username)==1){
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.println("<script language='javascript'>alert('冻结成功，该用户已无法登陆！');window.location.href='toasignrole'</script>");
		   return null;
		}
		else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.println("<script language='javascript'>alert('冻结失败，请重新尝试！');window.location.href='toasignrole'</script>");
			return  null;
		}
	}
	
	@RequestMapping(value="/unfrozenuser")
	public  ModelAndView  unFrozenUser(HttpServletRequest request,HttpServletResponse response) throws IOException{		
		String username=request.getParameter("username");
	
		if(usersDAO.unfrozen(username)==1){
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.println("<script language='javascript'>alert('解冻成功，该用户可以登陆！');window.location.href='toasignrole'</script>");
		   return null;
		}
		else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.println("<script language='javascript'>alert('解冻失败，请重新尝试！');window.location.href='toasignrole'</script>");
			return  null;
		}
	}
	
	@RequestMapping(value="/edituserrole")
	public @ResponseBody String editUserroles(HttpServletRequest request) throws IOException{		
		String roles=request.getParameter("roles");
		String username=request.getParameter("username");
		System.out.println(roles+""+username);
		String[] role=roles.split(",");
		user_rolesDAO.delete(username);
		User_Roles user_roles=new User_Roles();
		user_roles.setUsername(username);
		for(int i=0;i<role.length;i++){
		    user_roles.setRole_id(Integer.parseInt(role[i]));
			user_rolesDAO.save(user_roles);	
	}
		return "done";
	}
	
	@RequestMapping(value="/toeditroleauthors")
	public ModelAndView toEditRoleAuthors(HttpServletRequest request) {		
		ModelAndView model=new ModelAndView();	
		String role_ids=request.getParameter("role_id");
		int role_id;
		if(role_ids!=null) {
	    role_id=Integer.parseInt(role_ids);		
		List<Authors> authors=authorsDAO.list(role_id);
		List<Authors> noauthors=authorsDAO.listWithout(role_id);		
		model.addObject("authors",authors);
		model.addObject("noauthors",noauthors);
		model.addObject("role_id",role_ids);
		}		
		model.setViewName("role_authors");	
		return model;
	}
	
	@RequestMapping(value="/editroleauthor")
	public @ResponseBody String editRoleAuthors(HttpServletRequest request) throws IOException{		
		String role_id=request.getParameter("role_id");
		String authors =request.getParameter("authors");
		System.out.println(role_id+"===="+authors);
		String[] author=authors.split(",");
		role_authorsDAO.delete(role_id);
		System.out.println(role_id+"1111"+authors);
		Role_Authors role_authors=new Role_Authors();
		role_authors.setRole_id(Integer.parseInt(role_id));
		for(int i=0;i<author.length;i++){
			System.out.println(role_id+""+i+authors);
		    role_authors.setAuthor_id((Integer.parseInt(author[i])));
			role_authorsDAO.save(role_authors);	
	}
		return "done";
	}
	
	@RequestMapping(value="/addrole")
	public ModelAndView  addRole(HttpServletRequest request,HttpServletResponse response) throws IOException{		
		String role_name=request.getParameter("role_name");
		String role_type=request.getParameter("role_type");
		//System.out.println(role_name+"类型： "+role_type);
		Roles roles=new Roles();
		roles.setRole_name(role_name);
		roles.setRole_type(role_type);
		if(rolesDAO.role_nameExist(roles)==0){
			rolesDAO.save(roles);
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.println("<script language='javascript'>alert('创建角色成功！');window.location.href='toassignauthors'</script>");
		   return null;
		}
		else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.println("<script language='javascript'>alert('该角色名已存在,请重新填写！');window.location.href='toassignauthors'</script>");
			return  null;
		}
	
	

	}
	
	@RequestMapping(value="/deleterole")
	public ModelAndView  deleteRole(HttpServletRequest request,HttpServletResponse response) throws IOException{		
		String role_id=request.getParameter("role_id");
		System.out.println(role_id);
	
		
	
			if(rolesDAO.delete(role_id)!=0){
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out=response.getWriter();
				out.println("<script language='javascript'>alert('删除成功！');window.location.href='toassignauthors'</script>");
				return  null;
			}
			else{
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out=response.getWriter();
				out.println("<script language='javascript'>alert('删除失败，该角色被用户和权限表依赖，请先删除该角色的依赖！');window.location.href='toassignauthors'</script>");
				return  null;	
			}
            

	}
	
	
	@RequestMapping(value="/toapplyuserrole")
	public ModelAndView  ToApplyUserRole(HttpServletRequest request) throws IOException{		
        ModelAndView model=new ModelAndView();	
        model.setViewName("applyuserrole");
        return model;
	}
	
	
	@RequestMapping(value="/applyuserrole")
	public ModelAndView  applyUserRole(HttpServletRequest request,HttpServletResponse response) throws IOException{		
		String apply_role_type=request.getParameter("role_type");
		System.out.println(apply_role_type);
		Date date=new Date();
		User_role_apply user_role_apply=new User_role_apply();
		user_role_apply.setApply_role_type(apply_role_type);
		user_role_apply.setApply_flag(1);
		user_role_apply.setUsername(request.getUserPrincipal().getName());
		user_role_apply.setLast_modify_user(request.getUserPrincipal().getName());
		user_role_apply.setLast_modify_date(date);
		user_role_applyDAO.save(user_role_apply);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.println("<script language='javascript'>alert('申请成功！');window.location.href='toapplyuserrole'</script>");
		return  null;
	
		
	    
		
	}
	
	@RequestMapping(value="/toviewapply")
	public ModelAndView  toViewApply() throws IOException{		
	List<User_role_apply> user_role_apply=user_role_applyDAO.listOfFlag(1);
	ModelAndView model=new ModelAndView();
	model.addObject("user_role_apply",user_role_apply);
	model.setViewName("viewapply");
    return model;	
    	
	}
	
	
}
	

