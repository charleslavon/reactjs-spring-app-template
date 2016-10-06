package com.connect.portal.service;

import java.util.Locale;
import java.util.Map;

import org.springframework.http.HttpMethod;

import com.connect.portal.model.ApplicationException;
import com.connect.portal.model.Entity;

public class ConnectServiceImpl extends ConnectService {

	public ConnectServiceImpl(String uri) {
		super(uri);
	}

	@Override
	public Entity makeCall(Entity entity, String resourceMethod,
			HttpMethod httpMethod, Map<String, String> params)
			throws ApplicationException {
		
		switch ( httpMethod ) 
		{
			case GET:
				break;
			case POST:
				break;
			case PUT: 
				break;
			case DELETE:
				break;
			case OPTIONS:
				break;
			default:
				throw new ApplicationException(messageSource.getMessage("http.request.invalid.generic", null, Locale.US));
		}
		
		return entity;
	}

}
