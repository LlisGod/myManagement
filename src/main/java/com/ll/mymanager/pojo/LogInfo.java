package com.ll.mymanager.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogInfo {
    private String username;
    private String name;
    private Integer id;
    private String token;
}
