package org.akc.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.akc.assembler.CommitteeAssembler;
import org.akc.audit.AuditBuilder;
import org.akc.dao.model.Committee;
import org.akc.dto.CommitteeForm;
import org.akc.exception.InvalidException;
import org.akc.transformer.DtoTransformerImpl;
import org.akc.ws.CommitteeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component("committeeService")
public class CommitteeServiceImpl implements CommitteeService {
	
	
	public CommitteeServiceImpl() {
		super();
		if (logger.isDebugEnabled()) {
			logger.debug(" Executing Default constructor CommitteeServiceImpl class ");
		}
	}
	
	
	public CommitteeForm committeeForm;

	final static Logger logger = LoggerFactory.getLogger(Committee.class);
	
	/** The audit builder. */
	@Autowired
	AuditBuilder auditBuilder;
	
	/** The dto transformer. */
	@SuppressWarnings("rawtypes")
	@Autowired 
	DtoTransformerImpl dtoTransformer;
		

	@Resource
	@Qualifier("committeeAssembler")
	CommitteeAssembler committeeAssembler;

	@Override
	public CommitteeForm saveCommittee(CommitteeForm committeeForm)
			throws InvalidException {
		logger.info("Update Committee Details : "
				+ committeeForm.toString());

		if (logger.isDebugEnabled()) {
			logger.debug(" Enter in updateCommittee method of CommitteeServiceImpl class ");
		}
		String committeeName = committeeForm.getCommitteeId().toString();
				

		if(StringUtils.isEmpty(committeeName)) {
			throw new InvalidException("committeeName should not be empty");
		}

		String actor = committeeName;
		Map<String, String> fieldMap = prepareForAudit(committeeForm);
		auditBuilder.audit(actor, fieldMap, "saveorUpdatecommittee");

		CommitteeForm committeeReturned = committeeAssembler
				.saveorUpdateCommittee(committeeForm);

		if (logger.isDebugEnabled()) {
			logger.debug(" Value of committeeReturned is : "
					+ committeeReturned.toString());
			logger.debug(" Exit from  updateCommittee method of CommitteeServiceImpl class   ");
		}
		return committeeReturned;
	}
	
	/**
	 * method updateCommittee will update Committee details based on given
	 * input JSON.
	 *
	 * @param committeeForm
	 * @return committeeForm
	 * @throws InvalidException
	 */

	@Override
	public CommitteeForm updateCommittee(CommitteeForm committeeForm) {
		return saveCommittee(committeeForm);
	}

	/**
	 * method prepareForAudit will Audit save/updated Committee details based
	 * on based on given input JSON.
	 *
	 * @param CommitteeForm
	 * @return CommitteeForm
	 * @throws InvalidException
	 */

	private Map<String, String> prepareForAudit(CommitteeForm committeeForm) {
		logger.info(" Executing preparaing For Audit method  ");
		if (logger.isDebugEnabled()) {
			logger.debug(" Enter in prepareForAudit method of CommitteeServiceImpl class ");
		}
		Map<String, String> fieldMap = new HashMap<String, String>();
		fieldMap.put("eventId", committeeForm.getEventId().toString());
		fieldMap.put("committeeId", committeeForm.getCommitteeId().toString());
		fieldMap.put("firstName", committeeForm.getFirstName().toString());

		if (logger.isDebugEnabled()) {
			logger.debug(" Value of prepareForAudit is : "
					+ fieldMap.toString());
			logger.debug(" Exit from  prepareForAudit method of CommitteeServiceImpl class   ");
		}

		return fieldMap;
	}
		
	

	@Override
	public CommitteeForm getCommittee(Integer committeeId) {
		
		if(logger.isDebugEnabled()){
			
			logger.debug(" Enter getCommittee");
		}
		
		logger.info(" eventId : "+ committeeId);
		
		committeeForm = committeeAssembler.findByCommitteeId(committeeId);
		
		if(logger.isDebugEnabled()){
			logger.debug(" CommitteeForm :"+committeeForm.toString());
			logger.debug(" Exit getCommittee");
		}
		
		return committeeForm;
	}
 
	
 
	/**
	 * method deleteCommittee will delete Committee details based on
	 *  secretaryId.
	 *
	 * @param secretaryId
	 * @return secretaryForm
	 * @throws InvalidException
	 */
	
	@Override
	public void deleteCommittee(Integer committeeId) {
		
		if(logger.isDebugEnabled()){
			
			logger.debug(" Enter deleteCommittee");
		}
		
		logger.info(" chairPersonId : "+ committeeId);
		
		committeeAssembler.deleteCommittee(committeeId);
		
		if(logger.isDebugEnabled()){
			logger.debug(" committeeForm :"+committeeForm.toString());
			logger.debug(" Exit deleteCommittee");
		}
		
		
	}
	

}
