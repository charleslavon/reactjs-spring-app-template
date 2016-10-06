package com.connect.portal.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HeaderInjectorFilter implements Filter {

	private transient final Log logger = LogFactory.getLog(getClass());//NOPMD factory determines log class
	
	private static final String X_FRAME_DEFENSE_HEADER_KEY = "X-FRAME-OPTIONS";
	private static final String X_FRAME_DEFENSE_DENYALL = "DENY";
	
	private static final String CACHE_CONTROL_NAME = "Cache-Control";
	private static final String CACHE_CONTROL_VALUE = "no-store, no-cache, must-revalidate";
	
	private static final String ENFORCE_STRICT_TRANSPORT_KEY = "Strict-Transport-Security";
	private static final String ENFORCE_STRICT_TRANSPORT_VALUE = "max-age=31536000; includeSubDomains";
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		logger.debug("Injecting X-Frame Security Header");
		HttpServletResponse resp = (HttpServletResponse) response;
		resp.addHeader(X_FRAME_DEFENSE_HEADER_KEY, X_FRAME_DEFENSE_DENYALL);
		
		logger.debug("Injecting Cache-Control Header");
		resp.addHeader(CACHE_CONTROL_NAME, CACHE_CONTROL_VALUE);
		
		logger.debug("Injecting HTTPS Strict Transport Security Header");
		resp.addHeader(ENFORCE_STRICT_TRANSPORT_KEY, ENFORCE_STRICT_TRANSPORT_VALUE);
		
		chain.doFilter(request, resp);
		
	}

	@Override
	public void destroy() {
		
	}
	
}
