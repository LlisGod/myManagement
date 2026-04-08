package com.ll.mymanager.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ll.mymanager.pojo.Emp;
import com.ll.mymanager.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface EmpMapper {
//    @Select("select e.* d.name from employee e left join department d on e.dept_id = d.id order by e.update_time desc")
    IPage<Emp> page(Page<Emp> page, @Param("eqp") EmpQueryParam empQueryParam);

    @Insert("insert into employee (username,name,gender,phone,avatar_url,dept_id,entry_date,create_time,update_time)" +
            "values (#{username},#{name},#{gender},#{phone},#{avatarUrl},#{deptId},#{entryDate},#{createTime},#{updateTime})")
    // 数据库id回填，保证工作经验员工id与实际员工id一致
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Emp emp);

    void deleteBatchIds(List<Integer> ids);
}
