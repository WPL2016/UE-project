package net.codejava.spring.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.filter.CharacterEncodingFilter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


       

	@Autowired
	DataSource dataSource;
	
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		
	  auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery(
			"select username,password, enabled from users where username=?")
		.authoritiesByUsernameQuery(
			"select a.username as username,author_name as role from users as a,user_roles as b,roles as c,role_authors as d,authors as e where a.username=b.username and b.role_id=c.role_id and c.role_id =d.role_id and d.author_id =e.author_id and a.username=?");
	}	

	
	protected void configure(HttpSecurity http) throws Exception {
		
		 CharacterEncodingFilter filter = new CharacterEncodingFilter();
	        filter.setEncoding("UTF-8");
	        filter.setForceEncoding(false);
	        http.addFilterBefore(filter,CsrfFilter.class);
		     http
		           .authorizeRequests()
		                       //把需要拦截的请求和资源写在这里，若使用.antMatchers().access()请注意拦截的顺序，规则如有重叠，
		                       //上面的规则会覆盖下面的规则，而不是取与或者取或		                       
			                   // .antMatchers("/toadmin").access("hasRole('ROLE_ADMIN')")
			                   //.antMatchers("/toadmin").access("hasRole('ROLE_ENGINEER')")
			                   //.antMatchers("/**").access("hasRole('ROLE_USER')")
			                   // .antMatchers("/**").access("hasRole('ROLE_ADMIN')")
			                   // .antMatchers("/**").access("hasRole('ROLE_ENGINEER')")
			                   //.antMatchers("/**").access("hasRole('ROLE_MANAGE')")
		           
		                       //使用.antMatchers().hasRole()方法需要注意数据库里面的角色名要加ROLE_,如ROLE_USER,但是在
		                       //hasRole()里面不能加ROLE_,因为框架会自动加上这个前缀，如必须写成hasRole("USER")而不是hasRole("ROLE_USER")
		                       //注意如有重复的规则则会自动取或，而不是取与
		                       .antMatchers("/login").permitAll()		                                                    
                               .antMatchers("/resources/**" ).permitAll()
                               .antMatchers("/toregister").permitAll()
                               
                              	
                               //重复的规则取或，ADMIN和USER都可以请求“/toadmin”
			                  // .antMatchers("/toadmin").hasRole("ADMIN")
			                   //.antMatchers("/toadmin").hasRole("USER")
			                   //冲突的规则上面的先起作用，比如editjqgrid的请求都符合如下两个拦截规则，但是两个规则有冲突，因此位于上面的规则起效，ADMIN可以访问而USER不能，
			                   //如果换下顺序则只能由USER来访问
			                  // .antMatchers("/editequip_tab").hasRole("ADMIN")
			                   .antMatchers("/editatype_tab").hasRole("editatype_tab")
			                   .antMatchers("/showeatype_tab").hasRole("showeatype_tab")
			                   .antMatchers("/showeatype_use_inf_tab","/showsomeeatype_use_inf_tab").hasRole("showeatype_use_inf_tab")
			                   .antMatchers("/editatype_use_inf_tab").hasRole("editatype_use_inf_tab")
			                   .antMatchers("/toasignrole","/toedituserrole","/edituserrole").hasRole("edituserrole")
			                   .antMatchers("/toassignauthors","/toeditroleauthors","/editroleauthor").hasRole("editroleauthor")
			                   .antMatchers("/addrole").hasRole("addrole")
			                   .antMatchers("/deleterole").hasRole("deleterole")
			                   .antMatchers("/energylinedata","/energypiedata","/showenergy_tab").hasRole("showenergy_tab")
			                   .antMatchers("/showequip_dyn_para_tab").hasRole("showequip_dyn_para_tab")
			                   .antMatchers("/showequip_oper_stat_tab","/todayequip_oper_stat_tab").hasRole("showequip_oper_stat_tab")
			                   .antMatchers("/showequip_para_tab").hasRole("showequip_para_tab")
			                   .antMatchers("/editequip_para_tab").hasRole("editequip_para_tab")
			                   .antMatchers("/showequip_pres_para_tab").hasRole("showequip_pres_para_tab")
			                   .antMatchers("/showequip_product_relat_tab").hasRole("showequip_product_relat_tab")
			                   .antMatchers("/editequip_product_relat_tab").hasRole("editequip_product_relat_tab")
			                   .antMatchers("/showequip_tab","/getsomeequip").hasRole("showequip_tab")
			                   .antMatchers("/editequip_tab").hasRole("editequip_tab")
			                   .antMatchers("/gaslinedata","/gaspiedata","/showgas_tab").hasRole("showgas_tab")
			                   .antMatchers("/showmaint_plan_tab","/showsomemaint_plan_tab").hasRole("showmaint_plan_tab")
			                   .antMatchers("/editmaint_plan_tab").hasRole("editmaint_plan_tab")
			                   .antMatchers("/showmaint_reg_tab","/showsomemaint_reg_tab").hasRole("showmaint_reg_tab")
			                   .antMatchers("/editmaint_reg_tab").hasRole("editmaint_reg_tab")
			                   .antMatchers("/showmater_pur_tab").hasRole("showmater_pur_tab")
			                   .antMatchers("/editmater_pur_tab").hasRole("editmater_pur_tab")
			                   .antMatchers("/showmater_stock_stat_tab","/showsomemater_stock_stat_tab").hasRole("showmater_stock_stat_tab")
			                   .antMatchers("/showmater_tab").hasRole("showmater_tab")
			                   .antMatchers("/editmater_tab").hasRole("editmater_tab")
			                   .antMatchers("/showmater_use_stock_tab","/showsomemater_use_stock_tab").hasRole("showmater_use_stock_tab")
			                   .antMatchers("/getoeedata").hasRole("getoeedata")
			                   .antMatchers("/showproduce_plan_tab").hasRole("showproduce_plan_tab")
			                   .antMatchers("/editproduce_plan_tab").hasRole("editproduce_plan_tab")
			                   .antMatchers("/showproduce_static_tab","/showsomeproduce_static_tab").hasRole("showproduce_static_tab")
			                   .antMatchers("/showproduct_qual_asse_tab","/getsomeproduct").hasRole("showproduct_qual_asse_tab")
			                   .antMatchers("/editproduct_qual_asse_tab").hasRole("editproduct_qual_asse_tab")
			                   .antMatchers("/qualitylinedata","/qualitypiedata","/showproduct_qual_stat_tab").hasRole("showproduct_qual_stat_tab")
			                   .antMatchers("/showproduct_tab").hasRole("showproduct_tab")
			                   .antMatchers("/editproduct_tab").hasRole("editproduct_tab")
				               .anyRequest().authenticated()
				.and()				
			.formLogin().loginPage("/login").permitAll()   
			 .usernameParameter("username").passwordParameter("password")
				.and()
				.logout()                                                              
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/").                                           
				and()                              
			.httpBasic();
	}
}

