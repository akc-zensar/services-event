package org.akc.dto;

import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.akc.transformer.DtoTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * Author: Chander
 * Date: 09/08/15
 * AddressForm Class for address related properties to represent in the form.
 */

@XmlRootElement(name = "addressForm")
public class AddressForm implements DtoTransformer {
	
	
	public AddressForm() {
		super();

		if (logger.isDebugEnabled()) {
			logger.debug(" Executing Default constructor AddressForm dto class ");
		}
	}

	
	/** The Constant logger. */
	final static Logger logger = LoggerFactory.getLogger(AddressForm.class);
	
	private Integer addressId;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private Integer zipCode;
	private String email;
	private Integer phone;
	private Integer fax;
	private String addNotes;
	private Date effectiveDate;
	private Date endDate;
	private String createdBy;
	private Date createdDate;
	private String updatedBy;
	private Date updatedDate;
	
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getZipCode() {
		return zipCode;
	}
	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	public Integer getFax() {
		return fax;
	}
	public void setFax(Integer fax) {
		this.fax = fax;
	}
	public String getAddNotes() {
		return addNotes;
	}
	public void setAddNotes(String addNotes) {
		this.addNotes = addNotes;
	}
	public Date getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	@Override
	public String toString() {
		return "AddressForm [addressId=" + addressId + ", address1=" + address1
				+ ", address2=" + address2 + ", city=" + city + ", state="
				+ state + ", zipCode=" + zipCode + ", email=" + email
				+ ", phone=" + phone + ", fax=" + fax + ", addNotes="
				+ addNotes + ", effectiveDate=" + effectiveDate + ", endDate="
				+ endDate + ", createdBy=" + createdBy + ", createdDate="
				+ createdDate + ", updatedBy=" + updatedBy + ", updatedDate="
				+ updatedDate + "]";
	}
	
	

}
