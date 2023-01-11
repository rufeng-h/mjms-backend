package com.mjmspred.config;

import com.mjmspred.common.ApplicationSettings;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.lang.NonNull;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
        registry.addConverter(new LocalDateTimeConverter());
    }

    static class LocalDateTimeConverter implements Converter<String, LocalDateTime> {
        @Override
        public LocalDateTime convert(@NonNull String source) {
            if (StringUtils.hasText(source)) {
                return LocalDateTime.parse(source, ApplicationSettings.DATETIME_FORMATTER);
            }
            return null;
        }
    }

    static class LocalDateConverter implements Converter<String, LocalDate> {

        @Override
        public LocalDate convert(@NonNull String source) {
            if (StringUtils.hasText(source)) {
                return LocalDate.parse(source, ApplicationSettings.DATE_FORMATTER);
            }
            return null;
        }
    }

}