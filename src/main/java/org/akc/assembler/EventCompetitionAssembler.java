package org.akc.assembler;

/**
 * @author Sarwajeet Bharti 
 * This is a service interface for competition component
 */
import java.util.List;

import org.akc.dao.model.Competition;


public interface EventCompetitionAssembler {

	/**
	 * This method returns the competitionList based on the eventId 
	 * @param competition for a given eventId
	 * @return the competition list for a given eventId
	 */
	public List<Competition> competitionTypeListByEventId(
			Competition competition);
}
