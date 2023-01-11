package com.mjmspred.model.mjms.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author HuangChunFeng
 * @time 2023-01-10 10:12
 * @package com.mjmspred.model.mjms.query
 * @description user查询对象
 */
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UserQuery {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
