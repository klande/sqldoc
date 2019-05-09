package com.sqldoc.soft.vo;


import lombok.Data;

@Data
public class SqlDocTableColumnVO extends AbstractBaseVO {

    private String columnName; // 列名称
    private String columnType; // 列类型
    private String ifNullable; // 是否允许为空
    private String columnComment; // 列描述

}
