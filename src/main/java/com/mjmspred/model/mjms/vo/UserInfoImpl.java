package com.mjmspred.model.mjms.vo;

import com.mjmspred.model.mjms.MjmsUser;
import com.mjmspred.security.support.UserInfo;

/**
 * @author HuangChunFeng
 * @time 2023-01-10 10:32
 * @package com.mjmspred.model.mjms.vo
 * @description useinfo impl
 */
public class UserInfoImpl implements UserInfo {
    private final String username;
    private final Long userId;

    public UserInfoImpl(MjmsUser user) {
        this.userId = user.getUserId();
        this.username = user.getUsername();
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public Long getUserId() {
        return userId;
    }
}
