package com.sqldoc.soft.controller;

import com.sqldoc.soft.service.ISqlDocService;
import com.sqldoc.soft.vo.SqlDataBasesVO;
import com.sqldoc.soft.vo.SqlDocTableColumnVO;
import com.sqldoc.soft.vo.SqlDocTableVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by YM10106 on 2018/3/28.
 */
@Controller
@RequestMapping("/sqldoc")
public class SqlDocController {
    @Autowired
    private ISqlDocService sqlDocService;

    @Value("${spring.datasource.dataname}")
    private String dataBaseName;
    /**
     * 返回数据库文档页面
     *
     * @return
     */
    @RequestMapping("/sqldocPage")
    public String getSqlDocPageController(Model model) {
        model.addAttribute("dataBaseName",dataBaseName);
        model.addAttribute("dataBaseNameList",sqlDocService.getDataBaseNameList());
        return "sqldoc/sqldoc";
    }

    /**
     * 返回数据库表数据
     * @param dataBaseName
     * @return
     */
    @RequestMapping("/sqldocTable")
    @ResponseBody
    public List<SqlDocTableVO> getSqlDocTable(String dataBaseName) {
        return sqlDocService.getTableAndColumnList(dataBaseName);
    }

    /**
     * 返回数据库文档列数据
     * @param dataBaseName
     * @param tableName
     * @return
     */
    @RequestMapping("/sqldocColumn")
    @ResponseBody
    public List<SqlDocTableColumnVO> getSqlDocColum(String dataBaseName,String tableName) {
        return sqlDocService.getTableColumnList(dataBaseName,tableName);
    }
}
