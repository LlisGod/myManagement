package com.ll.mymanager.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
    private Integer code;
    private String message;
    private T data;
    private long timestamp;


    public static<T> ApiResponse<T>  success(){
        return ApiResponse.<T>builder()
                .code(200)
                .message("成功")
                .timestamp(System.currentTimeMillis())
                .build();
    }
    public static<T> ApiResponse<T>  success(T data){
        return ApiResponse.<T>builder()
                .code(200)
                .message("成功")
                .data(data)
                .timestamp(System.currentTimeMillis())
                .build();
    }
    public static<T> ApiResponse<T>  success(String msg ,T data){
        return ApiResponse.<T>builder()
                .code(200)
                .message(msg)
                .data(data)
                .timestamp(System.currentTimeMillis())
                .build();
    }

    public static<T> ApiResponse<T>  error(Integer code, String msg){
        return ApiResponse.<T>builder()
                .code(200)
                .message(msg)
                .timestamp(System.currentTimeMillis())
                .build();
    }
}
