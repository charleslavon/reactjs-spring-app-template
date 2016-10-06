package com.connect.portal.model;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.xml.ws.http.HTTPException;

import org.springframework.http.HttpMethod;


public class Vehicle extends Entity {

	private String vin;
	private String contractId;
	
	public Vehicle(String vin) {
		super("/vehicle");
		this.vin = vin;
	}
	
	public String getVin() {
		return vin;
	}

	public String getContractId() {
		return contractId;
	}
	
	private void setContractId(String contractId) {
		this.contractId = contractId;
	}
	
	public void addContract(String contractId) throws ApplicationException {
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("contractId", contractId);
		
		try 
		{
			connect.makeCall(this, "contract", HttpMethod.POST, params);
		}
		catch(HTTPException he) 
		{
			throw new ApplicationException(he.getStatusCode(), getErrorMessage(he, "addContract"));
		}
		
		setContractId(contractId);
	}
	
	private String getErrorMessage(HTTPException he, String method) {
		String errorMsg;
		
		if(he.getStatusCode() == 500)
			errorMsg = messageSource.getMessage("vehicle." +method+ ".error.http500", null, Locale.US);
		else if(he.getStatusCode() == 401)
			errorMsg = messageSource.getMessage("vehicle." +method+ ".error.http500", null, Locale.US);
		else
			errorMsg = messageSource.getMessage("vehicle." +method+ ".error.default", null, Locale.US);
		
		return errorMsg;
	}
	

}
