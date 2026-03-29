package com.ll.mymanager.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpQueryParam {
    private Integer pageNum=1;
    private Integer pageSize=10;
    private String name;
    private Integer gender;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate beginDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
}
