package net.codejava.spring.config;





import java.io.IOException;
import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
//import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
@ComponentScan(basePackages="net.codejava.spring")
@EnableWebMvc
@Import({DataSourceConfig.class})
//@ImportResource("/WEB-INF/SecurityConfig.xml")
public class BaseConfig extends WebMvcConfigurerAdapter{

	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;	
	
	}
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
   
	@Bean
	public MultipartResolver getMultipartResolver(){
		CommonsMultipartResolver multipartresolver=new CommonsMultipartResolver();
		multipartresolver.setDefaultEncoding("UTF-8");
		
		return multipartresolver;
	}
	@Bean
	public FormattingConversionServiceFactoryBean StringToDate(){
		FormattingConversionServiceFactoryBean conversion =new FormattingConversionServiceFactoryBean();
		return conversion;
	}
	
	@Primary
	public class CustomObjectMapper extends ObjectMapper {
	    public CustomObjectMapper() {
	        configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, true);
	    }
	}
	
}
