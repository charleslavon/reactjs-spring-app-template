package com.connect.portal.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

public class WebInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContainer) throws ServletException {

		// Add a listener to monitor sessions and enforcing timeouts for
		// inactive user sessions
		servletContainer.addListener(new SessionListener());

		/*
		 * If no active profile is set via -Dspring.profiles.active or some
		 * other mechanism then this will be used.
		 */
		servletContainer.setInitParameter("spring.profiles.default", "production");

		// Creates the root application context
		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();

		appContext.setDisplayName("Template Portal");

		// Registers the application configuration with the root context
		appContext.register(AppConfig.class);
		
		// Creates the Spring Container shared by all Servlets and Filters
		servletContainer.addListener(new ContextLoaderListener(appContext));

		// Add Filters
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter("UTF-8", true);
		servletContainer.addFilter("characterEncodingFilter", encodingFilter).addMappingForUrlPatterns(null, false,
				"/");

		/*
		 * TODO - If any required mime-types are not supported by default, we'll
		 * need to figure out how to do the java-based config like the following
		 * from the old web.xml
		 * 
		 *    <mime-mapping>
			    <extension>ico</extension>
			    <mime-type>image/x-icon</mime-type>
			  </mime-mapping>
			  <mime-mapping>
			    <extension>woff</extension>
			    <mime-type>application/x-font-woff</mime-type>
			  </mime-mapping>
			  <mime-mapping>
			    <extension>ttf</extension>
			    <mime-type>application/octet-stream</mime-type>
			  </mime-mapping>
			  <mime-mapping>
			    <extension>otf</extension>
			    <mime-type>application/octet-stream</mime-type>
			  </mime-mapping>
			  <mime-mapping>
			    <extension>eot</extension>
			    <mime-type>application/vnd.ms-fontobject</mime-type>
			  </mime-mapping>
		 * 
		 */

		// Creates the dispatcher servlet context
		AnnotationConfigWebApplicationContext servletContext = new AnnotationConfigWebApplicationContext();

		// Registers the servlet configuraton with the dispatcher servlet
		// context
		servletContext.register(ServletConfig.class);

		// Further configures the servlet context
		DispatcherServlet dispatcherServlet = new DispatcherServlet(servletContext);
		ServletRegistration.Dynamic dispatcher = servletContainer.addServlet("spring-mvc-dispatcher",
				dispatcherServlet);

		// throw NoHandlerFoundException to Controller
		dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");

	}

}
