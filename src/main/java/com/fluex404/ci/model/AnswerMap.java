package com.fluex404.ci.model;

import java.util.Date;

public class AnswerMap {
    private int id;
    private String answer;
    private Date postDate;

    public AnswerMap(){}

    public AnswerMap(int id, String answer, Date postDate) {
        super();
        this.id = id;
        this.answer = answer;
        this.postDate = postDate;
    }

    @Override
    public String toString() {
        return id + " "+ answer+ " "+ postDate;
    }
}
