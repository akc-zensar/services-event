package org.akc.dao.impl.queries;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;





import org.akc.dao.model.UserAccount;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Component;



public class UserAccountQuery extends BaseQuery<UserAccount>  {
    public UserAccountQuery(DataSource ds, String sql, SqlParameter... parameters) {
        super(ds, sql, parameters);
    }

    @Override
    protected UserAccount mapRow(ResultSet rs, int i) throws SQLException {
    	UserAccount user = new UserAccount();
    	
    	user.setAccountKey(rs.getLong("KEY_ACCOUNT"));
		user.setAccountStatusCode(rs.getString("CDE_ACCOUNT_STATUS"));
		user.setAccountTypeCode(rs.getString("CDE_ACCOUNT_TYPE"));
		user.setClubName(rs.getString("TEXT_LOGIN_CUSTOMER"));
		user.setClubNumber(rs.getString("KEY_STKHLDR_BASE"));
		user.setComments(rs.getString("TEXT_COMMENTS"));
		user.setFirstName(rs.getString("TEXT_NAME_FIRST"));
		user.setLastName(rs.getString("TEXT_NAME_LAST_OR_OTHER"));
		user.setMiddleName(rs.getString("TEXT_NAME_MIDDLE"));
		user.setStkhldrTypeCode(rs.getString("CDE_STKHLDR_BASE_TYPE"));
		user.setEncriptedPass(rs.getString("TEXT_PASSWORD_ENCRYPTED"));
    	return user;
    }
}
