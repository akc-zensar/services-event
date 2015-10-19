/*
 * 
 */
package org.akc.dao;

import org.akc.dao.model.Login;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;



// TODO: Auto-generated Javadoc
/**
 * User: Mukesh
 * Date: 08/20/15.
 */
public interface LoginDao extends Repository<Login, Long>{

	 /** The Constant FIND_BY_CLUB_PASSWORD_QUERY. */
 	public final static String FIND_BY_CLUB_PASSWORD_QUERY = "SELECT p " + 
             "FROM Login p " +
             "WHERE p.clubName = :clubName AND P.password = :password";
	 
 	/**
 	 * Find by club name and password.
 	 *
 	 * @param clubName the club name
 	 * @param password the password
 	 * @return the login
 	 */
 	@Query(FIND_BY_CLUB_PASSWORD_QUERY)
	Login findByClubNameAndPassword(@Param("clubName") String clubName, @Param("password") String password);
	
	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the login
	 */
	Login findById(Long id);
}
