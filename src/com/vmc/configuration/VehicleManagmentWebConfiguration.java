package com.vmc.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan("com.vmc")
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USER')")

public class VehicleManagmentWebConfiguration extends WebMvcConfigurationSupport {
	@Override 
	public void addViewControllers(ViewControllerRegistry registry) { 
		registry.addViewController("/"); 
	} 
 
	@Bean 
	public InternalResourceViewResolver viewResolver() { 
		InternalResourceViewResolver resolver = new InternalResourceViewResolver(); 
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/jsp/"); 
		resolver.setSuffix(".jsp"); 
		return resolver; 
	}	 

	
}
