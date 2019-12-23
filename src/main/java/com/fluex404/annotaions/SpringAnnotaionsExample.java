package com.fluex404.annotaions;

import org.springframework.context.annotation.*;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public class SpringAnnotaionsExample {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        DataBaseDriver oracle = context.getBean("oracleDriver", DataBaseDriver.class);
        DataBaseDriver mysql = context.getBean("mysqlDriver", DataBaseDriver.class);

        System.out.println("Oracle driver info");
        System.out.println(oracle.getInfo());

        System.out.println("MySQL driver info");
        System.out.println(mysql.getInfo());

        System.out.println("User Service Information");
        UserService userService = context.getBean(UserService.class);
        System.out.println(userService.getDatabaseDriver());

        System.out.println("Primary action");
        DataBaseDriver primaryDriver = context.getBean(DataBaseDriver.class);
        System.out.println(primaryDriver.getInfo());

        context.close();
    }
}

interface DataBaseDriver{
    String getInfo();
}
@Component
@PropertySource("classpath:mysqldatabase.properties")
class MySQLDriver implements DataBaseDriver{

    @Value("${databaseName}")
    String databaseName;
    @Value("${disableStatementPooling}")
    String disableStatementPooling;

    @Override
    public String getInfo() {
        return "[ Driver: mySql" +
                ", databaseName: " + databaseName +
                ", disableStatementPooling: " + disableStatementPooling +
                " ]";
    }
}
class OracleDriver implements DataBaseDriver{

    protected String url;
    protected String user;
    protected String password;
    protected String driver;
    protected Integer port;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    @Override
    public String getInfo() {
        return "[ Driver: Oracle" +
                ", url: " + url +
                ", port; " + port +
                ", user: " + user +
                ", password: " + password  +
                ", driver: " + driver +
                " ] ";
    }
}
@Service
class UserService{
    @Autowired
    @Qualifier("oracleDriver")
    DataBaseDriver dataBaseDriver;

    public String getDatabaseDriver(){
        return dataBaseDriver.getInfo();
    }
}
@Configuration
@ComponentScan("com.fluex404.annotaions")
@PropertySource("classpath:oracledatabase.properties")
class AppConfig{
    @Autowired
    Environment environment;

    @Bean
    DataBaseDriver oracleDriver(){
        OracleDriver oracleDriver = new OracleDriver();
        oracleDriver.setDriver(environment.getProperty("db.driver"));
        oracleDriver.setPassword(environment.getProperty("db.password"));
        oracleDriver.setUser(environment.getProperty("db.user"));
        oracleDriver.setPort(Integer.parseInt(environment.getProperty("db.port")));
        oracleDriver.setUrl(environment.getProperty("db.url"));
        return oracleDriver;
    }
    @Bean
    @Primary
    DataBaseDriver mysqlDriver(){
        return new MySQLDriver();
    }
}

