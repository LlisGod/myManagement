package com.ll.mymanager.service.Impl;


import com.ll.mymanager.mapper.DeptMapper;
import com.ll.mymanager.pojo.Dept;
import com.ll.mymanager.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }


}
