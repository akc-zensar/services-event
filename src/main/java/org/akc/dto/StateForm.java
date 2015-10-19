package org.akc.dto;

import java.util.Date;

import javax.persistence.Column;

/**
 * Author: chandra
 * Date: 09/08/15
 * State DTO defined for event service
 */
public class StateForm {

private int stateId;
private String stateCode;
private String stateDesc;
public int getStateId() {
	return stateId;
}
public void setStateId(int stateId) {
	this.stateId = stateId;
}
public String getStateCode() {
	return stateCode;
}
public void setStateCode(String stateCode) {
	this.stateCode = stateCode;
}
public String getStateDesc() {
	return stateDesc;
}
public void setStateDesc(String stateDesc) {
	this.stateDesc = stateDesc;
}

	
}
