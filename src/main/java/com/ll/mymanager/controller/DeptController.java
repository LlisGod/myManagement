package com.ll.mymanager.controller;

import com.ll.mymanager.pojo.ApiResponse;
import com.ll.mymanager.pojo.Dept;
import com.ll.mymanager.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/depts")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping
    public ApiResponse List(){
        System.out.println("查询部门信息");
        List<Dept> deptList = deptService.findAll();
         return ApiResponse.success(deptList);
    }

}
