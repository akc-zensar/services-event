package org.akc.assembler.impl;

import javax.annotation.Resource;

import org.akc.assembler.CompetitionAssembler;
import org.akc.dao.CompetitionDao;
import org.akc.dao.model.Competition;
import org.akc.dto.CompetitionForm;
import org.akc.exception.EmsGenericException;
import org.akc.transformer.BeanTransformer;
import org.akc.util.ApplicationConstants;
import org.akc.util.EmsGenericResponse;
import org.akc.util.Fault;
import org.akc.util.GenericStatus;
import org.akc.util.LoggerHelper;
import org.akc.util.RecordInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/*
  Author: Ashok Doddi 
  Date: 09/08/15 
  CompetitionAssemblerImpl provides the conversion from Model to DTO and vice versa and then call the DAO methods.
 */

@Service("competitionAssembler")
public class CompetitionAssemblerImpl implements CompetitionAssembler {

	static final Logger LOGGER = LoggerFactory.getLogger(CompetitionAssemblerImpl.class);
	@Resource
	@Qualifier("competitionDao")
	//@Autowired
	CompetitionDao competitionDao;
	

	@Autowired
	Fault fault;
	
/*	@SuppressWarnings("rawtypes")
	@Autowired
	DtoTransformerImpl dtoTransformerImpl;*/
	/*@Autowired
	BeanTransformer dtoTransformerImpl;*/
	BeanTransformer dtoTransformerImpl =  new BeanTransformer();
	@Autowired
	GenericStatus genericStatus;
	

	public String createdorUpdatedBy = "USER2";

