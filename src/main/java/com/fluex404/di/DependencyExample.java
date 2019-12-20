package com.fluex404.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

public class DependencyExample {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DIConfiguration.class);
        MyApplication app = context.getBean(MyApplication.class);

        app.processMessage("Hallo World", "isaabqari@gmail.com");
    }
}

// service
interface MessageService{
    boolean sendMessage(String msg, String rec);
}
class EmailService implements MessageService{

    @Override
    public boolean sendMessage(String msg, String rec) {
        System.out.println("Email Sent to "+rec+" with Message="+msg);
        return true;
    }
}
class TwitterService implements MessageService{

    @Override
    public boolean sendMessage(String msg, String rec) {
        System.out.println("Twitter message Sent to "+rec+" With message="+msg);
        return true;
    }
}
@Component
class MyApplication{
    private MessageService service;

    @Autowired
    public MyApplication(@Qualifier("twitter") MessageService service) {
        this.service = service;
    }
    public boolean processMessage(String msg, String rec){
        return service.sendMessage(msg, rec);
    }
}
@Configuration
@ComponentScan(value = {"com.fluex404.di"})
class DIConfiguration{

    @Bean(name="email")
    public MessageService getMessageService(){
        return new EmailService();
    }
    @Bean(name="twitter")
    public MessageService getMessageService2(){
        return new TwitterService();
    }
}

