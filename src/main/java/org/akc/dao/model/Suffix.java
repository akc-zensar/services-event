package org.akc.dao.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;



@Entity
@Table(name = "suffix")
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY,region="suffix")

public class Suffix implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The site number. */
	@Id
	@Column(name = "SUFFIX_CODE")
	private String suffixCode;
	
	/** The site name. */
	@Column(name = "SUFFIX_DESCRIPTION")
	private String suffixDecription;
	
	/** The site status. */
	@Column(name = "SUFFIX_STATUS")
	private int suffixStatus;

	public String getSuffixCode() {
		return suffixCode;
	}

	public void setSuffixCode(String suffixCode) {
		this.suffixCode = suffixCode;
	}

	public String getSuffixDecription() {
		return suffixDecription;
	}

	public void setSuffixDecription(String suffixDecription) {
		this.suffixDecription = suffixDecription;
	}

	public int getSuffixStatus() {
		return suffixStatus;
	}

	public void setSuffixStatus(int suffixStatus) {
		this.suffixStatus = suffixStatus;
	}

	

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((suffixCode == null) ? 0 : suffixCode.hashCode());
		result = prime
				* result
				+ ((suffixDecription == null) ? 0 : suffixDecription.hashCode());
		result = prime * result + suffixStatus;
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
		if (!(obj instanceof Suffix)) {
			return false;
		}
		Suffix other = (Suffix) obj;
		if (suffixCode == null) {
			if (other.suffixCode != null) {
				return false;
			}
		} else if (!suffixCode.equals(other.suffixCode)) {
			return false;
		}
		if (suffixDecription == null) {
			if (other.suffixDecription != null) {
				return false;
			}
		} else if (!suffixDecription.equals(other.suffixDecription)) {
			return false;
		}
		if (suffixStatus != other.suffixStatus) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Suffix [suffixCode=" + suffixCode + ", suffixDecription="
				+ suffixDecription + ", suffixStatus=" + suffixStatus + "]";
	}

	
	
}
