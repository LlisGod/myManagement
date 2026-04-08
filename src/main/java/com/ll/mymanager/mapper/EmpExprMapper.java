package com.ll.mymanager.mapper;


import com.ll.mymanager.pojo.EmpExpr;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpExprMapper {
    /**
     * 批量插入员工工作经历
     * @param empExprs 员工工作经历列表
     */

    void insertBatch(List<EmpExpr> empExprs);

    /**
     * 批量删除员工工作经历
     * @param ids 员工工作经历id列表
     */
    void deleteBatchEmpIds(List<Integer> ids);
}
