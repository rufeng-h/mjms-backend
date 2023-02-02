package com.mjmspred.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author : chunf
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Flow {
    private Long id;

    private LocalDate fDate;

    private String pred;

    private String real;

    private String remark;
}