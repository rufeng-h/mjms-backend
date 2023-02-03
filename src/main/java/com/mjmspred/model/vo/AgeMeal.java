package com.mjmspred.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author : chunf
 */
@Data
@AllArgsConstructor
public class AgeMeal {
    private String ageInterval;
    private Integer count;
}
