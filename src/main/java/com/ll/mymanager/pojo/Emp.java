package com.ll.mymanager.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
    private Integer id;
    private String username;
    private String name;
    private Integer gender;
    private String phone;
    private String password;
    private String avatarUrl;//头像
    private Integer deptId;
    private LocalDate entryDate;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    private Dept dept;
    // 员工工作经历
    private List<EmpExpr> empExprs;
}
