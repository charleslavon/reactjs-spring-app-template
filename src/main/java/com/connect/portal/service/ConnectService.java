package com.connect.portal.service;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpMethod;

import com.connect.portal.model.ApplicationException;
import com.connect.portal.model.Entity;

public abstract class ConnectService {

	protected final Log logger = LogFactory.getLog(getClass());
	protected String uri;
	
	@Autowired
	protected MessageSource messageSource;
	
	public ConnectService(String uri) {
		this.uri = uri;
	}
	
	public abstract Entity makeCall(Entity entity, String resourceMethod, HttpMethod httpMethod, Map<String, String> params) throws ApplicationException;

	public String getUri() {
		return uri;
	}
	
	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

}
