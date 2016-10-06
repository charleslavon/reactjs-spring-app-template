package com.connect.portal.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import com.connect.portal.service.ConnectService;

public abstract class Entity {

	protected String route;
	
	@Autowired
	protected MessageSource messageSource;
	
	@Autowired
	protected ConnectService connect;
	
	protected Entity(String route) {
		this.route = route;
	}
	
	public ConnectService getConnect() {
		return connect;
	}

	public void setConnect(ConnectService connect) {
		this.connect = connect;
	}
	
	public MessageSource getMessageSource() {
		return messageSource;
	}
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	public void setRoute(String route) {
		this.route = route;
	}

	public String getRoute() {
		return route;
	}
}
