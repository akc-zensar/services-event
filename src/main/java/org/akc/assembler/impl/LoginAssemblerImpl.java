 
package org.akc.assembler.impl;

import org.akc.assembler.LoginAssembler;
import org.akc.dao.LoginDao;
import org.akc.dao.model.Login;
import org.akc.exception.InvalidException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service("LoginAssembler")
public class LoginAssemblerImpl implements LoginAssembler {

	@Autowired
	LoginDao loginDao;
	
	public Login findByClubNameAndPassword(Login login) {
		Login loggedIn = loginDao.findByClubNameAndPassword(login.getClubName(),login.getPassword());
		return loggedIn;
	}

	@Override
	public Login findById(Login login) throws InvalidException {
		// TODO Auto-generated method stub
		return loginDao.findById(login.getId());
	}

}
