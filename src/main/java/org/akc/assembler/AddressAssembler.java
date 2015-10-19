package org.akc.assembler;

import org.akc.dao.model.Address;
import org.akc.exception.InvalidException;


/**
 * Author: Chander
 * Date: 09/08/15
 * AddressAssembler interface for save the Address related data on Address table 
 */

public interface AddressAssembler {
	
	/**
	 * getAddress method will get the Address based on
	 * AddressId, properties
	 *
	 * @param Address
	 * @return Address
	 * @exception InvalidException
	 */
	 
	public Address findByAddressId(int addressId) throws InvalidException;
	
	/**
	 * save Address details by passing the  save method
	 *
	 * @param Address
	 * @return Address
	 * @exception InvalidException
	 */
	
	
	public Address save(Address address) throws InvalidException;

	

}
