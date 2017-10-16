package com.emil.springjdbc.daoimpl;

import com.emil.springjdbc.test;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class TestRowMapper implements RowMapper<test> {

    @Override
    public test mapRow(ResultSet rs, int i) throws SQLException {
        test tesst = new test();
        tesst.setId(rs.getInt("idtest"));
        tesst.setName(rs.getString("name"));
        tesst.setLastname(rs.getString("lastname"));

        return tesst;
    }
}
