package com.ll.mymanager.service.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ll.mymanager.mapper.EmpMapper;
import com.ll.mymanager.pojo.Emp;
import com.ll.mymanager.pojo.EmpQueryParam;
import com.ll.mymanager.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public IPage<Emp> page(EmpQueryParam empQueryParam) {
        Page<Emp> page = new Page<>(empQueryParam.getPageNum(), empQueryParam.getPageSize());
        IPage<Emp> emps = empMapper.page(page,empQueryParam);
        return emps;
    }
}
