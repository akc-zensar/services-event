package org.akc.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.akc.assembler.SecretaryAssembler;
import org.akc.audit.AuditBuilder;
import org.akc.dao.model.Secretary;
import org.akc.dto.SecretaryForm;
import org.akc.exception.InvalidException;
import org.akc.transformer.DtoTransformerImpl;
import org.akc.ws.SecretaryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;



/**
 * SecretaryServiceImpl is component service class, used to get,update
 * Secretary details.
 * 
 */
@Component("secretaryService")
public class SecretaryServiceImpl implements SecretaryService {
	
	
	public SecretaryServiceImpl() {
		super();
		if (logger.isDebugEnabled()) {
			logger.debug(" Executing Default constructor SecretaryServiceImpl class ");
		}
	}
	
	
	/** The secretary form. */
	public SecretaryForm secretaryForm;
	
	/** The Constant logger. */
	final static Logger logger = LoggerFactory.getLogger(Secretary.class);
	
	/** The audit builder. */
	@Autowired
	AuditBuilder auditBuilder;
	
	/** The dto transformer. */
	@SuppressWarnings("rawtypes")
	@Autowired 
	DtoTransformerImpl dtoTransformer;
	
	/** The secretary assembler. */
	@Resource
	@Qualifier("secretaryAssembler")
	SecretaryAssembler secretaryAssembler;
	
	
	/**
	 * method saveSecretary will save Secretary details based on given input
	 * JSON.
	 *
	 * @param SecretaryForm
	 * @return SecretaryForm
	 * @throws InvalidException
	 */
	@Override
	public SecretaryForm saveSecretary(SecretaryForm secretaryForm)
			throws InvalidException {
		logger.info("Save or Update Secretary Details : "
				+ secretaryForm.toString());

		if (logger.isDebugEnabled()) {
			logger.debug(" Enter in save or update Secretary method of SecretaryServiceImpl class ");
		}
		String secretaryName = secretaryForm.getFirstName();
				

		if(StringUtils.isEmpty(secretaryName)) {
			throw new InvalidException("competitionName should not be empty");
		}

		String actor = secretaryName;
		Map<String, String> fieldMap = prepareForAudit(secretaryForm);
		auditBuilder.audit(actor, fieldMap, "saveorUpdatesecretary");

		SecretaryForm secretaryReturned = secretaryAssembler
				.saveorUpdateSecretary(secretaryForm);

		if (logger.isDebugEnabled()) {
			logger.debug(" Value of secretaryReturned is : "
					+ secretaryReturned.toString());
			logger.debug(" Exit from  updateSecretary method of SecretaryServiceImpl class   ");
		}
		return secretaryReturned;
	}
	
	/**
	 * method updateSecretary will update Secretary details based on given
	 * input JSON.
	 *
	 * @param secretaryForm
	 * @return secretaryForm
	 * @throws InvalidException
	 */

	@Override
	public SecretaryForm updateSecretary(SecretaryForm secretaryForm) {
		return saveSecretary(secretaryForm);
	}

	/**
	 * method prepareForAudit will Audit save/updated Secretary details based
	 * on based on given input JSON.
	 *
	 * @param Secretary
	 * @return Secretary
	 * @throws InvalidException
	 */

	private Map<String, String> prepareForAudit(SecretaryForm secretaryForm) {
		logger.info(" Executing preparaing For Audit method  ");
		if (logger.isDebugEnabled()) {
			logger.debug(" Enter in prepareForAudit method of SecretaryServiceImpl class ");
		}
		Map<String, String> fieldMap = new HashMap<String, String>();
		//fieldMap.put("eventId", secretaryForm.getEventId().toString());
		fieldMap.put("secretaryId", secretaryForm.getSecretaryId().toString());
		fieldMap.put("firstName", secretaryForm.getFirstName().toString());

		if (logger.isDebugEnabled()) {
			logger.debug(" Value of prepareForAudit is : "
					+ fieldMap.toString());
			logger.debug(" Exit from  prepareForAudit method of SecretaryServiceImpl class   ");
		}

		return fieldMap;
	}
	
	
	/**
	 * method getSecretary will get Secretary details based on
	 *  secretaryId.
	 *
	 * @param Secretary
	 * @return secretaryForm
	 * @throws InvalidException
	 */
	
	@Override
	public SecretaryForm getSecretary(Integer secretaryId) {
		
		if(logger.isDebugEnabled()){
			
			logger.debug(" Enter getSecretary");
		}
		
		logger.info(" secretaryId : "+ secretaryId);
		
		secretaryForm = secretaryAssembler.findBySecretaryId(secretaryId);
		
		if(logger.isDebugEnabled()){
			logger.debug(" secretaryForm :"+secretaryForm.toString());
			logger.debug(" Exit getSecretary");
		}
		
		return secretaryForm;
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
	public void deleteSecretary(Integer secretaryId) {
		
		if(logger.isDebugEnabled()){
			
			logger.debug(" Enter getSecretary");
		}
		
		logger.info(" secretaryId : "+ secretaryId);
		
		 secretaryAssembler.deleteSecretary(secretaryId);
		
		if(logger.isDebugEnabled()){
			logger.debug(" secretaryForm :"+secretaryForm.toString());
			logger.debug(" Exit getSecretary");
		}
		
		
	}

	
}
