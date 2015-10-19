package org.akc.dao.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "TIMEZONES")
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY,region="timezone")
public class TimeZones implements Serializable {
	private static final long serialVersionUID = -8538096722653348000L;
    @Id
	@Column(name = "TIMEZONE_CODE")
	private String timeZoneCode;
	@Column(name = "TIMEZONE_DESCRIPTION")
	private String timeZoneDecription;
	@Column(name = "STATUS")
	private int status;
	public String getTimeZoneCode() {
		return timeZoneCode;
	}
	public void setTimeZoneCode(String timeZoneCode) {
		this.timeZoneCode = timeZoneCode;
	}
	public String getTimeZoneDecription() {
		return timeZoneDecription;
	}
	public void setTimeZoneDecription(String timeZoneDecription) {
		this.timeZoneDecription = timeZoneDecription;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "TimeZones [timeZoneCode=" + timeZoneCode
				+ ", timeZoneDecription=" + timeZoneDecription + ", status="
				+ status + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + status;
		result = prime * result
				+ ((timeZoneCode == null) ? 0 : timeZoneCode.hashCode());
		result = prime
				* result
				+ ((timeZoneDecription == null) ? 0 : timeZoneDecription
						.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TimeZones other = (TimeZones) obj;
		if (status != other.status)
			return false;
		if (timeZoneCode == null) {
			if (other.timeZoneCode != null)
				return false;
		} else if (!timeZoneCode.equals(other.timeZoneCode))
			return false;
		if (timeZoneDecription == null) {
			if (other.timeZoneDecription != null)
				return false;
		} else if (!timeZoneDecription.equals(other.timeZoneDecription))
			return false;
		return true;
	}
    
	

	
	
}
