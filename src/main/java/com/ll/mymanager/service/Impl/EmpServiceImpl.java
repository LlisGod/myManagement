package com.ll.mymanager.service.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ll.mymanager.mapper.EmpExprMapper;
import com.ll.mymanager.mapper.EmpMapper;
import com.ll.mymanager.pojo.Emp;
import com.ll.mymanager.pojo.EmpQueryParam;
import com.ll.mymanager.pojo.LogInfo;
import com.ll.mymanager.service.EmpService;
import com.ll.mymanager.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private EmpExprMapper empExprMapper;

    @Override
    public IPage<Emp> page(EmpQueryParam empQueryParam) {
        Page<Emp> page = new Page<>(empQueryParam.getPageNum(), empQueryParam.getPageSize());
        IPage<Emp> emps = empMapper.page(page,empQueryParam);
        return emps;
    }

    @Override
    @Transactional
    public void add(Emp emp) {
        // 员工插入
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);

        //员工工作经历批量插入
        //工作经历不能为空
        if (emp.getEmpExprs() != null &&!emp.getEmpExprs().isEmpty()){
            // 给工作经历设置员工id
            emp.getEmpExprs().forEach(expr -> expr.setEmpId(emp.getId()));
            empExprMapper.insertBatch(emp.getEmpExprs());
        }

    }

    @Transactional
    @Override
    public void delete(List<Integer> ids) {

        empMapper.deleteBatchIds(ids);
        empExprMapper.deleteBatchEmpIds(ids);
    }

    @Override
    public Emp infoById(Integer id) {
        return empMapper.infoById(id);
    }

    @Transactional
    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
        empExprMapper.deleteBatchEmpIds(List.of(emp.getId()));
        //员工工作经历批量插入
        //工作经历不能为空
        if (emp.getEmpExprs() != null &&!emp.getEmpExprs().isEmpty()){
            // 给工作经历设置员工id
            emp.getEmpExprs().forEach(expr -> expr.setEmpId(emp.getId()));
            empExprMapper.insertBatch(emp.getEmpExprs());
        }
    }

    @Override
    public LogInfo login(Emp emp) {
        Emp e = empMapper.selectByUsernameAndPassword(emp);

        if (e == null){
            throw new RuntimeException("用户名或密码错误");
        }
        log.info("用户校验成功 {}",e);
        return new LogInfo(e.getUsername(), e.getName(),e.getId(),JwtUtils.generateToken(e.getUsername(), e.getId()));
    }
}
