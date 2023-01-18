package com.mjmspred.controller;

import com.mjmspred.common.api.ApiPage;
import com.mjmspred.common.api.ApiResponse;
import com.mjmspred.model.mjms.Dining;
import com.mjmspred.model.mjms.query.DiningQuery;
import com.mjmspred.service.mjms.DiningService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

import static com.mjmspred.config.OpenApiConfig.JWT_SCHEME_NAME;

/**
 * @author HuangChunFeng
 * @time 2023-01-10 14:26
 * @package com.mjmspred.controller
 * @description TODO
 */
@RestController
@Validated
@SecurityRequirement(name = JWT_SCHEME_NAME)
@RequestMapping("/api/dining")
@Tag(name = "Dining Api", description = "预测数据接口")
public class DiningController {
    private final DiningService diningService;

    public DiningController(DiningService diningService) {
        this.diningService = diningService;
    }

    @GetMapping
    public ApiResponse<ApiPage<Dining>> page(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize, @Validated DiningQuery query) {
        return ApiResponse.success(diningService.pageDining(page, pageSize, query));
    }

    @GetMapping("/{date}")
    public ApiResponse<Dining> getDining(@PathVariable LocalDate date) {
        return ApiResponse.success(diningService.getDining(date));
    }

    @PostMapping("/list")
    public ApiResponse<List<Dining>> statistic(@RequestBody @Size(min = 2) List<LocalDate> dates) {
        return ApiResponse.success(diningService.listByDates(dates));
    }
}
