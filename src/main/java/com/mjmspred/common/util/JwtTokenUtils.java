package com.rufeng.healthman.common.util;

import com.rufeng.healthman.enums.UserTypeEnum;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;

/**
 * @author rufeng
 * @time 2022-03-05 17:55
 * @package com.rufeng.healthman.common
 * @description jwt工具类
 */
public class JwtTokenUtils {
    private static final SecretKey KEY = Keys.hmacShaKeyFor(
            Decoders.BASE64.decode("SyI/8w+X528KqE2S8JKU8Sv1Bb+coixCZrU/fYYKDqc="));

    public static String generateToken(String id, UserTypeEnum userType) {
        return Jwts.builder()
                .setSubject(userType.name())
                .setId(id)
                .signWith(KEY)
                .compact();
    }

    public static String getId(String token) {
        return getClaimsBody(token).getId();
    }

    public static UserTypeEnum getSubject(String token) {
        return UserTypeEnum.valueOf(getClaimsBody(token).getSubject());
    }


    private static Claims getClaimsBody(String token) {
        return Jwts.parserBuilder().setSigningKey(KEY).build().parseClaimsJws(token).getBody();
    }

    public static boolean isValid(String token) {
        try {
            getClaimsBody(token);
            return true;
        } catch (JwtException ignored) {
            return false;
        }
    }
}
