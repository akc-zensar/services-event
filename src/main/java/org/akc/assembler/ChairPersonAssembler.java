package org.akc.assembler;

import org.akc.dto.ChairPersonForm;
import org.akc.exception.InvalidException;


/**
 * Author: Chander
 * Date: 09/08/15
 * ChairPersonAssembler interface for save the ChairPerson related data on ChairPerson table.
 */


public interface ChairPersonAssembler {
	
	/**
	  * getChairPerson method will get the ChairPerson based on
	 * ChairPersonId, Chairperson Name properties
	 * 
	 * @param eventId
	 * @return chair person
	 * @throws InvalidException 
	 */
	public ChairPersonForm findByChairPersonId(Integer chairPersonId) throws InvalidException;

	/**
	 * save Address details by passing the  save method
	 *
	 * @param chairperson
	 * @return chair person
	 * @throws InvalidException 
	 */
	public ChairPersonForm saveorUpdateChairPerson(ChairPersonForm chairPersonForm) throws InvalidException;
	
	/**
	  * deleteChairPerson method will delete the secretary based on
	 * chairPersonId, 
	 * 
	 * @param chairPersonId 
	 * @return  hairPerson
	 * @throws InvalidException 
	 */
	public void deleteChairPerson(Integer chairPersonId) throws InvalidException;
	
	
	
}
