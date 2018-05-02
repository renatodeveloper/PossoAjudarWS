package br.com.possoajudarws.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ServiceResponse {
	 public String code;
	 public String message;

	 public String getCode() {
		 return code;
	 }
	 
	 public String getMessage() {
		 return message;
	 }
}
