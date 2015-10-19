package org.akc.dao;

import org.akc.dao.model.Superintendent;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;



/**
 * Author: Chander
 * Date: 09/08/15
 * SuperintendentDao interface for querying CRUD operations on Superintendent table.
 */

public interface SuperintendentDao extends CrudRepository<Superintendent,Long> {
	
	
	
	/** The Constant FIND_BY_ID_AND_NAME_QUERYis used to get superintendent details */
	
	public final static String FIND_BY_ID_AND_NAME_QUERY = "SELECT s " + 
            "FROM Superintendent s " +
            "WHERE s.superintendentId = :superintendentId AND s.superintendentName = :superintendentName";
	 
	/**
	 * method findByIdAndName will get Superintendent details based on
	 * superintendentId and superintendentName
	 *
	 * @param superintendentId,superintendentName
	 *
	 * @return superintendent object
	 */
	
 	@Query(FIND_BY_ID_AND_NAME_QUERY)
	 Superintendent findByIdAndName(@Param("superintendentId") Long id, @Param("superintendentName") String name);

}
