package com.connect.portal.model;

import mockit.Mock;

import org.springframework.security.core.context.SecurityContext;

public class MockSecurityContextHolder {//NOPMD ignore static warnings

	private static MockSecurityContext context;
	
	static {
		context = new MockSecurityContext();
	}
	
	@Mock
	public static SecurityContext getContext() {
		return context;
	}
	
	public static void reset() {
		context = new MockSecurityContext();
	}
}
