package com.mjmspred.security.authentication;

import com.mjmspred.security.support.BaseUserInfo;
import org.springframework.lang.NonNull;

/**
 * @author rufeng
 * @time 2022-04-19 17:47
 * @package com.rufeng.healthman.security.authentication
 * @description TODO
 */
public class AuthenticationImpl implements Authentication {
    private final BaseUserInfo baseUserInfo;

    public AuthenticationImpl(BaseUserInfo baseUserInfo) {
        this.baseUserInfo = baseUserInfo;
    }

    @Override
    @NonNull
    public BaseUserInfo getUserInfo() {
        return baseUserInfo;
    }
}
