package org.akc.dao;

import org.akc.dao.model.ChairPerson;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;



/**
 * Author: Chander
 * Date: 09/08/15
 * ChairPersonDao interface for querying CRUD operations on ChairPerson table.
 */

public interface ChairPersonDao extends CrudRepository<ChairPerson,Integer> {
	
	/** The Constant FIND_BY_ID_AND_NAME_QUERY is used to get ChairPerson details */
	
	public final static String FIND_BY_CHAIRPERSON_ID = "SELECT c " + 
            "FROM ChairPerson c " +
            "WHERE c.chairPersonId = :chairPersonId";
	 
	/**
	 * method findByEventId will get chairperson details based on
	 * chairPersonId and chairPersonName
	 *
	 * @param eventId
	 *
	 * @return chairPerson 
	 */
	
 	@Query(FIND_BY_CHAIRPERSON_ID)
	 ChairPerson findByChairPersonId(@Param("chairPersonId") Integer id);



}
