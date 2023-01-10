package com.mjmspred.security.repositry;

import com.mjmspred.model.mjms.MjmsUser;
import com.mjmspred.security.authentication.AuthenticationImpl;
import com.mjmspred.security.context.SecurityContext;
import com.mjmspred.security.context.SecurityContextHolder;
import com.mjmspred.security.support.BaseUserInfo;
import com.mjmspred.security.support.JwtTokenManager;
import com.mjmspred.service.mjms.MjmsUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.mjmspred.config.OpenApiConfig.JWT_HEADER_NAME;


/**
 * @author rufeng
 */
@Component
@Slf4j
public class TokenSecurityContextRepository implements SecurityContextRepository {
    private final MjmsUserService userService;
    private final JwtTokenManager jwtTokenManager;

    public TokenSecurityContextRepository(MjmsUserService userService, JwtTokenManager jwtTokenManager) {
        this.userService = userService;
        this.jwtTokenManager = jwtTokenManager;
    }

    @Override
    @NonNull
    public SecurityContext loadContext(HttpServletRequest request) {
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        String token = request.getHeader(JWT_HEADER_NAME);
        if (!StringUtils.hasText(token)) {
            return context;
        }
        String id = jwtTokenManager.getId(token);
        MjmsUser user = userService.getUser(Long.parseLong(id));
        if (user == null) {
            return context;
        }
        context.setAuthentication(new AuthenticationImpl(new BaseUserInfo.UserInfoImpl(user)));
        return context;
    }

    /**
     * 完全存储在客户端，服务端空实现
     */
    @Override
    public void saveContext(SecurityContext context, HttpServletRequest request, HttpServletResponse response) {

    }
}