package com.windcf.springmybatismultipledatasource.controller;

import com.windcf.springmybatismultipledatasource.model.meal.MealRecords;
import com.windcf.springmybatismultipledatasource.model.mjms.Dining;
import com.windcf.springmybatismultipledatasource.service.meal.MealRecordsService;
import com.windcf.springmybatismultipledatasource.service.mjms.DiningService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : chunf
 */
@RestController
public class TestController {
    private final MealRecordsService mealRecordsService;
    private final DiningService diningService;

    public TestController(MealRecordsService mealRecordsService, DiningService diningService) {
        this.mealRecordsService = mealRecordsService;
        this.diningService = diningService;
    }

    @GetMapping("/dining/{dnId}")
    public Dining getDining(@PathVariable Long dnId) {
        return diningService.getDining(dnId);
    }

    @GetMapping("/meal/{id}")
    public MealRecords getMeal(@PathVariable Long id) {
        return mealRecordsService.getMeal(id);
    }
}
