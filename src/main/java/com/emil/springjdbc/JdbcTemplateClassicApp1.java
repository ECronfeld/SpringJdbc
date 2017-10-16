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
        List<test> orgs = dao.getAllTest();
        for(test org : orgs){
            System.out.println(org.toString());
        }

        ((ClassPathXmlApplicationContext)ctx).close();
    }
}
