package com.connect.portal.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class MockAuthentication implements Authentication{

	private static final long serialVersionUID = -7284991931355647310L;

	public List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	public static boolean authenticated;
    public static Object principal;
    {
    	authenticated = true;
	}
	
	public static void reset() {
		authenticated = false;
		principal = null;//NOPMD - intentionally setting to null
	}
	
	public String getName() {
		return "subscriber name";
	}

	public Collection<GrantedAuthority> getAuthorities() {
		GrantedAuthority ga = new SimpleGrantedAuthority("ADMIN");
		authorities.add(ga);
		return authorities;
	}

	public Object getCredentials() {
		return null;
	}

	public Object getDetails() {
		return null;
	}

	public Object getPrincipal() {
		return principal;
	}

	public boolean isAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(boolean isAuthenticated)
			throws IllegalArgumentException {
		
	}

}
