package org.akc.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.akc.assembler.CompetitionAssembler;
import org.akc.assembler.EventCompetitionAssembler;
import org.akc.audit.AuditBuilder;
import org.akc.dao.model.Competition;
import org.akc.dto.CompetitionForm;
import org.akc.dto.EventCompetitionForm;
import org.akc.exception.EmsGenericException;
import org.akc.exception.InvalidException;
import org.akc.util.EmsGenericResponse;
import org.akc.util.LoggerHelper;
import org.akc.ws.CompetitionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/*
  Author: Ashok Doddi
 */

/*
  CompetitionServiceImpl is component service class, used to get,update
  competition details.
 */
@Component("competitionService")
public class CompetitionServiceImpl implements CompetitionService {
	
	long start;
	static final Logger LOGGER = LoggerFactory.getLogger(CompetitionServiceImpl.class);
	public CompetitionServiceImpl() {
		super();
		LoggerHelper.debug(LOGGER, " Executing Default constructor CompetitionServiceImpl class ");
	}


	
	@Resource
	@Qualifier("competitionAssembler")
	CompetitionAssembler competitionAssembler;

	@Autowired
	AuditBuilder auditBuilder;
	
	@Resource()
	@Qualifier("eventCompetitionAssembler")
	EventCompetitionAssembler eventCompetitionAssembler;

	/*
	  method getCompetition will get competition details based on
	  competitionTypeCode and eventId.
	 
	  @param Competition
	  @return Competition
	  @throws InvalidException
	 */

	@Override
	public EmsGenericResponse getCompetition(Integer eventId, Integer competitionId) throws EmsGenericException {
		start=System.currentTimeMillis();
		LOGGER.info("Start getCompetition : "+start+" milliseconds");
		
		LoggerHelper.debug(LOGGER, " Enter in getCompetition method of CompetitionServiceImpl class ");
		
		EmsGenericResponse emsGenericResponse = competitionAssembler.findByEventIdAndCompetitionId(eventId, competitionId);
		
		LoggerHelper.debug(LOGGER, " Value of returned competitionData is : ", emsGenericResponse);
		LoggerHelper.debug(LOGGER, " Enter in getCompetition method of CompetitionServiceImpl class ");

		LOGGER.info("End getCompetition : "+(System.currentTimeMillis()-start+" milliseconds"));
		
		return emsGenericResponse;
	}

	/*
	  method saveCompetition will save competition details based on given input
	  JSON.
	 
	  @param CompetitionForm
	  @return CompetitionForm
	  @throws InvalidException
	 */

	@Override
	public EmsGenericResponse saveCompetition(CompetitionForm competitionForm)
			throws InvalidException {
		start=System.currentTimeMillis();
		LOGGER.info("Start saveCompetition : "+start+" milliseconds");
		LoggerHelper.debug(LOGGER, " Enter in saveCompetition method of CompetitionServiceImpl class ");
		String competitionName = competitionForm.getCompetitionTypeCode()
				+ competitionForm.getEventId();

		if (StringUtils.isEmpty(competitionName)) {
			throw new InvalidException("event name should not be empty");
		}

		String actor = competitionName;
		Map<String, String> fieldMap = prepareForAudit(competitionForm);
		auditBuilder.audit(actor, fieldMap, "saveCompetition");

		EmsGenericResponse emsGenericResponse = competitionAssembler.saveCompetition(competitionForm);
		LoggerHelper.debug(LOGGER, " Value of competitionReturned is : ", emsGenericResponse);
		LoggerHelper.debug(LOGGER, " Exit from  saveCompetition method of CompetitionServiceImpl class   ");
		LOGGER.info("End saveCompetition : "+(System.currentTimeMillis()-start+" milliseconds"));
		return emsGenericResponse;
	}

	/*
	  method updateCompetition will update competition details based on given
	  input JSON.
	 
	  @param CompetitionForm
	  @return CompetitionForm
	  @throws InvalidException
	 */

	@Override
	public EmsGenericResponse updateCompetition(CompetitionForm competitionForm) {
		
		start=System.currentTimeMillis();
		LOGGER.info("Start updateCompetition : "+start+" milliseconds");
		LoggerHelper.debug(LOGGER, " Enter in updateCompetition method of CompetitionServiceImpl class ");
		String competitionName = competitionForm.getCompetitionTypeCode()
				+ competitionForm.getEventId();

		if (StringUtils.isEmpty(competitionName)) {
			throw new InvalidException("event name should not be empty");
		}

		String actor = competitionName;
		Map<String, String> fieldMap = prepareForAudit(competitionForm);
		auditBuilder.audit(actor, fieldMap, "UpdateCompetition");

		EmsGenericResponse emsGenericResponse  = competitionAssembler.updateCompetition(competitionForm);
		LoggerHelper.debug(LOGGER, " Value of competitionReturned is : ", emsGenericResponse);
		LoggerHelper.debug(LOGGER, " Exit from  updateCompetition method of CompetitionServiceImpl class   ");
		LOGGER.info("End updateCompetition : "+(System.currentTimeMillis()-start+" milliseconds"));
		return emsGenericResponse;
	}

	/*
	  method prepareForAudit will Audit save/updated competition details based
	  on based on given input JSON.
	 
	  @param Competition
	  @return Competition
	  @throws InvalidException
	 */

	private Map prepareForAudit(CompetitionForm competitionForm) {
		start=System.currentTimeMillis();
		
		LOGGER.info(" Executing preparaing For Audit method  ");
		LoggerHelper.debug(LOGGER, " Enter in prepareForAudit method of CompetitionServiceImpl class ");
		
		Map fieldMap = new HashMap();
		fieldMap.put("eventId", competitionForm.getEventId().toString());
		fieldMap.put("eventName", competitionForm.getCompetitionTypeCode());
		fieldMap.put("StartDate", new Timestamp(new Date().getTime()));

		LoggerHelper.debug(LOGGER, " Value of prepareForAudit is : "+ fieldMap.toString());
		LoggerHelper.debug(LOGGER, " Exit from  prepareForAudit method of CompetitionServiceImpl class   ");
		LOGGER.info("End prepareForAudit : "+(System.currentTimeMillis()-start+" milliseconds"));
		return fieldMap;
	}

	/*
	  
	  
	  @see org.akc.ws.EventService#getCompetitionTypes(java.lang.Integer) This
	  method is used to get competition type for particular event id It
	  received event id as input and return list of competition type
	 */

/*	@Override
	public List<EventCompetitionForm> getCompetitionTypes(Integer eventId) {
		LoggerHelper.debug(LOGGER, " Enter getCompetitionTypes ");

		Competition competition = new Competition();
		competition.setEventId(eventId);

    	LOGGER.info(" eventId : " + eventId);

		List<Competition> resultedCompetition = eventCompetitionAssembler.competitionTypeListByEventId(competition);

		List<EventCompetitionForm> competitionFormList = new ArrayList<EventCompetitionForm>();

		for (Competition comp : resultedCompetition) {

			EventCompetitionForm competitionForm = new EventCompetitionForm();
			competitionForm.setEventId(comp.getEventId());
			competitionForm.setCompetitionTypeCode(comp.getCompetitionTypeCode());
			competitionForm.setCompetitionId(comp.getCompetitionId());
			competitionFormList.add(competitionForm);
		}

		LOGGER.info(" competittion type size : " + resultedCompetition.size());
		LoggerHelper.debug(LOGGER, " Exit getCompetitionTypes ");
		
		return competitionFormList;

	}*/

}