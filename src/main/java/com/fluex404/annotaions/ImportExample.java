package com.fluex404.annotaions;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

public class ImportExample {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigB.class);
//        A a = context.getBean(A.class);
        B b = (B) context.getBean("getB"); // B b = context.getBean(B.class);
        A a = context.getBean(A.class);
        C c = context.getBean(C.class);

        // call method of each classes
        b.info();
        a.info();
        c.info();
    }
}

class A{
    A(){
        System.out.println("A is called");
    }
    public void info(){
        System.out.println("info of A");
    }
}
class B{
    B(){
        System.out.println("B is called");
    }
    public void info(){
        System.out.println("info of B");
    }
}
class C{
    C(){
        System.out.println("C is called");
    }
    public void info(){
        System.out.println("info of C");
    }
}

@Configuration
class ConfigA{
    @Bean
    public A a(){
        return new A();
    }
}
@Configuration
@Import({
        C.class,
        ConfigA.class
})
class ConfigB{
    @Bean B getB(){
        return new B();
    }
}