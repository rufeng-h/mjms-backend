package com.mjmspred.security.support;

import com.mjmspred.model.mjms.MjmsUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author rufeng
 * @time 2022-03-09 18:29
 * @package com.rufeng.healthman.pojo.BO
 * @description 返回的userInfo
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseUserInfo {
    private Long userId;
    private String username;


    public static class UserInfoImpl extends BaseUserInfo {
        public UserInfoImpl(MjmsUser user) {
            super(user.getUserId(), user.getUsername());
        }
    }
}
