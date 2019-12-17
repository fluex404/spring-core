package com.fluex404.jdbc.dao.impl;

import com.fluex404.jdbc.dao.EmployeeDao;
import com.fluex404.jdbc.model.Employee;
import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDaoImpl implements EmployeeDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int saveEmployee(Employee e) {
        String query = "insert into employee values("+e.getId()+"," +
                e.getName()+","+e.getSalary()+")";
        return jdbcTemplate.update(query);
    }

    @Override
    public int updateEmployee(Employee e) {
        String query = "update employee set name="+e.getName()+", salary="+e.getSalary()+" where id="+e.getId();
        return jdbcTemplate.update(query);
    }

    @Override
    public int deleteEmployee(Employee e) {
        String query = "delte from employee where id="+e.getId();
        return jdbcTemplate.update(query);
    }
}
