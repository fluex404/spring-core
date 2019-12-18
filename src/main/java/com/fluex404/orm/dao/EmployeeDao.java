package com.fluex404.orm.dao;

import com.fluex404.orm.model.Employee;

import java.util.List;

public interface EmployeeDao {
    void saveEmployee(Employee e);
    void updateEmployee(Employee e);
    void deleteEmployee(Employee e);
    Employee getById(Long id);
    List<Employee> getEmployees();
}
