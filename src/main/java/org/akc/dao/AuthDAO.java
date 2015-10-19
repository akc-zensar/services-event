package org.akc.dao;

import org.akc.dao.model.GenericResponse;
import org.akc.dao.model.UserAccount;


public interface AuthDAO {
	
    //public UserAccount getUserAccountDetails(String userName, String password);
    public GenericResponse getUserAccountDetails(String userName, String password);
}
 