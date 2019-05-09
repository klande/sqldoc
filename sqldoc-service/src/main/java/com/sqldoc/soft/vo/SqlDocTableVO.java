package com.sqldoc.soft.vo;


import lombok.Data;

import java.util.List;


@Data
public class SqlDocTableVO extends AbstractBaseVO {

    private String tableName;            // 表名称
    private String tableComment;       // 表描述
    private List<SqlDocTableColumnVO> listColumn; // 表的列
}
