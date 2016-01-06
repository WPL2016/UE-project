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
		                       //����Ҫ���ص��������Դд�������ʹ��.antMatchers().access()��ע�����ص�˳�򣬹��������ص���
		                       //����Ĺ���Ḳ������Ĺ��򣬶�����ȡ�����ȡ��		                       
			                   // .antMatchers("/toadmin").access("hasRole('ROLE_ADMIN')")
			                   //.antMatchers("/toadmin").access("hasRole('ROLE_ENGINEER')")
			                   //.antMatchers("/**").access("hasRole('ROLE_USER')")
			                   // .antMatchers("/**").access("hasRole('ROLE_ADMIN')")
			                   // .antMatchers("/**").access("hasRole('ROLE_ENGINEER')")
			                   //.antMatchers("/**").access("hasRole('ROLE_MANAGE')")
		           
		                       //ʹ��.antMatchers().hasRole()������Ҫע�����ݿ�����Ľ�ɫ��Ҫ��ROLE_,��ROLE_USER,������
		                       //hasRole()���治�ܼ�ROLE_,��Ϊ��ܻ��Զ��������ǰ׺�������д��hasRole("USER")������hasRole("ROLE_USER")
		                       //ע�������ظ��Ĺ�������Զ�ȡ�򣬶�����ȡ��
		                       .antMatchers("resources/**","resources/UE_chair.jpg","resources/div.css","/login","/","/toauthority").permitAll()		                       
                               .antMatchers("*.js").permitAll()
                               //�ظ��Ĺ���ȡ��ADMIN��USER����������/toadmin��
			                   .antMatchers("/toadmin").hasRole("ADMIN")
			                   //.antMatchers("/toadmin").hasRole("USER")
			                   //��ͻ�Ĺ���������������ã�����editjqgrid�����󶼷��������������ع��򣬵������������г�ͻ�����λ������Ĺ�����Ч��ADMIN���Է��ʶ�USER���ܣ�
			                   //�������˳����ֻ����USER������
			                   .antMatchers("/editequip_tab").hasRole("ADMIN")
			                   .antMatchers("/**").hasRole("USER")			                  		
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

