package org.akc.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.akc.dao.EventSettingDao;
import org.akc.dao.JudgingCategoryDao;
import org.akc.dao.PrefixDao;
import org.akc.dao.StateDao;
import org.akc.dao.StatusDao;
import org.akc.dao.SuffixDao;
import org.akc.dao.TimeZoneDao;
import org.akc.dao.model.EventSettings;
import org.akc.dao.model.JudgingCategory;
import org.akc.dao.model.MasterStatus;
import org.akc.dao.model.Prefix;
import org.akc.dao.model.State;
import org.akc.dao.model.Suffix;
import org.akc.dao.model.TimeZones;
import org.akc.exception.EmsGenericException;
import org.akc.exception.InvalidException;
import org.akc.ws.UtilService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.ejb.EntityManagerFactoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Component;


/*
  @author mt40569
  This util class is used to implement to load all static data 
 It load at server startup and keep record active for entire application 
 */
@Component("masterDataUtil")
public class MasterDataUtil {

	@Autowired
	PrefixDao prefixDao;
	
	@Autowired
	SuffixDao suffixDao;
	
	@Autowired
	StateDao stateDao;
	
	@Autowired
	StatusDao statusDao;
	
	@Autowired
	EventSettingDao eventSettingsDao;
	
	@Autowired
	TimeZoneDao timeZoneDao;
	
	@Autowired
	JudgingCategoryDao judgingCategoryDao;

	@Autowired
	LocalContainerEntityManagerFactoryBean entityManagerFactory;

	private static final Logger LOGGER = LogManager
			.getLogger(UtilService.class);

	private Map<String, String> prefixMap = new HashMap<String, String>();
	private Map<String, String> suffixMap = new HashMap<String, String>();
	private Map<Integer, String> stateMap = new HashMap<Integer, String>();
	
	private Map<String, String> timeZone = new HashMap<String, String>();
	private Map<Integer, String> judgingCategory = new HashMap<Integer, String>();
	private Map<String, String> eventSetting = new HashMap<String, String>();
	private List<MasterStatus> masterStatus = new ArrayList<MasterStatus>();
	
		
	
	/*
	 @return the prefixMap
	 */
	public Map<String, String> getPrefixMap() {
		return prefixMap;
	}

	/*
	 @param prefixMap the prefixMap to set
	 */
	public void setPrefixMap(Map<String, String> prefixMap) {
		this.prefixMap = prefixMap;
	}

	/*
	 @return the suffixMap
	 */
	public Map<String, String> getSuffixMap() {
		return suffixMap;
	}

	/*
	 @param suffixMap the suffixMap to set
	 */
	public void setSuffixMap(Map<String, String> suffixMap) {
		this.suffixMap = suffixMap;
	}

	/*
	 @return the stateMap
	 */
	public Map<Integer, String> getStateMap() {
		return stateMap;
	}

	/*
	 @param stateMap the stateMap to set
	 */
	public void setStateMap(Map<Integer, String> stateMap) {
		this.stateMap = stateMap;
	}
	
	

	
	/*
	 @return the timeZone
	 */
	public Map<String, String> getTimeZone() {
		return timeZone;
	}

	/*
	 @param timeZone the timeZone to set
	 */
	public void setTimeZone(Map<String, String> timeZone) {
		this.timeZone = timeZone;
	}

	/*
	 @return the judgingCategory
	 */
	public Map<Integer, String> getJudgingCategory() {
		return judgingCategory;
	}

	/*
	 @param judgingCategory the judgingCategory to set
	 */
	public void setJudgingCategory(Map<Integer, String> judgingCategory) {
		this.judgingCategory = judgingCategory;
	}

	/*
	 @return the eventSetting
	 */
	public Map<String, String> getEventSetting() {
		return eventSetting;
	}

	/*
	 @param eventSetting the eventSetting to set
	 */
	public void setEventSetting(Map<String, String> eventSetting) {
		this.eventSetting = eventSetting;
	}


	
	/*
	 This method load at server load time and cache the record for entire application
	 It called from service layer and calling to dao layer
	 status pass as a input parameter and list of prefix  get out put
	 */
	
	
	

	public List<MasterStatus> getMasterStatus() {
		return masterStatus;
	}

	public void setMasterStatus(List<MasterStatus> masterStatus) {
		this.masterStatus = masterStatus;
	}

