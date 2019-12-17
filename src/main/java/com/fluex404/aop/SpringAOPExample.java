package com.fluex404.aop;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.lang.reflect.Method;
import java.sql.SQLOutput;

public class SpringAOPExample {
    public static void main(String[] args) {
        Resource r = new ClassPathResource("applicationContext.xml");
        BeanFactory factory = new XmlBeanFactory(r);

        A a = factory.getBean("proxy", A.class);
        a.m();
    }
}

class A{
    public void m(){
        System.out.println("actual business logic");
    }
}
class BeforeAdvisor implements MethodBeforeAdvice{

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("additional concern before actual logic");
    }
}
class AfterAdvisor implements AfterReturningAdvice{

    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("additional concern after actial logic");
    }
}
