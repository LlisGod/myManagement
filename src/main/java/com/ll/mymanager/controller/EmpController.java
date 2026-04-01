package com.ll.mymanager.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ll.mymanager.pojo.ApiResponse;
import com.ll.mymanager.pojo.Emp;
import com.ll.mymanager.pojo.EmpQueryParam;
import com.ll.mymanager.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;

    /*
     * 分页查询员工信息
     * @param pageNum
     * @param pageSize
     * @param
     */
    @GetMapping
    public ApiResponse<IPage<Emp>> page(EmpQueryParam empQueryParam){
//        System.out.println("查询员工信息");
        log.info("查询员工信息 {}",empQueryParam);
        IPage<Emp> emps = empService.page(empQueryParam);
        return ApiResponse.success(emps);
    }

    /**
     * 添加员工信息
     * @param emp
     * @return
     */
    @PostMapping
    public ApiResponse<String> add(@RequestBody Emp emp){
        empService.add(emp);
        return ApiResponse.success("添加成功");
    }
}
