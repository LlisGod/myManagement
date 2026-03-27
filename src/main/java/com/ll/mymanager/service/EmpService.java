package com.ll.mymanager.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ll.mymanager.pojo.Emp;


import java.util.List;

public interface EmpService {
    IPage<Emp> page(Integer pageNum, Integer pageSize);
}
