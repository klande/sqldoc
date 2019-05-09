package com.sqldoc.soft.service.impl;


import com.alibaba.fastjson.JSON;
import com.sqldoc.soft.repository.SqlDocRepository;
import com.sqldoc.soft.service.ISqlDocService;
import com.sqldoc.soft.vo.SqlDataBasesVO;
import com.sqldoc.soft.vo.SqlDocTableColumnVO;
import com.sqldoc.soft.vo.SqlDocTableVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class SqlDocServiceImpl implements ISqlDocService {
    @Autowired
    private SqlDocRepository sqlDocRepository;

    @Value("${spring.jpa.database}")
    private String dataBaseType;

    @Value("${spring.datasource.dataname}")
    private String dataBaseName;

    /**
     * 获取用户下数据库
     *
     * @return
     */
    @Override
    public List<SqlDataBasesVO> getDataBaseNameList() {
        List<SqlDataBasesVO> list = new ArrayList<>();
        if ("mysql".equalsIgnoreCase(dataBaseType)) {
            List<Object[]> listObj = sqlDocRepository.findDataBaseNameList();
            if (!CollectionUtils.isEmpty(listObj)) {
                for (Object[] obj : listObj) {
                    SqlDataBasesVO sqlDataBasesVO = new SqlDataBasesVO();
                    sqlDataBasesVO.setDataBaseName(obj[0].toString());
                    list.add(sqlDataBasesVO);
                }
            }
        }
        return list;
    }


    /**
     * 获取数据库下的所有表
     *
     * @param dataBaseName
     * @return
     */
    @Override
    public List<SqlDocTableVO> getTableAndColumnList(String dataBaseName) {
        List<SqlDocTableVO> listTable = new ArrayList<>();
        List<Object[]> listObj = null;
        // mysql
        if ("mysql".equalsIgnoreCase(dataBaseType)) {
            if (!StringUtils.isEmpty(dataBaseName)) {
                this.dataBaseName = dataBaseName;
            }
            listObj = sqlDocRepository.findTableListRepository(this.dataBaseName);
        } else {// oracle
            listObj = sqlDocRepository.findTableListRepository();
        }
        if (!CollectionUtils.isEmpty(listObj)) {
            for (Object[] obj : listObj) {
                SqlDocTableVO sqlDocTableVO = new SqlDocTableVO();
                sqlDocTableVO.setTableName(obj[0].toString());
                sqlDocTableVO.setTableComment(null !=obj[1] ? obj[1].toString() : null);
                listTable.add(sqlDocTableVO);
            }
        }
        return listTable;
    }

    /**
     * 获取表的所有列
     *
     * @param databaseName-数据库名称
     * @param tableName
     * @return
     */
    @Override
    public List<SqlDocTableColumnVO> getTableColumnList(String databaseName, String tableName) {
        List<SqlDocTableColumnVO> listColumn = new ArrayList<SqlDocTableColumnVO>();
        List<Object[]> listObj = null;
        if ("mysql".equalsIgnoreCase(dataBaseType)) {
            listObj = sqlDocRepository.findColumnRepository(databaseName, tableName);
        } else {
            listObj = sqlDocRepository.findColumnRepository(tableName);
        }
        if (!CollectionUtils.isEmpty(listObj)) {
            for (Object[] obj : listObj) {
                SqlDocTableColumnVO sqlDocTableColumnVO = new SqlDocTableColumnVO();
                sqlDocTableColumnVO.setColumnName(obj[0].toString());
                sqlDocTableColumnVO.setColumnType(obj[1].toString());
                sqlDocTableColumnVO.setIfNullable(obj[2].toString());
                sqlDocTableColumnVO.setColumnComment(null !=obj[3] ? obj[3].toString():null);
                listColumn.add(sqlDocTableColumnVO);
            }
        }
        return listColumn;
    }
}
