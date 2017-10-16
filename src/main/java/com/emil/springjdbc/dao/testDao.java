package com.emil.springjdbc.dao;

import com.emil.springjdbc.test;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.util.List;

public interface testDao {

    public void setDataSource(DataSource ds);

    public boolean create(test org);

    public test getTest(Integer id);

    public List<test> getAllTest();

    public boolean delete(test org);

    public boolean update(test org);

    public void cleanup();



}
