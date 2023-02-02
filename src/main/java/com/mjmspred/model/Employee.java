package com.mjmspred.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : chunf
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Long id;

    private String empId;

    private String empName;

    private String gender;

    private String dept;

    private String idNumber;

    private String position;

    private String rank;

    private String title;

    private LocalDateTime updateTime;
}