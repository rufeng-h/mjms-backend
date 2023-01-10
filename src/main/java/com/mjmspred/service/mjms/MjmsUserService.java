package com.mjmspred.service.mjms;

import com.mjmspred.exception.AuthenticationException;
import com.mjmspred.mapper.mjms.MjmsUserMapper;
import com.mjmspred.model.mjms.MjmsUser;
import com.mjmspred.model.mjms.form.LoginForm;
import com.mjmspred.model.mjms.query.UserQuery;
import com.mjmspred.model.mjms.vo.LoginResult;
import com.mjmspred.model.mjms.vo.UserInfoImpl;
import com.mjmspred.security.authentication.Authentication;
import com.mjmspred.security.context.SecurityContextHolder;
import com.mjmspred.security.support.JwtTokenManager;
import com.mjmspred.security.support.UserInfo;
import org.springframework.stereotype.Service;

/**
 * @author HuangChunFeng
 * @time 2023-01-09 19:09
 * @package com.mjmspred.service.mjms
 * @description TODO
 */
@Service
public class MjmsUserService {
    private final JwtTokenManager tokenManager;
    private final MjmsUserMapper userMapper;

    public MjmsUserService(JwtTokenManager tokenManager, MjmsUserMapper userMapper) {
        this.tokenManager = tokenManager;
        this.userMapper = userMapper;
    }


    public MjmsUser getUser(long id) {
        return userMapper.selectByPrimaryKey(id);
    }


    public LoginResult login(LoginForm form) {
        UserQuery query = UserQuery.builder().username(form.getUsername()).password(form.getPassword()).build();
        MjmsUser user = userMapper.getUser(query);
        if (user == null) {
            throw new AuthenticationException("用户名或密码错误!");
        }
        String token = tokenManager.generateToken(new UserInfoImpl(user));
        return new LoginResult(user, token);
    }

    public UserInfo currentUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Long userId = (Long) authentication.getUserInfo().getUserId();
        MjmsUser user = getUser(userId);
        return new UserInfoImpl(user);
    }
}
