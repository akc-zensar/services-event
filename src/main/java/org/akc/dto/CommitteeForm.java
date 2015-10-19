package org.akc.dto;

import java.sql.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.akc.transformer.DtoTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Author: Chander 
 * Date: 09/08/15
 *  CommitteeForm Class for Committee related properties to represent in the form.
 * 
 */

@XmlRootElement(name = "committee")
public class CommitteeForm implements DtoTransformer {
	
	/**
	 * Instantiates a new committee form.
	 */
	public CommitteeForm() {
		super();

		if (logger.isDebugEnabled()) {
			logger.debug(" Executing Default constructor CommitteeForm dto class ");
		}
	}
	

	/** The Constant logger. */
	final static Logger logger = LoggerFactory.getLogger(ChairPersonForm.class);

	/** The committee id. */
	private Integer committeeId;
	/** The first name. */
	private String firstName;
	
	/** The middle name. */
	private String middleName;
	
	/** The last name. */
	private String lastName;
	
	/** The event id. */
	@NotNull
	@Size(min = 4, max = 10)
	@Digits(fraction = 0, integer = 10)
	private Integer eventId;
	
	/** The created by. */
	private String createdBy;
	
	/** The created date. */
	private Date createdDate;
	
	/** The updated by. */
	private String updatedBy;
	
	/** The updated date. */
	private Date updatedDate;
	
	/** The address form. */
	@XmlElement(name = "addressForm")
	private AddressForm addressForm;

	/**
	 * Gets the event id.
	 *
	 * @return the event id
	 */
	public Integer getEventId() {
		return eventId;
	}

	/**
	 * Sets the event id.
	 *
	 * @param eventId the new event id
	 */
	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the middle name.
	 *
	 * @return the middle name
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * Sets the middle name.
	 *
	 * @param middleName the new middle name
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the committee id.
	 *
	 * @return the committee id
	 */
	public Integer getCommitteeId() {
		return committeeId;
	}

	/**
	 * Sets the committee id.
	 *
	 * @param committeeId the new committee id
	 */
	public void setCommitteeId(Integer committeeId) {
		this.committeeId = committeeId;
	}

	

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
	 * Gets the address form.
	 *
	 * @return the address form
	 */
	public AddressForm getAddressForm() {
		return addressForm;
	}

	/**
	 * Sets the address form.
	 *
	 * @param addressForm the new address form
	 */
	public void setAddressForm(AddressForm addressForm) {
		this.addressForm = addressForm;
	}

	
	@Override
	public String toString() {
		return "CommitteeForm [committeeId=" + committeeId + ", firstName="
				+ firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", eventId=" + eventId + ", createdBy="
				+ createdBy + ", createdDate=" + createdDate + ", updatedBy="
				+ updatedBy + ", updatedDate=" + updatedDate + ", addressForm="
				+ addressForm + "]";
	}


	
}
