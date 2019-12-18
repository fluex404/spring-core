package com.fluex404.jdbc.utils.impl;

import com.fluex404.jdbc.model.Employee;
import com.fluex404.jdbc.utils.MyUtils;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class MyUtilsImpl implements MyUtils {
    @Override
    public List<Object[]> resultSetToObjects(ResultSet rs) {
        List<Object[]> list = new ArrayList<>();

        try{
            ResultSetMetaData rsm = rs.getMetaData();
            Integer columnLength = rsm.getColumnCount();

            while(rs.next()) {
                Object[] objects = new Object[columnLength];
                for(int i = 1;i<=columnLength;i++) {
                    objects[(i-1)] = rs.getObject(i);
                }

                if(objects != null || objects.length == 0) {
                    list.add(objects);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Employee> resultSetToEmployee(ResultSet rs) {
        List<Employee> list = new ArrayList<>();
        try{
            while(rs.next()) {
                Employee e = new Employee(rs.getLong(1), rs.getString(2), rs.getBigDecimal(3));

                if(e != null || e.getId() != null) {
                    list.add(e);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
