package com.fluex404.ci.model;

import java.util.Map;
import java.util.Set;

public class QuestionMap {
    private int id;
    private String name;
    private Map<String, String> answers;
    public QuestionMap(){}

    public QuestionMap(int id, String name, Map<String, String> answers) {
        this.id = id;
        this.name = name;
        this.answers = answers;
    }
    public void displayInfo(){
        System.out.println("question id : "+id);
        System.out.println("question name : "+name);
        System.out.println("Answers...");
        answers.forEach((k, v) -> {
            System.out.println("Answer: "+k+ " Posted by " + v);
        });
    }
}
