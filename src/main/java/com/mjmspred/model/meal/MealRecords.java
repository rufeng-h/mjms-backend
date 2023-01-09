package com.mjmspred.model.meal;

import io.swagger.v3.oas.annotations.media.Schema;
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
public class MealRecords {
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
    private Object cardConsume;

    @Schema(description = "")
    private Object mval;

    @Schema(description = "")
    private Object coupon;

    @Schema(description = "")
    private Object cardBalance;

    @Schema(description = "")
    private Object aBalance;

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