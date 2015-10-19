package org.akc.service.impl;

import java.util.UUID;

import org.akc.controller.OcmsEventController;
import org.akc.dao.model.GenericResponse;
import org.akc.dao.model.PasswordService;
import org.akc.service.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("authService")  //ocmsService
public class AuthServiceImpl implements IAuthService {
	@Autowired
	OcmsEventController controller;
	
	@Autowired
	PasswordService pserv;
	
	
	

	@Override
	public GenericResponse getUserAccountDetails(String userName, String password) {
		System.out.println(userName +" : " +password);
		String encryptedPass="";
		try {
			encryptedPass= pserv.encrypt(password);
		} catch (Exception e) {
			System.out.println("Encription Fail");
		}
//		UserAccount user =controller.getUserAccountDetails(userName, encryptedPass);
//		return user;
		
		GenericResponse resp =controller.getUserAccountDetails(userName, encryptedPass);
		return resp;
	}




	@Override
	public GenericResponse getUserAccountDetails(GenericResponse form) {
		
		System.out.println("userName" +" : " +form.getUserName());
		String encryptedPass="";
		try {
			encryptedPass= pserv.encrypt(form.getPassword());
		} catch (Exception e) {
			System.out.println("Encription Fail");
		}
//		UserAccount user =controller.getUserAccountDetails(userName, encryptedPass);
//		return user;
		
		GenericResponse resp =controller.getUserAccountDetails(form.getUserName(), encryptedPass);
		return resp;
	}

}
