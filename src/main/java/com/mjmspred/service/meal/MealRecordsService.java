package com.mjmspred.service.meal;

import com.mjmspred.config.MealDataSourceConfig;
import com.mjmspred.mapper.meal.MealRecordsMapper;
import com.mjmspred.model.meal.MealRecords;
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

    @Transactional(rollbackFor = Exception.class, transactionManager = MealDataSourceConfig.TRANSACTION_BEAN_NAME)
    public MealRecords getMeal(long id) {
        return mealRecordsMapper.selectByPrimaryKey(id);
    }
}
