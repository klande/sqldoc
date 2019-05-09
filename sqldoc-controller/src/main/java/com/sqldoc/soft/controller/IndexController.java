package com.sqldoc.soft.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @Value("${sys.name}")
    private String sysName;

    /**
     * 登录页面
     *
     * @return
     * @author xiaodong-java
     * @date 2016年5月24日
     */
    @RequestMapping("/login")

    public String login(HttpSession session) {
        session.setAttribute("sysName", sysName);
        return "login";
    }

    /**
     * 登录失败
     *
     * @return
     */
    @RequestMapping("/loginError")
    public String loginError() {
        return "login";
    }

    /**
     * @return
     * @author xiaodong-java
     * @date 2016年6月24日
     */
    @RequestMapping("/")
    public String index() {
        return "redirect:/sqldoc/sqldocPage";
    }

    /**
     * @return
     * @author xiaodong-java
     * @date 2016年6月24日
     */
    @RequestMapping("/index")
    public String indexUrl() {
        return "redirect:/sqldoc/sqldocPage";
    }
}
