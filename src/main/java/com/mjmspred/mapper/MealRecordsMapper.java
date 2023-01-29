package com.mjmspred.mapper;

import com.github.pagehelper.Page;
import com.mjmspred.model.ConsDistribution;
import com.mjmspred.model.MealRecord;
import com.mjmspred.model.query.MealRecordsQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author HuangChunFeng
 * @time 2023-01-09 16:29
 * @package com.mjmspred.mapper.meal
 * @description TODO
 */

@Mapper
public interface MealRecordsMapper {
    MealRecord selectByPrimaryKey(Long id);

    Page<MealRecord> page(@Param("query") MealRecordsQuery query);

    List<MealRecord> selectByDate(@Param("query") MealRecordsQuery query);

    /**
     * 消费分布
     *
     * @param query q
     * @return list
     */

    List<ConsDistribution> mealDistribution(@Param("query") MealRecordsQuery query);

}