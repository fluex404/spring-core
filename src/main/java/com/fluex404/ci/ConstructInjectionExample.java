package com.fluex404.ci;

import com.fluex404.ci.model.*;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class ConstructInjectionExample {
    public static void main(String[] args) {
        Resource r = new ClassPathResource("applicationContext.xml");
        BeanFactory b = new XmlBeanFactory(r);

        Employee e1 = (Employee) b.getBean("e");
        Employee e2 = (Employee) b.getBean("e2");
        Address a1 = (Address) b.getBean("a1");

        e1.show();
        e2.show();
        System.out.println(a1.toString());

        Question q = (Question) b.getBean("q");
        q.displayInfo();

        QuestionMap qm = (QuestionMap) b.getBean("qm");
        qm.displayInfo();

        QuestionMap2 qm2 = (QuestionMap2) b.getBean("qm2");
        qm2.displayInfo();

        Question inheritanceQuestion = (Question) b.getBean("qutionInheritance");
        inheritanceQuestion.displayInfo();
    }
}


