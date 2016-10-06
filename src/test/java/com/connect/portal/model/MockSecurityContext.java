package com.connect.portal.model;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;

public class MockSecurityContext implements SecurityContext{

	private static final long serialVersionUID = -6470787776678875797L;
	public static boolean setAuthenticationCalledWithNull = false;
	
	public static Authentication authentication;//NOPMD - necessary for these mocks
	
	public MockSecurityContext(){
		authentication = new MockAuthentication();
	}
	
	public Authentication getAuthentication() {
		return authentication;
	}

	public void setAuthentication(final Authentication authentication) {
		if(authentication == null)
			setAuthenticationCalledWithNull = true;
	}

	public static void reset() {
		setAuthenticationCalledWithNull = false;
	}
}
