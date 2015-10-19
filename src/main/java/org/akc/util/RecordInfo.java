package org.akc.util;


import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.akc.transformer.DtoTransformer;

/*
Author: Ashok Doddi
*/

/*
The RecordInfo is common class for adding WHO columns data for Every Table.
*/

@Embeddable
public class RecordInfo implements DtoTransformer {

	/* The created by. */
	@Column(name = "CREATED_BY")
	public String createdBy;
	
	/* The updated by. */
	@Column(name = "UPDATED_BY")
	public String updatedBy;

	/*
	  Gets the created by.
	 
	  @return the created by
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/*
	  Sets the created by.
	
	  @param createdBy the new created by
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/*
	  Gets the updated by.
	
	 @return the updated by
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}

	/*
	 * Sets the updated by.
	 *
	  @param updatedBy the new updated by
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	/*
	  @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RecordInfo [createdBy=" + createdBy + ", updatedBy=" + updatedBy + "]";
	}

}