	/*
	  getByEventIdCompetitionId method will get the competition based on
	  eventId,competitionId properties
	 
	  @param eventId,competitionId
	  @return CompetitionForm
	 */
	@Override
	public EmsGenericResponse findByEventIdAndCompetitionId(Integer eventId, Integer competitionId) throws EmsGenericException {
		LoggerHelper.debug(LOGGER, " Enter in findCompetitionByEventIdCompetitionId method of CompetitionAssemblerImpl class ");
		Competition competition = competitionDao.findByEventIdAndCompetitionId(eventId, competitionId);
		if (competition!=null){
			LoggerHelper.debug(LOGGER, " Value of competitionReturn is : " , competition);
			LoggerHelper.debug(LOGGER, " Exit from  findCompetitionByEventIdCompetitionId method of CompetitionAssemblerImpl class   ");
			loadGenericStatus(competition);
    //return (CompetitionForm) dtoTransformerImpl.copyObjectDestination2Source(CompetitionForm.class, competition);
			CompetitionForm competitionFormReturned = new CompetitionForm();;
			try {
				competitionFormReturned = (CompetitionForm) dtoTransformerImpl.CopyProperties(competition,new CompetitionForm());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		EmsGenericResponse<CompetitionForm> emsGenericResponse = new EmsGenericResponse<CompetitionForm>(competitionFormReturned, null);
		return emsGenericResponse;
		}else {
			//Fault fault = new Fault();
			fault.setErrorMessage(ApplicationConstants.ID_UNAVAILABLE);
			fault.setErrorCode(ApplicationConstants.ID_UNAVAILABLE_CODE);
			fault.setOrigin(" competition getByEventIdCompetitionId ");
			EmsGenericException emsException = new EmsGenericException(fault,"competitionId,eventId");
			 fault = emsException.faultSet("competitionId,eventId");
			
			}
		EmsGenericResponse<CompetitionForm> emsGenericResponse = new EmsGenericResponse<CompetitionForm>(null, fault);   
		return emsGenericResponse;
			}
	/*
	 saveCompetition method will save the competition details based on input
	 JSON.
	 
	 @param CompetitionForm
	 @return CompetitionForm
	 */

	@Override
	public EmsGenericResponse saveCompetition(CompetitionForm competitionForm) throws EmsGenericException {
		Competition competition = new Competition();
		try {
			competition = (Competition) dtoTransformerImpl.CopyProperties(competitionForm,new Competition());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RecordInfo recordInfo = setRecordInfo();
		recordInfo.setCreatedBy(createdorUpdatedBy);
		competition.setRecordInfo(recordInfo);
		competition = competitionDao.save(competition);

		LoggerHelper.debug(LOGGER, " Value of competitionReturn is : " , competition);
		LoggerHelper.debug(LOGGER, " Exit from  saveorUpdateCompetition method of CompetitionAssemblerImpl class   ");
		CompetitionForm competitionFormReturned = new CompetitionForm();
		try {
			competitionFormReturned = (CompetitionForm) dtoTransformerImpl.CopyProperties(competition,new CompetitionForm());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EmsGenericResponse<CompetitionForm> emsGenericResponse = new EmsGenericResponse<CompetitionForm>(competitionFormReturned, null);
		return emsGenericResponse;
	}

	/*
	  UpdateCompetition method will update the competition details based on
	  input JSON.
	 
	  @param CompetitionForm
	  @return CompetitionForm
	 */
	@Override
	public EmsGenericResponse updateCompetition(CompetitionForm competitionForm) throws EmsGenericException {

		RecordInfo recordInfo = setRecordInfo();
		Competition competitionFindOneResult = competitionDao.findOne(competitionForm.getCompetitionId());

		CompetitionForm competitionFindOneResultForm;
		try {
			competitionFindOneResultForm = (CompetitionForm) dtoTransformerImpl.CopyProperties(competitionFindOneResult,new CompetitionForm());
			CompetitionForm competitioncopyfrom2form = (CompetitionForm) dtoTransformerImpl.CopyProperties(competitionForm,competitionFindOneResultForm);
			Competition competitionToUpdate = (Competition) dtoTransformerImpl.CopyProperties(competitioncopyfrom2form,new Competition());
			recordInfo.setCreatedBy(competitionFindOneResult.getRecordInfo().getCreatedBy());
			competitionToUpdate.setRecordInfo(recordInfo);
			Competition competitionUpdated = competitionDao.save(competitionToUpdate);
			loadGenericStatus(competitionUpdated);	
			LoggerHelper.debug(LOGGER, " Value of competitionReturn is : " , competitionToUpdate);
			LoggerHelper.debug(LOGGER, " Exit from  saveorUpdateCompetition method of CompetitionAssemblerImpl class   ");
			CompetitionForm competitionFormReturned = (CompetitionForm) dtoTransformerImpl.CopyProperties(competitionUpdated,new CompetitionForm());
			EmsGenericResponse<CompetitionForm> emsGenericResponse = new EmsGenericResponse<CompetitionForm>(competitionFormReturned, null);	
			return emsGenericResponse;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/*catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
    return null; 	
	}

	
	/*
	  setRecordInfo method will set RecordInfo details and later appended to model Object.
	 
	  @param CompetitionForm
	  @return CompetitionForm
	 */
	public RecordInfo setRecordInfo() {
		RecordInfo recordInfo = new RecordInfo();
		recordInfo.setUpdatedBy(createdorUpdatedBy);
		return recordInfo;
	}

	/*
	  loadGenericStatus method will Load JudgePanelStatus,TimeZones,EventSetting,EventStatus values
	  form key column values.
	  
	  @param competition
	  @return void
	 */
	public void loadGenericStatus(Competition competition) {

		if (genericStatus.getJudgePanelStatusMap().keySet().contains(competition.getJudgePanelStatus())) {
			competition.setJudgePanelStatus((String) genericStatus.getJudgePanelStatusMap().get(competition.getJudgePanelStatus()));
		}
		if (genericStatus.getTimeZonesMap().keySet().contains(competition.getTimeZone())) {
			competition.setTimeZone((String) genericStatus.getTimeZonesMap().get(competition.getTimeZone()));
		}
		if (genericStatus.getEventSettingMap().keySet().contains(competition.getEventSetting())) {
			competition.setEventSetting((String) genericStatus.getEventSettingMap().get(competition.getEventSetting()));
		}
		if (genericStatus.getEventStatusMap().keySet().contains(competition.getEventStatus())) {
			competition.setEventStatus((String) genericStatus.getEventStatusMap().get(competition.getEventStatus()));
		}

	}
}
