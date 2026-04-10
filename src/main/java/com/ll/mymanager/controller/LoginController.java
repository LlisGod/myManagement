package com.ll.mymanager.controller;

import com.ll.mymanager.pojo.ApiResponse;
import com.ll.mymanager.pojo.Emp;
import com.ll.mymanager.pojo.LogInfo;
import com.ll.mymanager.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoginController {

    @Autowired
    private EmpService empservice;
    /**
     * 登录
     * @param emp
     * @return
     */
    @PostMapping("/login")
    public ApiResponse<LogInfo> login(@RequestBody Emp emp){
        log.info("登录 {}",emp);
        LogInfo logInfo =empservice.login(emp);
        return ApiResponse.success(logInfo);
    }
}
