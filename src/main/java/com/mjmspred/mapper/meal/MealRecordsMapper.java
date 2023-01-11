package com.mjmspred.mapper.meal;

import com.github.pagehelper.Page;
import com.mjmspred.model.meal.MealRecords;
import com.mjmspred.model.meal.query.MealRecordsQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * @author HuangChunFeng
 * @time 2023-01-09 16:29
 * @package com.mjmspred.mapper.meal
 * @description TODO
 */

@Mapper
public interface MealRecordsMapper {
    MealRecords selectByPrimaryKey(Long id);

    Page<MealRecords> page(@Param("query") MealRecordsQuery query);
}