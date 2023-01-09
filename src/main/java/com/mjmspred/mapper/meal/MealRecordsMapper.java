package com.windcf.springmybatismultipledatasource.mapper.meal;

import com.windcf.springmybatismultipledatasource.model.meal.MealRecords;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author HuangChunFeng
 * @time 2023-01-09 10:21
 * @package com.windcf.springmybatismultipledatasource.mapper.meal
 * @description TODO
 */

@Mapper
public interface MealRecordsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MealRecords record);

    int insertSelective(MealRecords record);

    MealRecords selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MealRecords record);

    int updateByPrimaryKey(MealRecords record);
}