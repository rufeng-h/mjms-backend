package com.mjmspred.controller;

import com.mjmspred.common.api.ApiPage;
import com.mjmspred.common.api.ApiResponse;
import com.mjmspred.model.ConsDistribution;
import com.mjmspred.model.MealRecord;
import com.mjmspred.model.query.MealRecordsQuery;
import com.mjmspred.service.MealRecordService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

import static com.mjmspred.config.OpenApiConfig.JWT_SCHEME_NAME;

/**
 * @author HuangChunFeng
 * @time 2023-01-10 17:08
 * @package com.mjmspred.controller
 * @description TODO
 */
@RestController
@Validated
@RequestMapping("/api/meal")
@Tag(name = "MealRecord Api", description = "就餐记录接口")
@SecurityRequirement(name = JWT_SCHEME_NAME)
public class MealController {
    private final MealRecordService mealRecordService;

    public MealController(MealRecordService mealRecordService) {
        this.mealRecordService = mealRecordService;
    }

    @GetMapping
    public ApiResponse<ApiPage<MealRecord>> pageMeal(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize, @Validated MealRecordsQuery query) {
        return ApiResponse.success(mealRecordService.page(page, pageSize, query));
    }

    @GetMapping("/list")
    public ApiResponse<List<MealRecord>> list(@RequestParam LocalDate date){
        return ApiResponse.success(mealRecordService.listByDate(date));
    }

    @GetMapping("/distribution")
    public ApiResponse<List<ConsDistribution>> distribution(@RequestParam(required = false) LocalDate date) {
        return ApiResponse.success(mealRecordService.distribution(date));
    }
}
