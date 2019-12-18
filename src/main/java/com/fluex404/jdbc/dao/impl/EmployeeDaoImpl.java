package com.fluex404.jdbc.dao.impl;

import com.fluex404.jdbc.dao.EmployeeDao;
import com.fluex404.jdbc.model.Employee;
import com.fluex404.jdbc.utils.MyUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeDaoImpl implements EmployeeDao {

    private JdbcTemplate jdbcTemplate;
    private MyUtils myUtils;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public EmployeeDaoImpl(JdbcTemplate jdbcTemplate, MyUtils myUtils, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.myUtils = myUtils;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public int saveEmployee(Employee e) {
        String query = "insert into employee values("+e.getId()+",'" +
                e.getName()+"',"+e.getSalary()+")";
        return jdbcTemplate.update(query);
    }

    @Override
    public int updateEmployee(Employee e) {
        String query = "update employee set name='"+e.getName()+"', salary="+e.getSalary()+" where id="+e.getId();
        return jdbcTemplate.update(query);
    }

    @Override
    public int deleteEmployee(Employee e) {
        String query = "delete from employee where id="+e.getId();
        return jdbcTemplate.update(query);
    }

    @Override
    public int saveEmployeeByPreparedStatement(Employee e) {
        String query = "insert into employee values(?,?,?)";
        return jdbcTemplate.update(query, e.getId(), e.getName(), e.getSalary());
    }

    @Override
    public List<?> getAllEmployeeObjects() {
        String query = "select * from employee";
        return jdbcTemplate.query(query, rs -> (myUtils.resultSetToObjects(rs)));
    }

    @Override
    public List<Employee> getAllEmployees() {
        String query = "select * from employee";
        return jdbcTemplate.query(query, rs ->(myUtils.resultSetToEmployee(rs)));
    }

    @Override
    public List<Employee> getAllEmployeesByRowMapper() {
        return jdbcTemplate.query("select * from employee", (rs, i) ->
                (new Employee(
                        rs.getLong(1),
                        rs.getString(2),
                        rs.getBigDecimal(3)))
        );
    }

    @Override
    public void saveByNameParameterJdbcTemplate(Employee e) {
        String query = "insert into employee values(:id, :name, :salary)";
        Map<String, Object> map = new HashMap<>();
        map.put("id", e.getId());
        map.put("name", e.getName());
        map.put("salary", e.getSalary());

        namedParameterJdbcTemplate.query(query, map, resultSet -> {});
    }


}
