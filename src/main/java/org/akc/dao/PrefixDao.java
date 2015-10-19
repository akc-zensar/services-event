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
public interface PrefixDao extends  CrudRepository<Prefix, Long> {
	
	/**
	 * It takes prefix status as input and returns list of all active prefix record
	 * In case of Exception throws to the calling method
	 */
	List<Prefix> findByPrefixStatus(@Param("prefixStatus") Integer prefixStatus) throws DataAccessException;
	
}
