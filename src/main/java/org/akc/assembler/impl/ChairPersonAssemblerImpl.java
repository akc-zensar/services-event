package org.akc.assembler.impl;

import org.akc.assembler.ChairPersonAssembler;
import org.akc.dao.AddressDao;
import org.akc.dao.ChairPersonDao;
import org.akc.dao.model.Address;
import org.akc.dao.model.ChairPerson;
import org.akc.dto.AddressForm;
import org.akc.dto.ChairPersonForm;
import org.akc.exception.InvalidException;
import org.akc.transformer.DtoTransformerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Author: Chander Date: 09/08/15 ChairPersonAssemblerImpl Class for save the
 * ChairPerson related data and finding the data by passing Id value.
 */

@Service("chairPersonAssembler")
public class ChairPersonAssemblerImpl implements ChairPersonAssembler {

	/** The Constant logger. */
	final static Logger logger = LoggerFactory.getLogger(ChairPersonAssemblerImpl.class);

	/** The chair person dao. */
	@Autowired
	ChairPersonDao chairPersonDao;

	@Autowired
	@Qualifier("addressDao")
	AddressDao addressDao;

	@Autowired
	@SuppressWarnings("rawtypes")
	DtoTransformerImpl dtoTransformerImpl;

	/**
	 * save ChairPerson details by passing the save method
	 *
	 * @param ChairPersonForm
	 * @return ChairPersonForm
	 * @exception InvalidException
	 */
	@Override
	public ChairPersonForm saveorUpdateChairPerson(ChairPersonForm chairPersonForm) throws InvalidException {
		logger.info("SAVE ChairpersonFORM : " + chairPersonForm.toString());
		Address address = (Address) dtoTransformerImpl.copyObjectDestination2Source(Address.class,chairPersonForm.getAddressForm());
		ChairPerson chairPerson = (ChairPerson) dtoTransformerImpl.copyObjectDestination2Source(ChairPerson.class,chairPersonForm);
		chairPerson.setAddress(address);
		logger.info("SAVE ChairpersonDTO : " + chairPerson.toString());

		ChairPerson returnedChairPerson = chairPersonDao.save(chairPerson);

		logger.info("Returned data from SAVE returnedChairPerson : " + returnedChairPerson.toString());

		AddressForm returnedaddress = (AddressForm) dtoTransformerImpl.copyObjectDestination2Source(AddressForm.class,returnedChairPerson.getAddress());
		ChairPersonForm returnchairPersonForm = (ChairPersonForm) dtoTransformerImpl.copyObjectDestination2Source(ChairPersonForm.class, returnedChairPerson);
		returnchairPersonForm.setAddressForm(returnedaddress);

		logger.info("save the ChairPerson details :: " + chairPerson);
		logger.info("UI DATA of returnchairPersonForm : " + returnchairPersonForm.toString());

		return returnchairPersonForm;

	}

	/**
	 * findByChairPersonId method will get the ChairPerson based on chairPersonId
	 *
	 * @param chairPersonId
	 * @return ChairPersonForm
	 * @exception InvalidException
	 */

	@Override
	public ChairPersonForm findByChairPersonId(Integer chairPersonId) throws InvalidException {
		
		logger.info("GET Chairperson based on chairPersonId  : " + chairPersonId);
		ChairPerson chairPerson = chairPersonDao.findByChairPersonId(chairPersonId);
		
		logger.info("GET result Chairperson DTO on chairPersonId  : " + chairPerson.toString());
		AddressForm addressForm = (AddressForm) dtoTransformerImpl.copyObjectDestination2Source(AddressForm.class,chairPerson.getAddress());
		logger.info("AddressForm data from DAO  : " + addressForm.toString());
		
		ChairPersonForm returnchairPersonForm = (ChairPersonForm) dtoTransformerImpl.copyObjectDestination2Source(ChairPersonForm.class, chairPerson);
		returnchairPersonForm.setAddressForm(addressForm);
		logger.info("GET result Chairperson FORM on chairPersonId  : " + returnchairPersonForm.toString());

		return returnchairPersonForm;
	}

	/**
	 * delete method will delete the ChairPerson based on chairPersonId
	 *
	 * @param chairPersonId
	 * 
	 * @exception InvalidException
	 */

	@Override
	public void deleteChairPerson(Integer chairPersonId) throws InvalidException {
		logger.info("GET ChairPerson based on chairPersonId : " + chairPersonId);
		
		chairPersonDao.delete(chairPersonId);
		logger.info("DELETE result ChairPerson DTO on chairPersonId  : " );
		
		
	}
	
	
}
