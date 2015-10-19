package org.akc.assembler.impl;

import org.akc.assembler.SecretaryAssembler;
import org.akc.dao.AddressDao;
import org.akc.dao.SecretaryDao;
import org.akc.dao.model.Address;
import org.akc.dao.model.Secretary;
import org.akc.dto.AddressForm;
import org.akc.dto.SecretaryForm;
import org.akc.exception.InvalidException;
import org.akc.transformer.DtoTransformerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


/**
 * Author: Chander
 * Date: 09/08/15
 * SecretaryAssemblerImpl Class for save the Secretary related data and finding the data 
 * by passing Id value.
 */


@Service("secretaryAssembler")
public class SecretaryAssemblerImpl implements SecretaryAssembler {

	/** The Constant logger. */
	final static Logger logger = LoggerFactory.getLogger(SecretaryAssemblerImpl.class);

	/** The secretary dao. */
	@Autowired
	SecretaryDao secretaryDao;

	@Autowired
	@Qualifier("addressDao")
	AddressDao addressDao;

	@Autowired
	@SuppressWarnings("rawtypes")
	DtoTransformerImpl dtoTransformerImpl;

	/**
	 * save Secretary details by passing the save method
	 *
	 * @param SecretaryForm
	 * @return SecretaryForm
	 * @exception InvalidException
	 */
	@Override
	public SecretaryForm saveorUpdateSecretary(SecretaryForm secretaryForm) throws InvalidException {
		logger.info("SAVE SecretaryForm : " + secretaryForm.toString());
		
		Address address = (Address) dtoTransformerImpl.copyObjectDestination2Source(Address.class,secretaryForm.getAddressForm());
		Secretary secretary = (Secretary) dtoTransformerImpl.copyObjectDestination2Source(Secretary.class,secretaryForm);
		secretary.setAddress(address);
		logger.info("SAVE SecretaryDTO : " + secretary.toString());

		Secretary returnedSecretary = secretaryDao.save(secretary);

		logger.info("Returned data from SAVE returnedSecretary : " + returnedSecretary.toString());

		AddressForm returnedaddress = (AddressForm) dtoTransformerImpl.copyObjectDestination2Source(AddressForm.class,returnedSecretary.getAddress());
		SecretaryForm returnsecretaryForm = (SecretaryForm) dtoTransformerImpl.copyObjectDestination2Source(SecretaryForm.class, returnedSecretary);
		returnsecretaryForm.setAddressForm(returnedaddress);

		logger.info("save the Secretary details :: " + secretary);
		logger.info("UI DATA of returnsecretaryForm : " + returnsecretaryForm.toString());

		return returnsecretaryForm;

	}

	/**
	 * findBySecretaryId method will get the secretary based on secretaryId
	 *
	 * @param secretaryId
	 * @return secretaryForm
	 * @exception InvalidException
	 */

	@Override
	public SecretaryForm findBySecretaryId(Integer secretaryId) throws InvalidException {
		logger.info("GET Secretary based on secretaryId : " + secretaryId);
		
		Secretary secretary = secretaryDao.findBySecretaryId(secretaryId);
		logger.info("GET result Secretary DTO on secretaryId  : " + secretary.toString());
		
		AddressForm addressForm = (AddressForm) dtoTransformerImpl.copyObjectDestination2Source(AddressForm.class,secretary.getAddress());
		logger.info("AddressForm data from DAO  : " + addressForm.toString());
		
		SecretaryForm returnsecretaryForm = (SecretaryForm) dtoTransformerImpl.copyObjectDestination2Source(SecretaryForm.class, secretary);
		returnsecretaryForm.setAddressForm(addressForm);
		logger.info("GET result Secretary FORM on event id  : " + returnsecretaryForm.toString());

		return returnsecretaryForm;
	}
		
	
	/**
	 * delete method will delete the secretary based on secretaryId
	 *
	 * @param secretaryId
	 * 
	 * @exception InvalidException
	 */

	@Override
	public void deleteSecretary(Integer secretaryId) throws InvalidException {
		logger.info("GET Secretary based on secretaryId : " + secretaryId);
		
		 secretaryDao.delete(secretaryId);
		logger.info("DELETE result Secretary DTO on secretaryId  : " );
		
		
	}
		
	
	
}
