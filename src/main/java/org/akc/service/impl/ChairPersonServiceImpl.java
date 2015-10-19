package org.akc.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.akc.assembler.ChairPersonAssembler;
import org.akc.audit.AuditBuilder;
import org.akc.dao.model.ChairPerson;
import org.akc.dto.ChairPersonForm;
import org.akc.exception.InvalidException;
import org.akc.transformer.DtoTransformerImpl;
import org.akc.ws.ChairPersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component("chairPersonService")
public class ChairPersonServiceImpl implements ChairPersonService {
	
	public ChairPersonServiceImpl() {
		super();
		if (logger.isDebugEnabled()) {
			logger.debug(" Executing Default constructor ChairPersonServiceImpl class ");
		}
	}
	
	
	public ChairPersonForm chairPersonForm;

	final static Logger logger = LoggerFactory.getLogger(ChairPerson.class);
		
	/** The audit builder. */
	@Autowired
	AuditBuilder auditBuilder;
	
	/** The dto transformer. */
	@SuppressWarnings("rawtypes")
	@Autowired 
	DtoTransformerImpl dtoTransformer;

	@Resource
	@Qualifier("chairPersonAssembler")
	ChairPersonAssembler chairPersonAssembler;

	@Override
	public ChairPersonForm saveChairPerson(ChairPersonForm chairPersonForm)
			throws InvalidException {
		logger.info("Update ChairPerson Details : "
				+ chairPersonForm.toString());

		if (logger.isDebugEnabled()) {
			logger.debug(" Enter in updateChairPerson method of ChairPersonServiceImpl class ");
		}
		String chairPersonName = chairPersonForm.getChairPersonId().toString();
				

		if(StringUtils.isEmpty(chairPersonName)) {
			throw new InvalidException("chairPersonName should not be empty");
		}

		String actor = chairPersonName;
		Map<String, String> fieldMap = prepareForAudit(chairPersonForm);
		auditBuilder.audit(actor, fieldMap, "saveorUpdatechairPerson");
		

		ChairPersonForm chairPersonReturned = chairPersonAssembler
				.saveorUpdateChairPerson(chairPersonForm);

		if (logger.isDebugEnabled()) {
			logger.debug(" Value of chairPersonReturned is : "
					+ chairPersonReturned.toString());
			logger.debug(" Exit from  updatechairPerson method of ChairPersonServiceImpl class   ");
		}
		return chairPersonReturned;
	}
	
	/**
	 * method updateChairPerson will update ChairPerson details based on given
	 * input JSON.
	 *
	 * @param chairPersonForm
	 * @return chairPersonForm
	 * @throws InvalidException
	 */

	@Override
	public ChairPersonForm updateChairPerson(ChairPersonForm chairPersonForm) {
		return saveChairPerson(chairPersonForm);
	}

	/**
	 * method prepareForAudit will Audit save/updated ChairPersonForm details based
	 * on based on given input JSON.
	 *
	 * @param ChairPerson
	 * @return ChairPerson
	 * @throws InvalidException
	 */

	private Map<String, String> prepareForAudit(ChairPersonForm chairPersonForm) {
		logger.info(" Executing preparaing For Audit method  ");
		if (logger.isDebugEnabled()) {
			logger.debug(" Enter in prepareForAudit method of ChairPersonServiceImpl class ");
		}
		Map<String, String> fieldMap = new HashMap<String, String>();
		fieldMap.put("eventId", chairPersonForm.getEventId().toString());
		fieldMap.put("chairPersonId", chairPersonForm.getChairPersonId().toString());
		fieldMap.put("firstName", chairPersonForm.getFirstName().toString());

		if (logger.isDebugEnabled()) {
			logger.debug(" Value of prepareForAudit is : "
					+ fieldMap.toString());
			logger.debug(" Exit from  prepareForAudit method of ChairPersonServiceImpl class   ");
		}

		return fieldMap;
	}

	@Override
	public ChairPersonForm getChairPerson(Integer chairPersonId) {
		
		if(logger.isDebugEnabled()){
			
			logger.debug(" Enter getChairPerson");
		}
		
		logger.info(" eventId : "+ chairPersonId);
		
		chairPersonForm = chairPersonAssembler.findByChairPersonId(chairPersonId);
		
		if(logger.isDebugEnabled()){
			logger.debug(" chairPersonForm :"+chairPersonForm.toString());
			logger.debug(" Exit getChairPerson");
		}
		
		return chairPersonForm;
	}
 
	
	/**
	 * method deleteSecretary will delete Secretary details based on
	 *  secretaryId.
	 *
	 * @param secretaryId
	 * @return secretaryForm
	 * @throws InvalidException
	 */
	
	@Override
	public void deleteChairPerson(Integer chairPersonId) {
		
		if(logger.isDebugEnabled()){
			
			logger.debug(" Enter deleteChairPerson");
		}
		
		logger.info(" chairPersonId : "+ chairPersonId);
		
		chairPersonAssembler.deleteChairPerson(chairPersonId);
		
		if(logger.isDebugEnabled()){
			logger.debug(" chairPersonForm :"+chairPersonForm.toString());
			logger.debug(" Exit deleteChairPerson");
		}
		
		
	}


}
