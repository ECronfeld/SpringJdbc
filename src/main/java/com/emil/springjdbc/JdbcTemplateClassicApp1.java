package com.emil.springjdbc;

import com.emil.springjdbc.dao.testDao;
import com.emil.springjdbc.daoimpl.TestDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class JdbcTemplateClassicApp1 {
    public static void main(String [] args){

        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.cp.xml");

        testDao dao = (TestDaoImpl) ctx.getBean("orgDao");

        // creating seed data
        DaoUtils.createSeedData(dao);

        List<test> orgs = dao.getAllTest();
        DaoUtils.printTest(orgs, DaoUtils.readOperation);

        test org = new test("Emmm" ,"hey");
        boolean isCreated = dao.create(org);
        DaoUtils.printSuccessFailure(DaoUtils.createOperation, isCreated);
        DaoUtils.printTest(dao.getAllTest(), DaoUtils.readOperation);

        ((ClassPathXmlApplicationContext)ctx).close();
    }
}
