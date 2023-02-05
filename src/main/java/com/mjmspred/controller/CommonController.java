package com.mjmspred.controller;

import com.mjmspred.common.api.ApiResponse;
import com.mjmspred.model.form.LoginForm;
import com.mjmspred.model.vo.LoginResult;
import com.mjmspred.security.support.UserInfo;
import com.mjmspred.service.MjmsUserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.mjmspred.config.OpenApiConfig.JWT_SCHEME_NAME;

/**
 * @author HuangChunFeng
 * @time 2023-01-10 10:05
 * @package com.mjmspred.controller
 * @description TODO
 */
@RestController
@Validated
@Tag(name = "Common Api", description = "通用操作")
public class CommonController {
    private final MjmsUserService userService;

    public CommonController(MjmsUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ApiResponse<LoginResult> login(@RequestBody @Validated LoginForm form) {
        return ApiResponse.success(userService.login(form));
    }

    @GetMapping("/logout")
    public ApiResponse<Void> logout() {
        return ApiResponse.success();
    }

    @SecurityRequirement(name = JWT_SCHEME_NAME)
    @GetMapping("/api/getUserInfo")
    public ApiResponse<UserInfo> getUserInfo() {
        return ApiResponse.success(userService.currentUserInfo());
    }


}
