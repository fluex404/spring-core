package com.fluex404.jdbc.dao;

import com.fluex404.jdbc.model.Employee;

public interface EmployeeDao {
    int saveEmployee(Employee e);
    int updateEmployee(Employee e);
    int deleteEmployee(Employee e);
}
