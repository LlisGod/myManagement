package com.ll.mymanager.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpExpr {
    private Integer id;
    private Integer empId;
    private String company;
    private LocalDate startDate;
    private LocalDate endDate;
}
