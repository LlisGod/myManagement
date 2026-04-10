package com.ll.mymanager.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ll.mymanager.pojo.Emp;
import com.ll.mymanager.pojo.EmpQueryParam;
import com.ll.mymanager.pojo.LogInfo;

import java.util.List;


public interface EmpService {
    IPage<Emp> page(EmpQueryParam empQueryParam);

    void add(Emp emp);

    void delete(List<Integer> ids);

    Emp infoById(Integer id);

    void update(Emp emp);

    LogInfo login(Emp emp);
}
