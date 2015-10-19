/*
 * 
 */
package org.akc.dao;

import org.akc.dao.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * User: Mukesh
 * Date: 08/20/15
 */

public interface UserDao extends CrudRepository<User,Long> {
}
