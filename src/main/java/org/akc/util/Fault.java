/*
  Author: Ashok doddi
  
 */
package org.akc.util;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;


/*
 Fault class holds errorCode,errorMessage,origin of Exception
 */
@XmlRootElement
@Component("fault")
public class Fault {

	
	/* The origin. */
	private String errorMessage,origin,errorCode;
	private Date errorTime;
	
	public Date getErrorTime() {
		return errorTime;
	}

	public void setErrorTime(Date errorTime) {
		this.errorTime = errorTime;
	}

	/*
	  Gets the error code.
	 
	  @return the error code
	 */
	public String getErrorCode() {
		return errorCode;
	}
	
	/*
	 Sets the error code.
	 
	 @param errorCode the new error code
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	/*
	 Gets the error message.
	 
	 @return the error message
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
	
	/*
	 Sets the error message.
	 
	 @param errorMessage the new error message
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	/*
	 Gets the origin.
	 
	 @return the origin
	 */
	public String getOrigin() {
		return origin;
	}
	
	/*
	 Sets the origin.
	 
	 @param origin the new origin
	 */
	public void setOrigin(String origin) {
		this.origin = origin;
	}

	

}
