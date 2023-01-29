package com.mjmspred.model.query;

import lombok.Data;

import java.time.LocalDate;

/**
 * @author HuangChunFeng
 * @time 2023-01-10 14:32
 * @package com.mjmspred.model.mjms.query
 * @description 预测结果 查询
 */
@Data
public class DiningQuery {
    private LocalDate date;
    /**
     * 开始日期
     */
    private LocalDate sdate;
    /**
     * 结束日期，含
     */
    private LocalDate edate;
}
