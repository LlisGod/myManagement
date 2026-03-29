package com.ll.mymanager.controller;

import com.ll.mymanager.pojo.ApiResponse;
import com.ll.mymanager.pojo.Dept;
import com.ll.mymanager.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController()
@RequestMapping("/depts")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping
    public ApiResponse<List<Dept>> List(){
//        System.out.println("查询部门信息");
        log.info("查询部门信息");
        List<Dept> deptList = deptService.findAll();
         return ApiResponse.success(deptList);
    }

    /*
     * 删除部门
     */
    @DeleteMapping
    public ApiResponse<String> Delete(@RequestParam("id") Integer deptId){
//        System.out.println("删除部门信息"+deptId);
        log.info("删除部门信息"+deptId);
        deptService.delete(deptId);
        return ApiResponse.success("删除成功");
    }

    /*
     * 新增部门
     */
    @PostMapping
    public ApiResponse<String> Add(@RequestBody Dept dept){
//        System.out.println("新增部门信息"+dept);
        log.info("新增部门信息"+dept);
        deptService.add(dept);
        return ApiResponse.success("新增成功");
    }
    /*
     * 通过id查询部门
     */
    @GetMapping("/{id}")
    public ApiResponse<Dept> FindDeptById(@PathVariable Integer id){
        log.info("查询部门信息"+id);
        Dept dept=deptService.findDeptById(id);
        return ApiResponse.success(dept);
    }

    /*
     *修改部门信息
     */
    @PutMapping
    public ApiResponse<String> Update(@RequestBody Dept dept){
//        System.out.println("修改部门信息"+dept);
        log.info("修改部门信息"+dept);
        deptService.update(dept);
        return ApiResponse.success();
    }
}
