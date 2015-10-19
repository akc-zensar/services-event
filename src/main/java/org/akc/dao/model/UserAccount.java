package org.akc.dao.model;

import java.io.Serializable;
import java.util.Date;


import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;



@XmlRootElement
public class UserAccount implements Serializable {
    
     private static final long serialVersionUID = 1L;
     
     //private GenericResponse response;
     private Long accountKey;
     private Long keyStkhldrBase;
     private String stkhldrTypeCode;
     private String clubNumber;
     private String clubName;
     private String customerLogin;
     private String lastName;
     private String firstName;
     private String middleName;
     private String accountStatusCode;
     private String accountTypeCode;
     private Date effectiveDate;
     private Date endDate;
     private String comments;
     private String encriptedPass;
     
     public UserAccount() {
          super();
     }

     public UserAccount(Long accountKey, Long keyStkhldrBase, String stkhldrTypeCode, String clubNumber,
               String clubName, String customerLogin, String lastName, String firstName, String middleName,
               String accountStatusCode, String accountTypeCode, Date effectiveDate, Date endDate, String comments) {
          super();
          this.accountKey = accountKey;
          this.keyStkhldrBase = keyStkhldrBase;
          this.stkhldrTypeCode = stkhldrTypeCode;
          this.clubNumber = clubNumber;
          this.clubName = clubName;
          this.customerLogin = customerLogin;
          this.lastName = lastName;
          this.firstName = firstName;
          this.middleName = middleName;
          this.accountStatusCode = accountStatusCode;
          this.accountTypeCode = accountTypeCode;
          this.effectiveDate = effectiveDate;
          this.endDate = endDate;
          this.comments = comments;
     }
     
     public Long getAccountKey() {
    		 return accountKey;
          
     }
     
     public void setAccountKey(Long accountKey) {
          this.accountKey = accountKey;
     }
    
     public Long getKeyStkhldrBase() {
          return keyStkhldrBase;
     }
     
     public void setKeyStkhldrBase(Long keyStkhldrBase) {
          this.keyStkhldrBase = keyStkhldrBase;
     }
     
     public String getStkhldrTypeCode() {
    	 if(stkhldrTypeCode==null){
    		  return ""; 
    	  	}else
          return stkhldrTypeCode;
     }
     
     public void setStkhldrTypeCode(String stkhldrTypeCode) {
          this.stkhldrTypeCode = stkhldrTypeCode;
     }

     public String getClubNumber() {
    	 if(clubNumber==null){
     		  return ""; 
     	  	}else
          return clubNumber;
     }
     
     public void setClubNumber(String clubNumber) {
          this.clubNumber = clubNumber;
     }
     
     public String getClubName() {
    	 if(clubName==null){
      		  return ""; 
      	  	}else
          return clubName;
     }
     
     public void setClubName(String clubName) {
          this.clubName = clubName;
     }
     
     public String getCustomerLogin() {
    	 if(customerLogin==null){
   		  return ""; 
   	  	}else
          return customerLogin;
     }
     
     public void setCustomerLogin(String customerLogin) {
          this.customerLogin = customerLogin;
     }
     
     public String getLastName() {
    	 if(lastName==null){
    		  return ""; 
    	  	}else
          return lastName;
     }
     
     public void setLastName(String lastName) {
          this.lastName = lastName;
     }
     
     public String getFirstName() {
    	 if(firstName==null){
     		  return ""; 
     	  	}else
          return firstName;
     }
     
     public void setFirstName(String firstName) {
          this.firstName = firstName;
     }
     
     public String getMiddleName() {
    	 if(middleName==null){
      		  return ""; 
      	  	}else	
          return middleName;
     }
     
     public void setMiddleName(String middleName) {
          this.middleName = middleName;
     }
     
     public String getAccountStatusCode() {
    	 if(accountStatusCode==null){
   		  return ""; 
   	  	}else
          return accountStatusCode;
     }
     
     public void setAccountStatusCode(String accountStatusCode) {
          this.accountStatusCode = accountStatusCode;
     }
    
