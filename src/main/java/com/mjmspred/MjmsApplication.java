package com.mjmspred;

import com.mjmspred.common.ApplicationSettings;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author HuangChunFeng
 * @time 2023-01-09 16:00
 * @package com.mjms
 * @description TODO
 */
@SpringBootApplication
public class MjmsApplication {
    public static void main(String[] args) {
        /* apollo env */
        System.setProperty("env", "pro");
        SpringApplication.run(MjmsApplication.class);
    }
}
