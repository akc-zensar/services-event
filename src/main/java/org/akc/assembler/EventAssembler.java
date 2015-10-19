package org.akc.assembler;

import java.util.List;

import org.akc.dao.model.Competition;
import org.akc.dao.model.Event;
import org.akc.dto.EventForm;

/**
 * Author: chandra 
 * Date: 09/08/15 EventAssembler implemented class provides the
 * Business logic
 */
public interface EventAssembler {
	// method defined for getting the event details by eventID
	public Event findByEventId(Event event);
	public List<Event> findEventByClubId(
			Event event);
	public EventForm saveorUpdate(EventForm event) throws Exception;
}