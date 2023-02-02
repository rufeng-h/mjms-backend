package com.mjmspred.mapper;

import com.mjmspred.model.Flow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;

/**
* @author : chunf
*/
@Mapper
public interface FlowMapper {


    Flow selectByPrimaryKey(Long id);

    Flow selectByDate(@Param("date") LocalDate date);
}