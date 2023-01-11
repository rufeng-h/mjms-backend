package com.mjmspred.common;

import java.time.format.DateTimeFormatter;

/**
 * @author HuangChunFeng
 * @time 2023-01-11 8:48
 * @package com.mjmspred.common
 * @description 项目配置
 */
public class ApplicationSettings {
    public static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
}
