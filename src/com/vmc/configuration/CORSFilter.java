package com.vmc.configuration;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class CORSFilter implements Filter  {
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		System.out.println("Filtering on...........................................................");
		HttpServletResponse response = (HttpServletResponse) res;
//		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers",
				"Authorization,Content-Type, "
				+ "Content-Range, Content-Disposition, "
				+ "Content-Description,Origin, "
				+ "X-Requested-With, sessionId");
		
		response.setContentType("application/json; charset=utf-8");
		//response.setContentType("application/octet-stream; charset=utf-8");
		chain.doFilter(req, res);

}
	public void init(FilterConfig filterConfig) {}

	public void destroy() {}

}