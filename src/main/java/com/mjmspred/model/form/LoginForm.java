package com.mjmspred.model.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author HuangChunFeng
 * @time 2023-01-10 10:07
 * @package com.mjmspred.model.form
 * @description 登录表单
 */
@Data
public class LoginForm {
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
}
