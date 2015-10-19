/**
 * The Class CompletitionAssemblerImpl.
 * @author Sarwajeet Bharti
 * This is a bussiness serviceImpl for competition component  
 */
package org.akc.assembler.impl;

import java.util.List;

import org.akc.assembler.EventCompetitionAssembler;
import org.akc.dao.CompetitionDao;
import org.akc.dao.model.Competition;
import org.akc.exception.InvalidException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component("eventCompetitionAssembler")
public class EventCompetitionAssemblerImpl implements EventCompetitionAssembler{

	/** The competition dao. */
	@Autowired
	CompetitionDao competitionDao;

	/** The Constant logger. */
	final static Logger logger = LoggerFactory.getLogger(EventCompetitionAssemblerImpl.class);

	/**
	 * Responsible for getting the competition Type list by eventId.
	 *
	 * @param competition
	 *            the competition
	 * @return CompetitionForm which contains the fields to be displayed on form
	 */

	public List<Competition> competitionTypeListByEventId(Competition competition) {
		if (StringUtils.isEmpty(competition.getEventId()) && competition.getEventId() < 0) {
			logger.error(" EventId field can't be blank " + competition.getEventId());
			throw new InvalidException(" EventId field can't be blank");
		}
		List<Competition> CompetitionTypeList = competitionDao.findByEventId(competition.getEventId());
		if (CompetitionTypeList != null && CompetitionTypeList.size() > 0) {
			logger.info("CompetitionTypeList " + CompetitionTypeList.size());
			return CompetitionTypeList;
		} else {
			logger.error("CompetitionType for the given eventId " + competition.getEventId() + " not found ");
			throw new InvalidException(
					" CompetitionType for the given eventId " + competition.getEventId() + " not found ");
		}
	}

}
