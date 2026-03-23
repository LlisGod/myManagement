package com.ll.mymanager.controller;

import com.ll.mymanager.pojo.ApiResponse;
import com.ll.mymanager.pojo.Dept;
import com.ll.mymanager.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/depts")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping
    public ApiResponse<List<Dept>> List(){
        System.out.println("查询部门信息");
        List<Dept> deptList = deptService.findAll();
         return ApiResponse.success(deptList);
    }

    /*
     * 删除部门
     */
    @DeleteMapping
    public ApiResponse<String> Delete(@RequestParam("id") Integer deptId){
        System.out.println("删除部门信息"+deptId);
        deptService.delete(deptId);
        return ApiResponse.success("删除成功");
    }
}
