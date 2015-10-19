package org.akc.assembler;

import org.akc.dao.model.Superintendent;
import org.akc.exception.InvalidException;



/**
 * Author: Chander
 * Date: 09/08/15
 * SuperintendentAssembler interface for save the Superintendent related data on Superintendent table.
 */

public interface SuperintendentAssembler {

	/**
	  * getSuperintendent method will get the superintendent based on
	 * superintendentId, superintendent Name properties

	 * @param superintendent 
	 * @return superintendent
	 * @throws InvalidException
	 */
	public Superintendent findByIdAndName(long superintendentId,String SuperintendentName) throws InvalidException;

	/**
	* save superintendent details by passing the  save method
	 *
	 * @param superintendent 
	 * @return  superintendent
	 * @throws InvalidException
	 */
	public Superintendent save(Superintendent superintendent) throws InvalidException;
	
}
