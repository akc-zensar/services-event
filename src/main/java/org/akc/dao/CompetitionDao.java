/*
 The Interface CompetitionDao.
 
 @author Sarwajeet Bharti , Ashok Doddi
 This is a Dao interface for competition component
 */
package org.akc.dao;

import java.util.List;

import org.akc.dao.model.Competition;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/*
  Author: Ashok Doddi Date: 09/09/15 CompetitionDao interface for querying CRUD
  operations on Competition table.
 */

public interface CompetitionDao extends CrudRepository<Competition, Integer> {

	/*
	  method getByEventIdCompetitionId will get competition details based on
	  competitionId and eventId.
	 
	  @param competitionId,eventId
	 
	  @return the competition Model
	 */
	public Competition findByEventIdAndCompetitionId(@Param("eventId") Integer eventId,
			@Param("competitionId") Integer competitionId);

	/*
	  method is brings the competition list for a given eventId from the
	  database
	 
	 */

	/*
	  Find by event id.
	 
	  @param eventId
	             the event id
	  @return List<Competition>
	 */

	public List<Competition> findByEventId(@Param("eventId") Integer eventId);

}
