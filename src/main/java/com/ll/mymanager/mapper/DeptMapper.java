package com.ll.mymanager.mapper;

import com.ll.mymanager.pojo.Dept;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeptMapper {
    @Select("select id, name, create_time, update_time from department")
    List<Dept> findAll();

    /**
     * 删除部门
     * @param id 部门id
     */
    @Delete("delete from department where id=#{id}")
    void delete(Integer id);

    /**
     * 添加部门
     * @param dept 部门信息
     */
    @Insert("insert into department (name,create_time,update_time)values" +
            "(#{name},#{createTime},#{updateTime})")
    void add(Dept dept);
}
