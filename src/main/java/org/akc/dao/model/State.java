package org.akc.dao.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * Author: chandra
 * Date: 09/08/15
 * Site Model defined for event service
 */
@Entity
@Table(name = "STATE")
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY,region="state")
public class State implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The state id. */
	@Id
	@GeneratedValue
	@Column(name = "STATE_ID")
	private int stateId;
	
	/** The state code. */
	@Column(name = "STATE_CODE")
	private String stateCode;
	
	/** The state description. */
	@Column(name = "STATE_DESC")
	private String stateDesc;
	
	@Column(name = "STATUS")
	private int status;

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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((stateCode == null) ? 0 : stateCode.hashCode());
		result = prime * result
				+ ((stateDesc == null) ? 0 : stateDesc.hashCode());
		result = prime * result + stateId;
		result = prime * result + status;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof State)) {
			return false;
		}
		State other = (State) obj;
		if (stateCode == null) {
			if (other.stateCode != null) {
				return false;
			}
		} else if (!stateCode.equals(other.stateCode)) {
			return false;
		}
		if (stateDesc == null) {
			if (other.stateDesc != null) {
				return false;
			}
		} else if (!stateDesc.equals(other.stateDesc)) {
			return false;
		}
		if (stateId != other.stateId) {
			return false;
		}
		if (status != other.status) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "State [stateId=" + stateId + ", stateCode=" + stateCode
				+ ", stateDesc=" + stateDesc + ", status=" + status + "]";
	}
	
	
}
