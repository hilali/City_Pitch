/**
 * 
 */
package com.bsabbath.intuicity.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ErrorMessage {

	@XmlElement
	private String code;
	@XmlElement
	private String message;

	public ErrorMessage(){
		
	}
	
	public ErrorMessage(String code, String message){
		this.setCode(code);
		this.setMessage(message);
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ErrorMessage [code=" + code + ", message=" + message + "]";
	}



}
