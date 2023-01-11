package com.mjmspred.service.meal;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mjmspred.common.api.ApiPage;
import com.mjmspred.common.api.ApiResponse;
import com.mjmspred.config.MealDataSourceConfig;
import com.mjmspred.mapper.meal.MealRecordsMapper;
import com.mjmspred.model.meal.MealRecords;
import com.mjmspred.model.meal.query.MealRecordsQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author HuangChunFeng
 * @time 2023-01-09 11:13
 * @package com.windcf.springmybatismultipledatasource.service.meal
 * @description TODO
 */

@Service
public class MealRecordsService {
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
}
