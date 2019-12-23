package com.fluex404.annotaions;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

public class LazyExample {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LazyAppConfig.class);
//        FirstBean firstBean = context.getBean(FirstBean.class);
//        firstBean.test();
//        context.close();
    }
}

class FirstBean{
    FirstBean(){
        System.out.println("Inside FirstBean Constructor");
    }
    public void test(){
        System.out.println("Method of FirstBean Class");
    }
}
class SecoundBean{
    SecoundBean(){
        System.out.println("Inside SecoundBean Constructor");
    }
    public void test(){
        System.out.println("Method of SecoundBean Class");
    }
}
@Configuration
class LazyAppConfig{
    @Lazy(value=true)
    @Bean
    public FirstBean firstBean(){
        return new FirstBean();
    }
    @Bean
    public SecoundBean secoundBean(){
        return new SecoundBean();
    }
}
