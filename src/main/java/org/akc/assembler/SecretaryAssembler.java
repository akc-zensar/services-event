package org.akc.assembler;

import org.akc.dto.SecretaryForm;
import org.akc.exception.InvalidException;



/**
 * Author: Chander
 * Date: 09/08/15
 * SecretaryAssembler interface for save the Secretary related data on Secretary table.
 */

public interface SecretaryAssembler {

	/**
	  * getSecretary method will get the secretary based on
	 * secretaryId, 
	 * 
	 * @param secretaryId 
	 * @return  secretary
	 * @throws InvalidException 
	 */
	public SecretaryForm findBySecretaryId(Integer secretaryId) throws InvalidException;
	
	/**
	* save secretary details by passing the  save method
	 *
	 * @param secretary 
	 * @return  secretary
	 * @throws InvalidException 
	 */
	public SecretaryForm saveorUpdateSecretary(SecretaryForm secretaryForm) throws InvalidException;
	
	
	/**
	  * deleteSecretary method will delete the secretary based on
	 * secretaryId, 
	 * 
	 * @param secretaryId 
	 * @return  secretary
	 * @throws InvalidException 
	 */
	public void deleteSecretary(Integer secretaryId) throws InvalidException;
	
	
	
	
	
}
