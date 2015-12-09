package net.codejava.spring.config;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

public class WebInitializer implements WebApplicationInitializer {

    public void onStartup(ServletContext servletContext) throws ServletException {
    	

        // Create the 'root' Spring application context
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(BaseConfig.class);
        servletContext.addListener(new ContextLoaderListener(rootContext));
      
        
        //CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();  
       // characterEncodingFilter.setEncoding("UTF-8");  
       // characterEncodingFilter.setForceEncoding(true); 
        //FilterRegistration filterRegistration =  
           //  servletContext.addFilter("characterEncodingFilter", characterEncodingFilter);  
          //   filterRegistration.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), false, "/");  


        //FilterRegistration.Dynamic securityFilter = servletContext.addFilter("springSecurityFilterChain", DelegatingFilterProxy.class);
       // securityFilter.addMappingForUrlPatterns(null, false, "/*");

        // Manage the lifecycle of the root application context
        AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
        webContext.register(BaseConfig.class);
        webContext.setServletContext(servletContext);


        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(webContext));
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
        
     

    }
}
