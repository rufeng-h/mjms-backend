package com.mjmspred.controller;

import com.mjmspred.common.api.ApiPage;
import com.mjmspred.common.api.ApiResponse;
import com.mjmspred.model.mjms.Dining;
import com.mjmspred.model.mjms.query.DiningQuery;
import com.mjmspred.service.mjms.DiningService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
public class DiningController {
    private final DiningService diningService;

    public DiningController(DiningService diningService) {
        this.diningService = diningService;
    }

    @GetMapping
    public ApiResponse<ApiPage<Dining>> page(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize, @Validated DiningQuery query) {
        return ApiResponse.success(diningService.pageDining(page, pageSize, query));
    }
}
