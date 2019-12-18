package com.fluex404.jdbc;

import com.fluex404.jdbc.dao.EmployeeDao;
import com.fluex404.jdbc.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.List;

public class SpringJDBCExample {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeDao dao = (EmployeeDao) context.getBean("edao");

//        dao.saveEmployee(new Employee(101L, "Isa", new BigDecimal(1000)));
//        dao.saveEmployee(new Employee(90L, "Rara", new BigDecimal(200)));
//        dao.saveEmployee(new Employee(100L, "Test", new BigDecimal(110)));
//        dao.updateEmployee(new Employee(90L, "Tara", new BigDecimal(300)));
//        dao.deleteEmployee(new Employee(100L, null, null));
//        dao.saveEmployeeByPreparedStatement(new Employee(102L, "test2", new BigDecimal(400)));
//        List<?> employees = dao.getAllEmployeeObjects();
//        employees.forEach(object -> {
//            Object d[] = (Object[]) object;
//            for(int i=0;i<d.length;i++) {
//                System.out.print(d[i] + " ");
//            }
//            System.out.println();
//        });
//        dao.getAllEmployees().forEach(System.out::println);
//        dao.getAllEmployeesByRowMapper().forEach(System.out::println);
//        dao.saveByNameParameterJdbcTemplate(new Employee(113L, "Nikel", new BigDecimal(100)));

    }
}
