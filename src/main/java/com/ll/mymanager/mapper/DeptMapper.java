package com.ll.mymanager.mapper;

import com.ll.mymanager.pojo.Dept;
import org.apache.ibatis.annotations.*;

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

    /**
     * 根据id查询部门信息
     * @param id 部门id
     * @return 部门信息
     */
    @Select("select id,name,create_time,update_time from department where id = #{id}")
    Dept findDeptById(Integer id);

    /*
     * 修改部门信息
     */
    @Update("update department set name=#{name},update_time=#{updateTime} where id=#{id}")
    void update(Dept dept);
}
