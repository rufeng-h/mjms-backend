package com.mjmspred.model.meal;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 消费情况
 *
 * @author : chunf
 */
@Data
public class ConsDistribution {
    /**
     * 类型
     */
    private String type;
    /**
     * 消费总额
     */
    private BigDecimal consume;
    /**
     * 记录数
     */
    private Long count;
}
