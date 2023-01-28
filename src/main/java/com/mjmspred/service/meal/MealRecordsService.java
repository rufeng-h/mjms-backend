package com.mjmspred.service.meal;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mjmspred.common.api.ApiPage;
import com.mjmspred.mapper.meal.MealRecordsMapper;
import com.mjmspred.model.meal.ConsDistribution;
import com.mjmspred.model.meal.MealRecords;
import com.mjmspred.model.meal.query.MealRecordsQuery;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author HuangChunFeng
 * @time 2023-01-09 11:13
 * @package com.windcf.springmybatismultipledatasource.service.meal
 * @description TODO
 */

@Service
public class MealRecordsService {
    private static final Set<String> MEAL_TYPE_SET = new HashSet<>(4);

    static {
        MEAL_TYPE_SET.add("");
        MEAL_TYPE_SET.add("理发");
        MEAL_TYPE_SET.add("洗车");
        MEAL_TYPE_SET.add("扶贫");
        MEAL_TYPE_SET.add("商品");
    }

    private final MealRecordsMapper mealRecordsMapper;

    public MealRecordsService(MealRecordsMapper mealRecordsMapper) {
        this.mealRecordsMapper = mealRecordsMapper;
    }

    public MealRecords getMeal(long id) {
        return mealRecordsMapper.selectByPrimaryKey(id);
    }

    public ApiPage<MealRecords> page(Integer page, Integer pageSize, MealRecordsQuery query) {
        PageHelper.startPage(page, pageSize);
        Page<MealRecords> records = mealRecordsMapper.page(query);
        return ApiPage.convert(records);
    }

    public List<MealRecords> listByDate(LocalDate date) {
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
            if ("".equals(d.getType())) {
                d.setType("餐食");
            }
        });
        return dists;
    }
}
