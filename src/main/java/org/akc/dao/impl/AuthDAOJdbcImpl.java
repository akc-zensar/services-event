package org.akc.dao.impl;


import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;






import org.akc.dao.AuthDAO;
import org.akc.dao.impl.queries.UserAccountQuery;
import org.akc.dao.model.GenericResponse;
import org.akc.dao.model.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;


public class AuthDAOJdbcImpl extends BaseDAOJdbcImpl implements AuthDAO {
	
	private UserAccountQuery userAccountQuery;
   
	@Autowired
	GenericResponse resp;
	
	public AuthDAOJdbcImpl(DataSource ds) {
        super(ds);
    }
    
 public UserAccountQuery getUserAccountQuery() {
		return userAccountQuery;
	}

	public void setUserAccountQuery(UserAccountQuery userAccountQuery) {
		this.userAccountQuery = userAccountQuery;
	}

	
//@SuppressWarnings(value = { "null" })	
//public UserAccount getUserAccountDetails(String userName,String password){
//	
//		String  encriptedPass= password;
//		List<UserAccount> userList=new ArrayList<UserAccount>();
//		UserAccount ua=null;
//		
//	
//			userList = userAccountQuery.execute(userName);
//			if(userList.size()>1){
//				for (int i=0; i < userList.size(); i++) {
//					 ua =userList.get(i);
//					if(ua.getEncriptedPass()!=null && ua.getEncriptedPass().equalsIgnoreCase(encriptedPass)){
//						userList.removeAll(userList);
//						resp.setMessage("Succes");
//						ua.setResponse(resp);
//						userList.add(ua);
//					}else{
//						resp.setMessage("Your Password is not valid, Please contact AKC- helpdesk@akc.org"); 
//						resp.setSuccess(false);
//						ua.setResponse(resp);
//						userList.add(ua);
//						}
//					}
//				}else if(userList.size()==1){
//					ua = userList.get(0);
//					if(ua.getEncriptedPass()!=null && ua.getEncriptedPass().equalsIgnoreCase(encriptedPass)){
//						userList.removeAll(userList);
//						resp.setMessage("Succes");
//						resp.setSuccess(true);
//						ua.setEncriptedPass("");
//						ua.setResponse(resp);
//						userList.add(ua);
//					}else{
//						resp.setMessage("Your Password is not valid, Please contact AKC- helpdesk@akc.org"); 
//						resp.setSuccess(false);
//						userList.remove(0);
//						ua=new UserAccount();
//						ua.setResponse(resp);
//						userList.add(ua);
//						
//					}
//				}
//				else if(userList.size()==0){
//					resp.setMessage("Your Password is not valid, Please contact AKC- helpdesk@akc.org");
//					ua.setResponse(resp);
//					userList.add(ua);
//				}
//			
//	 return userList.get(0);
// 	}
	
public GenericResponse getUserAccountDetails(String userName,String password){
	
	String  encriptedPass= password;
	List<UserAccount> userList=new ArrayList<UserAccount>();
	UserAccount ua=null;
	GenericResponse resp=new GenericResponse();

		userList = userAccountQuery.execute(userName);
		if(userList.size()>1){
			for (int i=0; i < userList.size(); i++) {
				 ua =userList.get(i);
				if(ua.getEncriptedPass()!=null && ua.getEncriptedPass().equalsIgnoreCase(encriptedPass)){
					userList.removeAll(userList);
					resp.setMessage("Succes");
					resp.setSuccess(true);
					resp.setUserAccount(ua);
					//ua.setResponse(resp);
					//userList.add(ua);
				}else{
					resp.setMessage("Your Password is not valid, Please contact AKC- helpdesk@akc.org"); 
					resp.setSuccess(false);
					//ua.setResponse(resp);
					//userList.add(ua);
					}
				}
			}else if(userList.size()==1){
				ua = userList.get(0);
				if(ua.getEncriptedPass()!=null && ua.getEncriptedPass().equalsIgnoreCase(encriptedPass)){
					userList.removeAll(userList);
					resp.setMessage("Succes");
					resp.setSuccess(true);
					ua.setEncriptedPass("");
					resp.setUserAccount(ua);
					//ua.setResponse(resp);
					//userList.add(ua);
				}else{
					resp.setMessage("Your Password is not valid, Please contact AKC- helpdesk@akc.org"); 
					resp.setSuccess(false);
					userList.remove(0);
					//ua=new UserAccount();
					//ua.setResponse(resp);
					//userList.add(ua);
					
				}
			}
			else if(userList.size()==0){
				resp.setMessage("Your Password is not valid, Please contact AKC- helpdesk@akc.org");
				resp.setSuccess(false);
				//ua.setResponse(resp);
				//userList.add(ua);
			}
		
 return resp;
	}
}
