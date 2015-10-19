package org.akc.dao.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;



@Entity
@Table(name = "prefix")
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY,region="prefix")
public class Prefix implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The site number. */
	@Id
	@Column(name = "PREFIX_CODE")
	private String prefixCode;
	
	/** The site name. */
	@Column(name = "PREFIX_DESCRIPTION")
	private String prefixDecription;
	
	/** The site status. */
	@Column(name = "PREFIX_STATUS")
	private int prefixStatus;

	public String getPrefixCode() {
		return prefixCode;
	}

	public void setPrefixCode(String prefixCode) {
		this.prefixCode = prefixCode;
	}

	public String getPrefixDecription() {
		return prefixDecription;
	}

	public void setPrefixDecription(String prefixDecription) {
		this.prefixDecription = prefixDecription;
	}

	public int getPrefixStatus() {
		return prefixStatus;
	}

	public void setPrefixStatus(int prefixStatus) {
		this.prefixStatus = prefixStatus;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((prefixCode == null) ? 0 : prefixCode.hashCode());
		result = prime
				* result
				+ ((prefixDecription == null) ? 0 : prefixDecription.hashCode());
		result = prime * result + prefixStatus;
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
		if (!(obj instanceof Prefix)) {
			return false;
		}
		Prefix other = (Prefix) obj;
		if (prefixCode == null) {
			if (other.prefixCode != null) {
				return false;
			}
		} else if (!prefixCode.equals(other.prefixCode)) {
			return false;
		}
		if (prefixDecription == null) {
			if (other.prefixDecription != null) {
				return false;
			}
		} else if (!prefixDecription.equals(other.prefixDecription)) {
			return false;
		}
		if (prefixStatus != other.prefixStatus) {
			return false;
		}
		return true;
	}
	
	
}
