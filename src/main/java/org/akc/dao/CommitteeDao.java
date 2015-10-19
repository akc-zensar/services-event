package org.akc.dao;

import org.akc.dao.model.Committee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;



/**
 * Author: Chander
 * Date: 09/08/15
 * ChairPersonDao interface for querying CRUD operations on ChairPerson table.
 */

public interface CommitteeDao extends CrudRepository<Committee,Integer> {
	
	/** The Constant FIND_BY_ID_AND_NAME_QUERY is used to get ChairPerson details */
	
	public final static String FIND_BY_COMMITTEE_ID = "SELECT c " + 
            "FROM Committee c " +
            "WHERE c.committeeId = :committeeId";
	 
	/**
	 * method findByEventId will get committee details based on
	 * CommitteeId and CommitteeName
	 *
	 * @param eventId
	 *
	 * @return committee 
	 */
	
 	@Query(FIND_BY_COMMITTEE_ID)
 	Committee findByCommitteeId(@Param("committeeId") Integer id);



}
