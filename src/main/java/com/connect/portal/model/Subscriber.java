package com.connect.portal.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.xml.ws.http.HTTPException;

import org.springframework.http.HttpMethod;

public class Subscriber extends Entity {
	
	private String email;
	private String firstName;
	private String lastName;
	private boolean isPrimary;
	private Set<Vehicle> vehicles;
	
	public Subscriber(String email, String firstName, String lastName, boolean isPrimary) {
		super("/user");
		
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.setPrimary(isPrimary);
		vehicles = new HashSet<Vehicle>();
	}
	
	public void createSubscriber() throws ApplicationException {
		Map<String, String> params = new HashMap<String, String>();
		params.put("email", email);
		params.put("firstName", firstName);
		params.put("lastName", lastName);
		params.put("isPrimary", isPrimary ? "1" : "0");
		
		try 
		{
			connect.makeCall(this, null, HttpMethod.PUT, params);
		}
		catch(HTTPException he) 
		{
			throw new ApplicationException(he.getStatusCode(), getErrorMessage(he, "createSubscriber"));
		}
	}
	
	public void addVehicle(String vin) throws ApplicationException {
		Map<String, String> params = new HashMap<String, String>();
		params.put("vin", vin);
		
		try 
		{
			connect.makeCall(this, null, HttpMethod.PUT, params);
		}
		catch(HTTPException he) 
		{
			throw new ApplicationException(he.getStatusCode(), getErrorMessage(he, "addVehicle"));
		}
			
		addVehicleToSet(vin);
	}
	
	private String getErrorMessage(HTTPException he, String method) {
		String errorMsg;
		
		if(he.getStatusCode() == 500)
			errorMsg = messageSource.getMessage("subscriber." +method+ ".error.http500", null, Locale.US);
		else if(he.getStatusCode() == 401)
			errorMsg = messageSource.getMessage("subscriber." +method+ ".error.http500", null, Locale.US);
		else
			errorMsg = messageSource.getMessage("subscriber." +method+ ".error.default", null, Locale.US);
		
		return errorMsg;
	}
	
	private void addVehicleToSet(String vin) {
		vehicles.add(new Vehicle(vin));
	}

	public boolean isPrimary() {
		return isPrimary;
	}

	private void setPrimary(boolean isPrimary) {
		this.isPrimary = isPrimary;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
