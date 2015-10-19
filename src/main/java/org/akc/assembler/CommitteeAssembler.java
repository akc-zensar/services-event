package org.akc.assembler;

import org.akc.dto.CommitteeForm;
import org.akc.exception.InvalidException;


/**
 * Author: Chander
 * Date: 09/08/15
 * ChairPersonAssembler interface for save the ChairPerson related data on ChairPerson table.
 */


public interface CommitteeAssembler {
	
	/**
	  * getCommittee method will get the Committee based on
	 * committeeId properties
	 * 
	 * @param committeeId
	 * @return committee
	 * @throws InvalidException 
	 */
	public CommitteeForm findByCommitteeId(Integer committeeId) throws InvalidException;

	/**
	 * save committee details by passing the  save method
	 *
	 * @param committee
	 * @return committee
	 * @throws InvalidException 
	 */
	public CommitteeForm saveorUpdateCommittee(CommitteeForm committeeForm) throws InvalidException;
	
	
	/**
	  * deleteCommittee method will delete the Committee based on
	 * committeeId, 
	 * 
	 * @param committeeId 
	 * @return  Committee
	 * @throws InvalidException 
	 */
	public void deleteCommittee(Integer committeeId) throws InvalidException;
	
	
}
