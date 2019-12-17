package com.fluex404.aopaspectj;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class SpringAOPAspectJAnnotationsExample {
    public static void main(String[] args) {
        Resource r = new ClassPathResource("applicationContext.xml");
        BeanFactory factory = new XmlBeanFactory(r);

        Operation e = (Operation) factory.getBean("opBean");
        e.msg();
        e.m();
        e.k();

    }
}

class Operation{
    void msg(){
        System.out.println("msg method invoked");
    }
    int m(){
        System.out.println("m method invoked");
        return 2;
    }
    int k(){
        System.out.println("k method invoked");
        return 3;
    }
}
@Aspect
class TrackOperation{
    @Pointcut("execution(* Operation.*(..))")
    public void k(){} // poincut name

    @Before("k()")// applying poincut on before advice
    public void myadvice(JoinPoint jp) { // it is advice (before advice)
        System.out.println("additional concern");
    }
}
