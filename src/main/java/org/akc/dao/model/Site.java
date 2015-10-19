package org.akc.dao.model;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
// TODO: Auto-generated Javadoc
import javax.persistence.Table;

/**
 * Author: chandra
 * Date: 09/08/15
 * Site Model defined for event service
 */
@Entity
@Table(name = "SITE")
public class Site {
	
	/** The site id. */
	@Id
	@GeneratedValue
	@Column(name = "SITE_ID")
	private Long siteId;
	
	/** The site number. */
	@Column(name = "SITE_NUMBER")
	private Long siteNumber;
	
	/** The site name. */
	@Column(name = "SITE_NAME")
	private String siteName;
	
	/** The site status. */
	@Column(name = "SITE_STATUS")
	private String siteStatus;
	
	/** The site address. */
	@Column(name = "SITE_ADDRESS")
	private String siteAddress;
	
	/** The site phone number. */
	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;
	
	/** The site approved competition groups. */
	@Column(name = "APPROVED_COMPETITION_GROUPS")
	private String approvedcompGroups;
	
	/** The site approved competition groups. */
	@Column(name = "CREATED_BY")
	private String createdBy;
	
	/** The site approved competition groups. */
	@Column(name = "UPDATED_BY")
	private String updatedBy;
	@Column(name = "CREATED_DATE")
	private Date createdDate;
	@Column(name = "UPDATED_DATE")
	private Date updatedDate;
	/**
	 * Gets the site id.
	 *
	 * @return the site id
	 */
	public Long getSiteId() {
		return siteId;
	}
	
	/**
	 * Sets the site id.
	 *
	 * @param siteId the new site id
	 */
	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}
	
	/**
	 * Gets the site number.
	 *
	 * @return the site number
	 */
	public Long getSiteNumber() {
		return siteNumber;
	}
	
	/**
	 * Sets the site number.
	 *
	 * @param siteNumber the new site number
	 */
	public void setSiteNumber(Long siteNumber) {
		this.siteNumber = siteNumber;
	}
	
	/**
	 * Gets the site name.
	 *
	 * @return the site name
	 */
	public String getSiteName() {
		return siteName;
	}
	
	/**
	 * Sets the site name.
	 *
	 * @param siteName the new site name
	 */
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getSiteStatus() {
		return siteStatus;
	}

	public void setSiteStatus(String siteStatus) {
		this.siteStatus = siteStatus;
	}

	public String getSiteAddress() {
		return siteAddress;
	}

	public void setSiteAddress(String siteAddress) {
		this.siteAddress = siteAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getApprovedcompGroups() {
		return approvedcompGroups;
	}

	public void setApprovedcompGroups(String approvedcompGroups) {
		this.approvedcompGroups = approvedcompGroups;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	
}
