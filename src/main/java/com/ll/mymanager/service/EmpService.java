package com.ll.mymanager.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ll.mymanager.pojo.Emp;
import com.ll.mymanager.pojo.EmpQueryParam;




public interface EmpService {
    IPage<Emp> page(EmpQueryParam empQueryParam);

    void add(Emp emp);
}
