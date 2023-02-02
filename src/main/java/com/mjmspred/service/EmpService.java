package com.mjmspred.service;

import com.mjmspred.mapper.EmployeeMapper;
import com.mjmspred.model.Employee;
import org.springframework.stereotype.Service;

/**
 * @author : chunf
 */
@Service
public class EmpService {
    private final EmployeeMapper employeeMapper;

    public EmpService(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    public Employee getById(long id) {
        return employeeMapper.selectByPrimaryKey(id);
    }
}
