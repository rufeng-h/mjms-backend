package com.mjmspred.model.mjms.vo;

import com.mjmspred.model.mjms.MjmsUser;
import lombok.Data;

/**
 * @author HuangChunFeng
 * @time 2023-01-10 10:09
 * @package com.mjmspred.model.mjms.vo
 * @description 登陆结果
 */
@Data
public class LoginResult {
    private Long userId;
    private String token;

    public LoginResult(MjmsUser user, String token) {
        this.userId = user.getUserId();
        this.token = token;
    }
}
