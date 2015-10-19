package org.akc.dao.impl;

import javax.sql.DataSource;

public class BaseDAOJdbcImpl {
    protected DataSource ds;

    public BaseDAOJdbcImpl(DataSource ds) {
        this.ds = ds;
    }
}
