package com.ll.mymanager.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ll.mymanager.pojo.ApiResponse;
import com.ll.mymanager.pojo.Emp;
import com.ll.mymanager.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping
    public ApiResponse<IPage<Emp>> page(@RequestParam Integer pageNum, @RequestParam Integer pageSize){
        System.out.println("查询员工信息");
        IPage<Emp> emps = empService.page(pageNum, pageSize);
        return ApiResponse.success(emps);
    }
}
