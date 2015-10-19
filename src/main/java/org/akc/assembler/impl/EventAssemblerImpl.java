package org.akc.assembler.impl;

import java.util.List;

import org.akc.assembler.EventAssembler;
import org.akc.dao.EventDao;
import org.akc.dao.model.Event;
import org.akc.dao.model.Site;
import org.akc.dao.model.State;
import org.akc.dto.EventForm;
import org.akc.exception.InvalidException;
import org.akc.transformer.DtoTransformerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Author: chandra 
 * Date: 09/08/15 
 * EventAssembler implemented class provides the Business logic
 */

@Service("EventAssembler")
public class EventAssemblerImpl implements EventAssembler {

	final static Logger logger = LoggerFactory
			.getLogger(EventAssemblerImpl.class);

	@Autowired
	EventDao eventDao;
	
	@Autowired
	DtoTransformerImpl dtoTransformerImpl;

	// method defined for getting the event details by eventID
	public Event findByEventId(Event event) {

		logger.info("Inside findByEventId of EventAssemblerImpl" + event);

		Event eventinfo = eventDao.findByEventId(event.getEventId());
		return eventinfo;
	}
	public List<Event> findEventByClubId(Event event) {
		if (StringUtils.isEmpty(event.getClubId()) && event.getClubId() < 0) {
			logger.error(" ClubId field can't be blank " + event.getClubId());
			throw new InvalidException(" ClubId field can't be blank");
		}
		List<Event> EventTypeList = eventDao.findEventByClubId(event.getClubId());
		if (EventTypeList != null && EventTypeList.size() > 0) {
			logger.info("EventTypeList " + EventTypeList.size());
			return EventTypeList;
		} else {
			logger.error("CompetitionType for the given eventId " + event.getClubId() + " not found ");
			throw new InvalidException(
					" CompetitionType for the given eventId " + event.getClubId() + " not found ");
		}
	}	
	@Override
	public EventForm saveorUpdate(EventForm eventForm) throws Exception {

		Event event = (Event) dtoTransformerImpl.copyObjectDestination2Source(Event.class, eventForm);
		Site site = new Site();
		site.setSiteId(eventForm.getSite().getSiteId());
		event.setSite(site);
		State state = new State();
		state.setStateId(eventForm.getState().getStateId());
		event.setState(state);
		event = eventDao.save(event);
	    return (EventForm) dtoTransformerImpl.copyObjectDestination2Source(EventForm.class, event);
	}
}
