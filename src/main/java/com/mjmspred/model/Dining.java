package com.mjmspred.model;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author HuangChunFeng
 * @time 2023-01-09 16:08
 * @package com.mjmspred.model.mjms
 * @description TODO
 */

@Schema
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Dining {
    @Schema(description = "")
    private Long dnId;

    @Schema(description = "")
    private LocalDate dnDate;

    @Schema(description = "")
    private Integer realBreakfast;

    @Schema(description = "")
    private Integer realLunch;

    @Schema(description = "")
    private Integer realDinner;

    @Schema(description = "")
    private Integer predBreakfast;

    @Schema(description = "")
    private Integer predLunch;

    @Schema(description = "")
    private Integer predDinner;

    @Schema(description = "")
    private String remark;

    /**
     * 8：30统计早上门禁人数
     */
    @Schema(description = "8：30统计早上门禁人数 ")
    private Integer amsBreakfast;

    /**
     * 统计中午门禁数
     */
    @Schema(description = "统计中午门禁数 ")
    private Integer amsLunch;

    @Schema(description = "")
    private Integer amsDinner;
}