package com.fluex404.jdbc.dao;

import com.fluex404.jdbc.model.Employee;

import java.sql.ResultSet;
import java.util.List;

public interface EmployeeDao {
    int saveEmployee(Employee e);
    int updateEmployee(Employee e);
    int deleteEmployee(Employee e);
    int saveEmployeeByPreparedStatement(final Employee e);
    List<?> getAllEmployeeObjects();
    List<Employee> getAllEmployees();
    List<Employee> getAllEmployeesByRowMapper();
    void saveByNameParameterJdbcTemplate(final Employee e);
}
