package com.fluex404.fm;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class FactoryMethodExample {
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Resource r = new ClassPathResource("applicationContext.xml");
        BeanFactory b = new XmlBeanFactory(r);

        Printable p = (Printable) b.getBean("p");
        p.print();

        Printable p2 = (Printable) b.getBean("p2");
        p2.print();
    }
}

interface Printable{
    void print();
}
class A implements Printable{

    @Override
    public void print() {
        System.out.println("hello a");
    }
}
class B implements Printable{

    @Override
    public void print() {
        System.out.println("hello b");
    }
}
class PrintableFactory{
    public static Printable getPrintable(){
        // return new B();
        return new A(); // return any one instance, either A or B
    }
    public static Printable getPrintable2(){
        return new B();
    }
    public Printable getPrintable3(){
        return new A();
    }
}