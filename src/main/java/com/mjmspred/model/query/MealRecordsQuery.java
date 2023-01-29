package com.mjmspred.model.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author HuangChunFeng
 * @time 2023-01-10 17:20
 * @package com.mjmspred.model.query
 * @description TODO
 */
@Data
@Schema
public class MealRecordsQuery {
    /**
     * 最大消费
     */
    @Min(0)
    private BigDecimal maxConsume;

    /**
     * 最小消费
     */
    @Min(0)
    private BigDecimal minConsume;

    /**
     * 职工号
     */
    @Size(min = 1)
    private String empId;

    /**
     * 卡号
     */
    private Long cardId;

    /**
     * 消费时间，起
     */
    @Schema(type = "string",  example = "2022-12-25")
    private LocalDate sdate;
    /**
     * 消费时间，止
     */
    @Schema(type = "string",  example = "2023-01-01")
    private LocalDate edate;
}
