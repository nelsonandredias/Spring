package com.java.springbootsoapbasics.exceptions;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

//SoapFault - because it's not a server fault. Instead, the client is requesting an invalid authorId
@SoapFault(faultCode=FaultCode.CLIENT)
public class getAuthorNotFoundException extends RuntimeException {


	private static final long serialVersionUID = 1L;

	public getAuthorNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	
	
	
}
