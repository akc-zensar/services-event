package org.akc.dao.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.akc.transformer.DtoTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
* Author: Chander
* Date: 09/08/15
* Address Class for storing address related fields.
*/

@Entity
@Table(name = "ADDRESS")
public class Address implements DtoTransformer, Serializable {
	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	public Address() {
		super();

		if (logger.isDebugEnabled()) {
			logger.debug(" Executing Default constructor Address model class ");
		}
	}

	/** The Constant logger. */
	final static Logger logger = LoggerFactory.getLogger(Address.class);
	
	
	@Id
	@GeneratedValue
	@Column(name = "ADDRESS_ID")
	private Integer addressId;
	
	@Column(name = "ADDRESS_1")
	private String address1;
	
	
	@Column(name = "ADDRESS_2")
	private String address2;
	
	
	@Column(name = "CITY")
	private String city;
	
	
	@Column(name = "STATE")
	private String state;
	

	@Column(name = "ZIP_CODE")
	private Integer zipCode;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "PHONE")
	private Integer phone;
	
	@Column(name = "FAX")
	private Integer fax;
	
	@Column(name = "ADD_NOTES")
	private String addNotes;
	
	
	@Column(name = "EFFECTIVE_DATE")
	private Date effectiveDate;
	

	@Column(name = "END_DATE")
	private Date endDate;
	
	
	@Column(name = "CREATED_BY")
	private String createdBy;
	
	
	@Column(name = "CREATED_DATE")
	private Date createdDate;
	
	
	@Column(name = "UPDATED_BY")
	private String updatedBy;
	
	@Column(name = "UPDATED_DATE")
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
		return "Address [addressId=" + addressId + ", address1=" + address1
				+ ", address2=" + address2 + ", city=" + city + ", state="
				+ state + ", zipCode=" + zipCode + ", email=" + email
				+ ", phone=" + phone + ", fax=" + fax + ", addNotes="
				+ addNotes + ", effectiveDate=" + effectiveDate + ", endDate="
				+ endDate + ", createdBy=" + createdBy + ", createdDate="
				+ createdDate + ", updatedBy=" + updatedBy + ", updatedDate="
				+ updatedDate + "]";
	}

	
	
	

}
