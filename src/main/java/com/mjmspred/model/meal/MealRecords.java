package com.windcf.springmybatismultipledatasource.model.meal;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author HuangChunFeng
 * @time 2023-01-09 10:21
 * @package com.windcf.springmybatismultipledatasource.model.meal
 * @description TODO
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MealRecords {
    private Long id;

    private String empId;

    private Long cardId;

    private Integer clockId;

    private Integer posSequ;

    private Integer cardSequ;

    private Object cardConsume;

    private Object mval;

    private Object coupon;

    private Object cardBalance;

    private Object aBalance;

    private Integer kind;

    private Integer verId;

    private Integer flag;

    private LocalDateTime signTime;

    private LocalDateTime dcollecttime;

    private String opUser;
}