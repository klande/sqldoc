package com.sqldoc.soft.repository;


import com.sqldoc.soft.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SqlDocRepository extends PagingAndSortingRepository<UserInfo, String>, JpaSpecificationExecutor<UserInfo> {

    /**
     * mysql 查询所有数据库
     *
     * @return
     */
    @Query(value = "select schema_name from information_schema.schemata", nativeQuery = true)
    List<Object[]> findDataBaseNameList();


    /**
     * mysql 查询出数据库下所有的表
     *
     * @param databaseName-数据名
     * @return
     */
    @Query(value = "SELECT TABLE_NAME,TABLE_COMMENT FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = :databaseName", nativeQuery = true)
    List<Object[]> findTableListRepository(@Param("databaseName") String databaseName);

    /**
     * mysql 查询表下的所有列
     *
     * @param databaseName-数据名
     * @param tableName-表名称
     * @return
     */
    @Query(value = "SELECT COLUMN_NAME,COLUMN_TYPE,IS_NULLABLE,COLUMN_COMMENT FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_SCHEMA = :databaseName and TABLE_NAME = :tableName", nativeQuery = true)
    List<Object[]> findColumnRepository(@Param("databaseName") String databaseName, @Param("tableName") String tableName);

    /**
     * oracle 查询出当前用户下数据表
     *
     * @return
     */
    @Query(value = "select t.table_name,f.comments from user_tables t inner join user_tab_comments f on t.table_name = f.table_name", nativeQuery = true)
    List<Object[]> findTableListRepository();

    /**
     * oracle 查询表下的所有列
     *
     * @param tableName-表名称
     * @return
     */
    @Query(value = "SELECT T.column_name,f.data_type,f.nullable,T.comments FROM USER_TAB_COLUMNS f,user_col_comments T WHERE T.column_name = f.column_name AND  T.table_name = f.table_name  AND f.table_name = :tableName ORDER BY f.column_id asc", nativeQuery = true)
    List<Object[]> findColumnRepository(@Param("tableName") String tableName);

}
