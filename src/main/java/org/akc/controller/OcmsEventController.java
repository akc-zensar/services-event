package org.akc.controller;

import org.akc.dao.AuthDAO;
import org.akc.dao.model.GenericResponse;
import org.akc.dao.model.UserAccount;





public class OcmsEventController {
   
    private AuthDAO akcEventDao;
    

    /**
     * Constructor.
     */
    public OcmsEventController() {
    }

    public AuthDAO getAkcEventDao() {
		return akcEventDao;
	}


	public void setAkcEventDao(AuthDAO akcEventDao) {
		this.akcEventDao = akcEventDao;
	}

//String productName, String metricID
//	public UserAccount getUserAccountDetails(String userName, String password) {
//    	return akcEventDao.getUserAccountDetails(userName, password);
//    }
    
	
	public GenericResponse getUserAccountDetails(String userName, String password) {
    	return akcEventDao.getUserAccountDetails(userName, password);
    }
    

    
}
