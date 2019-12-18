package com.fluex404.orm;

import com.fluex404.orm.dao.EmployeeDao;
import com.fluex404.orm.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

public class SpringORMExample {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeDao dao = (EmployeeDao) context.getBean("eOrmDao");

//        dao.saveEmployee(new Employee("niken", new BigDecimal(150)));
        dao.getEmployees().forEach(System.out::println);
    }
}
