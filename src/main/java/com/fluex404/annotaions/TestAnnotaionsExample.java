package com.fluex404.annotaions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class TestAnnotaionsExample {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DIConfiguration.class);
        MyApp app = (MyApp) context.getBean("myApp");
        String msg = "Hallo World";
        String rec = "isaabqari@gmail.com";
        app.prossessMessage(msg, rec);
    }
}

interface MessageService{
    boolean sendMessage(String msg, String rec);
}
class EmailMessage implements MessageService{

    @Override
    public boolean sendMessage(String msg, String rec) {
        System.out.println("Email sent to " +rec + " Message="+msg);
        return true;
    }

    @PostConstruct
    void initMethod(){
        System.out.println("Email init");
    }
    @PreDestroy
    void initDestroy(){
        System.out.println("Email destroy");
    }
}
class TwitterMessage implements MessageService{

    @Override
    public boolean sendMessage(String msg, String rec) {
        System.out.println("Twitter sent message "+msg+" to "+rec);
        return true;
    }

    void initMethod(){
        System.out.println("Twitter diisi");
    }
    void destroyMethod(){
        System.out.println("Twitter destroyed");
    }
}

@Configuration("myconfig")
@ComponentScan(value = {"com.fluex404.annotaions"})
class DIConfiguration{

    @Bean(name = "email")
    MessageService emailService(){
        return new EmailMessage();
    }
    @Bean(name = "twitter", initMethod = "initMethod", destroyMethod = "destroyMethod")
    MessageService twitterService(){
        return new TwitterMessage();
    }
}

@Component
@Service("myApp")
class MyApp{
    MessageService service;

    @Autowired
    public MyApp(@Qualifier("email") MessageService service) {
        this.service = service;
    }

    public boolean prossessMessage(String msg, String rec){
        return service.sendMessage(msg, rec);
    }
}
