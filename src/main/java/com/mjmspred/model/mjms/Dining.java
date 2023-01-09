package com.windcf.springmybatismultipledatasource.model.mjms;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author HuangChunFeng
 * @time 2023-01-09 10:22
 * @package com.windcf.springmybatismultipledatasource.model.mjms
 * @description TODO
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Dining {
    private Long dnId;

    private LocalDate dnDate;

    private Integer realBreakfast;

    private Integer realLunch;

    private Integer realDinner;

    private Integer predBreakfast;

    private Integer predLunch;

    private Integer predDinner;

    private String remark;

    /**
     * 8：30统计早上门禁人数
     */
    private Integer amsBreakfast;

    /**
     * 统计中午门禁数
     */
    private Integer amsLunch;

    private Integer amsDinner;
}