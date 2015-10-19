package org.akc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.akc.dao.model.MasterStatus;
import org.akc.exception.EmsGenericException;
import org.akc.util.MasterDataUtil;
import org.akc.ws.UtilService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author mt40569 This class is the implementation of rest services. It load
 *         data from cache and provide key value pair in response It calls
 *         MasterDataUtil class to load record from the database
 *
 */
@Component("utilService")
public class UtilServiceImpl implements UtilService {

	private final static Logger LOGGER = LoggerFactory.getLogger(UtilService.class);
	public final static Integer EVENT_STATUS =1;
	public final static Integer JUDGE_PANEL_STATUS =2;
	

	@Autowired
	MasterDataUtil masterDataUtil;

	/*
	 * This method is used to load the entire list of prefix
	 */

	@Override
	public Map<String, String> getPrefix() throws EmsGenericException {

		debug(" inside : getPrefix");

		return masterDataUtil.getPrefixMap();
	}

	/*
	 * This method is used to load the entire list of sufix
	 */

	@Override
	public Map<String, String> getSufix() throws EmsGenericException {

		debug( " inside : getSufix");

		return masterDataUtil.getSuffixMap();
	}

	/*
	 * This method is used to load the entire list of state
	 */

	@Override
	public Map<Integer, String> getState() throws EmsGenericException {

		debug(" inside : getSufix");

		return masterDataUtil.getStateMap();
	}
	
	@Override
	public Map<Integer, String> getStatus(Integer category) throws EmsGenericException {

		debug(" inside : getStatus");
		
		Map<Integer, String> statusMap = new HashMap<Integer, String>();
		 
		List<MasterStatus> masterStatusList =  masterDataUtil.getMasterStatus();
		
		for(MasterStatus status :masterStatusList){
			
			if(status.getCategory() == category){
				statusMap.put(status.getId(), status.getDescription());
			}
		}
		
		return statusMap;
	}
	
	@Override
	public Map<String,String> getEventSettings() throws EmsGenericException {

		debug(" inside : getEventSetting");

		return masterDataUtil.getEventSetting();
	}

	@Override
	public Map<String,String> getTimeZone() throws EmsGenericException {

		debug(" inside : getTimeZone");
		
		return  masterDataUtil.getTimeZone();
	}
	
	@Override
	public Map<Integer, String> getJudgingCategory() {
		
		debug(" inside : getJudgingCategory");
		
		return  masterDataUtil.getJudgingCategory();
	}
	
	
/*
 * This method is used to log message on debugging state
 */
	
	void debug(String loggMsg) {

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(loggMsg);

		}

	}

	

}
