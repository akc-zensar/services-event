package org.akc.assembler.impl;

import org.akc.assembler.CommitteeAssembler;
import org.akc.dao.AddressDao;
import org.akc.dao.CommitteeDao;
import org.akc.dao.model.Address;
import org.akc.dao.model.Committee;
import org.akc.dto.AddressForm;
import org.akc.dto.CommitteeForm;
import org.akc.exception.InvalidException;
import org.akc.transformer.DtoTransformerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Author: Chander Date: 09/08/15 CommitteeAssemblerImpl Class for save the
 * Committee related data and finding the data by passing Id value.
 */

@Service("committeeAssembler")
public class CommitteeAssemblerImpl implements CommitteeAssembler {

	/** The Constant logger. */
	final static Logger logger = LoggerFactory.getLogger(CommitteeAssemblerImpl.class);

	/** The chair person dao. */
	@Autowired
	CommitteeDao committeeDao;

	@Autowired
	@Qualifier("addressDao")
	AddressDao addressDao;

	@Autowired
	@SuppressWarnings("rawtypes")
	DtoTransformerImpl dtoTransformerImpl;

	/**
	 * save Committee details by passing the save method
	 *
	 * @param CommitteeForm
	 * @return CommitteeForm
	 * @exception InvalidException
	 */
	@Override
	public CommitteeForm saveorUpdateCommittee(CommitteeForm committeeForm) throws InvalidException {
		logger.info("SAVE CommitteeFORM : " + committeeForm.toString());
		
		Address address = (Address) dtoTransformerImpl.copyObjectDestination2Source(Address.class,committeeForm.getAddressForm());
		Committee committee = (Committee) dtoTransformerImpl.copyObjectDestination2Source(Committee.class,committeeForm);
		committee.setAddress(address);
		
		logger.info("SAVE CommitteeDTO : " + committee.toString());

		Committee returnedCommittee = committeeDao.save(committee);

		logger.info("Returned data from SAVE returnedcommittee : " + returnedCommittee.toString());

		AddressForm returnedaddress = (AddressForm) dtoTransformerImpl.copyObjectDestination2Source(AddressForm.class,returnedCommittee.getAddress());
		CommitteeForm returncommitteeForm = (CommitteeForm) dtoTransformerImpl.copyObjectDestination2Source(CommitteeForm.class, returnedCommittee);
		returncommitteeForm.setAddressForm(returnedaddress);

		logger.info("save the Committeedetails :: " + committee);
		logger.info("UI DATA of returncommitteeForm : " + returncommitteeForm.toString());

		return returncommitteeForm;

	}

	/**
	 * findByEventId method will get the Committee based on eventId
	 *
	 * @param eventId
	 * @return CommitteeForm
	 * @exception InvalidException
	 */

	@Override
	public CommitteeForm findByCommitteeId(Integer committeeId) throws InvalidException {
		logger.info("GET Committee based on event id  : " + committeeId);
		Committee committee = committeeDao.findByCommitteeId(committeeId);
		logger.info("GET result Committee DTO on event id  : " + committee.toString());
		AddressForm addressForm = (AddressForm) dtoTransformerImpl.copyObjectDestination2Source(AddressForm.class,committee.getAddress());
		logger.info("AddressForm data from DAO  : " + addressForm.toString());
		CommitteeForm returncommitteeForm = (CommitteeForm) dtoTransformerImpl.copyObjectDestination2Source(CommitteeForm.class, committee);
		returncommitteeForm.setAddressForm(addressForm);
		logger.info("GET result Committee FORM on committeeId  : " + returncommitteeForm.toString());

		return returncommitteeForm;
	}
	
	
	/**
	 * delete method will delete the Committee based on committeeId
	 *
	 * @param committeeId
	 * 
	 * @exception InvalidException
	 */

	@Override
	public void deleteCommittee(Integer committeeId) throws InvalidException {
		logger.info("DELETE Committee based on committeeId : " + committeeId);
		
		committeeDao.delete(committeeId);
		logger.info("DELETE result Committee DTO on committeeId  : " );
		
		
	}
	

}
