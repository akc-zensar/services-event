/*
 * 
 */
package org.akc.assembler;

import org.akc.dao.model.Login;
import org.akc.exception.InvalidException;

public interface LoginAssembler {

	public Login findByClubNameAndPassword(Login login) ;

	public Login findById(Login login) throws InvalidException;
}
