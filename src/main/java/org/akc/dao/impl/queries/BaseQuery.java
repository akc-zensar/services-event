package org.akc.dao.impl.queries;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;

public abstract class BaseQuery<T> extends MappingSqlQuery<T> {
    public BaseQuery(DataSource ds, String sql, SqlParameter... parameters) {
        super(ds, sql);

        for (SqlParameter sp : parameters) {
            declareParameter(sp);
        }

        setFetchSize(1000);
        compile();
    }

    public BaseQuery(DataSource ds, String sql) {
        super(ds, sql);

        setFetchSize(1000);
        compile();
    }
}
