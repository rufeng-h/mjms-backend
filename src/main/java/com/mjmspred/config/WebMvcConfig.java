package com.mjmspred.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.lang.NonNull;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author HuangChunFeng
 * @time 2023-01-10 15:14
 * @package com.mjmspred.config
 * @description TODO
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new LocalDateConverter());
    }

    static class LocalDateConverter implements Converter<String, LocalDate> {

        @Override
        public LocalDate convert(@NonNull String source) {
            if (StringUtils.hasText(source)) {
                return LocalDate.parse(source, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            }
            return null;
        }
    }

}