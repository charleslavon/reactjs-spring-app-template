package com.connect.portal.service;

import java.util.Map;

import org.springframework.http.HttpMethod;

import com.connect.portal.model.ApplicationException;
import com.connect.portal.model.Entity;

public class ConnectServiceStub extends ConnectService{

	public ConnectServiceStub(String uri) {
		super(uri);
	}

	public Entity makeCall(Entity entity, String resourceMethod, 
			HttpMethod httpMethod, Map<String, String> params) throws ApplicationException {
		
		String url = getUri() + entity.getRoute();
		
		logger.debug("Componsed REST URL: " + url);
		
		logger.debug("With Params: ");
		for (Map.Entry<String, String> entry : params.entrySet())
		{
		    logger.debug(entry.getKey() + " : " + entry.getValue());
		}
		
		params.put("stubMakeCall_executed", "true");
		
		return entity;
	}
	

}
