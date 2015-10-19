package org.akc.dao.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.akc.transformer.DtoTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Author: Chander 
 * Date: 09/08/15 
 * Chairperson Class for storing chairperson related fields.
 * 
 */

@Entity
@Table(name = "CHAIRPERSON")
public class ChairPerson implements Serializable, DtoTransformer {
	
	
	/**
	 * Instantiates a new chair person.
	 */
	public ChairPerson() {
		super();

		if (logger.isDebugEnabled()) {
			logger.debug(" Executing Default constructor ChairPerson model class ");
		}
	}
	

	/** The Constant logger. */
	final static Logger logger = LoggerFactory.getLogger(ChairPerson.class);
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The chair person id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CHAIRPERSON_ID")
	private Integer chairPersonId;
	/** The first name. */
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	/** The middle name. */
	@Column(name = "MIDDLE_NAME")
	private String middleName;
	
	/** The last name. */
	@Column(name = "LAST_NAME")
	private String lastName;
	
	/** The event id. */
	@Column(name = "EVENT_ID")
	private Integer eventId;
	
	/** The created by. */
	@Column(name = "CREATED_BY")
	private String createdBy;
	
	/** The created date. */
	@Column(name = "CREATED_DATE")
	private Date createdDate;
	
	/** The updated by. */
	@Column(name = "UPDATED_BY")
	private String updatedBy;
	
	/** The updated date. */
	@Column(name = "UPDATED_DATE")
	private Date updatedDate;

	/** The address. */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ADDRESS_ID")
	private Address address;

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
	 * Gets the address.
	 *
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * Sets the address.
	 *
	 * @param address the new address
	 */
	public void setAddress(Address address) {
		this.address = address;
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
	 * @param chairPersonId
	 *            the new chair person id
	 */
	public void setChairPersonId(Integer chairPersonId) {
		this.chairPersonId = chairPersonId;
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

	
	@Override
	public String toString() {
		return "ChairPerson [chairPersonId=" + chairPersonId + ", firstName="
				+ firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", eventId=" + eventId + ", createdBy="
				+ createdBy + ", createdDate=" + createdDate + ", updatedBy="
				+ updatedBy + ", updatedDate=" + updatedDate + ", address="
				+ address + "]";
	}



}
