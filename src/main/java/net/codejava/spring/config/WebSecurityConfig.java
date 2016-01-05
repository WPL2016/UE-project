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
		                       .antMatchers("resources/**","resources/UE_chair.jpg","resources/div.css","/login","/","/toauthority").permitAll()		                       
                               .antMatchers("*.js").permitAll()
                               //重复的规则取或，ADMIN和USER都可以请求“/toadmin”
			                   .antMatchers("/toadmin").hasRole("ADMIN")
			                   //.antMatchers("/toadmin").hasRole("USER")
			                   //冲突的规则上面的先起作用，比如editjqgrid的请求都符合如下两个拦截规则，但是两个规则有冲突，因此位于上面的规则起效，ADMIN可以访问而USER不能，
			                   //如果换下顺序则只能由USER来访问
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