	@PostConstruct
	public void getPrefix() throws EmsGenericException {

		List<Prefix> prfixList = prefixDao.findByPrefixStatus(1);

		try {
			EntityManagerFactoryImpl empImpl = (EntityManagerFactoryImpl) entityManagerFactory
					.getNativeEntityManagerFactory();
			LOGGER.debug(empImpl.getSessionFactory().getStatistics());

			for (Prefix dto : prfixList) {
				prefixMap.put(dto.getPrefixCode(), dto.getPrefixDecription());
			}
			
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			throw new EmsGenericException(e.getMessage());

		}

		

	}

	/*
	 This method load at server load time and cache the record for entire application
	 It called from service layer and calling to dao layer
	 status pass as a input parameter and list of suffix get out put
	 */
	
	@PostConstruct
	public void getsuffix() throws InvalidException {
		
		try {
			
			List<Suffix> list = suffixDao.findBySuffixStatus(1);
			
			for(Suffix suffix :list){
				
				suffixMap.put(suffix.getSuffixCode(), suffix.getSuffixDecription());
				
			}
			
		} catch (DataAccessException e) {
			
			LOGGER.error(e.getMessage());
			throw new EmsGenericException(e.getMessage());
		}

	}

	/*
	 This method load at server load time and cache the record for entire application
	 It called from service layer and calling to dao layer
	 status pass as a input parameter and list of state get out put
	 */
	
	@PostConstruct
	public void getState() throws InvalidException {
		
		try {
			
			List<State>list = stateDao.findByStatus(1);
			
			for(State state :list){
				
				stateMap.put(state.getStateId(), state.getStateDesc());
				
			}
				
		} catch (DataAccessException e) {
			
			LOGGER.error(e.getMessage());
			throw new EmsGenericException(e.getMessage());
		}
	}
	
	/*
	 This method load at server load time and cache the record for entire application
	 It called from service layer and calling to dao layer
	 category pass as a input parameter and list of statuses get out put
	 */
	
	@PostConstruct
	public void getStatus() throws InvalidException {
		
		try {
			
			 masterStatus = statusDao.findByStatus(1);
			
			
				
		} catch (DataAccessException e) {
			
			LOGGER.error(e.getMessage());
			throw new EmsGenericException(e.getMessage());
		}
	}
	
	/*
	 This method load at server load time and cache the record for entire application
	 It called from service layer and calling to dao layer
	 status pass as a input parameter and list of suffix get out put
	 */
	
	@PostConstruct
	public void getEventSettings() throws InvalidException {
		
		try {
			
			List<EventSettings> list = eventSettingsDao.findByStatus(1);
			
			for(EventSettings eventSettings :list){
				
				eventSetting.put(eventSettings.getCode(), eventSettings.getDecription());
				
			}
			
		} catch (DataAccessException e) {
			
			LOGGER.error(e.getMessage());
			throw new EmsGenericException(e.getMessage());
		}

	}
	
	/*
	 This method load at server load time and cache the record for entire application
	 It called from service layer and calling to dao layer
	 status pass as a input parameter and list of suffix get out put
	 */
	
	@PostConstruct
	public void getTimeZones() throws InvalidException {
		
		try {
			
			List<TimeZones> list = timeZoneDao.findByStatus(1);
			
			for(TimeZones timeZones :list){
				
				timeZone.put(timeZones.getTimeZoneCode(), timeZones.getTimeZoneDecription());
				
			}
			
		} catch (DataAccessException e) {
			
			LOGGER.error(e.getMessage());
			throw new EmsGenericException(e.getMessage());
		}

	}
	
	/*
	 This method load at server load time and cache the record for entire application
	 It called from service layer and calling to dao layer
	 status pass as a input parameter and list of JudgingCategory as output
	 */
	
	@PostConstruct
	public void getJudgingCategoryMap() throws InvalidException {
		
		try {
			
			List<JudgingCategory> list = judgingCategoryDao.findByStatus(1);
			
			for(JudgingCategory judgingCatg :list){
				
				judgingCategory.put(judgingCatg.getJudgingcategoryId(), judgingCatg.getJudgingcategoryDescription());
				
			}
			
		} catch (DataAccessException e) {
			
			LOGGER.error(e.getMessage());
			throw new EmsGenericException(e.getMessage());
		}

	}
	

}
