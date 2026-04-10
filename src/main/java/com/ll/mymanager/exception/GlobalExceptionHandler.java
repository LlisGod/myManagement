package com.ll.mymanager.exception;

import com.ll.mymanager.pojo.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ApiResponse<String> handleException(Exception e) {
        log.error("全局异常处理", e);
        return ApiResponse.error(500, "出错了"+e.getMessage());
    }
}
