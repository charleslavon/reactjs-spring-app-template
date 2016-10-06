package com.connect.portal.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles all mvc requests
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class); 
	
	@Autowired
	MessageSource messageSource;
	
	/**
	 * Entry point for the index page
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home()
	{
		logger.debug("Preparing the index page.");
		return "index";
	}
	
}