     public String getAccountTypeCode() {
    	  if(accountTypeCode==null){
    		  return ""; 
    	  }else
          return accountTypeCode;
     }
     
     public void setAccountTypeCode(String accountTypeCode) {
          this.accountTypeCode = accountTypeCode;
     }
     
     public Date getEffectiveDate() {
          return effectiveDate;
     }
     
     public void setEffectiveDate(Date effectiveDate) {
          this.effectiveDate = effectiveDate;
     }
     
     public Date getEndDate() {
    	 
          return endDate;
     }
     
     public void setEndDate(Date endDate) {
          this.endDate = endDate;
     }
     
     public String getComments() {
    	 if(comments==null){
    		 return "";
    	 }else{
          return comments;
    	 }
     }
     
     public void setComments(String comments) {
          this.comments = comments;
     }

     @XmlTransient
     public String getEncriptedPass() {
		return encriptedPass;
	}

	public void setEncriptedPass(String encriptedPass) {
		this.encriptedPass = encriptedPass;
	}

	@Override
     public int hashCode() {
          final int prime = 31;
          int result = 1;
          result = prime * result + ((keyStkhldrBase == null) ? 0 : keyStkhldrBase.hashCode());
          result = prime * result + ((stkhldrTypeCode == null) ? 0 : stkhldrTypeCode.hashCode());
          result = prime * result + ((accountKey == null) ? 0 : accountKey.hashCode());
          result = prime * result + ((accountTypeCode == null) ? 0 : accountTypeCode.hashCode());
          result = prime * result + ((clubName == null) ? 0 : clubName.hashCode());
          result = prime * result + ((clubNumber == null) ? 0 : clubNumber.hashCode());
          result = prime * result + ((customerLogin == null) ? 0 : customerLogin.hashCode());
          return result;
     }

     @Override
     public boolean equals(Object obj) {
          if (this == obj)
               return true;
          if (obj == null)
               return false;
          if (getClass() != obj.getClass())
               return false;
          UserAccount other = (UserAccount) obj;
          if (keyStkhldrBase == null) {
               if (other.keyStkhldrBase != null)
                    return false;
          }
          else if (!keyStkhldrBase.equals(other.keyStkhldrBase))
               return false;
          if (stkhldrTypeCode == null) {
               if (other.stkhldrTypeCode != null)
                    return false;
          }
          else if (!stkhldrTypeCode.equals(other.stkhldrTypeCode))
               return false;
          if (accountKey == null) {
               if (other.accountKey != null)
                    return false;
          }
          else if (!accountKey.equals(other.accountKey))
               return false;
          if (accountTypeCode == null) {
               if (other.accountTypeCode != null)
                    return false;
          }
          else if (!accountTypeCode.equals(other.accountTypeCode))
               return false;
          if (clubName == null) {
               if (other.clubName != null)
                    return false;
          }
          else if (!clubName.equals(other.clubName))
               return false;
          if (clubNumber == null) {
               if (other.clubNumber != null)
                    return false;
          }
          else if (!clubNumber.equals(other.clubNumber))
               return false;
          if (customerLogin == null) {
               if (other.customerLogin != null)
                    return false;
          }
          else if (!customerLogin.equals(other.customerLogin))
               return false;
          return true;
     }

     @Override
     public String toString() {
          return "UserAccount [accountKey=" + accountKey + ", KeyStkhldrBase=" + keyStkhldrBase + ", StkhldrTypeCode="
                    + stkhldrTypeCode + ", clubNumber=" + clubNumber + ", clubName=" + clubName + ", customerLogin="
                    + customerLogin + ", lastName=" + lastName + ", firstName=" + firstName + ", middleName="
                    + middleName + ", accountStatusCode=" + accountStatusCode + ", accountTypeCode=" + accountTypeCode
                    + ", effectiveDate=" + effectiveDate + ", endDate=" + endDate + ", comments=" + comments + "]";
     }
     
}
