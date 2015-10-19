package org.akc.dao;

import java.util.List;

import org.akc.dao.model.Event;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Author: chandra
 * Date: 09/08/15
 * By extending CrudRepository by default will get crud sevices
 */
public interface EventDao extends CrudRepository<Event,Long> {
//	 public final static String FIND_BY_EVENT_ID = "SELECT p " + 
//           "FROM Event p " +
//           "WHERE p.eventId = :eventId";
//	 @Query(FIND_BY_EVENT_ID)
	Event findByEventId(@Param("eventId") int i);
 public final static String FIND_BY_CLUB_ID = "SELECT p " + 
   "FROM Event p " +
  "WHERE p.clubId = :clubId";
@Query(FIND_BY_CLUB_ID)	
 public List<Event> findEventByClubId(
			@Param("clubId") Long clubId);
}
