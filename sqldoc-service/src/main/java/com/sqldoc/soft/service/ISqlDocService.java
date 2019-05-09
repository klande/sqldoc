package com.sqldoc.soft.service;

import com.sqldoc.soft.vo.SqlDataBasesVO;
import com.sqldoc.soft.vo.SqlDocTableColumnVO;
import com.sqldoc.soft.vo.SqlDocTableVO;

import java.util.List;

public interface ISqlDocService {


    /**
     * 获取用户下数据库
     *
     * @return
     */
    List<SqlDataBasesVO> getDataBaseNameList();

    /**
     * 获取数据库下的所有表和表的列
     * @param dataBaseName
     * @return
     */
    List<SqlDocTableVO> getTableAndColumnList(String dataBaseName);

    /**
     * 获取表的所有列
     *
     * @param databaseName-数据库名称
     * @param tableName-表名称
     * @return
     */
    List<SqlDocTableColumnVO> getTableColumnList(String databaseName, String tableName);
}
