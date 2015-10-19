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
@Table(name = "JUDGINGCATEGORY")
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY,region="judgingcategory")
public class JudgingCategory implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

	public JudgingCategory() {
		super();
		
	}

	/** The state id. */
	@Id
	@GeneratedValue
	@Column(name = "JUDGING_CATEGORY_ID")
	private Integer judgingcategoryId;
	
	/** The state code. */
	@Column(name = "JUDGING_CATEGORY_CODE")
	private String judgingcategoryCode;
	
	/** The state description. */
	@Column(name = "JUDGING_CATEGORY_DESCRIPTITION")
	private String judgingcategoryDescription;
	
	@Column(name = "STATUS")
	private int status;

	public Integer getJudgingcategoryId() {
		return judgingcategoryId;
	}

	public void setJudgingcategoryId(Integer judgingcategoryId) {
		this.judgingcategoryId = judgingcategoryId;
	}

	public String getJudgingcategoryCode() {
		return judgingcategoryCode;
	}

	public void setJudgingcategoryCode(String judgingcategoryCode) {
		this.judgingcategoryCode = judgingcategoryCode;
	}

	public String getJudgingcategoryDescription() {
		return judgingcategoryDescription;
	}

	public void setJudgingcategoryDescription(String judgingcategoryDescription) {
		this.judgingcategoryDescription = judgingcategoryDescription;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((judgingcategoryCode == null) ? 0 : judgingcategoryCode
						.hashCode());
		result = prime
				* result
				+ ((judgingcategoryDescription == null) ? 0
						: judgingcategoryDescription.hashCode());
		result = prime
				* result
				+ ((judgingcategoryId == null) ? 0 : judgingcategoryId
						.hashCode());
		result = prime * result + status;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof JudgingCategory)) {
			return false;
		}
		JudgingCategory other = (JudgingCategory) obj;
		if (judgingcategoryCode == null) {
			if (other.judgingcategoryCode != null) {
				return false;
			}
		} else if (!judgingcategoryCode.equals(other.judgingcategoryCode)) {
			return false;
		}
		if (judgingcategoryDescription == null) {
			if (other.judgingcategoryDescription != null) {
				return false;
			}
		} else if (!judgingcategoryDescription
				.equals(other.judgingcategoryDescription)) {
			return false;
		}
		if (judgingcategoryId == null) {
			if (other.judgingcategoryId != null) {
				return false;
			}
		} else if (!judgingcategoryId.equals(other.judgingcategoryId)) {
			return false;
		}
		if (status != other.status) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "JudgingCategory [judgingcategoryId=" + judgingcategoryId
				+ ", judgingcategoryCode=" + judgingcategoryCode
				+ ", judgingcategoryDescription=" + judgingcategoryDescription
				+ ", status=" + status + "]";
	}

	
	
	
}
