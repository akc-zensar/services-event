package org.akc.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



// TODO: Auto-generated Javadoc
/**
 * Author: Chander
 * Date: 09/08/15
 * SuperintendentForm Class for Superintendent related properties to represent in the form.
 */


public class SuperintendentForm {
	
	/** The Constant logger. */
	final static Logger logger = LoggerFactory.getLogger(SuperintendentForm.class);
	
	/** The id. */
	@Id
	@GeneratedValue
	@Column(name="SUPERINTENDENT_ID")
	private Long superintendentId;
	
	/** The name. */
	@Column(name="SUPERINTENDENT_NAME")
	private String superintendenName;
	
	/** The address id. */
	@Column(name="ADDRESS_ID")
	private int addressId;
	
	
	/** The created by. */
	@Column(name="CREATED_BY")
	private String createdBy;
	
	/** The created date. */
	@Column(name="CREATED_DATE")
	private Date createdDate;
	
	/** The updated by. */
	@Column(name="UPDATED_BY")
	private String updatedBy;
	
	/** The updated date. */
	@Column(name="UPDATED_DATE")
	private Date updatedDate;
	
	/**
	 * Gets the created by.
	 *
	 * @return the created by
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * Sets the created by.
	 *
	 * @param createdBy the new created by
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * Gets the created date.
	 *
	 * @return the created date
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * Sets the created date.
	 *
	 * @param createdDate the new created date
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * Gets the updated by.
	 *
	 * @return the updated by
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * Sets the updated by.
	 *
	 * @param updatedBy the new updated by
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	/**
	 * Gets the updated date.
	 *
	 * @return the updated date
	 */
	public Date getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * Sets the updated date.
	 *
	 * @param updatedDate the new updated date
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	
	/**
	 * Gets the superintendent id.
	 *
	 * @return the superintendent id
	 */
	public Long getSuperintendentId() {
		return superintendentId;
	}

	/**
	 * Sets the superintendent id.
	 *
	 * @param superintendentId the new superintendent id
	 */
	public void setSuperintendentId(Long superintendentId) {
		this.superintendentId = superintendentId;
	}

	/**
	 * Gets the superintenden name.
	 *
	 * @return the superintenden name
	 */
	public String getSuperintendenName() {
		return superintendenName;
	}

	/**
	 * Sets the superintenden name.
	 *
	 * @param superintendenName the new superintenden name
	 */
	public void setSuperintendenName(String superintendenName) {
		this.superintendenName = superintendenName;
	}

	/**
	 * Gets the address id.
	 *
	 * @return the address id
	 */
	public int getAddressId() {
		return addressId;
	}
	
	/**
	 * Sets the address id.
	 *
	 * @param addressId the new address id
	 */
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	

}
