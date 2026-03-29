package com.ll.mymanager.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ll.mymanager.pojo.Emp;
import com.ll.mymanager.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface EmpMapper {
//    @Select("select e.* d.name from employee e left join department d on e.dept_id = d.id order by e.update_time desc")
    IPage<Emp> page(Page<Emp> page, @Param("eqp") EmpQueryParam empQueryParam);
}
