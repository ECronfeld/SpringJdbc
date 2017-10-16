package com.emil.springjdbc.daoimpl;

import com.emil.springjdbc.dao.testDao;
import com.emil.springjdbc.test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository("orgDao")
public class TestDaoImpl implements testDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    @Override
    public void setDataSource(DataSource ds) {
        jdbcTemplate = new JdbcTemplate(ds);
    }

    @Override
    public boolean create(test org) {
        String sqlQuery = "INSERT INTO test (name, lastname)" + "VALUE(?,?)";
        Object[] args = new Object[]{org.getName(), org.getLastname()};
        return jdbcTemplate.update(sqlQuery, args) == 1;
    }

    @Override
    public test getTest(Integer id) {
        return null;
    }

    @Override
    public List<test> getAllTest() {
        String sqlQuery = "SELECT * FROM test";
        List<test> orgList = jdbcTemplate.query(sqlQuery, new TestRowMapper());

        return orgList;
    }

    @Override
    public boolean delete(test org) {
        return false;
    }

    @Override
    public boolean update(test org) {
        return false;
    }

    @Override
    public void cleanup() {
        String sqlQuery = "TRUNCATE TABLE test";
        jdbcTemplate.execute(sqlQuery);
    }
}
