package org.akc.assembler.impl;

import org.akc.assembler.AddressAssembler;
import org.akc.dao.AddressDao;
import org.akc.dao.model.Address;
import org.akc.exception.InvalidException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Author: Chander
 * Date: 09/08/15
 * AddressAssemblerImpl Class for save the Address related data and finding the data 
 * by passing Id value.
 */

//@Repository()
@Service("addressAssembler")
public class AddressAssemblerImpl implements AddressAssembler  {
	
	/** The Constant logger. */
	final static Logger logger = LoggerFactory.getLogger(AddressAssemblerImpl.class); 

	/** The address dao. */
	

	@Autowired
	AddressDao addressDao;

	/**
	 * getAddress method will get the Address based on
	 * AddressId, properties
	 *
	 * @param Address
	 * @return Address
	 * @exception InvalidException
	 */
	
	public Address findByAddressId(int addressId) throws InvalidException {
		
		Address addressinfo = addressDao.findByAddressId(addressId);
		return addressinfo;
	}
	
	/**
	 * save Address details by passing the  save method
	 *
	 * @param Address
	 * @return Address
	 * @exception InvalidException
	 */
	
	@Override
	public Address save(Address address) throws InvalidException {
		
		logger.info("save the address details" + address);
		
		
		return addressDao.save(address);
	}

	
	
}
