package com.connect.portal.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class HeaderInjector extends HandlerInterceptorAdapter {

	private transient final Log logger = LogFactory.getLog(getClass());//NOPMD factory determines log class
	
	private static final String X_FRAME_DEFENSE_HEADER_KEY = "X-FRAME-OPTIONS";
	private static final String X_FRAME_DEFENSE_DENYALL = "DENY";
	
	@Override
	public void postHandle(final HttpServletRequest request, final HttpServletResponse response, 
			final Object handler, final ModelAndView modelAndView) throws Exception {//NOPMD matching abstract signature
		
			logger.debug("Injecting X-Frame Security Header");
			response.addHeader(X_FRAME_DEFENSE_HEADER_KEY, X_FRAME_DEFENSE_DENYALL);
	}
	
}
