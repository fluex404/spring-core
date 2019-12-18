package com.fluex404.orm.dao.impl;

import com.fluex404.orm.dao.EmployeeDao;
import com.fluex404.orm.model.Employee;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    HibernateTemplate template;

    public EmployeeDaoImpl(HibernateTemplate template) {
        this.template = template;
    }

    @Override
    public void saveEmployee(Employee e) {
        template.save(e);
    }

    @Override
    public void updateEmployee(Employee e) {
        template.update(e);
    }

    @Override
    public void deleteEmployee(Employee e) {
        template.delete(e);
    }

    @Override
    public Employee getById(Long id) {
        return template.get(Employee.class, id);
    }

    @Override
    public List<Employee> getEmployees() {
        return template.loadAll(Employee.class);
    }
}
