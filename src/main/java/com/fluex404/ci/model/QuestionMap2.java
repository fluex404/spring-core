package com.fluex404.ci.model;

import javax.swing.text.html.parser.Entity;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class QuestionMap2 {
    private int id;
    private String name;
    private Map<AnswerMap, UserMap> answers;

    public QuestionMap2(){}

    public QuestionMap2(int id, String name, Map<AnswerMap, UserMap> answers) {
        this.id = id;
        this.name = name;
        this.answers = answers;
    }

    public void displayInfo(){
        System.out.println("question id: "+id);
        System.out.println("question name: "+name);
        System.out.println("Answers...");

        Set<Map.Entry<AnswerMap, UserMap>> set = answers.entrySet();
        Iterator<Map.Entry<AnswerMap, UserMap>> itr = set.iterator();

        while(itr.hasNext()) {
            Map.Entry<AnswerMap, UserMap> entry = itr.next();
            AnswerMap ans = entry.getKey();
            UserMap usr = entry.getValue();

            System.out.println("Answer information");
            System.out.println(ans);
            System.out.println("Posted by");
            System.out.println(usr);
        }
    }
}
