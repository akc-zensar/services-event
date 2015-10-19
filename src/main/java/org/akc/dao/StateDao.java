package org.akc.dao;

import java.util.List;

import org.akc.dao.model.Prefix;
import org.akc.dao.model.State;
import org.akc.dao.model.Suffix;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author mt40569
 *
 */
public interface StateDao extends  CrudRepository<State, Long> {
	
	/**
	 * It takes state status as input and returns list of all active state record
	 * In case of Exception throws to the calling method
	 */
	
	List<State> findByStatus(@Param("status") Integer status) throws DataAccessException;

}
