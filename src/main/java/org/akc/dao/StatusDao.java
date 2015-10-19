package org.akc.dao;

import java.util.List;

import org.akc.dao.model.MasterStatus;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author mt40569
 *
 */
public interface StatusDao extends  CrudRepository<MasterStatus, Integer> {
	
	/**
	 * It takes state status as input and returns list of all active state record
	 * In case of Exception throws to the calling method
	 */
	
	List<MasterStatus> findByStatus(@Param("category") Integer category) throws DataAccessException;

}
