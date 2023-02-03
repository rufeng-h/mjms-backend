package com.mjmspred.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mjmspred.common.api.ApiPage;
import com.mjmspred.mapper.MealRecordsMapper;
import com.mjmspred.model.ConsDistribution;
import com.mjmspred.model.MealRecord;
import com.mjmspred.model.query.MealRecordsQuery;
import com.mjmspred.model.vo.AgeMeal;
import com.mjmspred.model.vo.DeptMeal;
import com.mjmspred.model.vo.SiteStatistic;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author HuangChunFeng
 * @time 2023-01-09 11:13
 * @package com.windcf.springmybatismultipledatasource.service.meal
 * @description TODO
 */

@Service
public class MealRecordService {
    private static final Set<String> MEAL_TYPE_SET = new HashSet<>(4);
    private static final String[] AGE_INTERVAL = new String[]{"20~30", "30~40", "40~50", "50~60", "60~70"};

    static {
        /* 兼容多种数据库 left函数返回null和空串 */
        MEAL_TYPE_SET.add(null);
        MEAL_TYPE_SET.add("");
        MEAL_TYPE_SET.add("理发");
        MEAL_TYPE_SET.add("洗车");
        MEAL_TYPE_SET.add("扶贫");
        MEAL_TYPE_SET.add("商品");
    }

    private final MealRecordsMapper mealRecordsMapper;

    public MealRecordService(MealRecordsMapper mealRecordsMapper) {
        this.mealRecordsMapper = mealRecordsMapper;
    }

    public MealRecord getMeal(long id) {
        return mealRecordsMapper.selectByPrimaryKey(id);
    }

    public ApiPage<MealRecord> page(Integer page, Integer pageSize, MealRecordsQuery query) {
        PageHelper.startPage(page, pageSize);
        Page<MealRecord> records = mealRecordsMapper.page(query);
        return ApiPage.convert(records);
    }

    public List<MealRecord> listByDate(LocalDate date) {
        MealRecordsQuery query = new MealRecordsQuery();
        query.setSdate(date);
        query.setEdate(date.plusDays(1L));
        return mealRecordsMapper.selectByDate(query);
    }

    public List<ConsDistribution> distribution(LocalDate date) {
        MealRecordsQuery query = new MealRecordsQuery();
        if (date != null) {
            query.setSdate(date);
            query.setEdate(date.plusDays(1L));
        }
        List<ConsDistribution> dists = mealRecordsMapper.mealDistribution(query);
        dists = dists.stream().filter(d -> MEAL_TYPE_SET.contains(d.getType())).collect(Collectors.toList());
        dists.forEach(d -> {
            if (!StringUtils.hasText(d.getType())) {
                d.setType("餐食");
            }
        });
        return dists;
    }

    public List<DeptMeal> countDeptMeal(LocalDate date) {
        MealRecordsQuery query = new MealRecordsQuery();
        query.setSdate(date);
        query.setEdate(date.plusDays(1L));
        return mealRecordsMapper.coutDeptMeal(query);
    }

    public List<AgeMeal> countAgeMeal(LocalDate date) {
        MealRecordsQuery query = new MealRecordsQuery();
        query.setSdate(date);
        query.setEdate(date.plusDays(1L));
        List<String> idNums = mealRecordsMapper.listMealIdNumber(query);
        int year = LocalDate.now().getYear();
        int[] counts = {0, 0, 0, 0, 0};
        idNums.forEach(id -> {
            int age = year - Integer.parseInt(id.substring(6, 10));
            if (age < 20 || age >= 70) {
                return;
            }
            counts[age / 10 - 2] += 1;
        });
        List<AgeMeal> ageMeals = new ArrayList<>();
        for (int i = 0; i < counts.length; i++) {
            ageMeals.add(new AgeMeal(AGE_INTERVAL[i], counts[i]));
        }
        return ageMeals;
    }

    public SiteStatistic siteStatistic() {
//        LocalDate today = LocalDate.now();
        /* TODO 测试数据 */
        LocalDate today = LocalDate.of(2023, 1, 19);
        LocalDate yesterday = today.minusDays(1L);
        LocalDate tomorrow = today.plusDays(1L);
        LocalDate firstDay = today.withDayOfMonth(1);
        LocalDate lastDay = today.withDayOfMonth(today.getMonth().length(today.isLeapYear()));
        return mealRecordsMapper.siteStatistic(today, yesterday, tomorrow, firstDay, lastDay);
    }
}
