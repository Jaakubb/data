package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeRepository {

    @Autowired
    private DataSource dataSource;

    public int addEmployee(Employee emp) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", emp.getId());
        parameters.put("first_name", emp.getFirst_name());
        parameters.put("last_name", emp.getLast_name());

        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("employee")
                .usingGeneratedKeyColumns("id");

        return simpleJdbcInsert.executeAndReturnKey(parameters).intValue();
    }
}
