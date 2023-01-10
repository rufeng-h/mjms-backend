package com.mjmspred.security.support;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.Data;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

/**
 * @author rufeng
 * @time 2022-03-05 17:55
 * @package com.rufeng.healthman.common
 * @description jwt
 */
@Component
@EnableConfigurationProperties(JwtTokenManager.JwtProperties.class)
public class JwtTokenManager implements InitializingBean {

    private final Log log = LogFactory.getLog(JwtTokenManager.class);

    private final SecretKey signedKey;


    public JwtTokenManager(JwtProperties properties) {
        signedKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(properties.getKey()));
    }

    @Data
    @ConfigurationProperties(prefix = "jwt")
    static class JwtProperties {
        private String key;
    }


    public String generateToken(BaseUserInfo baseUserInfo) {
        return Jwts.builder().setSubject(baseUserInfo.getUsername()).setId(String.valueOf(baseUserInfo.getUserId())).signWith(signedKey).compact();
    }

    @Nullable
    public String getId(String token) {
        try {
            return getClaimsBody(token).getId();
        } catch (JwtException e) {
            log.warn("Jwt解析异常", e);
            return null;
        }
    }


    private Claims getClaimsBody(String token) {
        return Jwts.parserBuilder().setSigningKey(signedKey).build().parseClaimsJws(token).getBody();
    }

    @Override
    public void afterPropertiesSet() {

    }
}
