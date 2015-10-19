package org.akc.dao;

import java.util.List;

import org.akc.dao.model.Prefix;
import org.akc.dao.model.State;
import org.akc.dao.model.Suffix;
import org.akc.dao.model.TimeZones;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author mt40569
 *
 */
public interface TimeZoneDao extends  CrudRepository<TimeZones, Integer> {
	
	
	/**
	 * It takes suffix status as input and returns list of all active suffix record
	 * In case of Exception throws to the calling method
	 */
	List<TimeZones> findByStatus(@Param("status") Integer status) throws DataAccessException;
	
}
