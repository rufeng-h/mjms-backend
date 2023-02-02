package com.mjmspred.mapper;

import com.mjmspred.model.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author : chunf
 */
@Mapper
public interface EmployeeMapper {


    Employee selectByPrimaryKey(Long id);

}