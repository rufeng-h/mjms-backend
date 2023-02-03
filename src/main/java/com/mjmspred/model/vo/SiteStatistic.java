package com.mjmspred.model.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author : chunf
 * 首页统计数据
 */
@Data
public class SiteStatistic {

    /**
     * 今日预计就餐
     */
    private Long dayPredMeal;
    /**
     * 昨日就餐
     */
    private Long yesterdayMeal;

    /**
     * 今日就餐人次
     */
    private Long dayMeal;
    /**
     * 月总人次
     */
    private Long monthMeal;

    /**
     * 日总金额
     */
    private BigDecimal dayMoney;

    /**
     * 月总金额
     */
    private BigDecimal monthMoney;

    /**
     * 今日门禁
     */
    private Long dayAms;

    /**
     * 月总门禁
     */
    private Long monthAms;
}
