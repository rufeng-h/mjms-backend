package com.mjmspred.controller;

import com.mjmspred.common.api.ApiResponse;
import com.mjmspred.model.Flow;
import com.mjmspred.service.FlowService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

import static com.mjmspred.config.OpenApiConfig.JWT_SCHEME_NAME;

/**
 * @author : chunf
 */
@RestController
@RequestMapping("/api/flow")
@Tag(name = "Flow Api", description = "分钟人流量")
@SecurityRequirement(name = JWT_SCHEME_NAME)
@Validated
public class FlowController {
    private final FlowService flowService;

    public FlowController(FlowService flowService) {
        this.flowService = flowService;
    }

    @GetMapping
    public ApiResponse<Flow> getFlow(@RequestParam LocalDate date) {
        return ApiResponse.success(flowService.getByDate(date));
    }
}
