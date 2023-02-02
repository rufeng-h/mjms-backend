package com.mjmspred.controller;

import com.mjmspred.common.api.ApiResponse;
import com.mjmspred.model.Employee;
import com.mjmspred.service.EmpService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : chunf
 */
@RestController
@RequestMapping("/api/emp")
public class EmpController {
    private final EmpService empService;

    public EmpController(EmpService empService) {
        this.empService = empService;
    }

    @GetMapping("/{id}")
    public ApiResponse<Employee> getEmp(@PathVariable Long id) {
        return ApiResponse.success(empService.getById(id));
    }
}
