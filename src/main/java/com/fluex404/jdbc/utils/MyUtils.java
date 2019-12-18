package com.fluex404.jdbc.utils;

import com.fluex404.jdbc.model.Employee;

import java.sql.ResultSet;
import java.util.List;

public interface MyUtils {
    List<Object[]> resultSetToObjects(ResultSet rs);
    List<Employee> resultSetToEmployee(ResultSet rs);
}
