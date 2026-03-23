package com.ll.mymanager.service;

import com.ll.mymanager.pojo.Dept;

import java.util.List;

public interface DeptService {
    // 查询部门信息
    List<Dept> findAll();
    // 删除部门
    void delete(Integer id);

    void add(Dept dept);
}
