package com.mjmspred.model.mjms.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author HuangChunFeng
 * @time 2023-01-10 10:12
 * @package com.mjmspred.model.mjms.query
 * @description user查询对象
 */
@Data
@Builder
@AllArgsConstructor
public class UserQuery {
    private String username;
    private String password;
}
