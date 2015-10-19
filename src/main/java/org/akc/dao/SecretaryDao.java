package org.akc.dao;

import org.akc.dao.model.Secretary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;



/**
 * Author: Chander
 * Date: 09/08/15
 * SecretaryDao interface for querying CRUD operations on Secretary table.
 */


public interface SecretaryDao extends CrudRepository<Secretary,Integer> {
	
	/** The Constant FIND_BY_SECRETARY_ID is used to get secretary details */
	
	public final static String FIND_BY_SECRETARY_ID = "SELECT s " + 
            "FROM Secretary s " +
            "WHERE s.secretaryId = :secretaryId";
	 
	/**
	 * method findBySecretaryId will get Secretary details based on
	 * secretaryId 
	 *
	 * @param secretaryId
	 *
	 * @return secretary object
	 */
	
 	@Query(FIND_BY_SECRETARY_ID)
	 Secretary findBySecretaryId(@Param("secretaryId") Integer id);

	

	
}
