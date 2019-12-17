package com.fluex404.autowire;

import com.fluex404.autowire.model.A;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class AutowireExample {
    public static void main(String[] args) {
        Resource r = new ClassPathResource("applicationContext.xml");
        BeanFactory b = new  XmlBeanFactory(r);

        A a = (A) b.getBean("a");
        a.display();
    }
}
