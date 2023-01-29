package com.mjmspred.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author HuangChunFeng
 * @time 2023-01-09 19:05
 * @package com.mjmspred.model.mjms
 * @description TODO
 */

@Schema
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MjmsUser {
    @Schema(description = "")
    private Long userId;

    @Schema(description = "")
    private String username;

    @Schema(description = "")
    private String password;
}