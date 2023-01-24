package com.solvd.reddit.task1.company;

import com.google.gson.Gson;

import java.io.FileReader;

public class Main {

    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("/Users/apetrov/Documents/java/projects/reddit/src/main/resources/company.json");
            Gson gson = new Gson();
            Company company = gson.fromJson(fr, Company.class);
            int avgSalary = company.getEmployees().stream().map(employee -> employee.getSalary()).reduce((x,y) -> x + y).get() / company.getEmployees().size();
            System.out.println(avgSalary);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
