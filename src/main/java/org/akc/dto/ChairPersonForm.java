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
 * Author: Chander Date: 09/08/15 ChairPersonForm Class for ChairPerson related
 * properties to represent in the form.
 */

@XmlRootElement(name = "chairPerson")
public class ChairPersonForm implements DtoTransformer {
	
	
	/**
	 * Instantiates a new chair person form.
	 */
	public ChairPersonForm() {
		super();

		if (logger.isDebugEnabled()) {
			logger.debug(" Executing Default constructor ChairPersonForm dto class ");
		}
	}
	

	/** The Constant logger. */
	final static Logger logger = LoggerFactory.getLogger(ChairPersonForm.class);

	/** The chair person id. */
	private Integer chairPersonId;
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
	 * Gets the chair person id.
	 *
	 * @return the chair person id
	 */
	public Integer getChairPersonId() {
		return chairPersonId;
	}

	/**
	 * Sets the chair person id.
	 *
	 * @param chairPersonId the new chair person id
	 */
	public void setChairPersonId(Integer chairPersonId) {
		this.chairPersonId = chairPersonId;
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

	
	@Override
	public String toString() {
		return "ChairPersonForm [chairPersonId=" + chairPersonId
				+ ", firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", eventId=" + eventId
				+ ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate
				+ ", addressForm=" + addressForm + "]";
	}

	
	
}
