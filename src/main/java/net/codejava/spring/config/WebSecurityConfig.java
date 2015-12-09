package net.codejava.spring.config;

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
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication()
				.withUser("user").password("password").roles("USER").and()
		        .withUser("admin").password("password").roles("USER", "GOD");
	}
	
	protected void configure(HttpSecurity http) throws Exception {
		 CharacterEncodingFilter filter = new CharacterEncodingFilter();
	        filter.setEncoding("UTF-8");
	        filter.setForceEncoding(false);
	        http.addFilterBefore(filter,CsrfFilter.class);
		http
		           .authorizeRequests()
			                   .antMatchers("resources/**", "/signup", "/about").permitAll()
			                   .antMatchers("*.js").permitAll()
			                   .antMatchers("/toadmin").hasRole("GOD")
			                   .antMatchers("/").permitAll()
			                   //.antMatchers("*.jsp").permitAll()
			                   .antMatchers("/**").hasRole("USER")
				               .anyRequest().authenticated()
				.and()				
			.formLogin().loginPage("/login").permitAll()                                  
				.and()
				.logout()                                                              
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/").                                           
				and()                              
			.httpBasic();
	}
}

