package com.mjmspred.mapper;

import com.github.pagehelper.Page;
import com.mjmspred.model.ConsDistribution;
import com.mjmspred.model.MealRecord;
import com.mjmspred.model.query.MealRecordsQuery;
import com.mjmspred.model.vo.DeptMeal;
import com.mjmspred.model.vo.SiteStatistic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
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

    List<DeptMeal> coutDeptMeal(@Param("query") MealRecordsQuery query);

    List<String> listMealIdNumber(@Param("query") MealRecordsQuery query);

    SiteStatistic siteStatistic(@Param("today") LocalDate today, @Param("yesterday") LocalDate yesterday, @Param("tomorrow") LocalDate tomorrow, @Param("firstDay") LocalDate firstDay, @Param("lastDay") LocalDate lastDay);
}