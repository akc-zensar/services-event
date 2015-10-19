package org.akc.dao;

import java.util.List;

import org.akc.dao.model.EventSettings;
import org.akc.dao.model.JudgingCategory;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface JudgingCategoryDao extends  CrudRepository<JudgingCategory, Integer> {
	
	
	/**
	 * It takes Judging Category status as input and returns list of all active JudgingCategory record
	 * In case of Exception throws to the calling method
	 */
	List<JudgingCategory> findByStatus(@Param("status") Integer status ) throws DataAccessException;
}
