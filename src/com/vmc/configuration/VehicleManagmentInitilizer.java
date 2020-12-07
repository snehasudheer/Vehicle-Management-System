package com.vmc.configuration;

import javax.servlet.Filter;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class VehicleManagmentInitilizer extends AbstractAnnotationConfigDispatcherServletInitializer {
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		System.out.println("Inside getRootConfigClasses");
		return new Class[] {VehicleManagmentServiceConfiguration.class, VehicleManagmentThreadConfiguration.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		  System.out.println("Inside getServletConfigClasses");
		  return new Class[] { VehicleManagmentWebConfiguration.class };
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		  System.out.println("Inside getServletMappings");
		  return new String[] { "/" };
	}
	
	@Override
    protected Filter[] getServletFilters() {
    	Filter [] singleton = { new CORSFilter()};
    	return singleton;
    }

	

}
