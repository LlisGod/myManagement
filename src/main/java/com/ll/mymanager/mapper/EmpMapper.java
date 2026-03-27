package com.ll.mymanager.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ll.mymanager.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface EmpMapper {
    @Select("select * from employee")
    IPage<Emp> page(Page<Emp> page);
}
