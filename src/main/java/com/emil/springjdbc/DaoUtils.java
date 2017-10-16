package com.emil.springjdbc;

import com.emil.springjdbc.dao.testDao;

import java.util.ArrayList;
import java.util.List;

public class DaoUtils {

    public static final String createOperation = "CREATE";
    public static final String readOperation = "READ";
    public static final String updateOperation = "UPDATE";
    public static final String deleteOperation = "DELETE";
    public static final String cleanupOperation = "TRUNCATE";

    public static void printTest(List<test> orgs, String operation){
        System.out.println("\n *********** printing test after " + operation + "operation **********");
        for(test org : orgs){
            System.out.println(org);
        }
    }

    public static void printSuccessFailure(String operation, boolean param){
        if(param)
            System.out.println("\nOperation" + operation + "succesful");
        else
            System.out.println("\nOperation " + operation + "failed");
    }

    public static void createSeedData(testDao dao){
        test test1 = new test("idji", "hey");
        test test2 = new test("Nikki", "mitchell");

        List<test> orgs = new ArrayList<test>();
        orgs.add(test1);
        orgs.add(test2);
        int createcount = 0;
        for(test org : orgs){
            boolean isCreated = dao.create(org);
            if(isCreated)
                createcount += 1;

        }

        System.out.println("Created " + createcount + "tests");
    }

}
