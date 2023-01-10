package com.mjmspred.security.authentication;

import com.mjmspred.security.support.UserInfo;
import org.springframework.lang.NonNull;
import org.springframework.util.Assert;

/**
 * @author rufeng
 * @time 2022-04-19 17:47
 * @package com.rufeng.healthman.security.authentication
 * @description TODO
 */
public class AuthenticationImpl implements Authentication {
    private final UserInfo userInfo;

    public AuthenticationImpl(@NonNull UserInfo userInfo) {
        Assert.notNull(userInfo, "userinfo不能为空");
        this.userInfo = userInfo;
    }

    @Override
    @NonNull
    public UserInfo getUserInfo() {
        return userInfo;
    }
}
