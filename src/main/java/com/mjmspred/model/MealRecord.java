package com.mjmspred.model;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author HuangChunFeng
 * @time 2023-01-09 16:29
 * @package com.mjmspred.model.meal
 * @description TODO
 */

@Schema
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MealRecord {
    @Schema(description = "")
    private Long id;

    @Schema(description = "")
    private String empId;

    @Schema(description = "")
    private Long cardId;

    @Schema(description = "")
    private Integer clockId;

    @Schema(description = "")
    private Integer posSequ;

    @Schema(description = "")
    private Integer cardSequ;

    @Schema(description = "")
    private BigDecimal cardConsume;

    @Schema(description = "")
    private BigDecimal mval;

    @Schema(description = "")
    private BigDecimal coupon;

    @Schema(description = "")
    private BigDecimal cardBalance;

    @Schema(description = "")
    private BigDecimal aBalance;

    @Schema(description = "")
    private Integer kind;

    @Schema(description = "")
    private Integer verId;

    @Schema(description = "")
    private Integer flag;

    @Schema(description = "")
    private LocalDateTime signTime;

    @Schema(description = "")
    private LocalDateTime dcollecttime;

    @Schema(description = "")
    private String opUser;
}