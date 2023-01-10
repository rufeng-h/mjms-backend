package com.mjmspred;

import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

/**
 * @author HuangChunFeng
 * @time 2023-01-10 10:52
 * @package com.mjmspred
 * @description TODO
 */
public class GenPassword {
    public static void main(String[] args) {
        System.out.println(DigestUtils.md5DigestAsHex("123456".getBytes(StandardCharsets.UTF_8)));
    }
}
