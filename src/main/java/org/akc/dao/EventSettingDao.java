package org.akc.dao;

import java.util.List;

import org.akc.dao.model.EventSettings;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author mt40569
 *
 */
public interface EventSettingDao extends  CrudRepository<EventSettings, String> {
	
	
	/**
	 * It takes Event Setting status as input and returns list of all active EventSetting record
	 * In case of Exception throws to the calling method
	 */
	List<EventSettings> findByStatus(@Param("status") Integer status ) throws DataAccessException;
	
}
